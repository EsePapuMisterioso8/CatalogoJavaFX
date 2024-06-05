package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Enemigop extends ComponentesJuego{
    private Rectangle figura ;
    private Rectangle otraFigura;
    private boolean disparo=true;
    private int contador=0;
    private int otroContador=0;
    public Enemigop(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);
        figura = new Rectangle(325,176,47,47);
        otraFigura = new Rectangle(363,535,50,35);
    }

    @Override
    public void pintar(GraphicsContext grafico) {
        grafico.strokeRect(figura.getX(),figura.getY(),figura.getWidth(),figura.getHeight());
        grafico.strokeRect(otraFigura.getX(),otraFigura.getY(),otraFigura.getWidth(),otraFigura.getHeight());
    }

    @Override
    public void teclado(KeyEvent evento, boolean presion) {

    }

    @Override
    public void raton(MouseEvent evento) {

    }

    @Override
    public void logicaCalculos() {


        if(disparo==true && contador>=0){
        if(contador<1) {
           Rectangle rectangulo = new Rectangle(figura.getX() + figura.getWidth(), figura.getY(), 10, 10);
            rectangulo.setFill(Paint.valueOf("#1F75FE"));
            SinglentonProyecto.getInstance().getDisparop().getDisparop().add(rectangulo);
            contador++;
        }

        }
        if(disparo==true && otroContador>=0) {
            if (otroContador < 1) {
                Rectangle rectangulos = new Rectangle(otraFigura.getX() + otraFigura.getWidth(), otraFigura.getY()+ (otraFigura.getHeight()/2)-3, 10, 10);
                SinglentonProyecto.getInstance().getDisparop().getOtro().add(rectangulos);
                otroContador++;
            }
        }
    }
}
