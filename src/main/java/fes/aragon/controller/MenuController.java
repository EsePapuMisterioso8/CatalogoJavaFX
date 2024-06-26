package fes.aragon.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private Pane pneMenu;

    @FXML
    private FontAwesomeIconView icnJuego;

    @FXML
    private FontAwesomeIconView icnMusica;

    @FXML
    private FontAwesomeIconView icnControles;

    private Thread hiloFondo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        icnControles.setGlyphStyle("-fx-cursor:hand;");
        icnJuego.setGlyphStyle("-fx-cursor:hand;");
        icnMusica.setGlyphStyle("-fx-cursor:hand;");
    }

    @FXML
    void accionIniciarJuego(MouseEvent event) {

        try {
            FXMLLoader modificar = new FXMLLoader(getClass().getResource("/fes/aragon/xml/proyecto.fxml"));
            Parent parent  = (Parent)modificar.load();
            Scene scene = new Scene(parent);
            ((ProyectoController)modificar.getController()).setEscena(scene);
            ((ProyectoController)modificar.getController()).iniciar();
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
    @FXML
    void accionTablaMusica(MouseEvent event) {
        try {

            Parent parent = FXMLLoader.load(getClass().getResource("/fes/aragon/xml/musica.fxml"));
            Scene scene = new Scene(parent);
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
    void accionAbrirControles(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fes/aragon/xml/controles.fxml"));
        try {
            Parent parent = (Parent)fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
