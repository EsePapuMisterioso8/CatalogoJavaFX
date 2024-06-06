package fes.aragon.controller;

import fes.aragon.modelo.ComponentesJuego;
import fes.aragon.modelo.Persona;
import fes.aragon.modelo.Personaje;
import fes.aragon.modelo.SinglentonProyecto;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ProyectoController {

    @FXML
    private Canvas canvas;

    @FXML
    private Pane pnePrincipal;
    private Scene escena;
    private GraphicsContext graficos;
    public void setEscena(Scene scene){
        this.escena =scene;
    }
    public void iniciar(){
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
                try {
                    Thread.sleep(9);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        tiempo.start();
    }

    public void eventoRaton() {
        escena.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            SinglentonProyecto.getInstance().getFondop().raton(event);
            }
        });
    }

    public void eventosTeclado() {
        escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("presionado");
                SinglentonProyecto.getInstance().getPersonaje().teclado(event,true);
            }
        });
        escena.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("soltado");
                SinglentonProyecto.getInstance().getPersonaje().teclado(event,false);

            }
        });
    }

    private void pintar() {
        for (ComponentesJuego componentesJuego: SinglentonProyecto.getInstance().getElementos()){
            componentesJuego.pintar(graficos);
        }

    }

    private void cerrarJuego() {

    }

    private void componentesIniciar() {
        graficos = canvas.getGraphicsContext2D();
        SinglentonProyecto.getInstance();
    }

    private void calculosLogicos(){
       for(ComponentesJuego componentesJuego:SinglentonProyecto.getInstance().getElementos()){
           componentesJuego.logicaCalculos();
       }
    }
}
