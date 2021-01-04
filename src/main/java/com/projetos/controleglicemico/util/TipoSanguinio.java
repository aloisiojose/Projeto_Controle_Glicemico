
package com.projetos.controleglicemico.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TipoSanguinio {
    private static ObservableList<String> obsList;
    
    public static ObservableList gerarTipoSanguinio() {
        obsList = FXCollections.observableArrayList(
                "Sangue tipo AB+ ",
                "Sangue tipo AB-",
                "Sangue tipo O+",
                "Sangue tipo O-"
        );
        return obsList;
    }
}