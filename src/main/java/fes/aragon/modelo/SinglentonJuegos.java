package fes.aragon.modelo;

import java.util.ArrayList;

public class SinglentonJuegos {
    private static SinglentonJuegos singlentonJuegos;
    private Nave nave;
    private Fondo fondo;
    private Enemigo enemigo;
    private Disparo disparo;
    private ArrayList<ComponentesJuego> elementos;
    private Circulo circulo;

    private SinglentonJuegos(){
        this.iniciar();
    }
    public static SinglentonJuegos getInstance(){
        if(singlentonJuegos == null){
            singlentonJuegos = new SinglentonJuegos();
        }
        return singlentonJuegos;
    }
    public void iniciar(){
        nave = new Nave(50,200,getClass().getResource("/fes/aragon/imagen/del.jpeg").getFile(),1);
        fondo=new Fondo(0,0,getClass().getResource("/fes/aragon/imagen/fondo2.jpg").getFile(),
                getClass().getResource("/fes/aragon/imagen/fondo3.jpg").getFile(),3);
        enemigo = new Enemigo(20,20,getClass().getResource("/fes/aragon/imagen/Cyrno.png").getFile(),1);
        disparo = new Disparo(0,0,null,3);
        circulo = new Circulo(40,30,null,1);
        elementos = new ArrayList<>();
        this.elementos.add(fondo);
        this.elementos.add(nave);
        this.elementos.add(enemigo);
        this.elementos.add(disparo);
        this.elementos.add(circulo);
    }
    public ArrayList<ComponentesJuego> getElementos(){
        return this.elementos;
    }
    public Fondo getFondo(){
        return fondo;
    }

    public Nave getNave() {
        return nave;
    }

    public Disparo getDisparo() {
        return disparo;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }
    public Circulo getCirculo(){
        return circulo;
    }
}
