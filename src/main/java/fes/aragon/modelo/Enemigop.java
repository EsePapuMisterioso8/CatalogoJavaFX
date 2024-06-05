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
        figura = new Rectangle(370,533,20,35);
        otraFigura = new Rectangle(230,159,75,50);
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
            Rectangle rectangulo = new Rectangle(x + figura.getWidth(), y, 10, 10);
            rectangulo.setFill(Paint.valueOf("#1F75FE"));
            SinglentonProyecto.getInstance().getDisparop().getDisparop().add(rectangulo);
            contador++;
        }

        }
        if(disparo==true && otroContador>=0) {
            if (otroContador < 1) {
                Rectangle rectangulos = new Rectangle(otraFigura.getX() + otraFigura.getWidth(), otraFigura.getY(), 10, 10);
                SinglentonProyecto.getInstance().getDisparop().getOtro().add(rectangulos);
                otroContador++;
            }
        }
    }
}
