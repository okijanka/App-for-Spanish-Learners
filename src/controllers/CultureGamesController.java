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

public class CultureGamesController {

    @FXML private Button closeButton;
    @FXML private Button allBackButton;
    @FXML private Button playRegionsButton;


    public void playRegionsEvent(ActionEvent actionEvent) throws IOException {
        Parent homeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/regPrep.fxml")));
        Stage window = (Stage) playRegionsButton.getScene().getWindow();
        window.setScene(new Scene(homeRoot));
        window.getScene().setFill(Color.TRANSPARENT);
    }

    public void allBackEvent(ActionEvent actionEvent) throws IOException {
        Parent homeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/chooseGroup.fxml")));
        Stage window = (Stage) allBackButton.getScene().getWindow();
        window.setScene(new Scene(homeRoot));
        window.getScene().setFill(Color.TRANSPARENT);
    }

    public void playPeopleEvent(ActionEvent actionEvent) throws IOException, SQLException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/peopleGame.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        PeopleGameController peopleGameController = loader.getController();
        peopleGameController.initLabels();

        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void closeEvent(ActionEvent actionEvent) {
        Stage window = (Stage) closeButton.getScene().getWindow();
        window.close();
    }
}
