package fes.aragon.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import fes.aragon.modelo.Persona;
import fes.aragon.modelo.SingletonUsuarios;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import javafx.util.Callback;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UsuariosController implements Initializable {

    @FXML
    private TableColumn<Persona, String> clmApellido;

    @FXML
    private TableColumn<Persona, String> clmCorreo;

    @FXML
    private TableColumn<Persona, String> clmNombre;

    @FXML
    private TableColumn<Persona, String> clmOperacion;

    @FXML
    private FontAwesomeIconView iconAbrirArchivo;

    @FXML
    private FontAwesomeIconView iconNuevoUsuario;

    @FXML
    private FontAwesomeIconView iconSalvar;

    @FXML
    private TableView<Persona> tblTablaUsuarios;
    @FXML
    private Pane pnPrincipal;



    @FXML
    void accionAbrirArchivo(MouseEvent event) {
        FileChooser fc= new FileChooser();
        File f= fc.showOpenDialog(this.iconAbrirArchivo.getScene().getWindow());
        try {
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream oi = new ObjectInputStream(fi);
            ArrayList<Persona> datos = (ArrayList<Persona>) oi.readObject();
            SingletonUsuarios.getInstance().getLista().clear();
            for(Persona dato: datos ){
                System.out.println(dato.getImagen());
                SingletonUsuarios.getInstance().getLista().add(dato);
            }
            oi.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void accionGuardar(MouseEvent event) {
    FileChooser fc= new FileChooser();
    File f = fc.showSaveDialog(this.iconSalvar.getScene().getWindow());
        try {
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            ArrayList<Persona> datos = SingletonUsuarios.getInstance().getConversion();
            for(Persona dato : datos){
                System.out.println(dato.getImagen());
            }
            oo.writeObject(datos);
            oo.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void accionUsuario(MouseEvent event){

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fes/aragon/xml/usuario.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        tblTablaUsuarios.setItems(SingletonUsuarios.getInstance().getLista());


    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    clmNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    clmApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    clmCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
    iconNuevoUsuario.setGlyphStyle("-fx-cursor:hand;");
    iconAbrirArchivo.setGlyphStyle("-fx-cursor:hand;");
    iconSalvar.setGlyphStyle("-fx-cursor:hand;");

     Callback<TableColumn<Persona, String>, TableCell<Persona, String>>
                celda= (TableColumn<Persona,String> parametros)->{
           final TableCell<Persona,String> cel= new TableCell<>(){
               @Override
               protected void updateItem(String s, boolean b) {
                   super.updateItem(s, b);
                   if(b){
                       setGraphic(null);
                       setText(null);
                   }else {
                       FontAwesomeIconView borrarIcono = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                       borrarIcono.setGlyphStyle("-fx-cursor:hand;"+"-glyph-size:28px;"+"-fx-fill:#ff1744");
                       borrarIcono.setOnMouseClicked((MouseEvent evento)->{
                           int indice  = tblTablaUsuarios.getSelectionModel().getSelectedIndex();
                           SingletonUsuarios usuarios = SingletonUsuarios.getInstance();
                           usuarios.getLista().remove(indice);



                       });
                       HBox hBox = new HBox(borrarIcono);
                       hBox.setStyle("-fx-alignment:center");
                       HBox.setMargin(borrarIcono,new Insets(2,2,0,3));
                       setGraphic(hBox);
                       setText(null);

                       FontAwesomeIconView editarIcono = new FontAwesomeIconView(FontAwesomeIcon.PENCIL);
                       editarIcono.setGlyphStyle("-fx-cursor:hand;"+"-glyph-size:28px;"+"-fx-fill:#ff1744");
                       editarIcono.setOnMouseClicked((MouseEvent evento)->{
                           modificarUsuario(tblTablaUsuarios.getSelectionModel().getSelectedIndex());




                       });
                       HBox hBox1 = new HBox(editarIcono,borrarIcono);
                       hBox1.setStyle("-fx-alignment:center");
                       HBox.setMargin(editarIcono,new Insets(2,2,0,3));
                       HBox.setMargin(borrarIcono,new Insets(2,2,0,3));
                       setGraphic(hBox1);
                       setText(null);
                   }

               }


           };
           return cel;
        };
        this.clmOperacion.setCellFactory(celda);





    }

   private void modificarUsuario(int indice ){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fes/aragon/xml/usuario.fxml"));
       try {
           Parent parent = (Parent)fxmlLoader.load();
           ((usuarioController)fxmlLoader.getController()).indiceUsuario(indice);
           Scene scene = new Scene(parent);
           Stage stage = new Stage();
           stage.setScene(scene);
           stage.initStyle(StageStyle.UTILITY);
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.show();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
}



