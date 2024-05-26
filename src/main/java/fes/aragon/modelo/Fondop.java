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
    private Image imagendos;
    int yy = 0;
    public Fondop(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);
        File file =new File(imagen);
        this.imagenUno = new Image(file.toURI().toString());
        file = new File(imagen);
        this.imagendos = new Image(file.toURI().toString());
    }

    @Override
    public void pintar(GraphicsContext grafico) {
    grafico.drawImage(imagenUno,x,y);
    grafico.drawImage(imagendos,x,yy);
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
        /*
    y+=velocidad;
    yy+=velocidad;
    if(y>=400){
        y=-400;
    }if(yy>=400){
        yy=-400;
        }

         */
    }
    public Image getImagenUno(){
        return imagenUno;
    }
}
