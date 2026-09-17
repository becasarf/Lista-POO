package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Exercicio4Controller {

    @FXML
    private ImageView imgPlano;

    @FXML
    private Label lblQuadrante;

    @FXML
    private Label lblX;

    @FXML
    private Label lblY;

    @FXML
private void initialize() {
    imgPlano.setOnMouseMoved(e -> {
    double largura = imgPlano.getBoundsInLocal().getWidth();
    double altura = imgPlano.getBoundsInLocal().getHeight();

    double xCartesiano = e.getX() - (largura / 2);
    double yCartesiano = (altura / 2) - e.getY();

    String quadrante;
    if (xCartesiano > 0 && yCartesiano > 0) {
        quadrante = "1º Quadrante";
    } else if (xCartesiano < 0 && yCartesiano > 0) {
        quadrante = "2º Quadrante";
    } else if (xCartesiano < 0 && yCartesiano < 0) {
        quadrante = "3º Quadrante";
    } else if (xCartesiano > 0 && yCartesiano < 0) {
        quadrante = "4º Quadrante";
    } else {
        quadrante = "Sobre um dos eixos";
    }

    lblX.setText(String.format("X: %.1f", xCartesiano));
    lblY.setText(String.format("Y: %.1f", yCartesiano));
    lblQuadrante.setText(quadrante);
});
}

}
