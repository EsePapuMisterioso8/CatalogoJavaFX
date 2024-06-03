package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Disparop extends ComponentesJuego{
private ArrayList<Rectangle> disparos = new ArrayList<>();
private ArrayList<Rectangle> otro = new ArrayList<>();
    public Disparop(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);

    }

    @Override
    public void pintar(GraphicsContext grafico) {
    for(Rectangle disparo: disparos){
        grafico.fillRect(disparo.getX(),disparo.getY(),disparo.getWidth(),disparo.getHeight());
    }
    for (Rectangle disparo:otro){
        grafico.fillRect(disparo.getX(),disparo.getY(),disparo.getWidth(),disparo.getHeight());
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

    for (Rectangle balas: disparos) {
        if (balas.getX() < SinglentonPrueba.getInstance().getFondop().getImagenUno().getWidth() -balas.getWidth()) {
            balas.setX((balas.getX()+1));
        }else {
            balas.setX(SinglentonPrueba.getInstance().getEnemigop().x+20);
        }
    }
    for (Rectangle balas: otro) {
        if (balas.getX() < SinglentonPrueba.getInstance().getFondop().getImagenUno().getWidth() -balas.getWidth()) {
            balas.setX((balas.getX()+1));
        }else {
            balas.setX(305);
        }
    }




    for (Rectangle bala: disparos){
        if(bala.getBoundsInLocal().intersects(SinglentonPrueba.getInstance().getPersonaje().x,SinglentonPrueba.getInstance().getPersonaje().y,40,60)){
            System.out.println("Muerto");
            SinglentonPrueba.getInstance().getPersonaje().setX(25);
            SinglentonPrueba.getInstance().getPersonaje().setY(580);
        }
    }
    for (Rectangle balas: otro){
        if(balas.getBoundsInLocal().intersects(SinglentonPrueba.getInstance().getPersonaje().x,SinglentonPrueba.getInstance().getPersonaje().y,40,60)){
            System.out.println("Muerto");
            SinglentonPrueba.getInstance().getPersonaje().setX(25);
            SinglentonPrueba.getInstance().getPersonaje().setY(580);
        }
    }
    }
    public ArrayList<Rectangle> getDisparop(){
        return disparos;
    }
    public  ArrayList<Rectangle> getOtro(){
        return otro;
    }
}
