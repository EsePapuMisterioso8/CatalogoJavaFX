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
    private  ArrayList<Rectangle> rectangle;
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
        rectangle= new ArrayList<>();
         Rectangle rectangulo= new Rectangle(x,y,40,60);
         rectangle.add(rectangulo);
    }

    @Override
    public void pintar(GraphicsContext grafico) {
        for(Rectangle rectangulos:rectangle){
            grafico.strokeRect(SinglentonPrueba.getInstance().getPersonaje().x,SinglentonPrueba.getInstance().getPersonaje().y,40,60);
        }
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
            if (contador <= 27) {
                y--;
                if (x <= SinglentonProyecto.getInstance().getFondop().getImagenUno().getWidth() - ancho && cara == true) {
                    x += 3;

                } else {
                    if (x > 0) {
                        x -= 3;

                    }
                }
                //System.out.println(SinglentonProyecto.getInstance().getPersonaje().getDerecha());
                System.out.println(SinglentonProyecto.getInstance().getPersonaje().izquierda);
                contador++;
                if (contador == 27) {
                    salto = false;
                }
            }
        } else {
            if (contador > 0) {
                y++;
                contador--;
            }
        }
        ArrayList platafo = new ArrayList<>();
        ArrayList personaje  = new ArrayList<>();
        for(Rectangle persona : rectangle){
            for (Rectangle forma: SinglentonPrueba.getInstance().getPlataformas().getPlataforma()){
                if(persona.getBoundsInLocal().intersects(forma.getBoundsInLocal())){
                    System.out.println("colision");
                    if(persona.getY()>=forma.getY()){

                    }
                }
            }
        }
    }
    }



