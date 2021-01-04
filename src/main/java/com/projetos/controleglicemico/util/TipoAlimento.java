
package com.projetos.controleglicemico.util;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TipoAlimento {
    private static ObservableList<String> obsList;
    
    public static ObservableList gerarTipoAlimento() {
        obsList = FXCollections.observableArrayList(
                "Café da Manhã",
                "Almoço",
                "Lanche da Tarde",
                "Janta"
        );
        return obsList;
    }
}