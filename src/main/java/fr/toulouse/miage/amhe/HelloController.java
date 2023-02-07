package fr.toulouse.miage.amhe;
import fr.toulouse.miage.amhe.*;
import fr.toulouse.miage.amhe.tournoi.Solo;
import fr.toulouse.miage.amhe.tournoi.Tournoi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;


public class HelloController {


    @FXML
    private Button creerTournoi;

    @FXML
    private ToggleGroup Group_nb=new ToggleGroup();
    @FXML
    private RadioButton nb_16=new RadioButton("16");

    @FXML
    private RadioButton nb_8=new RadioButton("8");
    @FXML
    private RadioButton nb_4=new RadioButton("4");
    @FXML
    private Button validerNbPartSolo;
    @FXML
    private Button retourRentrerParticipant;

    @FXML
    private Button retourAccueilSolo;

    public void creation_tournoi(){
        int nb_part;
        if(Group_nb.getSelectedToggle()!=null){
            RadioButton button = (RadioButton) Group_nb.getSelectedToggle();

        }
    }




    @FXML
    protected void Go_to_CreerTournoi() throws Exception {
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
    protected void returnToCreerTournoi() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreerTournoi.fxml")));
        Stage window = (Stage) retourRentrerParticipant.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }
    @FXML
    protected void goToRentrerParticipant() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Rentrer_participants.fxml")));
        Stage window = (Stage) validerNbPartSolo.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }

    @FXML
    protected void goToRentrerParticipant4() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rentrer_participants_4.fxml")));
        Stage window = (Stage) validerNbPartSolo.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }

    @FXML
    protected void goToRentrerParticipant8() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rentrer_participants_8.fxml")));
        Stage window = (Stage) validerNbPartSolo.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }









}