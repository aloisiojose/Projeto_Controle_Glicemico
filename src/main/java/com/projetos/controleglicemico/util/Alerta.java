package com.projetos.controleglicemico.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class Alerta {

    static ButtonType btnConfirmar = new ButtonType("Confirmar");
    static ButtonType btnCancelar = new ButtonType("Cancelar");
    static boolean resposta;

    public static void msgInformacao(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("INFORMAÇÃO PARA O CADASTRO");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static boolean msgConfirmarExclusao(String mensagemExclusao) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Exclusão de Registro");
        alert.setContentText(mensagemExclusao);
        alert.getButtonTypes().setAll(btnConfirmar, btnCancelar);
        alert.showAndWait().ifPresent(b -> {
            if (b == btnConfirmar) {
                resposta = true;
            } else {
                resposta = false;
            }
        });
        return resposta;
    }
}
