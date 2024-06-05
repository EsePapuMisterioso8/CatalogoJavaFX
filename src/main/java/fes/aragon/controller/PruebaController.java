package fes.aragon.controller;

import fes.aragon.modelo.ComponentesJuego;
import fes.aragon.modelo.Personaje;
import fes.aragon.modelo.SinglentonProyecto;
import fes.aragon.modelo.SinglentonPrueba;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class PruebaController {

    @FXML
    private Canvas canvasPrueba;

    @FXML
    private Pane pnePrueba;
    private Scene escena;
    private GraphicsContext graficos;
    private Personaje personaje;
    private AnimationTimer tiempo;
    public void setEscena(Scene scene){
        this.escena =scene;
    }
    public void inicio(){
        componentesIniciar();
        cerrarJuego();
        pintar();
        eventosTeclado();
        eventoRaton();
        ciclo();
        verificarCambioEscenario();
    }

    private void ciclo() {
        long tiempoInicio = System.nanoTime();
         this.tiempo = new AnimationTimer() {
            @Override
            public void handle(long tiempoActual) {
                double t = (tiempoActual-tiempoInicio)/1000000000.0;
                calculosLogicos();
                pintar();
            }

        };
        tiempo.start();
    }

    private void eventoRaton() {
        escena.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SinglentonPrueba.getInstance().getFondop().raton(event);
            }
        });
    }
    private void eventosTeclado() {
        escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("presionado");
                SinglentonPrueba.getInstance().getPersonaje().teclado(event,true);
            }
        });
        escena.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("soltado");
                SinglentonPrueba.getInstance().getPersonaje().teclado(event,false);
            }
        });


    }

    private void pintar() {
        for (ComponentesJuego componentesJuego: SinglentonPrueba.getInstance().getElementos()){
            componentesJuego.pintar(graficos);
        }
    }

    private void componentesIniciar() {
        graficos = canvasPrueba.getGraphicsContext2D();
        SinglentonPrueba.getInstance();
    }
    private void calculosLogicos(){
        for(ComponentesJuego componentesJuego:SinglentonPrueba.getInstance().getElementos()){
            componentesJuego.logicaCalculos();
        }
    }
    public void cerrarJuego(){
        Stage stage = (Stage) canvasPrueba.getScene().getWindow();
        stage.setOnCloseRequest((t)->{
            tiempo.stop();
            SinglentonPrueba.getInstance().iniciar();
            stage.close();
            }
        );
    }
    private void verificarCambioEscenario() {
        Personaje personaje = SinglentonPrueba.getInstance().getPersonaje();
        int x = personaje.getX();
        int y = personaje.getY();
        if (x == 860 && y == 670) {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("/fes/aragon/xml/proyecto.fxml"));
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
    }

}
