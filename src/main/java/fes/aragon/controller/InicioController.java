package fes.aragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class InicioController {

    @FXML
    private Button btnRacionales;
    @FXML
    private Button bntArchivo;
    @FXML
    private Button btnUsuarios;
    @FXML
    private Button btnJuego;
    @FXML
    private BorderPane btpPrincipal;


    @FXML
    void abrirArchivo(ActionEvent event) {
        escena("/fes/aragon/xml/archivo.fxml");
    }
    @FXML
    void accionAbrirRacionales(ActionEvent event) {
        escena("/fes/aragon/xml/racional.fxml");
    }
    @FXML
    void accionAbrirUsuarios(ActionEvent event) {
        escena("/fes/aragon/xml/usuarios.fxml");
    }
    public void escena(String ruta){
        try {
            Contenido contenido = new Contenido(ruta);
            btpPrincipal.setCenter(contenido);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void accionJuego(ActionEvent event) {
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

}
