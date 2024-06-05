package fes.aragon.modelo;

import java.util.ArrayList;

public class SinglentonProyecto {
    private Personaje personaje;
    private Fondop fondop;
    private static SinglentonProyecto singlentonProyecto;
    private ArrayList<ComponentesJuego> elementos;
    private Plataformas plataformas;
    private Plataformero plataformero;
    private SinglentonProyecto(){
        this.inicial();
    }
    public static SinglentonProyecto getInstance(){
        if(singlentonProyecto == null){
            singlentonProyecto = new SinglentonProyecto();
        }
        return singlentonProyecto;
    }

    public void inicial() {
        fondop = new Fondop(0,0,getClass().getResource("/fes/aragon/imagen/MapaOficial.png").getFile(),3);
        personaje = new Personaje(770,670,getClass().getResource("/fes/aragon/imagen/ReimuPx.png").getFile(),1);
        plataformas= new Plataformas(489,684,null,1);
        //plataformero= new Plataformero(489,684,null,1);
        elementos = new ArrayList<>();
        elementos.add(fondop);
        this.elementos.add(personaje);
        elementos.add(2,plataformas);
       // elementos.add(plataformero);


    }
    public ArrayList<ComponentesJuego> getElementos(){
        return  this.elementos;
    }
    public Personaje getPersonaje(){
        return personaje;
    }
    public Fondop getFondop(){
        return fondop;
    }
    public Plataformas getPlataformas(){
        return plataformas;
    }
    public Plataformero getPlataformero(){
        return plataformero;
    }
}
