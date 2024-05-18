package fes.aragon.controller;

import fes.aragon.modelo.OperacionRacional;
import fes.aragon.modelo.Racional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RacionalesController {

    @FXML
    private Button btnResolver;

    @FXML
    private TextField txfDenominadorDos;

    @FXML
    private TextField txfDenominadorResultado;

    @FXML
    private TextField txfDenominadorUno;

    @FXML
    private TextField txfNumeradorDos;

    @FXML
    private TextField txfNumeradorResultado;

    @FXML
    private TextField txfNumeradorUno;

    @FXML
    void eventoResolver(ActionEvent event) {
     Racional racional1 = new Racional(Integer.parseInt(txfNumeradorUno.getText()),Integer.parseInt(txfDenominadorUno.getText()));
    Racional racional2 = new Racional(Integer.parseInt(txfNumeradorDos.getText()),Integer.parseInt(txfDenominadorDos.getText()));
    OperacionRacional operacionRacional1 = new OperacionRacional(racional1,racional2);
    txfNumeradorResultado.setText(String.valueOf(operacionRacional1.suma().getNumerador()));
    txfDenominadorResultado.setText(String.valueOf(operacionRacional1.suma().getDenominador()));
    txfNumeradorUno.clear();
    txfDenominadorUno.clear();
    txfNumeradorDos.clear();
    txfDenominadorDos.clear();
    }

}
