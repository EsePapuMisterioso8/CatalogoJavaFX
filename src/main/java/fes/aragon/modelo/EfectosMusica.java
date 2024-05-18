package fes.aragon.modelo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class EfectosMusica implements Runnable{
    private FileInputStream archivo;
    private BufferedInputStream buffer = null;
    private Player player;

    public EfectosMusica(String archivo){
        try {
            this.archivo = new FileInputStream(this.getClass()
                    .getResource("/fes/aragon/musica/" + archivo + ".mp3").toURI().getPath());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
     buffer  = new BufferedInputStream(archivo);
        try {
            player = new Player(buffer);
            player.play();
        } catch (JavaLayerException e) {
            throw new RuntimeException(e);
        }
    }
}
