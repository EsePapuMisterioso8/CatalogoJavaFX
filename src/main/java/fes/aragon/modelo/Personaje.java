package fes.aragon.modelo;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Personaje extends ComponentesJuego{
    private boolean callendo;

    private boolean enSalto;
    private boolean cara;
    private Image imagen;
    private boolean derecha;
    private boolean izquierda;
    private boolean arriba;
    private boolean abajo;
    private int ancho= 25;
    private int alto = 35;
    private boolean salto;
    int contador = 0;

    public Personaje(int x, int y, String imagen, int velocidad) {
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
    grafico.drawImage(imagen,x,y,ancho,alto);
    }

    @Override
    public void teclado(KeyEvent evento, boolean presion) {

        switch (evento.getCode().toString()) {

            case "RIGHT":
                derecha = true;
                cara = true;
                izquierda = false;
                salto = false;
                abajo = false;
                break;
            case "LEFT":
                derecha = false;
                cara = false;
                izquierda = true;
                salto = false;
                abajo = false;
                break;
            case "SPACE":
                derecha = false;
                izquierda = false;
                salto = true;
                abajo = false;
                break;
        }
    }

    @Override
    public void raton(MouseEvent evento) {

    }

    @Override
    public void logicaCalculos() {
        if (derecha) {

            if (x < SinglentonProyecto.getInstance().getFondop().getImagenUno().getWidth() - ancho) {
                this.x++;
            }

        } else if (izquierda) {
            if (x > 0) {
                x--;
            }
        } else if (salto ) {
            if (contador <= 30) {
                y--;
                System.out.println(y);

                if (x <= SinglentonProyecto.getInstance().getFondop().getImagenUno().getWidth() - ancho && cara == true) {
                    x += 2;


                } else {
                    if (x > 0) {
                        x -= 2;

                    }
                }
                contador++;
                System.out.println(contador);
                if (contador == 30) {
                    callendo=true;
                    salto = false;

                }
            }
        } else {


            if(y<SinglentonProyecto.getInstance().getFondop().getImagenUno().getHeight()-alto) {
                if (callendo == true) {

                    y++;
                    contador = 0;

                }
            }
              // }



        }

        ArrayList<Rectangle> platafo = new ArrayList<>();

                 for (Rectangle forma: SinglentonProyecto.getInstance().getPlataformas().getPlataforma()) {
                     int xx = 0;

                     if(SinglentonProyecto.getInstance().getPersonaje().y-alto<=forma.getY()) {
                         if (forma.getBoundsInLocal().intersects(SinglentonProyecto.getInstance().getPersonaje().x, SinglentonProyecto.getInstance().getPersonaje().y, 25, 35)
                         ) {
                             platafo.add(forma);
                             if (y-alto <= forma.getY()) {
                                 y = (int) (forma.getY() - alto);
                             }
                         }
                     }else {
                         for (Rectangle formas : platafo) {
                             xx = (int) (formas.getX() + formas.getWidth());
                             if (x<xx) {
                             }else{
                                 if(y<SinglentonProyecto.getInstance().getFondop().getImagenUno().getHeight()-alto) {
                                     y =(int) (SinglentonProyecto.getInstance().getFondop().getImagenUno().getHeight()-alto);
                                 }
                             }

                             if(x+ancho>formas.getX()){

                             }else{
                                 if(y<SinglentonProyecto.getInstance().getFondop().getImagenUno().getHeight()-alto) {
                                     y=(int) (SinglentonProyecto.getInstance().getFondop().getImagenUno().getHeight()-alto);
                                     ;
                                 }
                             }
                         }
                     }
                 }

    }
}


