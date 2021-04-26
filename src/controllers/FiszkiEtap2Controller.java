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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import myObjects.Word;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class FiszkiEtap2Controller implements Initializable {

    @FXML private Button closeButton;
    @FXML private Label tempWordLabel;
    @FXML private javafx.scene.control.TextField keyboardTrans;
    @FXML private Button checkButton;
    @FXML private Button nextWordButton;
    @FXML private Label pointsLabel;
    @FXML private Label iteratorLabel;
    @FXML private Label transLabel;

    private ArrayList<Word> yourWords = new ArrayList<>();
    private int number;
    private int iterator = 0;

    private Word tempWord;

    private int score2;
    private int score1;
    private boolean point = false;
    private boolean checked = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void initAfter1(ArrayList<Word> wordsYouGot, int score) {
        yourWords = wordsYouGot;
        number = yourWords.size();
        score1 = score;

        tempWord = yourWords.get(iterator);
        tempWordLabel.setText(tempWord.getSpanish());
        iteratorLabel.setText(Integer.toString(iterator+1));
        transLabel.setText(null);
    }


    public void checkEvent(ActionEvent actionEvent) {

        if(!checked) {
            if (keyboardTrans.getText() == null || keyboardTrans.getText().equals("")) {
                keyboardTrans.setPromptText("pon tu respuesta");
            } else {
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

                    transLabel.setText(translation);

                    if (keyboardTrans.getText().equals(translation)) {
                        point = true;
                        keyboardTrans.setBackground(new Background(new BackgroundFill(Color.rgb(189, 229, 111), CornerRadii.EMPTY, Insets.EMPTY)));
                    }

                    if (!keyboardTrans.getText().equals(translation)) {
                        point = false;
                        keyboardTrans.setBackground(new Background(new BackgroundFill(Color.rgb(252, 125, 89), CornerRadii.EMPTY, Insets.EMPTY)));
                    }

                    if (point) {
                        score2 += 1;
                        pointsLabel.setText(Integer.toString(score2));
                    }

                    if (iterator == number - 1) {
                        nextWordButton.setDisable(true);
                        checkButton.setDisable(true);
                    }
                }

            }
        }
    }

    public void nextWordEvent(ActionEvent actionEvent) {

        if(checked) {
            if (keyboardTrans.getText() == null || keyboardTrans.getText().equals("")) {
                keyboardTrans.setPromptText("pon tu respuesta");
            } else {
                if (iterator < number - 1) {

                    keyboardTrans.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                    keyboardTrans.setText(null);

                    transLabel.setText(null);

                    iterator += 1;
                    iteratorLabel.setText(Integer.toString(iterator + 1));
                    tempWord = yourWords.get(iterator);

                    // hiszpanski -> polski
                    if (iterator % 2 == 0) {
                        tempWordLabel.setText(yourWords.get(iterator).getSpanish());
                    }

                    // polski -> hiszpanski
                    if (iterator % 2 != 0) {
                        tempWordLabel.setText(yourWords.get(iterator).getPolish());
                    }
                }
            }
            checked = false;
        }
    }

    public void áEvent(ActionEvent actionEvent) {
        String alreadyThere;
        alreadyThere = keyboardTrans.getText();
        if (alreadyThere != null) {
            keyboardTrans.setText(alreadyThere + "á");
        } else {
            keyboardTrans.setText("á");
        }
    }

    public void éEvent(ActionEvent actionEvent) {
        String alreadyThere;
        alreadyThere = keyboardTrans.getText();
        if (alreadyThere != null) {
            keyboardTrans.setText(alreadyThere + "é");
        } else {
            keyboardTrans.setText("é");
        }
    }

    public void íEvent(ActionEvent actionEvent) {
        String alreadyThere;
        alreadyThere = keyboardTrans.getText();
        if (alreadyThere != null) {
            keyboardTrans.setText(alreadyThere + "í");
        } else {
            keyboardTrans.setText("í");
        }
    }

    public void óEvent(ActionEvent actionEvent) {
        String alreadyThere;
        alreadyThere = keyboardTrans.getText();
        if (alreadyThere != null) {
            keyboardTrans.setText(alreadyThere + "ó");
        } else {
            keyboardTrans.setText("ó");
        }
    }

    public void úEvent(ActionEvent actionEvent) {
        String alreadyThere;
        alreadyThere = keyboardTrans.getText();
        if (alreadyThere != null) {
            keyboardTrans.setText(alreadyThere + "ú");
        } else {
            keyboardTrans.setText("ú");
        }
    }

    public void üEvent(ActionEvent actionEvent) {
        String alreadyThere;
        alreadyThere = keyboardTrans.getText();
        if (alreadyThere != null) {
            keyboardTrans.setText(alreadyThere + "ü");
        } else {
            keyboardTrans.setText("ü");
        }
    }

    public void nEvent(ActionEvent actionEvent) {
        String alreadyThere;
        alreadyThere = keyboardTrans.getText();
        if (alreadyThere != null) {
            keyboardTrans.setText(alreadyThere + "ñ");
        } else {
            keyboardTrans.setText("ñ");
        }
    }

    public void finishFiszkiEvent(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/fiszkiFinish.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        FiszkiFinishController fiszkiFinishController = loader.getController();
        fiszkiFinishController.initScores(score1,score2);
        fiszkiFinishController.initYourWords(yourWords);

        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void closeEvent(ActionEvent actionEvent) {
        Stage window = (Stage) closeButton.getScene().getWindow();
        window.close();
    }
}
