package controllers;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class HowManyController implements Initializable {

    @FXML private Button closeButton;
    @FXML private Button backButton;
    @FXML private ListView<String> wordsList;
    @FXML private Button toVocabGamesButton;

    private int number = 0;

    private ObservableList<String> words = FXCollections.observableArrayList();

    public void disableButtons(){
        toVocabGamesButton.setDisable(true);
    }

    public void tenClicked(ActionEvent actionEvent) throws SQLException {
        wordsList.setItems(words);
        number = 10;
        insertWordsList(number);
        toVocabGamesButton.setDisable(false);
    }

    public void fifteenClicked(ActionEvent actionEvent) throws SQLException {
        wordsList.setItems(words);
        number = 15;
        insertWordsList(number);
        toVocabGamesButton.setDisable(false);
    }

    public void twentyClicked(ActionEvent actionEvent) throws SQLException {
        wordsList.setItems(words);
        number = 20;
        insertWordsList(number);
        toVocabGamesButton.setDisable(false);
    }


    public void insertWordsList(int number) throws SQLException {
        words.clear();
        PreparedStatement statement = DBConnection.getConnection().prepareStatement("SELECT polish, spanish FROM projekt_hiszpania_db.words ORDER BY RAND() LIMIT ?");
        statement.setInt(1, number);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            String stripe = result.getString(2) + " - " + result.getString(1);
            words.add(stripe);
        }
    }

    public void letsPlayVocabEvent(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/vocabularyGames.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        VocabularyGamesController vocabularyGamesController = loader.getController();
        vocabularyGamesController.initYourList(words);
        vocabularyGamesController.makeWordsObjects(words);

        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void backEvent(ActionEvent actionEvent) throws IOException {
        Parent homeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/chooseGroup.fxml")));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(homeRoot));
        window.getScene().setFill(Color.TRANSPARENT);
    }

    public void closeEvent(ActionEvent actionEvent) {
        Stage window = (Stage) closeButton.getScene().getWindow();
        window.close();
    }
}
