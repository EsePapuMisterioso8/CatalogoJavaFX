package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Nave extends ComponentesJuego {

    private boolean derecha = false;
    private boolean izquierda = false;
    private boolean arriba = false;
    private boolean abajo = false;
    private boolean disparo = false;
    private int ancho = 20;
    private int alto = 20;
    private Image imageNave;

    public Nave(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);
        try {
            FileInputStream fi = new FileInputStream(imagen);
            this.imageNave = new Image(fi);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void pintar(GraphicsContext grafico) {
        grafico.drawImage(imageNave, x, y, ancho, alto);


    }

    @Override
    public void teclado(KeyEvent evento, boolean presion) {
        if (evento.isAltDown()) {
            String codigo = evento.getCode().toString();
            if (codigo.equals("X")) {
                System.out.println("evento combinado");
            }
        }
        switch (evento.getCode().toString()) {
            case "RIGHT":
                derecha = true;
                izquierda = false;
                arriba = false;
                abajo = false;
                break;
            case "LEFT":
                derecha = false;
                izquierda = true;
                arriba = false;
                abajo = false;
                break;
            case "UP":
                derecha = false;
                izquierda = false;
                arriba = true;
                abajo = false;
                break;
            case "DOWN":
                derecha = false;
                izquierda = false;
                arriba = false;
                abajo = true;
                break;
            case "F":
                if (!presion) {
                    disparo = true;

                }
                break;
        }
    }

    @Override
    public void raton(MouseEvent evento) {

    }

    @Override
    public void logicaCalculos() {
        if (derecha) {
            if(x < SinglentonJuegos.getInstance().getFondo().getImge().getWidth()-SinglentonJuegos.getInstance().getNave().ancho){
                x++;
            }
        } else if (izquierda) {
            if(x>0){
                x--;
            }
        } else if (arriba) {
            if(y>0){
                y--;
            }
        } else if (abajo) {
            if(y<SinglentonJuegos.getInstance().getFondo().getImge().getHeight()-alto){
                y++;
            }
        }
        if(disparo){
            Rectangle bala = new Rectangle(x,y,10,10);
            SinglentonJuegos.getInstance().getDisparo().getDisparos().add(bala);
            disparo= false;
        }
        //prueba
    }
}