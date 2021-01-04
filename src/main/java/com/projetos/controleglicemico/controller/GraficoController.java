
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
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class GraficoController implements Initializable {

    @FXML
    private Label lbTitulo;
    @FXML
    private JFXTextField tfNome;
    @FXML
    private LineChart<?, ?> grGraficoControleGlicemico;
    @FXML
    private JFXTextField tfCef;
    @FXML
    private JFXDatePicker dtData;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       lbTitulo.setText("Grafico");
    }    

    
}
