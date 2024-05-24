package fes.aragon.modelo;

import java.util.ArrayList;

public class SinglentonProyecto {
    private Personaje personaje;
    private Fondop fondop;
    private static SinglentonProyecto singlentonProyecto;
    private ArrayList<ComponentesJuego> elementos;
    private SinglentonProyecto(){
        this.iniciar();
    }
    public static SinglentonProyecto getInstance(){
        if(singlentonProyecto == null){
            singlentonProyecto = new SinglentonProyecto();
        }
        return singlentonProyecto;
    }

    private void iniciar() {
        fondop = new Fondop(0,0,getClass().getResource("/fes/aragon/imagen/Fondo2.jpg").getFile(),3);
        personaje = new Personaje(20,20,getClass().getResource("/fes/aragon/imagen/Nave.jpeg").getFile(),1);
        elementos = new ArrayList<>();
        elementos.add(fondop);
        this.elementos.add(personaje);

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
}
