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

    private boolean enSalto;
    private boolean cara;
    private Image imagen;
    private boolean derecha;
    private boolean izquierda;
    private boolean abajo;
    private int ancho= 20;
    private int alto = 30;
    private boolean salto;
    int contador = 0;
    int contadorBajadaDerecha = 50;
    int contadorBajadaIzquierda = 50;

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
                if(enSalto==false) {
                    derecha = true;
                    cara = true;
                    izquierda = false;
                    salto = false;
                    abajo = false;
                    break;
                }

            case "LEFT":
                if(enSalto==false) {
                    derecha = false;
                    cara = false;
                    izquierda = true;
                    salto = false;
                    abajo = false;
                    break;
                }
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
            //al presionar enter se activará el movimiento de salto
            if (contador <= 40) {
                y--;
                enSalto=true;
                //Si la cara a la que ves es la derecha saltarás hacía la derecha
                if (x <= SinglentonProyecto.getInstance().getFondop().getImagenUno().getWidth() - ancho && cara == true) {
                    x += 2;
                    //si no hacia la izquierda
                } else {
                    if (x > 0) {
                        x -= 2;

                    }
                }
                contador++;
                //cuando el maximo del salto se de entonces el salto se vuelve falso
                if (contador == 40) {
                    salto = false;
                }
            }
        } else {
            //cuando el salto es falso

            if(y<SinglentonProyecto.getInstance().getFondop().getImagenUno().getHeight()-alto) {
                //bajamos y entonces el contador se vuelve cero para poder volver a saltar
                    y++;
                    contador = 0;
            }
            enSalto=false;



        }
        //array list creado para almacenar las plataformas en las que caemos
        ArrayList<Rectangle> platafo = new ArrayList<>();
                //iteramos en todas las plataformas
                 for (Rectangle forma: SinglentonProyecto.getInstance().getPlataformas().getPlataforma()) {
                     int xx = 0;//variable para ver cuando se salga el personaje de la plataforma

                     //si el
                    // System.out.println(SinglentonProyecto.getInstance().getPersonaje().y+alto);
                     System.out.println(forma.getY());
                     if(SinglentonProyecto.getInstance().getPersonaje().y<=forma.getY()) {
                         if (forma.getBoundsInLocal().intersects(SinglentonProyecto.getInstance().getPersonaje().x, SinglentonProyecto.getInstance().getPersonaje().y, 20, 30)
                         ) {
                             System.out.println("colision");
                             platafo.add(forma);
                             if (SinglentonProyecto.getInstance().getPersonaje().y<= forma.getY()) {
                                 y = (int) (forma.getY() - alto);
                             }
                         }
                     }else {
                         for (Rectangle formas : platafo) {
                             xx = (int) (formas.getX() + formas.getWidth());
                             if (x<xx) {
                             }else{
                                 if(y<SinglentonProyecto.getInstance().getFondop().getImagenUno().getHeight()-alto ) {
                                     if (contadorBajadaDerecha >= 0) {
                                         y++;
                                         derecha = false;
                                         y++;
                                         contadorBajadaDerecha--;
                                     }
                                     if(contadorBajadaDerecha==0){
                                         contadorBajadaDerecha= 50;
                                     }
                                 }
                             }

                             if(x+ancho>formas.getX()){

                             }else{
                                 if(y<SinglentonProyecto.getInstance().getFondop().getImagenUno().getHeight()-alto) {
                                     if(contadorBajadaIzquierda>= 0){
                                     y++;
                                     izquierda=false;
                                     y++;
                                     contadorBajadaIzquierda--;
                                     }
                                     if(contadorBajadaIzquierda == 0 ){
                                         contadorBajadaIzquierda = 50;
                                     }
                                 }
                             }
                         }
                     }
                 }

    }
}


