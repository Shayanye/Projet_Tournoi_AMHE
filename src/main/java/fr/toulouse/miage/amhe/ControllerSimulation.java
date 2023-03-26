package fr.toulouse.miage.amhe;

import fr.toulouse.miage.amhe.manche.MancheEquipe;
import fr.toulouse.miage.amhe.manche.MancheJoueur;
import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.participant.Equipe;
import fr.toulouse.miage.amhe.participant.Participant;
import fr.toulouse.miage.amhe.tournoi.Solo;
import fr.toulouse.miage.amhe.tournoi.Tournoi;
import fr.toulouse.miage.amhe.tournoi.TournoiEquipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSimulation implements Initializable{

    @FXML
    private TextArea affichageSimulation=new TextArea();

    @FXML
    private Button retourLancementTournoi;

    @FXML
    private Button lancerSimulation;

    private Tournoi tournoisimulation;
    private Tournoi tournoi;
    private int choix;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        affichageSimulation.setText("Bienvenue dans une simulation du tournoi AMHE");
        try {
            simulation_tournoi();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /** Crée un réplicat du tournoi pour pouvoir l'utiliser en tant que simulation
     * @param tournoi
     * @param choix
     * @throws Exception**/
    public ControllerSimulation(Tournoi tournoi,int choix) throws Exception {
        this.tournoi=tournoi;
        this.choix=choix;
        if(choix==0) {
            this.tournoisimulation = new Solo(this.tournoi.getNbParticipant(),this.tournoi.getArme(),this.tournoi.getNom());
        }else{
            this.tournoisimulation = new TournoiEquipe(this.tournoi.getNbParticipant(),this.tournoi.getArme(),this.tournoi.getNom());
        }
        for(int i=0 ; i<this.tournoi.getNbVainqueursNecessairesPool();i++){
            this.tournoisimulation.getListeParticipant().add(this.tournoi.getListeParticipant().get(i));
        }
    }

    /** permet de revenir au lancement de tournoi et de gérer**/
    @FXML
    protected void returnToLancementTournoi() throws Exception {
        this.tournoi.clearJournal();
        this.tournoi.getListeManche().clear();
        ControllerLancement CL= new ControllerLancement(this.tournoi,this.choix);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("lancementTournoi.fxml"));
        loader.setController(CL);
        Parent root = loader.load();
        Stage window = (Stage) retourLancementTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    /** Permet de relancer une simulation du tournoi**/
    @FXML
    protected void relancer_tournoi_simulation() throws Exception {
        simulation_tournoi();
       ControllerSimulation CS= new ControllerSimulation(this.tournoi,this.choix);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageSimulation.fxml"));
        loader.setController(CS);
        Parent root = loader.load();
        Stage window = (Stage) lancerSimulation.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    /** nettoie les manches de la simulation**/
    @FXML
    protected void simulation_tournoi()throws Exception{
        this.tournoisimulation.getListeManche().clear();
        remplirTournoiSimulation();
        affichageSimulation.appendText(this.tournoisimulation.jouerToutesLesManches());
        this.tournoisimulation.clearJournal();
    }

    /** rempli le tournoi de simulation**/
    private void remplirTournoiSimulation() {
        int participant = 0;
        if (this.choix == 0) {
            while (participant <  this.tournoisimulation.getNbParticipant() - 1) {
                this.tournoisimulation.getListeManche().add(new MancheJoueur((Duelliste)  this.tournoisimulation.getListeParticipant().get(participant), (Duelliste)  this.tournoisimulation.getListeParticipant().get(participant + 1)));
                participant=participant+2;
            }
        } else {
            while (participant <  this.tournoisimulation.getNbParticipant() - 1) {
                this.tournoisimulation.getListeManche().add(new MancheEquipe((Equipe) this.tournoisimulation.getListeParticipant().get(participant), (Equipe)  this.tournoisimulation.getListeParticipant().get(participant + 1)));
                participant=participant+2;
            }
        }
    }


}
