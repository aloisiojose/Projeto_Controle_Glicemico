
package com.projetos.controleglicemico.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UF {
    private static ObservableList<String> obsList;
    
    public static ObservableList gerarUF() {
        obsList = FXCollections.observableArrayList(
                "MG",
                "SP",
                "RJ"
        );
        return obsList;
    }
}