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
import java.util.Objects;

public class ChooseGroupController {

    @FXML private Button testButton;
    @FXML private Button easterEggButton;
    @FXML private Button closeButton;
    @FXML private Button cultureButton;

    public void vocabularyClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/howMany.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        HowManyController howManyController = loader.getController();
        howManyController.disableButtons();

        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void cultureClicked(ActionEvent actionEvent) throws IOException{
        Parent homeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/cultureGames.fxml")));
        Stage window = (Stage) cultureButton.getScene().getWindow();
        window.setScene(new Scene(homeRoot));
        window.getScene().setFill(Color.TRANSPARENT);
    }

    public void easterEggEvent(ActionEvent actionEvent) throws IOException {
        Parent homeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/easterEgg.fxml")));
        Stage window = (Stage) easterEggButton.getScene().getWindow();
        window.setScene(new Scene(homeRoot));
        window.getScene().setFill(Color.TRANSPARENT);
    }

    public void testEvent(ActionEvent actionEvent) throws IOException {
        Parent homeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/editMe.fxml")));
        Stage window = (Stage) testButton.getScene().getWindow();
        window.setScene(new Scene(homeRoot));
        window.getScene().setFill(Color.TRANSPARENT);
    }

    public void closeEvent(ActionEvent actionEvent) {
        Stage window = (Stage) closeButton.getScene().getWindow();
        window.close();
    }


}
