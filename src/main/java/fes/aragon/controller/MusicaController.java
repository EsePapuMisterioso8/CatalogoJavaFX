package fes.aragon.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import fes.aragon.modelo.MusicaCiclica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MusicaController implements Initializable {

    @FXML
    private TableColumn<MusicaCiclica, String> clmAccion;

    @FXML
    private TableColumn<MusicaCiclica, String> clmCancionNombre;

    @FXML
    private TableColumn<MusicaCiclica, String> clmRuta;

    @FXML
    private Pane pnePrincipalmusica;

    @FXML
    private TableView<MusicaCiclica> tblTablamusica;
    private ArrayList<MusicaCiclica> canciones;
    private ObservableList<MusicaCiclica> cancionesTabla;
    private boolean activo;
    private Thread hilo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//para colocar canciones y el boton de reproducir falat implementar la funcion del boton
    this.clmCancionNombre.setCellValueFactory(new PropertyValueFactory<>("nombreArchivo"));
    MusicaCiclica musicaCiclica = new MusicaCiclica("BadApple");
        MusicaCiclica musicaCiclica2 = new MusicaCiclica("MusicaMenu");
        MusicaCiclica musicaCiclica3 = new MusicaCiclica("MegavsZero");
        ObservableList<MusicaCiclica> list = FXCollections.observableArrayList();
        list.add(musicaCiclica);
        list.add(musicaCiclica2);
        list.add(musicaCiclica3);
        cancionesTabla = list;
    this.tblTablamusica.setItems(cancionesTabla);


    Callback<TableColumn<MusicaCiclica, String>, TableCell<MusicaCiclica, String>>
                celda= (TableColumn<MusicaCiclica,String> parametros)->{
           final TableCell<MusicaCiclica,String> cel= new TableCell<>(){
               @Override
               protected void updateItem(String s, boolean b) {
                   super.updateItem(s, b);
                   if(b){
                       setGraphic(null);
                       setText(null);
                   }else{
                       FontAwesomeIconView borrarIcono = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                       borrarIcono.setGlyphStyle("-fx-cursor:hand;"+"-glyph-size:28px;"+"-fx-fill:#ff1744");
                       //
                       FontAwesomeIconView reproducirIcono = new FontAwesomeIconView(FontAwesomeIcon.PLAY);
                       reproducirIcono.setGlyphStyle("-fx-cursor:hand;"+"-glyph-size:28px;"+"-fx-fill:#ff1744");
                       //
                       borrarIcono.setOnMouseClicked((MouseEvent evento)->{
                            int indice = tblTablamusica.getSelectionModel().getSelectedIndex();
                           System.out.println(tblTablamusica.getSelectionModel().getSelectedIndex());
                           list.get(indice).getHilo().stop();
                       });
                       reproducirIcono.setOnMouseClicked((MouseEvent evento)->{
                        MusicaCiclica musicaCiclica1 = tblTablamusica.getSelectionModel().getSelectedItem();
                           System.out.println(tblTablamusica.getSelectionModel().getSelectedIndex());
                        musicaCiclica1.setHilo( hilo = new Thread(musicaCiclica1));
                       hilo.start();
                       });
                       HBox hBox = new HBox(reproducirIcono, borrarIcono);
                       hBox.setStyle("-fx-alignment:center");
                       HBox.setMargin(reproducirIcono,new Insets(2,2,0,3));
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
    public void cerrarJuego(){
        Stage stage = (Stage) pnePrincipalmusica.getScene().getWindow();
        stage.setOnCloseRequest((t)->{
            hilo.stop();
            stage.close();
            }
        );
    }
}
