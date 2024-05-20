package fes.aragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button btnabrirjuego;

    @FXML
    private Button btnmusica;

    @FXML
    private Pane pneMenu;

    @FXML
    void accionAbrirjuego(ActionEvent event) {
        try {
            FXMLLoader modificar = new FXMLLoader(getClass().getResource("/fes/aragon/xml/juego.fxml"));
            Parent parent  = (Parent)modificar.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.APPLICATION_MODAL);
            ((JuegoController)modificar.getController()).setEscena(scene);
            ((JuegoController)modificar.getController()).iniciar();
            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    void accionPonermusica(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fes/aragon/xml/musica.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
