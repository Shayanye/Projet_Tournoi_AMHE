package fr.toulouse.miage.amhe;

import fr.toulouse.miage.amhe.manche.MancheEquipe;
import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.participant.Equipe;
import fr.toulouse.miage.amhe.tournoi.Tournoi;
import fr.toulouse.miage.amhe.tournoi.TournoiEquipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerRemplirTournoiEquipe implements Initializable {

    @FXML
    private Tournoi tournoi;
    private int choix;
    @FXML
    private Button remplirTournoiEquipe;

    @FXML
    private Button retourRentrerParticipant;
    @FXML
    private TextField nomEquipe;
    @FXML
    private TextField P1;
    @FXML
    private TextField P2;
    @FXML
    private TextField P3;
    @FXML
    private TextField P4;
    @FXML
    private Text numEquipe;

    public ControllerRemplirTournoiEquipe(Tournoi tournoi){
        this.tournoi=tournoi;
        this.choix=1;
    }
    @FXML
    protected void remplirTournoi() throws Exception {
        if (tournoi instanceof TournoiEquipe && !nomEquipe.getText().isEmpty()) {
            tournoi.addParticipant(new Equipe(nomEquipe.getText(), tournoi.getArme(),
                    new Duelliste(P1.getText(), tournoi.getArme()),
                    new Duelliste(P2.getText(), tournoi.getArme()),
                    new Duelliste(P3.getText(), tournoi.getArme()),
                    new Duelliste(P4.getText(), tournoi.getArme())));
        }
        if (tournoi.getListeParticipant().size() != tournoi.getNbParticipant()) {
            BoucleRentrerParticipant4Equipe();
        } else {
            goToLancementTournoi4();
        }
    }

    @FXML
    protected void BoucleRentrerParticipant4Equipe() throws Exception {
        ControllerRemplirTournoiEquipe CRTE= new ControllerRemplirTournoiEquipe(tournoi);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Rentrer_participants_4_Equipe.fxml"));
        loader.setController(CRTE);
        Parent root = loader.load();
        Stage window = (Stage) remplirTournoiEquipe.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    protected void goToLancementTournoi4() throws Exception {
        ControllerLancement CL= new ControllerLancement(this.tournoi,this.choix);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("lancementTournoi.fxml"));
        loader.setController(CL);
        Parent root = loader.load();
        Stage window = (Stage) remplirTournoiEquipe.getScene().getWindow();
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
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       numEquipe.setText("Rentrez l'équipe n°"+this.tournoi.getListeParticipant().size()+1+" et ses 4 participants");
    }
}