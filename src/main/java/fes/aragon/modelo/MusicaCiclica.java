package fes.aragon.modelo;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class MusicaCiclica implements Runnable{
    private BufferedInputStream buffer=null;
    private Player player;
    private FileInputStream archivo;

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    private String nombreArchivo;
    public MusicaCiclica(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
        try {
            archivo = new FileInputStream(getClass().getResource("/fes/aragon/musica/" + nombreArchivo+ ".mp3").toURI().getPath());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {

        try {
            buffer = new BufferedInputStream(archivo);
            player = new Player(buffer);
            player.play();
            while(true){
                if(player.isComplete()){
                    archivo.close();
                    try {
                        archivo=new FileInputStream(getClass().getResource("/fes/aragon/musica/" + nombreArchivo+ ".mp3").toURI().getPath());

                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                    buffer = new BufferedInputStream(archivo);
                        player= new Player(buffer);
                        player.play();
                }
            }
        } catch (JavaLayerException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
