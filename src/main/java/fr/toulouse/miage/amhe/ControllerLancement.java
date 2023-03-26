package fr.toulouse.miage.amhe;

import fr.toulouse.miage.amhe.tournoi.Tournoi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private TextArea console_lancement;
    private int choix;
    private Tournoi tournoi;


    /** Crée un Controller pour la page Lancement.tournoi qui prend en paramètre un tournoi et le choix du type de tournoi**/
    public ControllerLancement(Tournoi tournoi, int choix){
        this.choix = choix;
        this.tournoi=tournoi;
    }

    /** Fonction qui permet de créer un Controller de la page Simulation et de se diriger vers cette dernière
     * @throws Exception*/
    public void GotoSimulation() throws Exception {
        //je crée le controller de la page sur laquelle je vais aller
        ControllerSimulation CS = new ControllerSimulation(this.tournoi, this.choix);
        //on "load" la page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageSimulation.fxml"));
        //on lui donne le controler précédemment crée
        loader.setController(CS);
        // et là on change de page
        Parent root = loader.load();
        Stage window = (Stage) lancer_tournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    /** Fonction qui permet d'allez vers la page pour rentrer les manches du tournoi**/
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



    /**Fonction qui se lance dès l'arrivée sur la page, permettant d'afficher le résumé du tournoi**/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        console_lancement.clear();
        console_lancement.setText("Bienvenue dans le tournoi AMHE : "+this.tournoi.getNom()+"\n");
        console_lancement.appendText(this.tournoi.toString());
        }


    /** Fonction qui permet de retourner à l'accueil de l'application**/
    @FXML
    protected void retour_Accueil_Lancement() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage window = (Stage) retourAccueilLancement.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }


/** fonction qui permet de retourner  à la création du tournoi**/
    @FXML
    protected void retour_lancement_tournoi() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreerTournoi.fxml"));
        ControllerCreationTournoi CCT=new ControllerCreationTournoi(this.choix);
        loader.setController(CCT);
        Parent root = loader.load();
        Stage window = (Stage) retourRentrer_participants.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

}
