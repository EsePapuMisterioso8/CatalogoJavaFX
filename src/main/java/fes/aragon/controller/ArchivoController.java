package fes.aragon.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import fes.aragon.modelo.Archivo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.util.Callback;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ArchivoController implements Initializable {
    @FXML
    private TableColumn<Archivo, String> clmAccion;

    @FXML
    private TableColumn<Archivo, String> clmNombre;

    @FXML
    private TableColumn<Archivo, String> clmRuta;

    @FXML
    private Button ldAbrir;

    @FXML
    private TableView<Archivo> tlbTabla;
    private ObservableList<Archivo> listaGeneral;

    @FXML
    void accionAbrirDirectorio(ActionEvent event) {
        DirectoryChooser dc = new DirectoryChooser();
        File f = dc.showDialog(this.ldAbrir.getScene().getWindow());
        if(f!=null){
            listaGeneral = listaArchivos(f.getAbsoluteFile());
            tlbTabla.setItems(listaGeneral);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.clmNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.clmRuta.setCellValueFactory(new PropertyValueFactory<>("ruta"));
        Callback<TableColumn<Archivo, String>, TableCell<Archivo, String>>
                celda= (TableColumn<Archivo,String> parametros)->{
           final TableCell<Archivo,String> cel= new TableCell<>(){
               @Override
               protected void updateItem(String s, boolean b) {
                   super.updateItem(s, b);
                   if(b){
                       setGraphic(null);
                       setText(null);
                   }else{
                       FontAwesomeIconView borrarIcono = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                       borrarIcono.setGlyphStyle("-fx-cursor:hand;"+"-glyph-size:28px;"+"-fx-fill:#ff1744");
                       borrarIcono.setOnMouseClicked((MouseEvent evento)->{
                           Archivo elemento = tlbTabla.getSelectionModel().getSelectedItem();
                           listaGeneral.remove(elemento);
                           File borrar = new File(elemento.getRuta());
                           borrar.delete();

                       });
                       HBox hBox = new HBox(borrarIcono);
                       hBox.setStyle("-fx-alignment:center");
                       HBox.setMargin(borrarIcono,new Insets(2,2,0,3));
                       setGraphic(hBox);
                       setText(null);
                   }
               }
           };
           return cel;
        };
        this.clmAccion.setCellFactory(celda);
    }
    private ObservableList<Archivo> listaArchivos(File f){
        ObservableList<Archivo> lista = FXCollections.observableArrayList();
        ArrayList<File> directorios = new ArrayList<>();
        directorios.add(f);
        while(!directorios.isEmpty()){
            File actual = directorios.remove(0);
            if(actual.listFiles()!=null){
                for(File dato: actual.listFiles()){
                    if(dato.isDirectory()){
                        directorios.add(dato);
                    }else{
                        Archivo archivo = new Archivo(dato.getAbsolutePath(), dato.getName());
                        lista.add(archivo);
                    }
                }
            }
        }
        return lista;
    }
}
