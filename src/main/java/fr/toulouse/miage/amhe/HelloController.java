package fr.toulouse.miage.amhe;
import fr.toulouse.miage.amhe.*;
import fr.toulouse.miage.amhe.participant.Duelliste;
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
    private Button remplirTournoi;
    @FXML
    private TextField P1;
    @FXML
    private TextField P2;
    @FXML
    private TextField P3;
    @FXML
    private TextField P4;


    @FXML
    private static Solo tournoi;
    @FXML
    private Button creerTournoi;

    @FXML
    private Button goSolo;
    @FXML
    private TextField ArmeTournoi;

    @FXML
    private TextField NomTournoi;
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
    private Button retourChoixTypeTournoi;
    @FXML
    private Button retourRentrerParticipant;

    @FXML
    private Button retourAccueilSolo;

    @FXML
    public void creation_tournoi_solo() throws Exception {
        int nb_part;

        if( (Group_nb.getSelectedToggle() != null) && (!this.ArmeTournoi.getText().isEmpty()) && (!this.NomTournoi.getText().isEmpty())){
            RadioButton button = (RadioButton) Group_nb.getSelectedToggle();
            nb_part = Integer.parseInt(button.getText());
            this.tournoi = new Solo(nb_part, NomTournoi.getText(), ArmeTournoi.getText());
            System.out.println(tournoi.toString());
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Rentrer_participants_4.fxml")));
            Stage window = (Stage) validerNbPartSolo.getScene().getWindow();
            window.setScene(new Scene(root, 750, 500));
        }

    }


    /* Remplis le tournoi et boucle sur la page d'insertion tant qu'on a pas tous les joueurs du tournoi et après on part sur le lancement */
    @FXML
    protected void remplirTournoi() throws Exception {
        if( !P1.getText().isEmpty() && !P1.getText().isEmpty() && !P1.getText().isEmpty() && !P1.getText().isEmpty()) {
            this.tournoi.addParticipant(new Duelliste(P1.getText(), this.tournoi.getArme()));
            this.tournoi.addParticipant(new Duelliste(P2.getText(), this.tournoi.getArme()));
            this.tournoi.addParticipant(new Duelliste(P3.getText(), this.tournoi.getArme()));
            this.tournoi.addParticipant(new Duelliste(P4.getText(), this.tournoi.getArme()));
        }
        if(tournoi.getListeDuelliste().size()!=tournoi.getNbParticipant()){
            BoucleRentrerParticipant4();
        }else{
            goToLancementTournoi4();
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
    protected void goToChoixTypeTournoi() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChoixTypeTournoi.fxml")));
        Stage window = (Stage) goSolo.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }
    @FXML
    protected void returnToCreerTournoi() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreerTournoi.fxml")));
        Stage window = (Stage) retourRentrerParticipant.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }
    /*@FXML
    protected void goToRentrerParticipant() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Rentrer_participants_16.fxml")));
        Stage window = (Stage) validerNbPartSolo.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }
     */


    @FXML
    protected void retourChoixTypeTournoi() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChoixTypeTournoi.fxml")));
        Stage window = (Stage) retourChoixTypeTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }
    @FXML
    protected void goToRentrerParticipant4() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Rentrer_participants_4.fxml")));
        Stage window = (Stage) validerNbPartSolo.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }
    @FXML
        protected void BoucleRentrerParticipant4() throws Exception {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Rentrer_participants_4.fxml")));
            Stage window = (Stage) remplirTournoi.getScene().getWindow();
            window.setScene(new Scene(root, 750, 500));
    }

    @FXML
    protected void goToRentrerParticipant8() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Rentrer_participants_8.fxml")));
        Stage window = (Stage) validerNbPartSolo.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }

    @FXML
    protected void goToLancementTournoi4() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("lancementTournoi.fxml")));
        Stage window = (Stage) remplirTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
        tournoi.AfficherDuellistes();
    }







}