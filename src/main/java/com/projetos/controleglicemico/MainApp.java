package com.projetos.controleglicemico;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TelaPrincipal.fxml"));
        
        Image applicationtioIcon = new Image(getClass().getResourceAsStream("/icons/medico.png") );
        stage.getIcons().add(applicationtioIcon);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        
        stage.setTitle("Controle Glicêmico ");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

      public static void main(String[] args) {
        launch(args);
    }

}
