package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import myObjects.Word;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

public class FiszkiFinishController implements InitialContextFactory {

    @FXML private Button closeButton;
    @FXML private Button allBack;
    @FXML private Label score1Label;
    @FXML private Label score2Label;

    private int score1;
    private int score2;


    private ArrayList<Word> yourWords = new ArrayList<>();

    public void initYourWords(ArrayList<Word> wordsYouGot){
        yourWords = wordsYouGot;
    }

    public void initScores(int scoreE1, int scoreE2){
        score1 = scoreE1;
        score2 = scoreE2;

        score1Label.setText(Integer.toString(score1));
        score2Label.setText(Integer.toString(score2));
    }


    @Override
    public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
        return null;
    }

    public void vocabBackEvent(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/vocabularyGames.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        VocabularyGamesController vocabularyGamesController = loader.getController();
        vocabularyGamesController.weAreBack(yourWords);


        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void allBackEvent(ActionEvent actionEvent) throws IOException {
        Parent homeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/chooseGroup.fxml")));
        Stage window = (Stage) allBack.getScene().getWindow();
        window.setScene(new Scene(homeRoot));
        window.getScene().setFill(Color.TRANSPARENT);
    }

    public void closeEvent(ActionEvent actionEvent) {
        Stage window = (Stage) closeButton.getScene().getWindow();
        window.close();
    }
}
