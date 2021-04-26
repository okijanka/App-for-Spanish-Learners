package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import myObjects.Word;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class FiszkiEtap1Controller implements Initializable {

    @FXML private Button closeButton;
    @FXML private Label tempWordLabel;
    @FXML private RadioButton tempTrans1Radio;
    @FXML private RadioButton tempTrans2Radio;
    @FXML private RadioButton tempTrans3Radio;
    @FXML private Button nextWordButton;
    @FXML private Label pointsLabel;
    @FXML private Label iteratorLabel;
    @FXML private Button checkButton;

    private int number;
    private int iterator = 0;

    private ArrayList<Word> yourWords = new ArrayList<>();
    private Word tempWord;

    private int score1 = 0;
    private boolean point = false;
    private boolean checked = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public static ArrayList<Integer> randomize(int current_word_number, int how_many_words) {
        Random r = new Random();
        int r1 = r.nextInt(how_many_words);
        int r2 = r.nextInt(how_many_words);

        while (r1 == current_word_number) {
            r1 = r.nextInt(how_many_words);
        }

        while (r2 == r1 || r2 == current_word_number) {
            r2 = r.nextInt(how_many_words);
        }
        ArrayList<Integer> received_numbers = new ArrayList<>();
        received_numbers.add(current_word_number);
        received_numbers.add(r1);
        received_numbers.add(r2);

        return received_numbers;
    }

    public void initYourWords(ArrayList<Word> wordsYouGot){
        yourWords = wordsYouGot;
        number = yourWords.size();

        tempWord = yourWords.get(iterator);
        tempWordLabel.setText(yourWords.get(iterator).getSpanish());

        ArrayList<Integer> indices = randomize(iterator, number);
        String correct_answer = yourWords.get(iterator).getPolish();
        String wrong_answer_1 = yourWords.get(indices.get(1)).getPolish();
        String wrong_answer_2 = yourWords.get(indices.get(2)).getPolish();

        tempTrans1Radio.setText(wrong_answer_1);
        tempTrans2Radio.setText(correct_answer);
        tempTrans3Radio.setText(wrong_answer_2);

        iteratorLabel.setText(Integer.toString(iterator+1));

    }


    public void nextWordEvent(ActionEvent actionEvent) {

        if(checked) {
            if (iterator < number - 1) {

                tempTrans1Radio.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                tempTrans2Radio.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                tempTrans3Radio.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                tempTrans1Radio.setSelected(false);
                tempTrans2Radio.setSelected(false);
                tempTrans3Radio.setSelected(false);

                iterator += 1;
                iteratorLabel.setText(Integer.toString(iterator + 1));
                tempWord = yourWords.get(iterator);

                int wild = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

                // hiszpanski -> polski
                if (iterator % 2 == 0) {

                    tempWordLabel.setText(yourWords.get(iterator).getSpanish());

                    ArrayList<Integer> indices = randomize(iterator, number);
                    String correct_answer = yourWords.get(iterator).getPolish();
                    String wrong_answer_1 = yourWords.get(indices.get(1)).getPolish();
                    String wrong_answer_2 = yourWords.get(indices.get(2)).getPolish();

                    if (wild == 1) {
                        tempTrans1Radio.setText(correct_answer);
                        tempTrans2Radio.setText(wrong_answer_1);
                        tempTrans3Radio.setText(wrong_answer_2);
                    }

                    if (wild == 2) {
                        tempTrans2Radio.setText(correct_answer);
                        tempTrans1Radio.setText(wrong_answer_1);
                        tempTrans3Radio.setText(wrong_answer_2);
                    }

                    if (wild == 3) {
                        tempTrans3Radio.setText(correct_answer);
                        tempTrans1Radio.setText(wrong_answer_1);
                        tempTrans2Radio.setText(wrong_answer_2);

                    }

                }

                // polski -> hiszpanski
                if (iterator % 2 != 0) {

                    tempWordLabel.setText(yourWords.get(iterator).getPolish());

                    ArrayList<Integer> indices = randomize(iterator, number);
                    String correct_answer = yourWords.get(iterator).getSpanish();
                    String wrong_answer_1 = yourWords.get(indices.get(1)).getSpanish();
                    String wrong_answer_2 = yourWords.get(indices.get(2)).getSpanish();

                    if (wild == 1) {
                        tempTrans1Radio.setText(correct_answer);
                        tempTrans2Radio.setText(wrong_answer_1);
                        tempTrans3Radio.setText(wrong_answer_2);
                    }

                    if (wild == 2) {
                        tempTrans2Radio.setText(correct_answer);
                        tempTrans1Radio.setText(wrong_answer_1);
                        tempTrans3Radio.setText(wrong_answer_2);
                    }

                    if (wild == 3) {
                        tempTrans3Radio.setText(correct_answer);
                        tempTrans1Radio.setText(wrong_answer_1);
                        tempTrans2Radio.setText(wrong_answer_2);
                    }

                }
            }
            checked = false;
        }

    }

    public void checkEvent(ActionEvent actionEvent) {

        if (!checked) {
            if (tempTrans1Radio.isSelected() || tempTrans2Radio.isSelected() || tempTrans3Radio.isSelected()) {
                checked = true;
                if (iterator < number) {
                    String word = "";
                    String translation = "";

                    if (iterator % 2 == 0) {
                        word = tempWord.getSpanish();
                        translation = tempWord.getPolish();
                    }
                    if (iterator % 2 != 0) {
                        word = tempWord.getPolish();
                        translation = tempWord.getSpanish();
                    }


                    if (tempTrans1Radio.getText().equals(translation) && tempTrans1Radio.isSelected()) {
                        point = true;
                        tempTrans1Radio.setBackground(new Background(new BackgroundFill(Color.rgb(189, 229, 111), new CornerRadii(20), Insets.EMPTY)));
                    }
                    if (!tempTrans1Radio.getText().equals(translation) && tempTrans1Radio.isSelected()) {
                        point = false;
                        tempTrans1Radio.setBackground(new Background(new BackgroundFill(Color.rgb(252, 125, 89), new CornerRadii(20), Insets.EMPTY)));
                    }

                    if (tempTrans2Radio.getText().equals(translation) && tempTrans2Radio.isSelected()) {
                        point = true;
                        tempTrans2Radio.setBackground(new Background(new BackgroundFill(Color.rgb(189, 229, 111), new CornerRadii(20), Insets.EMPTY)));
                    }

                    if (!tempTrans2Radio.getText().equals(translation) && tempTrans2Radio.isSelected()) {
                        point = false;
                        tempTrans2Radio.setBackground(new Background(new BackgroundFill(Color.rgb(252, 125, 89), new CornerRadii(20), Insets.EMPTY)));
                    }
                    if (tempTrans3Radio.getText().equals(translation) && tempTrans3Radio.isSelected()) {
                        point = true;
                        tempTrans3Radio.setBackground(new Background(new BackgroundFill(Color.rgb(189, 229, 111), new CornerRadii(20), Insets.EMPTY)));
                    }
                    if (!tempTrans3Radio.getText().equals(translation) && tempTrans3Radio.isSelected()) {
                        point = false;
                        tempTrans3Radio.setBackground(new Background(new BackgroundFill(Color.rgb(252, 125, 89), new CornerRadii(20), Insets.EMPTY)));
                    }

                    if (point) {
                        score1 += 1;
                        pointsLabel.setText(Integer.toString(score1));
                    }

                    if (iterator == number - 1) {
                        nextWordButton.setDisable(true);
                        checkButton.setDisable(true);
                    }

                }
            }
        }
    }


    public void goToEtap2Event(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/fiszkiEtap2.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        FiszkiEtap2Controller fiszkiEtap2Controller = loader.getController();
        fiszkiEtap2Controller.initAfter1(yourWords, score1);

        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void closeEvent(ActionEvent actionEvent) {
        Stage window = (Stage) closeButton.getScene().getWindow();
        window.close();
    }
}
