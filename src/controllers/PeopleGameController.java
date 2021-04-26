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
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class PeopleGameController implements Initializable {

    @FXML private Button closeButton;
    @FXML private Button allBackButton;
    @FXML private Button cultureBackButton;
    @FXML private Label info1;
    @FXML private Label info2;
    @FXML private Label info4;
    @FXML private Label info3;
    @FXML private StackPane pane1;
    @FXML private StackPane pane2;
    @FXML private StackPane pane3;
    @FXML private StackPane pane4;
    @FXML private Label label1;
    @FXML private Label label2;
    @FXML private Label label3;
    @FXML private Label label4;
    @FXML private Label person1;
    @FXML private Label person2;
    @FXML private Label person3;
    @FXML private Label person4;

    private ArrayList<String> people = new ArrayList<>();
    private ArrayList<String> info = new ArrayList<>();
    private Map<String, String> people_map = new HashMap<>();

    private boolean label1set = false;
    private boolean label2set = false;
    private boolean label3set = false;
    private boolean label4set = false;

    public void acceptPersonEvent(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }

    public void person1DraggedEvent(MouseEvent mouseEvent) {
        Dragboard dragboard = person1.startDragAndDrop(TransferMode.ANY);
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(person1.getText());
        dragboard.setContent(clipboardContent);
        mouseEvent.consume();
    }

    public void person2DraggedEvent(MouseEvent mouseEvent) {
        Dragboard dragboard = person2.startDragAndDrop(TransferMode.ANY);
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(person2.getText());
        dragboard.setContent(clipboardContent);
        mouseEvent.consume();
    }

    public void person3DraggedEvent(MouseEvent mouseEvent) {
        Dragboard dragboard = person3.startDragAndDrop(TransferMode.ANY);
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(person3.getText());
        dragboard.setContent(clipboardContent);
        mouseEvent.consume();
    }

    public void person4DraggedEvent(MouseEvent mouseEvent) {
        Dragboard dragboard = person4.startDragAndDrop(TransferMode.ANY);
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(person4.getText());
        dragboard.setContent(clipboardContent);
        mouseEvent.consume();
    }

    public void droppedAt1Event(DragEvent dragEvent) {
        label1set = true;
        String person = dragEvent.getDragboard().getString();
        label1.setText(person);
        pane1.setBackground(new Background(new BackgroundFill(Color.rgb(231,202,215), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void droppedAt2Event(DragEvent dragEvent) {
        label2set = true;
        String person = dragEvent.getDragboard().getString();
        label2.setText(person);
        pane2.setBackground(new Background(new BackgroundFill(Color.rgb(231,202,215), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void droppedAt3Event(DragEvent dragEvent) {
        label3set = true;
        String person = dragEvent.getDragboard().getString();
        label3.setText(person);
        pane3.setBackground(new Background(new BackgroundFill(Color.rgb(231,202,215), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void droppedAt4Event(DragEvent dragEvent) {
        label4set = true;
        String person = dragEvent.getDragboard().getString();
        label4.setText(person);
        pane4.setBackground(new Background(new BackgroundFill(Color.rgb(231,202,215), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initLabels() throws SQLException {

        //Connection connection = database.DBConnection.getConnection();
        Statement statement = DBConnection.getConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT name, description FROM projekt_hiszpania_db.people ORDER BY RAND() LIMIT 4");
        while (result.next()) {
            people.add(result.getString(1));
            info.add(result.getString(2));
            people_map.put(result.getString(1), result.getString(2));
        }

        Collections.shuffle(people);
        Collections.shuffle(info);

        person1.setText(people.get(0));
        info1.setText(info.get(0));
        person2.setText(people.get(1));
        info2.setText(info.get(1));
        person3.setText(people.get(2));
        info3.setText(info.get(2));
        person4.setText(people.get(3));
        info4.setText(info.get(3));

}

    public void checkEvent(ActionEvent actionEvent) {

        if(label1set && label2set && label3set && label4set) {
            compare(label1, info1, pane1);
            compare(label2, info2, pane2);
            compare(label3, info3, pane3);
            compare(label4, info4, pane4);
        }

    }

    public void compare(Label label, Label info, StackPane pane){
            String chosenPerson = label.getText();
            String chosenInfo = info.getText();
            boolean pairFound = false;

            if (people_map.get(chosenPerson).equals(chosenInfo)) {
                pairFound=true;
                pane.setBackground(new Background(new BackgroundFill(Color.rgb(184,196,95), CornerRadii.EMPTY, Insets.EMPTY)));
            }

            if(!pairFound){
                pane.setBackground(new Background(new BackgroundFill(Color.rgb(228,134,102), CornerRadii.EMPTY, Insets.EMPTY)));
            }
    }

    public void allBackEvent(ActionEvent actionEvent) throws IOException {
        Parent homeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/chooseGroup.fxml")));
        Stage window = (Stage) allBackButton.getScene().getWindow();
        window.setScene(new Scene(homeRoot));
        window.getScene().setFill(Color.TRANSPARENT);
    }

    public void cultureBackEvent(ActionEvent actionEvent) throws IOException {
        Parent homeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/cultureGames.fxml")));
        Stage window = (Stage) cultureBackButton.getScene().getWindow();
        window.setScene(new Scene(homeRoot));
        window.getScene().setFill(Color.TRANSPARENT);
    }

    public void closeEvent(ActionEvent actionEvent) {
        Stage window = (Stage) closeButton.getScene().getWindow();
        window.close();
    }

}
