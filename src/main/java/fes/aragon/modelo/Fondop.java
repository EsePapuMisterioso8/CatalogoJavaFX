package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Fondop extends ComponentesJuego{
    private Image imagenUno;

    public Fondop(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);
        File file =new File(imagen);
        this.imagenUno = new Image(file.toURI().toString());
    }

    @Override
    public void pintar(GraphicsContext grafico) {
    grafico.drawImage(imagenUno,x,y);
    }

    @Override
    public void teclado(KeyEvent evento, boolean presion) {

    }

    @Override
    public void raton(MouseEvent evento) {
        System.out.println(evento.getX() + " " + evento.getY());
    }

    @Override
    public void logicaCalculos() {

    }
    public Image getImagenUno(){
        return imagenUno;
    }
}
