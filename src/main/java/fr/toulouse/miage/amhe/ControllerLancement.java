package fr.toulouse.miage.amhe;

import fr.toulouse.miage.amhe.historique.Historique;
import fr.toulouse.miage.amhe.manche.MancheEquipe;
import fr.toulouse.miage.amhe.manche.MancheJoueur;
import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.participant.Equipe;
import fr.toulouse.miage.amhe.tournoi.Tournoi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerLancement implements Initializable {

    @FXML
    private Button gérerTournoi;
    @FXML
    private Button retourRentrer_participants;
   @FXML
    private Button retourAccueilLancement;
    @FXML
    private Button lancer_tournoi;
    @FXML
    private ComboBox<String> comboBoxHistorique= new ComboBox();
    @FXML
    private  Historique historique = new Historique();
    @FXML
    private TextArea console_lancement;
    private Tournoi  tournoi_doublon_simulation;
    private int choix;
    private Tournoi tournoi;

    public ControllerLancement(Tournoi tournoi, int choix){
        this.choix = choix;
        this.tournoi=tournoi;
    }


    // Exemple qui permet d'aller sur une autre page tout en lui donnant le tournoi qu'on a crée précédemment
    public void GoToRentrerManche() throws IOException {
        //je crée le controller de la page sur laquelle je vais aller
        ControllerManche cm = new ControllerManche(this.tournoi, choix);
        //on "load" la page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Rentrer_manches_4.fxml"));
        //on lui donne le controler précédemment crée
        loader.setController(cm);
        // et là on change de page
        Parent root = loader.load();
        Stage window = (Stage) gérerTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }
    private void remplirTournoiSimulation(Tournoi tournoisimu) {
        tournoisimu.getListeManche().clear();
        int participant = 0;
        if (this.choix == 0) {
            while (participant < tournoisimu.getNbParticipant() - 1) {
                tournoisimu.getListeManche().add(new MancheJoueur((Duelliste) tournoisimu.getListeParticipant().get(participant), (Duelliste) tournoisimu.getListeParticipant().get(participant + 1)));
                participant=participant+2;
            }
        } else {
            while (participant < tournoisimu.getNbParticipant() - 1) {
                tournoisimu.getListeManche().add(new MancheEquipe((Equipe) tournoisimu.getListeParticipant().get(participant), (Equipe) tournoisimu.getListeParticipant().get(participant + 1)));
                participant=participant+2;
            }
        }
    }

    // A modifier car quand je clique sur simulation et que je gère le tournoi... J'ai un problème pour la dernière manche
    @FXML
    protected void simulation_tournoi()throws Exception{
        console_lancement.appendText("Bienvenue dans une simulation du tournoi AMHE : "+this.tournoi.getNom()+"\n");
        //this.tournoi_doublon_simulation=this.tournoi;
        //remplirTournoiSimulation(tournoi_doublon_simulation);
        //console_lancement.appendText(tournoi_doublon_simulation.jouerToutesLesManches());
        //this.comboBoxHistorique.getItems().add(this.tournoi.getNom());
        lancer_tournoi.setDisable(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        console_lancement.clear();
        console_lancement.setText("Bienvenue dans le tournoi AMHE : "+this.tournoi.getNom()+"\n");
        console_lancement.appendText(this.tournoi.toString());
        if(this.tournoi.getListeManche().size()==this.tournoi.getNbParticipant()-1){
            this.historique.ajouterTournoi(this.tournoi);
        }
    }

    @FXML
    protected void retour_Accueil_Lancement() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage window = (Stage) retourAccueilLancement.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    protected void retour_lancement_tournoi() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreerTournoi.fxml")));
        Stage window = (Stage) retourRentrer_participants.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

}
