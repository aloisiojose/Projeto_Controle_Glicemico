package com.projetos.controleglicemico.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import com.projetos.controleglicemico.dao.ColetaDao;
import com.projetos.controleglicemico.model.Coleta;
import com.projetos.controleglicemico.util.Alerta;
import com.projetos.controleglicemico.util.TipoSanguinio;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ColetaController implements Initializable, ICadastro {

    @FXML
    private Label lbTitulo;
    @FXML
    private JFXTextField tfCpf;
    @FXML
    private JFXTextField tfNome;
    @FXML
    private JFXDatePicker dtColeta;
    @FXML
    private JFXTimePicker hrColeta;
    @FXML
    private JFXTextField tfSexo;
    @FXML
    private JFXTextArea tfDescricao;
    @FXML
    private JFXComboBox<String> cbTipoSanguinio;
    @FXML
    private JFXComboBox<String> cbTipoAlimento;
    @FXML
    private JFXTextField tfValorGlicemico;
    @FXML
    private JFXTextField tfPeso;
    @FXML
    private JFXTextField tfValorArterial;
    @FXML
    private JFXTextField tfAltura;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnCorrigir;
    @FXML
    private Button btnNovo;
    @FXML
    private JFXTextField tfPesquisa;
    @FXML
    private TableView<Coleta> tbView;

    private ColetaDao dao = new ColetaDao();
    private ObservableList<Coleta> observableList = FXCollections.observableArrayList();
    private List<Coleta> listCadastro;
    private Coleta objetoSelecionado = new Coleta();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // cbTipoAlimento.setItems(TipoAlimento.gerarTipoAlimento());
        cbTipoSanguinio.setItems(TipoSanguinio.gerarTipoSanguinio());
        lbTitulo.setText("Coleta de Dados ");
        criarColunasTabela();
        atualizarTabela();
    }

    @FXML
    private void salvarRegistro(ActionEvent event) {

        Coleta coleta = new Coleta();

         if (objetoSelecionado != null) {
            coleta.setId(objetoSelecionado.getId());
        }
        coleta.setCpf(tfCpf.getText());
        coleta.setNome(tfNome.getText());
        LocalDate datacoleta = dtColeta.getValue();
        coleta.setData(datacoleta);
        LocalTime timecoleta = hrColeta.getValue();
        coleta.setHora(timecoleta);
        coleta.setSexo(tfSexo.getText());
        coleta.setDescricao(tfDescricao.getText());
        coleta.setValorDiabete(Long.parseLong(tfValorGlicemico.getText()));
        coleta.setValorPeso(Long.parseLong(tfPeso.getText()));
        coleta.setValorPressaoArterial(Long.parseLong(tfValorArterial.getText()));
        coleta.setAltura(tfAltura.getText());

        if (dao.salvar(coleta)) {
            Alerta.msgInformacao("Registro Gravado com Sucesso");
        } else {
            Alerta.msgInformacao("Ocorreu um Erro ao tentar gravar o registro");
        }

        atualizarTabela();
        limparCampoFormulario();
    }

    @FXML
    private void corrigirRegistro(ActionEvent event) {
    }

    @FXML
    private void novoRegisto(ActionEvent event) {
    }

    @FXML
    private void filtrarRegistro(KeyEvent event) {
    }

    @FXML
    private void clicarTabela(MouseEvent event) {
        setCamposFormulario();
    }

    @FXML
    private void moverTabela(KeyEvent event) {
    }

    @Override
    public void criarColunasTabela() {
        TableColumn<Coleta, Long> colunaId = new TableColumn<>("ID");
        colunaId.setMinWidth(40);
        colunaId.setMaxWidth(40);

        TableColumn<Coleta, LocalDate> colunaData = new TableColumn<>("DATA");
        TableColumn<Coleta, String> colunaNome = new TableColumn<>("NOME");
        TableColumn<Coleta, String> colunaCpf = new TableColumn<>("CPF");
        TableColumn<Coleta, String> colunaValorGlicemico = new TableColumn<>("Controle Glicêmico");

        tbView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tbView.getColumns().addAll(colunaId, colunaData, colunaNome, colunaCpf, colunaValorGlicemico);

        colunaId.setCellValueFactory(new PropertyValueFactory("id"));
        colunaData.setCellValueFactory(new PropertyValueFactory("data"));
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
        colunaValorGlicemico.setCellValueFactory(new PropertyValueFactory("contole Glicemico"));

        // Definindo o formato da data para exibição na tabela
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Converte a data da tabela para o formato especificado
        colunaData.setCellFactory(tc -> new TableCell<Coleta, LocalDate>() {
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

        for (Coleta t : listCadastro) {
            observableList.add(t);
        }
        tbView.getItems().setAll(observableList);
        tbView.getSelectionModel().selectFirst();
    }

    @Override
    public void setCamposFormulario() {
        objetoSelecionado = tbView.getItems().get(tbView.getSelectionModel().getSelectedIndex());
        tfNome.setText(objetoSelecionado.getNome());
        tfCpf.setText(objetoSelecionado.getCpf());
        dtColeta.setValue(objetoSelecionado.getData());
        hrColeta.setValue(objetoSelecionado.getHora());
        tfSexo.setText(objetoSelecionado.getSexo());
        tfDescricao.setText(objetoSelecionado.getDescricao());
        tfValorGlicemico.setText(String.valueOf(objetoSelecionado.getValorDiabete()));
        tfPeso.setText(String.valueOf(objetoSelecionado.getValorPeso()));
        tfValorArterial.setText(String.valueOf(objetoSelecionado.getValorPressaoArterial()));
        tfAltura.setText(String.valueOf(objetoSelecionado.getAltura()));
    }

    @Override
    public void limparCampoFormulario() {
    }

}
