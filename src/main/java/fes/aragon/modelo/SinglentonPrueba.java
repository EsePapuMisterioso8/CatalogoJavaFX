package fes.aragon.modelo;

import java.util.ArrayList;

public class SinglentonPrueba {
    private Personaje personaje;
    private Fondop fondop;
    private static SinglentonPrueba singlentonPrueba;
    private ArrayList<ComponentesJuego> elementos;
    private Plataformero plataform;
    private Enemigop enemigop;
    private Disparop disparop;
    private Trampas trampas;
    private SinglentonPrueba(){
        this.iniciar();
    }
    public static SinglentonPrueba getInstance(){
        if(singlentonPrueba == null){
            singlentonPrueba = new SinglentonPrueba();
        }
        return singlentonPrueba;
    }

    public void iniciar() {
        fondop = new Fondop(0,0,getClass().getResource("/fes/aragon/imagen/MapaJx.jpeg").getFile(),3);
        personaje = new Personaje(25,580,getClass().getResource("/fes/aragon/imagen/ReimuPx.png").getFile(),1);
        enemigop = new Enemigop(586,385,null,1);
        disparop = new Disparop(0,0,null,1);
        plataform = new Plataformero(13,640,getClass().getResource("/fes/aragon/imagen/Gotas.png").getFile(),1);
        trampas = new Trampas(464,574,getClass().getResource("/fes/aragon/imagen/Trampa.png").getFile(),1);
        elementos = new ArrayList<>();
        elementos.add(fondop);
        elementos.add(personaje);
        elementos.add(enemigop);
        elementos.add(disparop);
        elementos.add(plataform);
        elementos.add(trampas);
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
    public Enemigop getEnemigop(){
        return enemigop;
    }
    public Disparop getDisparop(){
        return disparop;
    }
}
