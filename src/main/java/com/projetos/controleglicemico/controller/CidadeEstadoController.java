package com.projetos.controleglicemico.controller;

import com.jfoenix.controls.JFXTextField;
import com.projetos.controleglicemico.dao.CidadeEstadoDao;
import com.projetos.controleglicemico.model.CadastroPessoa;
import com.projetos.controleglicemico.model.CidadeEstado;
import com.projetos.controleglicemico.util.Alerta;
import java.net.URL;
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

public class CidadeEstadoController implements Initializable, ICadastro {

    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnCorrigir;
    @FXML
    private Button btnNovo;
    @FXML
    private ComboBox<String> cbCidadeEstado;
    @FXML
    private JFXTextField tfCEP;
    @FXML
    private Label lbTitulo;
    @FXML
    private JFXTextField tfCidade;

    private CidadeEstadoDao dao = new CidadeEstadoDao();
    private ObservableList<CidadeEstadoDao> observableList = FXCollections.observableArrayList();
    private List<CidadeEstado> lista;;
    private CidadeEstado objetoSelecionado = new CidadeEstado();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbTitulo.setText("Cidade Estado ");
        // TODO
    }

    @FXML
    private void salvarRegistro(ActionEvent event) {

        CidadeEstado cidadeEstado = new CidadeEstado();

        if (objetoSelecionado != null) {
            cidadeEstado.setId(objetoSelecionado.getId());
        }

        cidadeEstado.setCep(Long.parseLong(tfCEP.getText()));
        cidadeEstado.setCidade(tfCidade.getText());

        if (dao.salvar(cidadeEstado)) {
            Alerta.msgInformacao("Registro Gravado com Sucesso");
        } else {
            Alerta.msgInformacao("Ocorreu um Erro ao tentar gravar o registro");
        }
    }

    @FXML
    private void corrigirRegistro(ActionEvent event) {
        if (Alerta.msgConfirmarExclusao(tfCidade.getText())) {

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

    }

    @Override
    public void atualizarTabela() {
        
    }

    @Override
    public void setCamposFormulario() {

    }

    @Override
    public void limparCampoFormulario() {
        tfCEP.clear();
        tfCidade.clear();
        cbCidadeEstado.clipProperty();
        objetoSelecionado = null;
        tfCEP.requestFocus();
        atualizarTabela();
    }

}
