
package com.projetos.controleglicemico.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class HistoricoController implements Initializable {

    @FXML
    private Label lbTitulo;
    @FXML
    private JFXTextField tfPesquisa;
    @FXML
    private TableView<?> tbView;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbTitulo.setText("Histórico");
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
    
}
