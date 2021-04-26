package controllers;

import database.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.ResourceBundle;

public class RegGameController implements Initializable {

    @FXML private Button closeButton;
    @FXML private Button backAllButton;
    @FXML private Button backCultureButton;
    @FXML private Label label1;
    @FXML private ChoiceBox choice1;
    @FXML private Label label2;
    @FXML private ChoiceBox choice2;
    @FXML private Label label3;
    @FXML private ChoiceBox choice3;
    @FXML private Label label4;
    @FXML private ChoiceBox choice4;
    @FXML private Label label5;
    @FXML private ChoiceBox choice5;
    @FXML private Label label6;
    @FXML private ChoiceBox choice6;
    @FXML private Label label7;
    @FXML private ChoiceBox choice7;

    ArrayList<String> regions = new ArrayList<>();
    ArrayList<String> regionsShuffled = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void initLabels() {

        ArrayList<String> numbers = new ArrayList<>();
        for (int i = 1; i <= 17; i++) {
            numbers.add(Integer.toString(i));
        }
        Collections.shuffle(numbers);
        label1.setText(numbers.get(1));
        label2.setText(numbers.get(2));
        label3.setText(numbers.get(3));
        label4.setText(numbers.get(4));
        label5.setText(numbers.get(5));
        label6.setText(numbers.get(6));
        label7.setText(numbers.get(7));
    }

    public void initChoice() throws SQLException {
        Statement statement = DBConnection.getConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT region FROM projekt_hiszpania_db.comunidades");
        while (result.next()) {
            regions.add(result.getString(1));
        }

        regionsShuffled.addAll(regions);
        Collections.shuffle(regionsShuffled);

        addToBoxes(choice1);
        addToBoxes(choice2);
        addToBoxes(choice3);
        addToBoxes(choice4);
        addToBoxes(choice5);
        addToBoxes(choice6);
        addToBoxes(choice7);
    }

    public void addToBoxes(ChoiceBox choiceBox){

        for(int i=0; i<17; i++){
            choiceBox.getItems().add(regionsShuffled.get(i));
        }
    }

    public void checkEvent(ActionEvent actionEvent) {
        if(choice1.getValue()!=null && choice2.getValue()!=null && choice3.getValue()!=null && choice4.getValue()!=null && choice5.getValue()!=null && choice6.getValue()!=null && choice7.getValue()!=null) {
            compare(label1, choice1);
            compare(label2, choice2);
            compare(label3, choice3);
            compare(label4, choice4);
            compare(label5, choice5);
            compare(label6, choice6);
            compare(label7, choice7);
        }
    }

    public void compare(Label label, ChoiceBox choiceBox){

        int number = Integer.parseInt(label.getText()) - 1;
        String trueRegion = regions.get(number);
        String chosenRegion = choiceBox.getValue().toString();

        if (chosenRegion.equals(trueRegion)) {
            choiceBox.setBackground(new Background(new BackgroundFill(Color.rgb(184,196,95), CornerRadii.EMPTY, Insets.EMPTY)));
        }
        if (!chosenRegion.equals(trueRegion)) {
            choiceBox.setBackground(new Background(new BackgroundFill(Color.rgb(228,134,102), CornerRadii.EMPTY, Insets.EMPTY)));
        }

    }

    public void backCultureEvent(ActionEvent actionEvent) throws IOException {
        Parent homeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/cultureGames.fxml")));
        Stage window = (Stage) backCultureButton.getScene().getWindow();
        window.setScene(new Scene(homeRoot));
        window.getScene().setFill(Color.TRANSPARENT);
    }

    public void backAllEvent(ActionEvent actionEvent) throws IOException {
        Parent homeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/chooseGroup.fxml")));
        Stage window = (Stage) backAllButton.getScene().getWindow();
        window.setScene(new Scene(homeRoot));
        window.getScene().setFill(Color.TRANSPARENT);
    }

    public void closeEvent(ActionEvent actionEvent) {
        Stage window = (Stage) closeButton.getScene().getWindow();
        window.close();
    }
}
