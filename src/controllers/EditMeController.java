package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class EditMeController {

    @FXML private Button backButton;
    @FXML private Button closeButton;
    @FXML private Label piwoLabel;
    @FXML private Label ruterLabel;
    @FXML private Label rj45Label;
    @FXML private Label fortunaLabel;

    public void closeEvent(ActionEvent actionEvent) {
        Stage window = (Stage) closeButton.getScene().getWindow();
        window.close();
    }

    public void backEvent(ActionEvent actionEvent) throws IOException {
        Parent homeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/chooseGroup.fxml")));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(homeRoot));
        window.getScene().setFill(Color.TRANSPARENT);
    }

    public void translateEvent(ActionEvent actionEvent) {
        piwoLabel.setText("figa");
        ruterLabel.setText("figa");
        rj45Label.setText("figa");
        fortunaLabel.setText("figa");
    }
}
