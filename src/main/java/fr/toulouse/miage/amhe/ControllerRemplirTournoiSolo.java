package fr.toulouse.miage.amhe;

import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.tournoi.Solo;
import fr.toulouse.miage.amhe.tournoi.Tournoi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class ControllerRemplirTournoiSolo implements Initializable {


    private int choix;
    private Tournoi tournoi;
    @FXML
    private Text nbParticipants;
    @FXML
    private Text labelPart1;
    @FXML
    private Text labelPart4;
    @FXML
    private Text labelPart2;
    @FXML
    private Text labelPart3;


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

    /**
     * Crée un controller de la page Rentrer_Participant_4 et qui prend en paramètre le tournoi et son type
     **/
    public ControllerRemplirTournoiSolo(Tournoi tournoi) {
        this.tournoi = tournoi;
        this.choix = 0;
    }

    /**
     * permet de remplir le tournoi quand les 4 champs sont remplis
     **/
    @FXML
    protected void remplirTournoi() throws Exception {
        if (!P1.getText().isEmpty() && !P2.getText().isEmpty() && !P3.getText().isEmpty() && !P4.getText().isEmpty()) {
            if (tournoi instanceof Solo) {
                tournoi.addParticipant(new Duelliste(P1.getText(), tournoi.getArme()));
                tournoi.addParticipant(new Duelliste(P2.getText(), tournoi.getArme()));
                tournoi.addParticipant(new Duelliste(P3.getText(), tournoi.getArme()));
                tournoi.addParticipant(new Duelliste(P4.getText(), tournoi.getArme()));
            }
            if (tournoi.getListeParticipant().size() != tournoi.getNbParticipant()) {
                BoucleRentrerParticipant4();
            } else {
                goToLancementTournoi4();

            }
        }else

        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setContentText("Un ou plusieurs champs de participants ne sont pas remplis");
            alert.showAndWait();
        }
    }


        /** Fonction qui permet de revenir sur la page pour rentrer 4 nouveaux participants**/
    @FXML
    protected void BoucleRentrerParticipant4() throws Exception {
        ControllerRemplirTournoiSolo CRTS= new ControllerRemplirTournoiSolo(tournoi);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Rentrer_participants_4.fxml"));
        loader.setController(CRTS);
        Parent root = loader.load();
        Stage window = (Stage) remplirTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    /** Fonction qui permet d'aller dans la page du lancement de tournoi et de le gérer**/
    @FXML
    protected void goToLancementTournoi4() throws Exception {
        ControllerLancement CL= new ControllerLancement(this.tournoi,this.choix);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("lancementTournoi.fxml"));
        loader.setController(CL);
        Parent root = loader.load();
        Stage window = (Stage) remplirTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }
    /** Fonction qui permet de revenir sur la page pour créer le tournoi**/
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelPart1.setText(String.valueOf(this.tournoi.getListeParticipant().size()+1));
        labelPart2.setText(String.valueOf(this.tournoi.getListeParticipant().size()+2));
        labelPart3.setText(String.valueOf(this.tournoi.getListeParticipant().size()+3));
        labelPart4.setText(String.valueOf(this.tournoi.getListeParticipant().size()+4));
        nbParticipants.setText("Nombre de participants rentrés : " + this.tournoi.getListeParticipant().size()+", restant : "+(this.tournoi.getNbParticipant()-this.tournoi.getListeParticipant().size()));
    }
}

