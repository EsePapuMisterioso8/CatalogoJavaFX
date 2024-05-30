package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Plataformero extends ComponentesJuego{
    private Image imagenes;
    private ArrayList<Rectangle> plataformas = new ArrayList<>();
    public Plataformero(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);

        try {
            FileInputStream fi = new FileInputStream(imagen);
            imagenes = new Image(fi);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        int xx=13;
        int yy=640;
        int salto=0;
        for(int i=0;i<=23;i++){
            Rectangle plataforma = new Rectangle(xx,yy,67,19);
            plataformas.add(plataforma);
            switch (i){
                case 1:
                    plataforma = new Rectangle(145,640,45,19);
                    plataformas.add(plataforma);
                    break;
                case 2:
                    plataforma = new Rectangle(255,640,40,19);
                    plataformas.add(plataforma);
                    break;
                case 3:
                    plataforma = new Rectangle(365,627,45,19);
                    plataformas.add(plataforma);
                    break;
                case 4:
                    plataforma = new Rectangle(466,577,150,19);
                    plataformas.add(plataforma);
                    break;
                case 5:
                    plataforma = new Rectangle(664,541,150,19);
                    plataformas.add(plataforma);
                    break;
                case 6:
                    plataforma = new Rectangle(836,495,65,19);
                    plataformas.add(plataforma);
                    break;
                case 7:
                    plataforma = new Rectangle(763,459,23,10);
                    plataformas.add(plataforma);
                    break;
                case 8:
                    plataforma = new Rectangle(517,430,222,19);
                    plataformas.add(plataforma);
                    break;
                case 9:
                    plataforma = new Rectangle(363,487,45,19);
                    plataformas.add(plataforma);
                    break;
                case 10:
                    plataforma = new Rectangle(195,458,62,19);
                    plataformas.add(plataforma);
                    break;
                case 11:
                    plataforma = new Rectangle(120,431,45,19);
                    plataformas.add(plataforma);
                    break;
                case 12:
                    plataforma = new Rectangle(48,405,45,19);
                    plataformas.add(plataforma);
                    break;
                case 13:
                    plataforma = new Rectangle(1,378,29,19);
                    plataformas.add(plataforma);
                    break;
                case 14:
                    plataforma = new Rectangle(71,358,23,10);
                    plataformas.add(plataforma);
                    break;
                case 15:
                    plataforma = new Rectangle(134,343,23,10);
                    plataformas.add(plataforma);
                    break;
                case 16:
                    plataforma = new Rectangle(221,366,23,10);
                    plataformas.add(plataforma);
                    break;
                case 17:
                    plataforma = new Rectangle(308,345,23,10);
                    plataformas.add(plataforma);
                    break;
                case 18:
                    plataforma = new Rectangle(385,324,23,10);
                    plataformas.add(plataforma);
                    break;
                case 19:
                    plataforma = new Rectangle(465,300,23,10);
                    plataformas.add(plataforma);
                    break;
                case 20:
                    plataforma = new Rectangle(545,279,23,10);
                    plataformas.add(plataforma);
                    break;
                case 21:
                    plataforma = new Rectangle(612,253,23,10);
                    plataformas.add(plataforma);
                    break;
                case 22:
                    plataforma = new Rectangle(664,232,23,10);
                    plataformas.add(plataforma);
                    break;
                case 23:
                    plataforma = new Rectangle(745,213,155,19);
                    plataformas.add(plataforma);
                    break;
            }

        }
    }
    @Override
    public void pintar(GraphicsContext grafico) {
        for(Rectangle rectangle: plataformas){
            grafico.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(),rectangle.getHeight());
            grafico.drawImage(imagenes,rectangle.getX(),rectangle.getY(), rectangle.getWidth(),rectangle.getHeight());
        }
    }

    @Override
    public void teclado(KeyEvent evento, boolean presion) {

    }

    @Override
    public void raton(MouseEvent evento) {

    }

    @Override
    public void logicaCalculos() {

    }
    public ArrayList<Rectangle> getPlataforma(){
        return plataformas;
    }
}
