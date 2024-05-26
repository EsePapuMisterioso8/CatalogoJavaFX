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

public class Plataformas extends ComponentesJuego{
    private Image imagenes;
    private ArrayList<Rectangle> plataformas = new ArrayList<>();
    public Plataformas(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);
        /*
        try {
            FileInputStream fi = new FileInputStream(imagen);
            imagenes = new Image(fi);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

         */
        int xx=489;
        int yy=684;
        int salto=0;
        for(int i=0;i<=21;i++){
            Rectangle plataforma = new Rectangle(xx,yy,60,25);
            plataformas.add(plataforma);
            switch (i){
                case 1:
                    plataforma = new Rectangle(112,661,60,25);
                    plataformas.add(plataforma);
                    break;
                case 2:
                   plataforma = new Rectangle(70,609,45,25);
                   plataformas.add(plataforma);
                   break;
                case 3:
                    plataforma = new Rectangle(154,562,125,25);
                    plataformas.add(plataforma);
                    break;
                case 6:
                    plataforma = new Rectangle(342,542,105,25);
                    plataformas.add(plataforma);
                    break;
                case 7:
                    plataforma = new Rectangle(525,525,150,25);
                    plataformas.add(plataforma);
                    break;
                case 8:
                    plataforma = new Rectangle(707,496,65,25);
                    plataformas.add(plataforma);
                    break;
                case 9:
                    plataforma = new Rectangle(815,472,75,25);
                    plataformas.add(plataforma);
                    break;
                case 10:
                    plataforma = new Rectangle(874,425,60,25);
                    plataformas.add(plataforma);
                    break;
                case 11:
                    plataforma = new Rectangle(720,394,90,25);
                    plataformas.add(plataforma);
                    break;
                case 12:
                    plataforma = new Rectangle(574,378,85,25);
                    plataformas.add(plataforma);
                    break;
                case 13:
                    plataforma = new Rectangle(356,376,130,25);
                    plataformas.add(plataforma);
                    break;
                case 14:
                    plataforma = new Rectangle(205,354,85,25);
                    plataformas.add(plataforma);
                    break;
                case 15:
                    plataforma = new Rectangle(22,326,130,25);
                    plataformas.add(plataforma);
                    break;
                case 16:
                    plataforma = new Rectangle(0,277,30,25);
                    plataformas.add(plataforma);
                    break;
                case 17:
                    plataforma = new Rectangle(87,234,130,25);
                    plataformas.add(plataforma);
                    break;
                case 18:
                    plataforma = new Rectangle(283,218,90,25);
                    plataformas.add(plataforma);
                    break;
                case 19:
                    plataforma = new Rectangle(436,200,180,25);
                    plataformas.add(plataforma);
                    break;
                case 20:
                    plataforma = new Rectangle(632,139,45,25);
                    plataformas.add(plataforma);
                    break;
                case 21:
                    plataforma = new Rectangle(743,100,180,25);
                    plataformas.add(plataforma);
                    break;
            }

        }
    }

    @Override
    public void pintar(GraphicsContext grafico) {
    //grafico.strokeRect(x,y,5,5);
        for(Rectangle rectangle: plataformas){
            grafico.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(),rectangle.getHeight());
            grafico.setFill(Paint.valueOf("#1F75FE"));
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
}
