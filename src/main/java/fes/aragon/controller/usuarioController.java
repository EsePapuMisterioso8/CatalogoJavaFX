package fes.aragon.controller;

import fes.aragon.modelo.Persona;
import fes.aragon.modelo.SerializableImage;
import fes.aragon.modelo.SingletonUsuarios;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class usuarioController implements Initializable {
    private Integer indice;
    private ObservableList listaPersona ;
    @FXML
    private Button btnGuardarImagen;

    @FXML
    private Button btnGuardarUsuario;

    @FXML
    private TextField txtApellidoPaterno;
    @FXML
    private ImageView imgImagen;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtNombre;
    @FXML
    private Pane pnPrincipal;
    private File selectedFile;

    @FXML
    void guardarImagen(ActionEvent event) {
        FileChooser f = new FileChooser();
        f.setTitle("Escoja una imagen");
        f.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("imagen","*.png","*.jpg","*.jpeg"));
                //new FileChooser.ExtensionFilter("imagen JPG", "*.jpg"));
        this.selectedFile = f.showOpenDialog(btnGuardarImagen.getScene().getWindow());
        if (selectedFile!=null) {
            try {
                FileInputStream fo = new FileInputStream(selectedFile);
                Image image = new Image(fo);
                imgImagen.setImage(image);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @FXML
    void guardarUsuario(ActionEvent event) {
       Persona persona = new Persona(this.txtNombre.getText(),this.txtApellidoPaterno.getText(),this.txtCorreo.getText());
       if(selectedFile!=null){
           try {
               FileInputStream fi = new FileInputStream(selectedFile);
               Image image = new Image(fi);
               SerializableImage serializableImage = new SerializableImage();
               serializableImage.setImage(image);
               persona.setImagen(serializableImage);
           } catch (FileNotFoundException e) {
               throw new RuntimeException(e);
           }

       }
       if(indice==null){
           SingletonUsuarios.getInstance().getLista().add(persona);
       }else{
          Image imagen = this.imgImagen.getImage();
          SerializableImage si = new SerializableImage();
          si.setImage(imagen);
          persona.setImagen(si);
          SingletonUsuarios.getInstance().getLista().set(indice,persona);
          Stage stage = (Stage) this.btnGuardarUsuario.getScene().getWindow();
          stage.close();
       }
       this.txtCorreo.clear();
       this.imgImagen.setImage(null);
       this.txtNombre.clear();
       txtApellidoPaterno.clear();



    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
        FileInputStream f = null;
        File file = new File(System.getProperty("user.dir")+"/src/main/resources/fes/aragon/imagen/hero.png");
        try {
            f =new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Image image = new Image(f);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        pnPrincipal.setBackground(background);

         */
    }
    public void indiceUsuario(int indice ){
        this.indice = indice;
        Persona persona = SingletonUsuarios.getInstance().getLista().get(indice);
        this.txtNombre.setText(persona.getNombre());
        this.txtApellidoPaterno.setText(persona.getApellido());
        this.txtCorreo.setText(persona.getCorreo());
        System.out.println(persona.getImagen());
        this.imgImagen.setImage(persona.getImagen().getImage());
    }


}
