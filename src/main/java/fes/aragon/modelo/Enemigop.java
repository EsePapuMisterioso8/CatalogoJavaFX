package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Enemigop extends ComponentesJuego {
    private Rectangle soldado2;
    private Rectangle soldado1;
    private Rectangle figura;
    private Rectangle otraFigura;
    private boolean disparo = true;
    private int contador = 0;
    private int otroContador = 0;
    private int otrosContador = 0;
    private int contadors = 0;

    public Enemigop(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);
            figura= new Rectangle(325, 170, 47, 40);
            otraFigura = new Rectangle(363, 530, 50, 35);
            soldado1= new Rectangle(964,456,52,40);
            soldado2 = new  Rectangle(14,278,40,45);
    }

    @Override
    public void pintar(GraphicsContext grafico) {
        grafico.strokeRect(figura.getX(),figura.getY(),figura.getWidth(),figura.getHeight());
        grafico.strokeRect(otraFigura.getX(),otraFigura.getY(),otraFigura.getWidth(),otraFigura.getHeight());
        grafico.strokeRect(soldado1.getX(),soldado1.getY(),soldado1.getWidth(),soldado1.getHeight());
        grafico.strokeRect(soldado2.getX(),soldado2.getY(),soldado2.getWidth(),soldado2.getHeight());
    }

    @Override
    public void teclado(KeyEvent evento, boolean presion) {

    }

    @Override
    public void raton(MouseEvent evento) {

    }

    @Override
    public void logicaCalculos() {


        if(disparo && contador>=0){
            if(contador<1) {
                Rectangle rectangulo = new Rectangle(figura.getX() + figura.getWidth(), figura.getY()+(figura.getHeight()/2)-2, 15, 15);
                SinglentonProyecto.getInstance().getDisparop().getDisparop().add(rectangulo);
                contador++;
            }

        }
        if(disparo && otroContador>=0) {
            if (otroContador < 1) {
                Rectangle rectangulos = new Rectangle(otraFigura.getX() + otraFigura.getWidth(), otraFigura.getY()+ (otraFigura.getHeight()/2)-3, 15, 15);
                SinglentonProyecto.getInstance().getDisparop().getOtro().add(rectangulos);
                otroContador++;
            }
        }

        if(disparo && otrosContador>=0) {
            if (otrosContador < 1) {
                Rectangle rectangulos = new Rectangle(soldado1.getX(), soldado1.getY(), 15, 15);
                SinglentonProyecto.getInstance().getDisparop().getSoldadoBajo().add(rectangulos);
                otrosContador++;
            }
        }
        if(disparo && contadors>=0) {
            if (contadors < 1) {
                Rectangle rectangulos = new Rectangle(soldado2.getX() + soldado2.getWidth(), soldado2.getY()+ (soldado2.getHeight()/2)-3, 15, 15);
                SinglentonProyecto.getInstance().getDisparop().getSoldadoArriba().add(rectangulos);
                contadors++;
            }
        }



    }

}