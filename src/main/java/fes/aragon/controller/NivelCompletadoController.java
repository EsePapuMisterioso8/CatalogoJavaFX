package fes.aragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class NivelCompletadoController {
    private MenuController menuController;

    @FXML
    private Button btnSiguente;

    @FXML
    private Button btnTabla;
    private Scene scene;

    @FXML
    void accionPonerMusica(ActionEvent event) {

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fes/aragon/xml/musica.fxml"));
            scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setAlwaysOnTop(true);
            stage.show();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    void accionSIguenteNIvel(ActionEvent event) {

    }
}
