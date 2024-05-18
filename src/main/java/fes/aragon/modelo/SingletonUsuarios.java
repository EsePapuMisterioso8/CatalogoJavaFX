package fes.aragon.modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class SingletonUsuarios {
    private  static SingletonUsuarios singletonUsuarios;
    private ObservableList<Persona> lista;

    private SingletonUsuarios(){
        lista = FXCollections.observableArrayList();
    }
    public static SingletonUsuarios getInstance(){
        if (singletonUsuarios == null){
            singletonUsuarios = new SingletonUsuarios();
        }
        return singletonUsuarios;
    }
    public ObservableList<Persona> getLista(){
        return lista;
    }

    public ArrayList<Persona> getConversion(){
        return new ArrayList<>(lista);
    }
}
