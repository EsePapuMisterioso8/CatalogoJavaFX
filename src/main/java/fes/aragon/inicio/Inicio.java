package fes.aragon.inicio;
//Ola xd como esta si se ve xd? Wazaaaaaaa
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class Inicio extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Inicio.class.getResource("/fes/aragon/xml/inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Catálogo JavaFX");
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setScene(scene);
        stage.show();
    }
//xddddddddd
//Wazaaaaaaaaa
    //olaaaaaaaaaa
    //Ae
    public static void main(String[] args) {
        launch();
    }
}