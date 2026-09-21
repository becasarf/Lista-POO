package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

public class Exercicio8Controller {

    @FXML
    private Spinner<Integer> spnValor1;

    @FXML
    private Spinner<Integer> spnValor2;

    @FXML
    private Spinner<Integer> spnValor3;

    @FXML
    private Label lblValor1;

    @FXML
    private Label lblValor2;

    @FXML
    private Label lblValor3;

    @FXML
    private Label lblResultado;

    @FXML
    private void sortear() {

        int max1 = spnValor1.getValue();
        int max2 = spnValor2.getValue();
        int max3 = spnValor3.getValue();

        int numero1;
        int numero2;
        int numero3;

        do {
            numero1 = (int) (Math.random() * (max1 + 1));
            numero2 = (int) (Math.random() * max2) + 1;
            numero3 = (int) (Math.random() * (max3 - 1)) + 2;

        } while (numero1 == numero2 ||
                 numero1 == numero3 ||
                 numero2 == numero3);

        lblValor1.setText(String.valueOf(numero1));
        lblValor2.setText(String.valueOf(numero2));
        lblValor3.setText(String.valueOf(numero3));

        String resultado = numero1 + "" + numero2 + numero3;

        lblResultado.setText(resultado);
    }
}

