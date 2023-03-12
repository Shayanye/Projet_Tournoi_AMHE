package fr.toulouse.miage.amhe;
import fr.toulouse.miage.amhe.historique.Historique;
import fr.toulouse.miage.amhe.manche.Manche;
import fr.toulouse.miage.amhe.manche.MancheEquipe;
import fr.toulouse.miage.amhe.manche.MancheJoueur;
import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.participant.Equipe;
import fr.toulouse.miage.amhe.participant.Participant;
import fr.toulouse.miage.amhe.tournoi.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    // Rentrer_Manches.fxml
    @FXML
    private ComboBox<String> MG = new ComboBox();

    @FXML
    private Button remplirTournoi;

    @FXML
    private Button creerTournoi;

    @FXML
    private Button goSolo;

    @FXML
    private Button Button_Equipe;

    @FXML
    private Button retourAccueilSolo;


    @FXML
    private Button goHistorique;

    @FXML
    private Button retourHistorique;
    @FXML
    private Button goAffichageHistorique;
    @FXML
    private Button retourAffichageHistorique;
    @FXML
    private Button retour_Accueil_Lancement_Historique;
    @FXML
    private TextArea console_historique = new TextArea();

    @FXML
    private static Historique historique = new Historique();

    @FXML
    private ComboBox<String> comboBoxHistorique= new ComboBox();

    @FXML
    private Button afficherHistorique;

    private static String combobox_value;






    @FXML
    protected void Go_to_CreerTournoi_Solo() throws Exception {
        ControllerCreationTournoi CCT= new ControllerCreationTournoi(0);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreerTournoi.fxml"));
        loader.setController(CCT);
        Parent root = loader.load();
        Stage window = (Stage) creerTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));

    }
    @FXML
    protected void Go_to_CreerTournoi_Equipe() throws Exception {
        ControllerCreationTournoi CCT= new ControllerCreationTournoi(1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreerTournoi.fxml"));
        loader.setController(CCT);
        Parent root = loader.load();
        Stage window = (Stage) Button_Equipe.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));

    }

    @FXML
    protected void RetourAccueilSolo() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage window = (Stage) retourAccueilSolo.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    protected void goToChoixTypeTournoi() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChoixTypeTournoi.fxml")));
        Stage window = (Stage) goSolo.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }




    @FXML
        protected void BoucleRentrerParticipant4() throws Exception {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Rentrer_participants_4.fxml")));
            Stage window = (Stage) remplirTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }







    @FXML
    protected void goToHistorique() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Historique.fxml")));
        Stage window = (Stage) goHistorique.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    protected void RetourAccueil() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage window = (Stage) retourHistorique.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }
    @FXML
    protected void RetourHistorique() throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Historique.fxml")));
        Stage window = (Stage) retourAffichageHistorique.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    protected void RetourAccueilHistorique() throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage window = (Stage)  retour_Accueil_Lancement_Historique.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    protected void goToAffichageHistorique() throws Exception {
        combobox_value = this.comboBoxHistorique.getValue();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AffichageHistorique.fxml")));
        Stage window = (Stage) goAffichageHistorique.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    protected void remplirComboBox() throws Exception {
        for(Tournoi t : historique.getHistoriqueDeTousLesTournois()){
                this.comboBoxHistorique.getItems().add(t.getNom());
        }


    }

    @FXML
    protected void afficherHistorique() throws Exception{
        for (Tournoi t: this.historique.getHistoriqueDeTousLesTournois()){
            if (t.getNom()==this.combobox_value){
                console_historique.setText("Historique du tournoi: ");
                console_historique.appendText(t.toString());
            }
        }
    }
}