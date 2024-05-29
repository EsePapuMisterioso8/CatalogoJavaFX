package fes.aragon.modelo;

import java.util.ArrayList;

public class SinglentonPrueba {
    private Personaje personaje;
    private Fondop fondop;
    private static SinglentonPrueba singlentonPrueba;
    private ArrayList<ComponentesJuego> elementos;
    private Plataformero plataform;
    private SinglentonPrueba(){
        this.iniciar();
    }
    public static SinglentonPrueba getInstance(){
        if(singlentonPrueba == null){
            singlentonPrueba = new SinglentonPrueba();
        }
        return singlentonPrueba;
    }

    private void iniciar() {
        fondop = new Fondop(0,0,getClass().getResource("/fes/aragon/imagen/MapaJx.jpeg").getFile(),3);
        personaje = new Personaje(25,580,getClass().getResource("/fes/aragon/imagen/ReimuPx.png").getFile(),1);
        plataform = new Plataformero(13,640,getClass().getResource("/fes/aragon/imagen/Gotas.png").getFile(),1);
        elementos = new ArrayList<>();
        elementos.add(fondop);
        elementos.add(personaje);
        elementos.add(plataform);
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
    public Plataformero getPlataformas(){
        return plataform;
    }
}
