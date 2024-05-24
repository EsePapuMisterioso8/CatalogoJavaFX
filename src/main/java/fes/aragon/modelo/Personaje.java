package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Personaje extends ComponentesJuego{
    private Image imagen;
    private boolean derecha;
    private boolean izquierda;
    private boolean arriba;
    private boolean abajo;
    private int ancho=40;
    private int alto = 40;
    public Personaje(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);
        try {
            FileInputStream fi = new FileInputStream(imagen);
            this.imagen = new Image(fi);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void pintar(GraphicsContext grafico) {
    grafico.drawImage(imagen,x,y,ancho,alto);
    }

    @Override
    public void teclado(KeyEvent evento, boolean presion) {
        switch (evento.getCode().toString()){
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
        }

    }

    @Override
    public void raton(MouseEvent evento) {

    }

    @Override
    public void logicaCalculos() {
            if(derecha){
                    if(x<SinglentonProyecto.getInstance().getFondop().getImagenUno().getWidth()-ancho) {
                    this.x++;
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
                if (y<SinglentonProyecto.getInstance().getFondop().getImagenUno().getHeight()-alto){
                    y++;
                }
            }
    }
}