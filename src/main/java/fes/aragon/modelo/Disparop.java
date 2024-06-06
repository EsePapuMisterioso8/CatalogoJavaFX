package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Disparop extends ComponentesJuego{
private ArrayList<Rectangle> disparos = new ArrayList<>();
private ArrayList<Rectangle> otro = new ArrayList<>();
private Image imagen;

    public Disparop(int x, int y, String imagen, int velocidad) {
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
        for(Rectangle disparo: disparos){
            //grafico.strokeRect(disparo.getX(), disparo.getY(), disparo.getWidth(),disparo.getHeight());
            grafico.drawImage(imagen,disparo.getX(),disparo.getY(),disparo.getWidth(),disparo.getHeight());
        }
        for (Rectangle disparo:otro){
            //grafico.strokeRect(disparo.getX(), disparo.getY(), disparo.getWidth(),disparo.getHeight());
            grafico.drawImage(imagen,disparo.getX(),disparo.getY(),disparo.getWidth(),disparo.getHeight());
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
        if (balas.getX() < SinglentonProyecto.getInstance().getFondop().getImagenUno().getWidth() -balas.getWidth()) {
            balas.setX((balas.getX()+1));
        }else {
            balas.setX(SinglentonProyecto.getInstance().getEnemigop().x+20);
        }
    }
    for (Rectangle balas: otro) {
        if (balas.getX() < SinglentonProyecto.getInstance().getFondop().getImagenUno().getWidth() -balas.getWidth()) {
            balas.setX((balas.getX()+2));
        }else {
            balas.setX(52);
        }
    }




    for (Rectangle bala: disparos){
        if(bala.getBoundsInLocal().intersects(SinglentonProyecto.getInstance().getPersonaje().x,SinglentonProyecto.getInstance().getPersonaje().y,40,60)){
            System.out.println("Muerto");
            SinglentonProyecto.getInstance().getPersonaje().setX(58);
            SinglentonProyecto.getInstance().getPersonaje().setY(660);
        }
    }
    for (Rectangle balas: otro){
        if(balas.getBoundsInLocal().intersects(SinglentonProyecto.getInstance().getPersonaje().x,SinglentonProyecto.getInstance().getPersonaje().y,40,60)){
            System.out.println("Muerto");
            SinglentonProyecto.getInstance().getPersonaje().setX(58);
            SinglentonProyecto.getInstance().getPersonaje().setY(660);
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
