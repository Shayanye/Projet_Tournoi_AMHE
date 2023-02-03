package fr.toulouse.miage.amhe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloController {


    @FXML
    private Button creerTournoi;
    @FXML
    private RadioButton nb_16;
    @FXML
    private RadioButton nb_8;
    @FXML
    private RadioButton nb_4;
    @FXML
    ObservableList<Integer> list
            = FXCollections.observableArrayList(8, 16, 4);
    @FXML
    private ComboBox<Integer> nb_participants = new ComboBox<>(list);


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void CreerTournoi() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreerTournoi.fxml")));
        Stage window = (Stage) creerTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }

    @FXML
    protected void RetourAccueilSolo() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage window = (Stage) retourAccueilSolo.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }
    @FXML
    private Button validerNbPartSolo;

    @FXML
    private Button retourAccueilSolo;

}