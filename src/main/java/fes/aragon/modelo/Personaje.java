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
    private  Rectangle rectangle;
    private boolean cara;
    private Image imagen;
    private boolean derecha;
    private boolean izquierda;
    private boolean arriba;
    private boolean abajo;
    private int ancho=40;
    private int alto = 60;
    private boolean salto;
    int contador = 0;
    private int alturaInicial;
    private int alturaMaxima=2;
    private int alturaActual;
    private int velocidadSalto=2;
    public Personaje(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);
        try {
            FileInputStream fi = new FileInputStream(imagen);
            this.imagen = new Image(fi);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }
         rectangle = new Rectangle(x,y,40,60);
    }

    @Override
    public void pintar(GraphicsContext grafico) {
        grafico.strokeRect(SinglentonPrueba.getInstance().getPersonaje().x,SinglentonPrueba.getInstance().getPersonaje().y,40,60);
    grafico.drawImage(imagen,x,y,ancho,alto);
    }
    @Override
    public void teclado(KeyEvent evento, boolean presion) {

        switch (evento.getCode().toString()){
            case "RIGHT":
                derecha = true;
                cara=true;
                izquierda = false;
                arriba = false;
                abajo = false;
                break;
            case "LEFT":
                derecha = false;
                izquierda = true;
                cara=false;
                arriba = false;
                abajo = false;
                break;
            case "SPACE":
                derecha = false;
                izquierda = false;
                salto = true;
                abajo = false;
                break;
            /*case "DOWN":
                derecha = false;
                izquierda = false;
                arriba = false;
                abajo = true;
                break;

             */
        }

    }

    @Override
    public void raton(MouseEvent evento) {

    }

    @Override
    public void logicaCalculos() {
        //System.out.println(izquierda);
        System.out.println(cara);
        if (derecha) {
            if (x < SinglentonProyecto.getInstance().getFondop().getImagenUno().getWidth() - ancho) {
                this.x++;
            }
        } else if (izquierda) {
            if (x > 0) {
                x--;
            }
        } else if (salto) {
            if (contador <= 30) {
                y--;

                if (x <= SinglentonProyecto.getInstance().getFondop().getImagenUno().getWidth() - ancho && cara == true) {
                    x += 2;

                } else {
                    if (x > 0) {
                        x -= 2;

                    }
                }
                //System.out.println(SinglentonProyecto.getInstance().getPersonaje().getDerecha());
                System.out.println(SinglentonProyecto.getInstance().getPersonaje().izquierda);
                contador++;
                if (contador == 30) {
                    salto = false;
                }
            }
        } else {

               if (y<SinglentonPrueba.getInstance().getFondop().getImagenUno().getHeight()-alto) {
                       y++;
                       contador=0;
                }


        }
        ArrayList platafo = new ArrayList<>();
                ArrayList personaje  = new ArrayList<>();

                 for (Rectangle forma: SinglentonPrueba.getInstance().getPlataformas().getPlataforma()){
                if(forma.getBoundsInLocal().intersects(SinglentonPrueba.getInstance().getPersonaje().x,SinglentonPrueba.getInstance().getPersonaje().y,40,60)){
                    System.out.println("colision");
                    System.out.println(y);
                    if(y<=forma.getY()){
                         System.out.println("arriba de la plataforma");
                        if(x>forma.getWidth()-ancho || x<forma.getWidth()-ancho) {
                            y = (int) (forma.getY() - alto);
                        }

                    }
                }

        }
    }
    }



