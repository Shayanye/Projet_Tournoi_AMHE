package fr.toulouse.miage.amhe;
import fr.toulouse.miage.amhe.historique.Historique;
import fr.toulouse.miage.amhe.manche.Manche;
import fr.toulouse.miage.amhe.manche.MancheEquipe;
import fr.toulouse.miage.amhe.manche.MancheJoueur;
import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.participant.Equipe;
import fr.toulouse.miage.amhe.participant.Participant;
import fr.toulouse.miage.amhe.tournoi.*;
import fr.toulouse.miage.amhe.tournoi.Tournoi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerManche implements  Initializable{


     @FXML private Button retourRentrerManche;
     private Tournoi tournoi;
     private static int choix;

     private static int nombre_actuel=1;
    @FXML
    private ComboBox<String> MG = new ComboBox<>();

    @FXML
    private ComboBox<String> MP1 = new ComboBox<>();

    @FXML
    private  ComboBox<String> MP2 = new ComboBox<>();

    @FXML
    private  Text numManche;

    @FXML
    private  Label manchecb;
    @FXML
    private Button remplirtournoiGestion;


    public ControllerManche(Tournoi tournoi, int choix){
        ControllerManche.this.tournoi =tournoi;
        ControllerManche.choix =choix;
    }

    @FXML
    public void remplirtournoiGestion() throws IOException {
        if(!(MP2.getValue()==null) & !(MP1.getValue()==null) & !(MG.getValue()==null)) {
            if (choix == 0) {
                this.tournoi.addManches(new MancheJoueur((Duelliste) RecupererJoueurtournoi(MP1.getValue()), (Duelliste) RecupererJoueurtournoi(MP2.getValue())));
            } else {
                this.tournoi.addManches(new MancheEquipe((Equipe) RecupererJoueurtournoi(MP1.getValue()), (Equipe) RecupererJoueurtournoi(MP2.getValue())));
            }
            if(!this.tournoi.getListeParticipantGagnant().contains(RecupererJoueurtournoi(MG.getValue()))) {
                this.tournoi.getListeParticipantGagnant().add(RecupererJoueurtournoi(MG.getValue()));
            }
            String perdant=recupererPerdant();
            if(this.tournoi.getListeParticipantGagnant().contains(RecupererJoueurtournoi(perdant))){
                this.tournoi.getListeParticipantGagnant().remove(RecupererJoueurtournoi(perdant));
            }
            this.tournoi.getListeParticipantArentrer().remove(RecupererJoueurtournoi(MP1.getValue()));
            this.tournoi.getListeParticipantArentrer().remove(RecupererJoueurtournoi(MP2.getValue()));
            nombre_actuel = nombre_actuel + 1;
            ControllerManche cm= new ControllerManche(this.tournoi,choix);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Rentrer_manches_4.fxml"));
            loader.setController(cm);
            Parent root = loader.load();
            Stage window = (Stage) remplirtournoiGestion.getScene().getWindow();
            window.setScene(new Scene(root, 600, 400));
        }
    }

    private String recupererPerdant(){
        if(Objects.equals(MG.getValue(), MP1.getValue())){
            this.tournoi.ajouterMessage("le joueur "+RecupererJoueurtournoi(MP1.getValue()).getNom()+" a gagné contre le joueur "+RecupererJoueurtournoi(MP2.getValue()).getNom()+" lors de la manche "+ nombre_actuel+"\n");
            return MP2.getValue();
        }else{
            this.tournoi.ajouterMessage("le joueur "+RecupererJoueurtournoi(MP2.getValue()).getNom()+" a gagné contre le joueur "+RecupererJoueurtournoi(MP1.getValue()).getNom()+" lors de la manche "+ nombre_actuel+"\n");
            return MP1.getValue();
        }
    }
    public void verificationMP1() {
        if (!(MP1.getValue()==null) && !(MP2.getValue()==null )) {
            MP1.getItems().remove(MP2.getValue());
        }
    }


    public void verificationMP2(){
        if(!(MP1.getValue()==null) && !(MP1.getValue()==null)){
            MP2.getItems().remove(MP1.getValue());
        }
    }


    private Participant RecupererJoueurtournoi(String nom){
        for(Participant p : this.tournoi.getListeParticipant()){
            if(p.getNom()==nom){
                return p;
            }
        }
        return null;
    }

    private void remplirParticipantArentrer(){
        for(Participant p : this.tournoi.getListeParticipantGagnant()) {
            this.tournoi.getListeParticipantArentrer().add(p);
        }
        if(this.tournoi.getListeParticipantArentrer().size()==1){
            remplirtournoiGestion.setDisable(true);
        }
    }

    @FXML
    public void choisirGagnant(){
        if(!(MP2.getValue()==null) && !(MP1.getValue()==null)){
            MG.getItems().add(MP2.getValue());
            MG.getItems().add(MP1.getValue());

        }
    }


    // LA METHODE TROP BIEN, qui permet d'initialiser les trucs dès l'arrivée sur une page ! Donc de changer les label text sans cliquer sur un bouton
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        manchecb.setText("Manche "+ nombre_actuel+" sur "+(this.tournoi.getNbParticipant()-1));
        numManche.setText("M"+nombre_actuel);
        if(this.tournoi.getListeParticipantArentrer().size()==0 && this.tournoi.getListeManche().size()!=this.tournoi.getNbParticipant()-1) {
            remplirParticipantArentrer();
        }else if(this.tournoi.getListeManche().size()==this.tournoi.getNbParticipant()-1){
            this.tournoi.ajouterMessage("Le gagnant du tournoi "+ this.tournoi.getNom()+ " est "+ this.tournoi.getListeParticipantGagnant().get(0).getNom());
        }
        for(Participant p : this.tournoi.getListeParticipantArentrer()) {
            MP1.getItems().add(p.getNom());
            MP2.getItems().add(p.getNom());
        }
    }

    public void retourLancementtournoi() throws IOException {
        ControllerLancement CL= new ControllerLancement(this.tournoi,choix);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("lancementTournoi.fxml"));
        loader.setController(CL);
        Parent root = loader.load();
        Stage window = (Stage) retourRentrerManche.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }
}
