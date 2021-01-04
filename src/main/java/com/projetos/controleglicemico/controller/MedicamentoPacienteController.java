package com.projetos.controleglicemico.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.projetos.controleglicemico.dao.MedicamentoDao;
import com.projetos.controleglicemico.model.Coleta;
import com.projetos.controleglicemico.model.MedicamentoPaciente;
import com.projetos.controleglicemico.util.Alerta;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class MedicamentoPacienteController implements Initializable, ICadastro {

    @FXML
    private Label lbTitulo;
    @FXML
    private JFXTextField tfPesquisa;
    @FXML
    private TableView<MedicamentoPaciente> tbView;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnCorrigir;
    @FXML
    private Button btnNovo;
    @FXML
    private JFXTextField tbNomeComercial;
    @FXML
    private JFXTextField tbCodigo;
    @FXML
    private JFXTextArea tbDescricao;
    @FXML
    private JFXDatePicker dtDataMedicamento;
    @FXML
    private JFXTextField tbNomeQuimico;
    @FXML
    private JFXTextField tfPrescricaoMedica;

    private MedicamentoDao dao = new MedicamentoDao();
    private ObservableList<Coleta> observableList = FXCollections.observableArrayList();
    private List<Coleta> listCadastro;
    private MedicamentoPaciente objetoSelecionado = new MedicamentoPaciente();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbTitulo.setText("Cadastro Medicamento");
        criarColunasTabela();
    }

    @FXML
    private void filtrarRegistro(KeyEvent event) {
    }

    @FXML
    private void clicarTabela(MouseEvent event) {

    }

    @FXML
    private void moverTabela(KeyEvent event) {
    }

    @FXML
    private void salvarRegistro(ActionEvent event) {
        MedicamentoPaciente medicamentoPaciente = new MedicamentoPaciente();

         if (objetoSelecionado != null) {
            medicamentoPaciente.setId(objetoSelecionado.getId());
        }
        medicamentoPaciente.setNomeComercial(tbNomeComercial.getText());
        medicamentoPaciente.setNomeQuimico(tbNomeQuimico.getText());
        medicamentoPaciente.setDescricao(tbDescricao.getText());
        medicamentoPaciente.setPrescreicaoMedica(tfPrescricaoMedica.getText());
        LocalDate dadtaDataMedicamento = dtDataMedicamento.getValue();

        medicamentoPaciente.setDataHora(dadtaDataMedicamento);

        if (dao.salvar(medicamentoPaciente)) {
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

    @Override
    public void criarColunasTabela() {
        TableColumn<MedicamentoPaciente, Long> colunaId = new TableColumn<>("ID");
        colunaId.setMinWidth(40);
        colunaId.setMaxWidth(40);

        TableColumn<MedicamentoPaciente, String> colunaNomeComercial = new TableColumn<>("NOME COMERCIAL");
        TableColumn<MedicamentoPaciente, String> colunaNomeQuimico = new TableColumn<>("NOME QUÍMICO");
        TableColumn<MedicamentoPaciente, String> colunaPrescricaoMedica = new TableColumn<>("PRESCRIÇÃO MÉDICA");

        tbView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tbView.getColumns().addAll(colunaId, colunaNomeComercial, colunaNomeQuimico, colunaPrescricaoMedica);

        colunaId.setCellValueFactory(new PropertyValueFactory("id"));
        colunaNomeComercial.setCellValueFactory(new PropertyValueFactory("nome comercial"));
        colunaNomeQuimico.setCellValueFactory(new PropertyValueFactory("nome quimico"));
        colunaPrescricaoMedica.setCellValueFactory(new PropertyValueFactory("prescrição médica"));

    }

    @Override
    public void atualizarTabela() {

    }

    @Override
    public void setCamposFormulario() {
        objetoSelecionado = tbView.getItems().get(tbView.getSelectionModel().getSelectedIndex());
        tbNomeComercial.setText(objetoSelecionado.getNomeComercial());
        tbNomeQuimico.setText(objetoSelecionado.getNomeQuimico());
        tbDescricao.setText(objetoSelecionado.getDescricao());
        tfPrescricaoMedica.setText(objetoSelecionado.getPrescreicaoMedica());
        dtDataMedicamento.setValue(objetoSelecionado.getDataHora());
        
         
    }

    @Override
    public void limparCampoFormulario() {

    }

}
