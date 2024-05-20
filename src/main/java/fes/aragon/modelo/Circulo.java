package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Circulo extends ComponentesJuego{
    private boolean campo=false;
    public Circulo(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);
    }

    @Override
    public void pintar(GraphicsContext grafico) {
        grafico.strokeOval(x,y,60,60);
    }

    @Override
    public void teclado(KeyEvent evento, boolean presion) {
        switch (evento.getCode().toString()){
            case "C":
                campo= true;
                x= SinglentonJuegos.getInstance().getNave().getX()-10;
                y= SinglentonJuegos.getInstance().getNave().getY()-10;
                break;
        }
    }

    @Override
    public void raton(MouseEvent evento) {

    }

    @Override
    public void logicaCalculos() {
        if(campo){
            x = SinglentonJuegos.getInstance().getNave().x-10;
            y = SinglentonJuegos.getInstance().getNave().y-10;
        }
    }
}
