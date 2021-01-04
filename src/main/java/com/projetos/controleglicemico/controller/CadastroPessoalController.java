package com.projetos.controleglicemico.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.projetos.controleglicemico.dao.CadastroPessoaDao;
import com.projetos.controleglicemico.dao.CidadeEstadoDao.ComboBoxGenericoDao;
import com.projetos.controleglicemico.model.CadastroPessoa;
import com.projetos.controleglicemico.model.CidadeEstado;
import com.projetos.controleglicemico.util.Alerta;
import com.projetos.controleglicemico.util.UF;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CadastroPessoalController implements Initializable, ICadastro {

    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfEndereco;
    @FXML
    private TextField tfCpf;
    @FXML
    private TextField tfBairro;
    @FXML
    private TextField tfNumero;
    @FXML
    private TextField tfComplemento;
    @FXML
    private TextField tfTelefone;
    @FXML
    private TextField tfNomeResponsavel;
    @FXML
    private TextField tfCelular;
    @FXML
    private TextField tfTelefoneResponsavel;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnCorrigir;
    @FXML
    private Button btnNovo;
    @FXML
    private Label lbTitulo;
    @FXML
    private ComboBox<CidadeEstado> cbCidade;
    @FXML
    private JFXTextField tfPesquisa;
    @FXML
    private TableView<CadastroPessoa> tbView;
    @FXML
    private JFXTextField tfCep;
    @FXML
    private JFXDatePicker dtNascimento;
    @FXML
    private JFXRadioButton rbMasculino;
    @FXML
    private JFXRadioButton rbFeminino;
    @FXML
    private JFXCheckBox ckAtivo;
    @FXML
    private JFXTextField tbCelularResponsavel;
    @FXML
    private ToggleGroup sexo;
    @FXML
    private JFXComboBox<String> cbUF;
      @FXML
    private JFXComboBox<?> cbTipoSanguineo;

    /* private ComboBoxGenericoDao<TipoSanguinio> comboBoxTipoSanguinioDao = new ComboBoxTipoSanguinioDao();*/
    
    private CadastroPessoaDao dao = new CadastroPessoaDao();
    private ObservableList<CadastroPessoa> observableList = FXCollections.observableArrayList();
    private List<CadastroPessoa> listCadastro;
    private CadastroPessoa objetoSelecionado = new CadastroPessoa();
  
  //  private ComboBoxGenericoDao<CidadeEstado> comboBoxCidadeEstadoDao;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // cbCidade.setItems(comboBoxCidadeEstadoDao.comboBox("CidadeEstado"));
        
        cbUF.setItems(UF.gerarUF());
        lbTitulo.setText("Cadastro de Pessoa");
        //cbTipoSanguinio.setItems(TipoSanguinio.gerarTipoSanguinio());
        criarColunasTabela();
        atualizarTabela();
        //setCamposFormulario();

    }

    @FXML
    private void salvarRegistro(ActionEvent event) {
        CadastroPessoa cadastroPessoa = new CadastroPessoa();

        if (objetoSelecionado != null) {
            cadastroPessoa.setId(objetoSelecionado.getId());
        }

        cadastroPessoa.setNome(tfNome.getText());
        cadastroPessoa.setEndereco(tfEndereco.getText());
        cadastroPessoa.setCpf(tfCpf.getText());
        cadastroPessoa.setBairro(tfBairro.getText());
        cadastroPessoa.setNumero(Long.parseLong(tfNumero.getText()));
        cadastroPessoa.setComplemento(tfComplemento.getText());
        cadastroPessoa.setTelefone(Long.parseLong(tfTelefone.getText()));
        cadastroPessoa.setResponsavel(tfNomeResponsavel.getText());
        cadastroPessoa.setCelular(Long.parseLong(tfCelular.getText()));
        cadastroPessoa.setTelefoneResponsvel(Long.parseLong(tfTelefoneResponsavel.getText()));
        cadastroPessoa.setCep(Long.parseLong(tfCep.getText()));
        cadastroPessoa.setCelularResponsavel(Long.parseLong(tbCelularResponsavel.getText()));
        
        LocalDate dataNascimento = dtNascimento.getValue();

        cadastroPessoa.setNascimento(dataNascimento);

        if (ckAtivo.isSelected()) {
            cadastroPessoa.setAtivo(true);
        } else {
            cadastroPessoa.setAtivo(false);
        }

        if (rbMasculino.isSelected()) {
            cadastroPessoa.setSexo("M");
        } else {
            cadastroPessoa.setSexo("F");
        }

        if (dao.salvar(cadastroPessoa)) {
            Alerta.msgInformacao("Registro Gravado com Sucesso");
        } else {
            Alerta.msgInformacao("Ocorreu um Erro ao tentar gravar o registro");
        }

        atualizarTabela();
        limparCampoFormulario();
    }

    @FXML
    private void corrigirRegistro(ActionEvent event) {
        if (Alerta.msgConfirmarExclusao(tfNome.getText())) {

            dao.excluir(objetoSelecionado);
            limparCampoFormulario();
            atualizarTabela();
            Alerta.msgInformacao("Registro excluído com sucesso!");
        }
    }

    @FXML
    private void novoRegisto(ActionEvent event) {
        limparCampoFormulario();
    }

    @Override
    public void criarColunasTabela() {
        TableColumn<CadastroPessoa, Long> colunaId = new TableColumn<>("ID");
        colunaId.setMinWidth(40);
        colunaId.setMaxWidth(40);

        TableColumn<CadastroPessoa, String> colunaNome = new TableColumn<>("NOME");
        TableColumn<CadastroPessoa, String> colunaCpf = new TableColumn<>("CPF");
        TableColumn<CadastroPessoa, LocalDate> colunaData = new TableColumn<>("DATA");
        TableColumn<CadastroPessoa, CidadeEstado> colunaCidade = new TableColumn<>("CIDADE");
        TableColumn<CadastroPessoa, UF> colunaUf = new TableColumn<>("UF");
        TableColumn<CadastroPessoa, Long> colunaCelular = new TableColumn<>("CELULAR");
        TableColumn<CadastroPessoa, Long> colunaCep = new TableColumn<>("CEP");

        tbView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tbView.getColumns().addAll(colunaId, colunaNome, colunaCpf, colunaData, colunaCidade, colunaUf, colunaCelular);

        colunaId.setCellValueFactory(new PropertyValueFactory("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
        colunaData.setCellValueFactory(new PropertyValueFactory("data"));
        colunaCidade.setCellValueFactory(new PropertyValueFactory("cidade"));
        colunaUf.setCellValueFactory(new PropertyValueFactory("uf"));
        colunaCelular.setCellValueFactory(new PropertyValueFactory("celular"));
        colunaCep.setCellValueFactory(new PropertyValueFactory("cep"));

// Definindo o formato da data para exibição na tabela
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Converte a data da tabela para o formato especificado
        colunaData.setCellFactory(tc -> new TableCell<CadastroPessoa, LocalDate>() {
            @Override
            protected void updateItem(LocalDate data, boolean empty) {
                super.updateItem(data, empty);
                if (data != null) {
                    setText(formato.format(data));
                } else {
                    setText(null);
                }
            }
        });

    }

    @Override
    public void atualizarTabela() {
        observableList.clear();
        listCadastro = dao.consulta(tfPesquisa.getText());

        for (CadastroPessoa t : listCadastro) {
            observableList.add(t);
        }
        tbView.getItems().setAll(observableList);
        tbView.getSelectionModel().selectFirst();
    }

    @Override
    public void setCamposFormulario() {
        objetoSelecionado = tbView.getItems().get(tbView.getSelectionModel().getSelectedIndex());
        
        tfNome.setText(objetoSelecionado.getNome());
        tfEndereco.setText(objetoSelecionado.getEndereco());
        tfCpf.setText(objetoSelecionado.getCpf());
        tfBairro.setText(objetoSelecionado.getBairro());
        tfNumero.setText(String.valueOf(objetoSelecionado.getNumero()));
        tfComplemento.setText(String.valueOf(objetoSelecionado.getComplemento()));
        tfTelefone.setText(String.valueOf(objetoSelecionado.getTelefone()));
        tfNomeResponsavel.setText(String.valueOf(objetoSelecionado.getTelefoneResponsvel()));
        tfCelular.setText(String.valueOf(objetoSelecionado.getCelular()));
        tfTelefoneResponsavel.setText(String.valueOf(objetoSelecionado.getTelefoneResponsvel()));
        tbCelularResponsavel.setText(String.valueOf(objetoSelecionado.getCelularResponsavel()));
        dtNascimento.setValue(objetoSelecionado.getNascimento());
        

    }

    @Override
    public void limparCampoFormulario() {
        tfNome.clear();
        tfEndereco.clear();
        tfCpf.clear();
        tfBairro.clear();
        tfNumero.clear();
        tfComplemento.clear();
        tfTelefone.clear();
        tfNomeResponsavel.clear();
        tfCelular.clear();
        tfTelefoneResponsavel.clear();
        objetoSelecionado = null;
        tfNome.requestFocus();
        atualizarTabela();
        //falta para dar um clear no tipoSanguinio e cida bairro

    }

    @FXML
    private void filtrarRegistro(KeyEvent event) {
        atualizarTabela();
    }

    @FXML
    private void clicarTabela(MouseEvent event) {
        setCamposFormulario();
    }

    @FXML
    private void moverTabela(KeyEvent event) {
        setCamposFormulario();
    }

}
