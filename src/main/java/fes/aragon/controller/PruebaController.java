package fes.aragon.controller;

import fes.aragon.modelo.ComponentesJuego;
import fes.aragon.modelo.Personaje;
import fes.aragon.modelo.SinglentonProyecto;
import fes.aragon.modelo.SinglentonPrueba;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PruebaController {

    @FXML
    private Canvas canvasPrueba;

    @FXML
    private Pane pnePrueba;
    private Scene escena;
    private GraphicsContext graficos;
    private Personaje personaje;
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
    }

    private void ciclo() {
        long tiempoInicio = System.nanoTime();
        AnimationTimer tiempo = new AnimationTimer() {
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
    private void cerrarJuego() {
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

}
