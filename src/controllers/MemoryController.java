package controllers;

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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import myObjects.Word;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.ResourceBundle;

public class MemoryController implements Initializable {

    @FXML private Button closeButton;
    @FXML private Button allBackButton;
    @FXML private Label label00;
    @FXML private Label label10;
    @FXML private Label label20;
    @FXML private Label label30;
    @FXML private Label label01;
    @FXML private Label label11;
    @FXML private Label label21;
    @FXML private Label label31;
    @FXML private Label label02;
    @FXML private Label label12;
    @FXML private Label label22;
    @FXML private Label label32;
    @FXML private Label label03;
    @FXML private Label label13;
    @FXML private Label label23;
    @FXML private Label label33;
    @FXML private Label label04;
    @FXML private Label label14;
    @FXML private Label label24;
    @FXML private Label label34;
    @FXML private ImageView congratsImg;

    @FXML private Label scoreLabel;

    @FXML private ListView pairsList;

    private ObservableList<String> pairs = FXCollections.observableArrayList();

    private int uncovered = 0;
    private boolean canUncover = true;

    private String tempWord = "";
    private String tempTrans = "";

    private boolean pairWasFound = false;
    private int score = 0;

    private ArrayList<Word> yourWords = new ArrayList<>();
    private int number;

    private int token = 1000;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void initYourWords(ArrayList<Word> wordsYouGot) {
        yourWords = wordsYouGot;
        number = wordsYouGot.size();
        Collections.shuffle(yourWords);
    }

    public void assignWords(){

        congratsImg.setVisible(false);

        ArrayList<String> wordsStrings = new ArrayList<>();

        for(int i=0; i<10; i++){
            wordsStrings.add(yourWords.get(i).getSpanish());
            wordsStrings.add(yourWords.get(i).getPolish());
        }
        Collections.shuffle(wordsStrings);

        label00.setText(wordsStrings.get(0));
        label00.setVisible(false);
        label10.setText(wordsStrings.get(1));
        label10.setVisible(false);
        label20.setText(wordsStrings.get(2));
        label20.setVisible(false);
        label30.setText(wordsStrings.get(3));
        label30.setVisible(false);
        label01.setText(wordsStrings.get(4));
        label01.setVisible(false);
        label11.setText(wordsStrings.get(5));
        label11.setVisible(false);
        label21.setText(wordsStrings.get(6));
        label21.setVisible(false);
        label31.setText(wordsStrings.get(7));
        label31.setVisible(false);
        label02.setText(wordsStrings.get(8));
        label02.setVisible(false);
        label12.setText(wordsStrings.get(9));
        label12.setVisible(false);
        label22.setText(wordsStrings.get(10));
        label22.setVisible(false);
        label32.setText(wordsStrings.get(11));
        label32.setVisible(false);
        label03.setText(wordsStrings.get(12));
        label03.setVisible(false);
        label13.setText(wordsStrings.get(13));
        label13.setVisible(false);
        label23.setText(wordsStrings.get(14));
        label23.setVisible(false);
        label33.setText(wordsStrings.get(15));
        label33.setVisible(false);
        label04.setText(wordsStrings.get(16));
        label04.setVisible(false);
        label14.setText(wordsStrings.get(17));
        label14.setVisible(false);
        label24.setText(wordsStrings.get(18));
        label24.setVisible(false);
        label34.setText(wordsStrings.get(19));
        label34.setVisible(false);

    }

    public void clicked00(MouseEvent mouseEvent){
        if(token==0 && uncovered==1) {
            return;
        }
        else{
            uncoveringSituation(label00);
            pairFound(label00);
            token = 0;
        }
    }

