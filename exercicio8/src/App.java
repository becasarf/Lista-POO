import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
public void start(Stage primaryStage) throws Exception {
    URL url = getClass().getResource("/view/Tela.fxml");

    Parent root = FXMLLoader.load(url);

    Scene scene = new Scene(root);

    primaryStage.setTitle("EXERCICIO 8 - REBECA ROSA E LUCAS MACHADO");
    primaryStage.setScene(scene);
    primaryStage.show();
}
}