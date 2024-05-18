package fes.aragon.modelo;

public class Archivo {
    private String ruta;
    private String nombre;

    public Archivo() {
    }

    public Archivo(String ruta, String nombre) {
        this.ruta = ruta;
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
