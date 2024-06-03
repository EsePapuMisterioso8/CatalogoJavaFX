package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Trampas extends ComponentesJuego{
    private Image image;
    private ArrayList<Rectangle> trampa =new ArrayList<>();
    public Trampas(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);
        try {
            FileInputStream fi= new FileInputStream(imagen);
            image = new Image(fi);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int xx= 464;
        int yy=576;
        for(int i=0;i<10;i++){
        Rectangle rectangle = new Rectangle(xx,yy,20,20);
        trampa.add(rectangle);
        switch (i){
            case 1:
                rectangle = new Rectangle(663,540,20,20);
                trampa.add(rectangle);
                break;
            case 2:
                rectangle = new Rectangle(1,378,29,19);
                trampa.add(rectangle);
                break;
            case 3:
                rectangle = new Rectangle(71,358,23,10);
                trampa.add(rectangle);
                break;
            case 4:
                rectangle = new Rectangle(134,343,23,10);
                trampa.add(rectangle);
                break;
            case 5:
                rectangle = new Rectangle(308,345,23,10);
                trampa.add(rectangle);
                break;
            case 6:
                rectangle = new Rectangle(220,365,23,10);
                trampa.add(rectangle);
                break;
            case 7:
                rectangle = new Rectangle(465,300,23,10);
                trampa.add(rectangle);
                break;
        }
        }
    }

    @Override
    public void pintar(GraphicsContext grafico) {
    for (Rectangle trampa : trampa){
        grafico.fillRect(trampa.getX(),trampa.getY(),trampa.getWidth(),trampa.getHeight());
        grafico.drawImage(image,trampa.getX(),trampa.getY(),trampa.getWidth(),trampa.getHeight());
    }
    }

    @Override
    public void teclado(KeyEvent evento, boolean presion) {

    }

    @Override
    public void raton(MouseEvent evento) {

    }

    @Override
    public void logicaCalculos() {

    }
    public ArrayList<Rectangle> getTrampa(){
        return  trampa;
    }
}
