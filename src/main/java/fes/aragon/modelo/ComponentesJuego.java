package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public abstract class ComponentesJuego {

    protected int x;
    protected int y;
    protected String imagen;
    protected int velocidad;

    public ComponentesJuego(int x, int y, String imagen, int velocidad) {
        this.x = x;
        this.y = y;
        this.imagen = imagen;
        this.velocidad = velocidad;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    public abstract void pintar(GraphicsContext grafico);
    public abstract void teclado(KeyEvent evento,boolean presion);
    public abstract void raton(MouseEvent evento);
    public abstract void logicaCalculos();

}
