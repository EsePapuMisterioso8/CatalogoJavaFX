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

        switch (evento.getCode().toString()){

            case "RIGHT":
                if(enSalto ==false ) {
                        derecha = true;
                        cara = true;
                        izquierda = false;
                        arriba = false;
                        abajo = false;
                        break;
                }

            case "LEFT":
                if(enSalto ==false ) {

                        derecha = false;
                        izquierda = true;
                        cara = false;
                        arriba = false;
                        abajo = false;
                        break;
                }

            case "SPACE":
                derecha = false;
                izquierda = false;
                salto = true;
                enSalto= true;
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
        } else if (salto) {

            if (contador <= 50) {
                y--;
            enSalto = true;
                if (x <= SinglentonProyecto.getInstance().getFondop().getImagenUno().getWidth() - ancho && cara == true) {
                    x += 2;


                } else {
                    if (x > 0) {
                        x -= 2;

                    }
                }
                contador++;
                if (contador == 50) {
                    salto = false;

                }

            }
        } else {
            enSalto=false;
            if (y < SinglentonProyecto.getInstance().getFondop().getImagenUno().getHeight() - alto) {
                // System.out.println(derecha+ "derecha");
                //System.out.println(izquierda+ "izquierda");
                y++;
                contador = 0;
            }

        }

        ArrayList<Rectangle> platafo = new ArrayList<>();

                 for (Rectangle forma: SinglentonProyecto.getInstance().getPlataformas().getPlataforma()) {
                     int xx = 0;

                     if(SinglentonProyecto.getInstance().getPersonaje().y-alto<=forma.getY()) {
                         if (forma.getBoundsInLocal().intersects(SinglentonProyecto.getInstance().getPersonaje().x, SinglentonProyecto.getInstance().getPersonaje().y, 40, 60)
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
                /**
                 if(x ==746){
                     try {
                        Parent parent = FXMLLoader.load(getClass().getResource("/fes/aragon/xml/nivelcompletado.fxml"));
                        Scene scene = new Scene(parent);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initStyle(StageStyle.UTILITY);
                        //
                         // stage.setAlwaysOnTop(true);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.show();
                     } catch (IOException ex) {
                         throw new RuntimeException(ex);
                     }
                 }
                 */
    }
}


