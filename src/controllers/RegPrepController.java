package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class RegPrepController {

    @FXML private Button closeButton;

    public void playEvent(ActionEvent actionEvent) throws IOException, SQLException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/regGame.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        RegGameController regGameController = loader.getController();
        regGameController.initLabels();
        regGameController.initChoice();

        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public void closeEvent(ActionEvent actionEvent) {
        Stage window = (Stage) closeButton.getScene().getWindow();
        window.close();
    }
}
