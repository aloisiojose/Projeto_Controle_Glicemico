package com.projetos.controleglicemico.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaPrincipalController implements Initializable {

    @FXML
    private Menu barraMenuAjuda;
    @FXML
    private MenuItem menuItemAjude;
    @FXML
    private Menu barraMenuSobre;
    @FXML
    private MenuItem menuItemSobre;
    @FXML
    private Menu barraMeunuArquivo;
    @FXML
    private MenuItem menuItemCadastro;
    @FXML
    private MenuItem menuItemHistorico;
    @FXML
    private MenuItem menuItemRelatorio;
    @FXML
    private MenuItem menuItemGrafico;
    @FXML
    private MenuItem menuItemSair;
    @FXML
    private Button btnCadastro;
    @FXML
    private Button btnHistorico;
    @FXML
    private Button btnListaMedicamento;
    @FXML
    private Button btnRelatorio;
    @FXML
    private Button btnAjuda;
    @FXML
    private Button btnColeta;
    @FXML
    private MenuItem menuItemCidadeEstado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCadastro.setGraphic(new ImageView("/icons/cadastro.png"));
        // menuItemCadastroTipoSanguinio.setGraphic(new ImageView("/fxml/TipoSanguinio.fxml"));
        // menuItemCadastroCidadeEstado.setGraphic(new ImageView("/icons/CidadeEstado.fxml"));
    }

    @FXML
    private void acessarItemAjuda(ActionEvent event) throws IOException {
        abrirFormulario("Ajuda");
    }

    @FXML
     private void acessarColeta(ActionEvent event) throws IOException {
        abrirFormulario("Coleta");
    }

    @FXML
    private void acessarItemCadastro(ActionEvent event) throws IOException {
         abrirFormulario("CadastroPessoal");
    }

    @FXML
    private void acessarItemRelatorio(ActionEvent event) throws IOException {
        abrirFormulario("Grafico");
    }

    @FXML
    private void acessarItemGrafico(ActionEvent event) throws IOException {
        abrirFormulario("Grafico");
    }

    @FXML
    private void acessarItemSair(ActionEvent event) {
    }

    @FXML
    private void acessarCadastro(ActionEvent event) throws IOException {
        abrirFormulario("CadastroPessoal");
    }

    @FXML
    private void acessarHistorico(ActionEvent event) throws IOException {
        abrirFormulario("Historico");
    }

    @FXML
    private void acessarListaMedicamento(ActionEvent event) throws IOException {
        abrirFormulario("MedicamentoPaciente");
    }

    @FXML
    private void acessarItemHistorico(ActionEvent event) throws IOException {
        abrirFormulario("Historico");
    }

    @FXML
    private void acessarRelatorio(ActionEvent event) throws IOException {
        abrirFormulario("Grafico");
    }

    private void acessarSobre(ActionEvent event) throws IOException {
        abrirFormulario("Sobre");
    }

    @FXML
    private void acessarAjuda(ActionEvent event) throws IOException {
        abrirFormulario("Ajuda");
    }
    
        @FXML
    private void acessarItemSobre(ActionEvent event) {
         abrirFormulario("Sobre");
    }

    @FXML
    private void acessarItemCidadeEstado(ActionEvent event) {
        abrirFormulario("CidadeEstado");
    }

    public void abrirFormulario(String formulario){
        try{
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + formulario + ".fxml"));
        
        Image applicationtioIcon = new Image(getClass().getResourceAsStream("/icons/medico.png") );
        
        
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Controle Glicêmico ");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(applicationtioIcon);
        stage.show();
        } catch (Exception e ){
    }
    }

}
