import database.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent welcomeRoot = FXMLLoader.load(getClass().getResource("resources/welcome.fxml"));
        Scene welcome = new Scene(welcomeRoot);
        welcome.setFill(Color.TRANSPARENT);
        primaryStage.setTitle("Hola");
        primaryStage.centerOnScreen();
        primaryStage.setScene(welcome);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getIcons().add(new Image("sun.png"));
        primaryStage.show();

    }

    public static void main(String[] args) {
        DBConnection.getConnection();
        launch(args);
    }
}
