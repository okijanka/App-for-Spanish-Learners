package controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import myObjects.Word;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class VocabularyGamesController implements Initializable {

    @FXML private Button closeButton;
    @FXML private Button allBackButton;
    private ArrayList<Word> yourWords = new ArrayList<>();
    private ArrayList<String> yourStrings = new ArrayList<>();
    private ObservableList<String> yourList;
    private int number;

    public void initYourList(ObservableList<String> observableList){
        yourList = observableList;
    }

    public void makeWordsObjects(ObservableList<String> observableList){

        number = observableList.size();

        for(int i=0; i<number; i++){
            yourStrings.add(observableList.get(i));
        }

        for(int i=0; i<number; i++){
            String spanish = yourStrings.get(i).split(" - ")[0];
            String polish = yourStrings.get(i).split(" - ")[1];
            yourWords.add(new Word(polish,spanish));
        }

    }

    public void weAreBack(ArrayList<Word> wordsYouGot){
        yourWords = wordsYouGot;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void playFiszkiEvent(ActionEvent actionEvent) throws IOException {
        //makeWordsObjects(yourList);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/fiszkiEtap1.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        FiszkiEtap1Controller fiszkiEtap1Controller = loader.getController();
        fiszkiEtap1Controller.initYourWords(yourWords);

        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void playMemoryEvent(ActionEvent actionEvent) throws IOException {
        //makeWordsObjects(yourList);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/memory.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        MemoryController memoryController = loader.getController();
        memoryController.initYourWords(yourWords);
        memoryController.assignWords();

        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }


    public void allBackEvent(ActionEvent actionEvent) throws IOException {
        Parent homeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/chooseGroup.fxml")));
        Stage window = (Stage) allBackButton.getScene().getWindow();
        window.setScene(new Scene(homeRoot));
        window.getScene().setFill(Color.TRANSPARENT);
    }

    public void closeEvent(ActionEvent actionEvent) {
        Stage window = (Stage) closeButton.getScene().getWindow();
        window.close();
    }
}
