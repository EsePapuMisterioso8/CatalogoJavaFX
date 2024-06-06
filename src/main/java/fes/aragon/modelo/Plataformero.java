package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Plataformero extends ComponentesJuego{

    private ArrayList<Rectangle> plataformas = new ArrayList<>();
    private Rectangle piso;
    public Plataformero(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);

        piso = new Rectangle(1,729,1023,3);

        int xx=28;
        int yy=696;

        for(int i=0;i<=38;i++){

            Rectangle plataforma = new Rectangle(xx,yy,89,10);
            plataformas.add(plataforma);

            switch (i){
                case 1:
                    plataforma = new Rectangle(178,716,67,10);
                    plataformas.add(plataforma);
                    break;
                case 2:
                    plataforma = new Rectangle(319,707,67,10);
                    plataformas.add(plataforma);
                    break;
                case 3:
                    plataforma = new Rectangle(439,690,67,10);
                    plataformas.add(plataforma);
                    break;
                case 4:
                    plataforma = new Rectangle(548,679,67,10);
                    plataformas.add(plataforma);
                    break;
                case 5:
                    plataforma = new Rectangle(668,660,67,10);
                    plataformas.add(plataforma);
                    break;
                case 6:
                    plataforma = new Rectangle(792,642,56,10);
                    plataformas.add(plataforma);
                    break;
                case 7:
                    plataforma = new Rectangle(891,628,45,10);
                    plataformas.add(plataforma);
                    break;
                case 8:
                    plataforma = new Rectangle(965,612,55,10);
                    plataformas.add(plataforma);
                    break;
                case 9:
                    plataforma = new Rectangle(900,573,42,5);
                    plataformas.add(plataforma);
                    break;
                case 10:
                    plataforma = new Rectangle(835,549,42,5);
                    plataformas.add(plataforma);
                    break;
                case 11:
                    plataforma = new Rectangle(776,523,33,5);
                    plataformas.add(plataforma);
                    break;
                case 12:
                    plataforma = new Rectangle(718,508,33,5);
                    plataformas.add(plataforma);
                    break;
                case 13:
                    plataforma = new Rectangle(649,501,33,5);
                    plataformas.add(plataforma);
                    break;
                case 14:
                    plataforma = new Rectangle(364,569,254,10);
                    plataformas.add(plataforma);
                    break;
                case 15:
                    plataforma = new Rectangle(444,535,33,5);
                    plataformas.add(plataforma);
                    break;
                case 16:
                    plataforma = new Rectangle(387,518,33,5);
                    plataformas.add(plataforma);
                    break;
                case 17:
                    plataforma = new Rectangle(325,497,33,5);
                    plataformas.add(plataforma);
                    break;
                case 18:
                    plataforma = new Rectangle(233,501,33,5);
                    plataformas.add(plataforma);
                    break;
                case 19:
                    plataforma = new Rectangle(177,486,33,5);
                    plataformas.add(plataforma);
                    break;
                case 20:
                    plataforma = new Rectangle(90,487,33,5);
                    plataformas.add(plataforma);
                    break;
                case 21:
                    plataforma = new Rectangle(45,462,33,5);
                    plataformas.add(plataforma);
                    break;
                case 22:
                    plataforma = new Rectangle(1,433,33,5);
                    plataformas.add(plataforma);
                    break;
                case 23:
                    plataforma = new Rectangle(71,407,33,5);
                    plataformas.add(plataforma);
                    break;
                case 24:
                    plataforma = new Rectangle(137,400,33,5);
                    plataformas.add(plataforma);
                    break;
                case 25:
                    plataforma = new Rectangle(205,381,33,5);
                    plataformas.add(plataforma);
                    break;
                case 26:
                    plataforma = new Rectangle(280,365,33,5);
                    plataformas.add(plataforma);
                    break;
                case 27:
                    plataforma = new Rectangle(356,350,67,10);
                    plataformas.add(plataforma);
                    break;
                case 28:
                    plataforma = new Rectangle(516,390,67,10);
                    plataformas.add(plataforma);
                    break;
                case 29:
                    plataforma = new Rectangle(628,322,67,10);
                    plataformas.add(plataforma);
                    break;
                case 30:
                    plataforma = new Rectangle(763,315,67,10);
                    plataformas.add(plataforma);
                    break;
                case 31:
                    plataforma = new Rectangle(867,285,156,10);
                    plataformas.add(plataforma);
                    break;
                case 32:
                    plataforma = new Rectangle(779,234,67,5);
                    plataformas.add(plataforma);
                    break;
                case 33:
                    plataforma = new Rectangle(681,214,67,5);
                    plataformas.add(plataforma);
                    break;
                case 34:
                    plataforma = new Rectangle(562,211,67,5);
                    plataformas.add(plataforma);
                    break;
                case 35:
                    plataforma = new Rectangle(482,179,67,5);
                    plataformas.add(plataforma);
                    break;
                case 36:
                    plataforma = new Rectangle(398,151,67,5);
                    plataformas.add(plataforma);
                    break;
                case 37:
                    plataforma = new Rectangle(336,134,33,5);
                    plataformas.add(plataforma);
                    break;
                case 38:
                    plataforma = new Rectangle(21,161,288,10);
                    plataformas.add(plataforma);
                    break;
            }
        }
    }
    @Override
    public void pintar(GraphicsContext grafico) {
        grafico.strokeRect(piso.getX(),piso.getY(),piso.getWidth(),piso.getHeight());
        //grafico.setFill(Paint.valueOf("#1F75FE"));
        for(Rectangle rectangle: plataformas){
            grafico.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(),rectangle.getHeight());
            //grafico.setFill(Paint.valueOf("#1F75FE"));
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
            if(piso.getBoundsInLocal().intersects(SinglentonProyecto.getInstance().getPersonaje().x,SinglentonProyecto.getInstance().getPersonaje().y,20,30)){
                SinglentonProyecto.getInstance().getPersonaje().setX(25);
                SinglentonProyecto.getInstance().getPersonaje().setY(580);
        }
    }
    public ArrayList<Rectangle> getPlataforma(){
        return plataformas;
    }
}
