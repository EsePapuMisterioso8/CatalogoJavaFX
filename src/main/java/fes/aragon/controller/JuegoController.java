package fes.aragon.controller;

import fes.aragon.modelo.*;
import javafx.animation.AnimationTimer;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class JuegoController {

    @FXML
    private Canvas canvas;
    private Scene escena;
    private GraphicsContext graficos;

    private Thread hiloFondo;
    private AnimationTimer tiempo;
    public void ciclo(){
        long tiempoInicio = System.nanoTime();
        tiempo = new AnimationTimer() {
            @Override
            public void handle(long tiempoActual) {
                double t = (tiempoActual-tiempoInicio)/1000000000.0;
                calculosLogicos();
                pintar();
            }

        };
        tiempo.start();
    }


    private void pintar() {
        for(ComponentesJuego componentesJuego:SinglentonJuegos.getInstance().getElementos()){
            componentesJuego.pintar(graficos);
        }



    }

    private void calculosLogicos() {
        for(ComponentesJuego componentesJuego:SinglentonJuegos.getInstance().getElementos()){
            componentesJuego.logicaCalculos();
        }
    }

    public void setEscena(Scene escena){
        this.escena = escena;
    }

    public void iniciar(){
        componentesIniciar();
        cerrarJuego();
        pintar();
        eventosTeclado();
        eventoRaton();
        ciclo();
    }

   public void eventosTeclado(){
       escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
           @Override
           public void handle(KeyEvent keyEvent) {
               System.out.println("presionado");
               SinglentonJuegos.getInstance().getNave().teclado(keyEvent,true);
               SinglentonJuegos.getInstance().getCirculo().teclado(keyEvent,true);
           }
       });
       escena.setOnKeyReleased(new EventHandler<KeyEvent>() {
           @Override
           public void handle(KeyEvent keyEvent) {
               System.out.println("soltado");
               SinglentonJuegos.getInstance().getNave().teclado(keyEvent,false);
           }
       });
   }

    private void componentesIniciar(){
        graficos = canvas.getGraphicsContext2D();
        SinglentonJuegos.getInstance();
        MusicaCiclica musicaCiclica = new MusicaCiclica("musica_entrada");
        hiloFondo = new Thread(musicaCiclica);
        hiloFondo.start();
    }
    public void eventoRaton(){
        escena.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                SinglentonJuegos.getInstance().getFondo().raton(mouseEvent);
            }
        });
    }
    public void cerrarJuego(){
        Stage stage = (Stage) canvas.getScene().getWindow();
        stage.setOnCloseRequest((t)->{
            tiempo.stop();
            SinglentonJuegos.getInstance().iniciar();
            hiloFondo.stop();
            stage.close();
            }
        );
    }
}
