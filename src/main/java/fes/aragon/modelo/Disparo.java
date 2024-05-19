package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Disparo extends ComponentesJuego{
    private ArrayList<Rectangle> disparos = new ArrayList<>();
    public Disparo(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);
    }

    @Override
    public void pintar(GraphicsContext grafico) {
    for(Rectangle bala:disparos){

        grafico.fillRect(bala.getX(),bala.getY(),bala.getWidth(),bala.getHeight());
        grafico.setFill(Paint.valueOf("#1F75FE"));
       // EfectosMusica efectosMusica = new EfectosMusica("disparos");
        //Thread hilosEfecto = new Thread(efectosMusica);
                    //hilosEfecto.start();

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
    //para recorrer el disparo
        for(Rectangle bala:disparos){
            bala.setY(bala.getY()-1);
        }
        //revisamos el primer disasparo viendo si no se sale de la pantalla
        if(!disparos.isEmpty() && disparos.get(0).getY()<=0){
            disparos.remove(0);
        }
        //revismoa las colisiones
        ArrayList<Rectangle> enemigos = new ArrayList<>();
        ArrayList<Rectangle> balas = new ArrayList<>();
        for(Rectangle bala: disparos){
            for(Rectangle rect: SinglentonJuegos.getInstance().getEnemigo().getEnemigo()){
                if(bala.getBoundsInLocal().intersects(rect.getBoundsInLocal())){
                    System.out.println("colision");
                    EfectosMusica efectosMusica = new EfectosMusica("disparo");
                    Thread hilosEfecto = new Thread(efectosMusica);
                    hilosEfecto.start();
                    enemigos.add(rect);
                    balas.add(bala);
                    break;
                }
            }
        }
        //removemiendo los diparos
        for(Rectangle recta:balas){
            disparos.remove(recta);
        }
        //removiendo enenemigos
        for(Rectangle enemigo: enemigos){
            SinglentonJuegos.getInstance().getEnemigo().getEnemigo().remove(enemigo);
        }
    }
    public ArrayList<Rectangle> getDisparos(){
        return disparos;
    }
    //xddddddddddddddddd
}
