package fes.aragon.modelo;

import java.util.ArrayList;

public class SinglentonProyecto {
    private Personaje personaje;
    private Fondop fondop;
    private static SinglentonProyecto singlentonProyecto;
    private ArrayList<ComponentesJuego> elementos;
    private Plataformero plataform;
    private Enemigop enemigop;
    private Disparop disparop;
    //private Trampas trampas;
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
        fondop = new Fondop(0,0,getClass().getResource("/fes/aragon/imagen/MapaFinal.jpeg").getFile(),0);
        personaje = new Personaje(58,660,getClass().getResource("/fes/aragon/imagen/ReimuPx2.png").getFile(),1);
        enemigop = new Enemigop(376,547,null,1);
        disparop = new Disparop(0,0, getClass().getResource("/fes/aragon/imagen/BalaSM2.png").getFile(),1);
        plataform = new Plataformero(13,640,null, 1);
        elementos = new ArrayList<>();
        elementos.add(fondop);
        elementos.add(personaje);
        elementos.add(enemigop);
        elementos.add(disparop);
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
    public Enemigop getEnemigop(){
        return enemigop;
    }
    public Disparop getDisparop(){
        return disparop;
    }
}
