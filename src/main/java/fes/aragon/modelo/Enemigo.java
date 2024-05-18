package fes.aragon.modelo;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Enemigo extends ComponentesJuego{
    private ArrayList<Rectangle> enemigo = new ArrayList<>();
    private boolean movimiento=true;

    public Enemigo(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);

        int salto=0;
        int xx = 20;
        int yy= 20;
        for(int i=0;i<16;i++){
            Rectangle enemigos = new Rectangle(xx,yy,20,20);
            enemigo.add(enemigos);
            xx += 30;
            salto ++;
            if(salto == 4){
                xx=20;
                yy += 30;
                salto= 0;
            }
        }

    }

    @Override
    public void pintar(GraphicsContext grafico) {
       for(Rectangle rectangle : enemigo){
           grafico.strokeRect(rectangle.getX(),rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
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
        if(movimiento == true){
            for(Rectangle recta:enemigo){
                recta.setX(recta.getX()+1);
                if(recta.getX()>=450){
                    movimiento=false;
                    for(Rectangle rect : enemigo){
                        rect.setY(rect.getY()+1);
                    }
                }
            }
        }else {
            for(Rectangle rectangle:enemigo){
                rectangle.setX(rectangle.getX()-1);
                if(rectangle.getX()<= 20){
                    movimiento=true;
                rectangle.setY(rectangle.getY()+1);
                }
            }

        }

    }
    public ArrayList<Rectangle> getEnemigo(){
        return enemigo;
    }
}
