package controller;
 
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
 
/**
 * Controller do Exercicio 06: Funcao de 2o Grau e Imagens.
 * Os nomes das variaveis abaixo sao IGUAIS aos fx:id usados no FXML --
 * e' assim que o JavaFX injeta cada componente automaticamente.
 */
public class Exercicio6Controller {
 
    @FXML
    private TextField txtA;
    @FXML
    private TextField txtB;
    @FXML
    private TextField txtC;
 
    @FXML
    private Label lblDelta;
    @FXML
    private Label lblX1;
    @FXML
    private Label lblX2;
    @FXML
    private Label lblResultado;
 
    @FXML
    private ImageView imgParabola;
 
    private Image imagemParabolaUp;
    private Image imagemParabolaDown;
 
  
    @FXML
    public void initialize() {
        carregarImagens();
    }
 
   
    private void carregarImagens() {
        try {
            imagemParabolaUp = new Image(getClass().getResourceAsStream("/images/parabolaUP.jpg"));
            imagemParabolaDown = new Image(getClass().getResourceAsStream("/images/parabolaDOWN.jpg"));
        } catch (Exception e) {
            System.out.println("Nao foi possivel carregar as imagens: " + e.getMessage());
        }
    }
 
    
    @FXML
    private void calcular() {
        double a, b, c;
 
        try {
            a = Double.parseDouble(txtA.getText().replace(",", "."));
            b = Double.parseDouble(txtB.getText().replace(",", "."));
            c = Double.parseDouble(txtC.getText().replace(",", "."));
        } catch (NumberFormatException e) {
            lblDelta.setText("erro");
            lblX1.setText("-");
            lblX2.setText("-");
            lblResultado.setText("Digite valores numericos validos.");
            return;
        }
 
        if (a == 0) {
            lblDelta.setText("-");
            lblX1.setText("-");
            lblX2.setText("-");
            lblResultado.setText("Coeficiente 'a' nao pode ser zero.");
            return;
        }
 
        double delta = calcularDelta(a, b, c);
        atualizarLabelDelta(delta);
        atualizarRaizes(a, b, delta);
        atualizarImagemParabola(a);
    }
 
  
    private double calcularDelta(double a, double b, double c) {
        return Math.pow(b, 2) - 4 * a * c;
    }
 

    private void atualizarLabelDelta(double delta) {
        lblDelta.setText(String.format("%.2f", delta));
    }
 
    private void atualizarRaizes(double a, double b, double delta) {
        if (delta < 0) {
            lblX1.setText("-");
            lblX2.setText("-");
            lblResultado.setText("A equacao nao possui raizes reais.");
        } else if (delta == 0) {
            double x = (-b) / (2 * a);
            lblX1.setText(String.format("%.2f", x));
            lblX2.setText(String.format("%.2f", x));
            lblResultado.setText("A equacao possui uma raiz real (dupla).");
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            lblX1.setText(String.format("%.2f", x1));
            lblX2.setText(String.format("%.2f", x2));
            lblResultado.setText("A equacao possui duas raizes reais.");
        }
    }
 
   
    private void atualizarImagemParabola(double a) {
        if (a > 0) {
            imgParabola.setImage(imagemParabolaUp);
        } else {
            imgParabola.setImage(imagemParabolaDown);
        }
    }
}