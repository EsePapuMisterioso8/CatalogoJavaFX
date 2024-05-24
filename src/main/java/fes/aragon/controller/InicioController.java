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
    @FXML
    void accionJuego(ActionEvent event) {
        escena("/fes/aragon/xml/menu.fxml");
    }

    public void escena(String ruta) {
        try {
            Contenido contenido = new Contenido(ruta);
            btpPrincipal.setCenter(contenido);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}