    public void clicked10(MouseEvent mouseEvent) {
        if(token==10 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label10);
            pairFound(label10);
            token = 10;
        }
    }

    public void clicked20(MouseEvent mouseEvent) {
        if(token==20 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label20);
            pairFound(label20);
            token = 20;
        }
    }

    public void clicked30(MouseEvent mouseEvent) {
        if(token==30 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label30);
            pairFound(label30);
            token = 30;
        }
    }

    public void clicked01(MouseEvent mouseEvent) {
        if(token==1 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label01);
            pairFound(label01);
            token = 1;
        }
    }

    public void cliecked11(MouseEvent mouseEvent) {
        if(token==11 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label11);
            pairFound((label11));
            token = 11;
        }
    }

    public void clicked21(MouseEvent mouseEvent) {
        if(token==21 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label21);
            pairFound(label21);
            token = 21;
        }
    }

    public void clicked31(MouseEvent mouseEvent) {
        if(token==31 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label31);
            pairFound(label31);
            token = 31;
        }
    }

    public void clicked02(MouseEvent mouseEvent) {
        if(token==2 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label02);
            pairFound(label02);
            token = 2;
        }
    }

    public void clicked12(MouseEvent mouseEvent) {
        if(token==12 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label12);
            pairFound(label12);
            token = 12;
        }
    }

    public void clicked22(MouseEvent mouseEvent) {
        if(token==22 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label22);
            pairFound(label22);
            token = 22;
        }
    }

    public void clicked32(MouseEvent mouseEvent) {
        if(token==32 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label32);
            pairFound(label32);
            token = 32;
        }
    }

    public void clicked03(MouseEvent mouseEvent) {
        if(token==3 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label03);
            pairFound(label03);
            token = 3;
        }
    }

    public void clicked13(MouseEvent mouseEvent) {
        if(token==13 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label13);
            pairFound(label13);
            token = 13;
        }
    }

    public void clicked23(MouseEvent mouseEvent) {
        if(token==23 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label23);
            pairFound(label23);
            token = 23;
        }
    }

    public void clicked33(MouseEvent mouseEvent) {
        if(token==33 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label33);
            pairFound(label33);
            token = 33;
        }
    }

    public void clicked04(MouseEvent mouseEvent) {
        if(token==4 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label04);
            pairFound(label04);
            token = 4;
        }
    }

    public void clicked14(MouseEvent mouseEvent) {
        if(token==14 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label14);
            pairFound(label14);
            token = 14;
        }

    }

    public void clicked24(MouseEvent mouseEvent) {
        if(token==24 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label24);
            pairFound(label24);
            token = 24;
        }
    }

    public void clicked34(MouseEvent mouseEvent) {
        if(token==34 && uncovered==1) {
            return;
        }
        else {
            uncoveringSituation(label34);
            pairFound(label34);
            token = 34;
        }
    }

    public void uncoveringSituation(Label label){
        if(canUncover) {
            if (uncovered == 0) {
                label.setVisible(true);
                uncovered = 1;
                return;
            }
            if (uncovered == 1) {
                label.setVisible(true);
                uncovered = 2;
                canUncover = false;
                return;
            }
            if (uncovered == 2) {
                label.setVisible(false);
                uncovered--;
                return;
            }
        }
        if(!canUncover && label.isVisible() && uncovered == 2){
            label.setVisible(false);
            uncovered--;
        }
        if(!canUncover && label.isVisible() && uncovered == 1){
            label.setVisible(false);
            uncovered--;
            canUncover = true;
        }
        if(!canUncover && !label.isVisible()){
            return;
        }
    }


    public void pairFound(Label label){

        if(uncovered == 1){
            tempWord = label.getText();
        }
        if(uncovered == 2){
            tempTrans = label.getText();

            for(int i=0; i<10; i++){
                if(tempWord.equals(yourWords.get(i).getPolish()) && tempTrans.equals(yourWords.get(i).getSpanish()) || tempWord.equals(yourWords.get(i).getSpanish()) && tempTrans.equals(yourWords.get(i).getPolish())){
                    //pairWasFound = true;
                    score++;
                    scoreLabel.setText(Integer.toString(score));
                    tempWord = "";
                    tempTrans = "";
                    label.getParent().setDisable(true);
                    findTokenAndDisable(token);
                    uncovered = 0;
                    canUncover = true;
                    String pair = yourWords.get(i).getSpanish() + " - " + yourWords.get(i).getPolish();
                    pairs.add(pair);
                    pairsList.setItems(pairs);
                    if(score == 10){
                        congratsImg.setVisible(true);
                    }
                    break;
                }
            }
        }
    }

    public void findTokenAndDisable(int token){
        if(token == 0){
            label00.getParent().setDisable(true);
        }
        if(token == 1){
            label01.getParent().setDisable(true);
        }
        if(token == 2){
            label02.getParent().setDisable(true);
        }
        if(token == 3){
            label03.getParent().setDisable(true);
        }
        if(token == 4){
            label04.getParent().setDisable(true);
        }
        if(token == 10){
            label10.getParent().setDisable(true);
        }
        if(token == 11){
            label11.getParent().setDisable(true);
        }
        if(token == 12){
            label12.getParent().setDisable(true);
        }
        if(token == 13){
            label13.getParent().setDisable(true);
        }
        if(token == 14){
            label14.getParent().setDisable(true);
        }
        if(token == 20){
            label20.getParent().setDisable(true);
        }
        if(token == 21){
            label21.getParent().setDisable(true);
        }
        if(token == 22){
            label22.getParent().setDisable(true);
        }
        if(token == 23){
            label23.getParent().setDisable(true);
        }
        if(token == 24){
            label24.getParent().setDisable(true);
        }
        if(token == 30){
            label30.getParent().setDisable(true);
        }
        if(token == 31){
            label31.getParent().setDisable(true);
        }
        if(token == 32){
            label32.getParent().setDisable(true);
        }
        if(token == 33){
            label33.getParent().setDisable(true);
        }
        if(token == 34){
            label34.getParent().setDisable(true);
        }
    }

    public void allBackEvent(ActionEvent actionEvent) throws IOException {
        Parent homeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/chooseGroup.fxml")));
        Stage window = (Stage) allBackButton.getScene().getWindow();
        window.setScene(new Scene(homeRoot));
        window.getScene().setFill(Color.TRANSPARENT);
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

    public void closeEvent(ActionEvent actionEvent) {
        Stage window = (Stage) closeButton.getScene().getWindow();
        window.close();
    }
}