package fr.toulouse.miage.amhe;

import fr.toulouse.miage.amhe.manche.MancheEquipe;
import fr.toulouse.miage.amhe.manche.MancheJoueur;
import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.participant.Equipe;
import fr.toulouse.miage.amhe.tournoi.Solo;
import fr.toulouse.miage.amhe.tournoi.Tournoi;
import fr.toulouse.miage.amhe.tournoi.TournoiEquipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

import static fr.toulouse.miage.amhe.HelloController.tournoi;

public class ControllerRemplirTournoiSolo {

    private int choix;
    private  Tournoi tournoi;
    @FXML
    private Button retourRentrerParticipant;
    @FXML
    private TextField P1;
    @FXML
    private TextField P2;
    @FXML
    private TextField P3;
    @FXML
    private TextField P4;
    @FXML
    private Button remplirTournoi;

    public ControllerRemplirTournoiSolo(Tournoi tournoi){
        this.tournoi=tournoi;
        this.choix=0;
    }
    @FXML
    protected void remplirTournoi() throws Exception {
        if (!P1.getText().isEmpty() && !P2.getText().isEmpty() && !P3.getText().isEmpty() && !P4.getText().isEmpty()) {
            if (tournoi instanceof Solo) {
                tournoi.addParticipant(new Duelliste(P1.getText(), tournoi.getArme()));
                tournoi.addParticipant(new Duelliste(P2.getText(), tournoi.getArme()));
                tournoi.addParticipant(new Duelliste(P3.getText(), tournoi.getArme()));
                tournoi.addParticipant(new Duelliste(P4.getText(), tournoi.getArme()));
            }
        }
        if (tournoi.getListeParticipant().size() != tournoi.getNbParticipant()) {
            BoucleRentrerParticipant4();
        } else {
                goToLancementTournoi4();

            }
        }


    @FXML
    protected void BoucleRentrerParticipant4() throws Exception {
        ControllerRemplirTournoiSolo CRTS= new ControllerRemplirTournoiSolo(tournoi);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Rentrer_participants_4.fxml"));
        loader.setController(CRTS);
        Parent root = loader.load();
        Stage window = (Stage) remplirTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    protected void goToLancementTournoi4() throws Exception {
        ControllerLancement CL= new ControllerLancement(this.tournoi,this.choix);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("lancementTournoi.fxml"));
        loader.setController(CL);
        Parent root = loader.load();
        Stage window = (Stage) remplirTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }
    @FXML
    protected void returnToCreerTournoi() throws Exception {
        ControllerCreationTournoi CCT= new ControllerCreationTournoi(this.choix);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreerTournoi.fxml"));
        loader.setController(CCT);
        Parent root = loader.load();
        Stage window = (Stage) retourRentrerParticipant.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
        tournoi=null;
    }
}

