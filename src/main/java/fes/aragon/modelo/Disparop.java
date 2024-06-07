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

private ArrayList<Rectangle> soldadoBajo = new ArrayList<>();

private ArrayList<Rectangle> soldadoArriba = new ArrayList<>();

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
            grafico.drawImage(imagen,disparo.getX(),disparo.getY(),disparo.getWidth(),disparo.getHeight());
        }

        for (Rectangle disparo:otro){
            grafico.drawImage(imagen,disparo.getX(),disparo.getY(),disparo.getWidth(),disparo.getHeight());
        }

        for (Rectangle disparo: soldadoBajo){
            grafico.drawImage(imagen,disparo.getX(),disparo.getY(),disparo.getWidth(),disparo.getHeight());
        }

        for(Rectangle disparo : soldadoArriba){
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
            balas.setX(SinglentonProyecto.getInstance().getEnemigop().x+47);
        }
    }

    for (Rectangle balas: otro) {
        if (balas.getX() < SinglentonProyecto.getInstance().getFondop().getImagenUno().getWidth() -balas.getWidth()) {
            balas.setX((balas.getX()+1));
        }else {
            balas.setX(413);
        }
    }

    for(Rectangle balas: soldadoBajo){
        if(balas.getX()>0){
            balas.setX(balas.getX()-3);
        }else{
            balas.setX(960);
        }
    }

    for(Rectangle balas: soldadoArriba){
        if(balas.getX()<SinglentonProyecto.getInstance().getFondop().getImagenUno().getWidth()-balas.getWidth()){
                balas.setX(balas.getX()+3);
        }else{
            balas.setX(56);
        }
    }

    for (Rectangle bala: disparos){
        if(bala.getBoundsInLocal().intersects(SinglentonProyecto.getInstance().getPersonaje().x,SinglentonProyecto.getInstance().getPersonaje().y,20,30)){
            System.out.println("Muerto");
            SinglentonProyecto.getInstance().getPersonaje().setX(25);
            SinglentonProyecto.getInstance().getPersonaje().setY(580);
        }
    }

    for (Rectangle balas: otro){
        if(balas.getBoundsInLocal().intersects(SinglentonProyecto.getInstance().getPersonaje().x,SinglentonProyecto.getInstance().getPersonaje().y,20,30)){
            System.out.println("Muerto");
            SinglentonProyecto.getInstance().getPersonaje().setX(25);
            SinglentonProyecto.getInstance().getPersonaje().setY(580);
        }
    }

    for (Rectangle balas: soldadoBajo){
        if(balas.getBoundsInLocal().intersects(SinglentonProyecto.getInstance().getPersonaje().x,SinglentonProyecto.getInstance().getPersonaje().y,20,30)){
            System.out.println("Muerto");
            SinglentonProyecto.getInstance().getPersonaje().setX(25);
            SinglentonProyecto.getInstance().getPersonaje().setY(580);
        }
    }

    for (Rectangle balas:soldadoArriba){
        if(balas.getBoundsInLocal().intersects(SinglentonProyecto.getInstance().getPersonaje().x,SinglentonProyecto.getInstance().getPersonaje().y,20,30)){
            System.out.println("Muerto");
            SinglentonProyecto.getInstance().getPersonaje().setX(25);
            SinglentonProyecto.getInstance().getPersonaje().setY(580);
        }
    }

    }

    public ArrayList<Rectangle> getDisparop(){
        return disparos;
    }

    public  ArrayList<Rectangle> getOtro(){
        return otro;
    }

    public ArrayList<Rectangle> getSoldadoBajo(){
        return soldadoBajo;
    }

    public  ArrayList<Rectangle> getSoldadoArriba(){
        return soldadoArriba;
    }
}
