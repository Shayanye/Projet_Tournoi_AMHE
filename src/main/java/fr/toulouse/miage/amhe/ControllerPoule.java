package fr.toulouse.miage.amhe;

import fr.toulouse.miage.amhe.participant.Participant;
import fr.toulouse.miage.amhe.tournoi.Tournoi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerPoule implements Initializable {
    @FXML
    private Button retourPoule;
    @FXML
    private Button validerPoule;
    @FXML
    private ComboBox<String> GP1;
    @FXML
    private ComboBox<String> GP2;
    @FXML
    private ComboBox<String> GP3;
    @FXML
    private ComboBox<String> GP4;
    @FXML
    private Text textPoule;
    private ArrayList<Participant> vainqueurs = new ArrayList<>();
    private int choix;
    private Tournoi tournoi;

    public ControllerPoule(Tournoi tournoi, int choix) {
        this.tournoi = tournoi;
        this.choix = choix;
    }

    public ControllerPoule(Tournoi tournoi, int choix, ArrayList<Participant> vainqueurs) {
        this.tournoi = tournoi;
        this.choix = choix;
        this.vainqueurs = vainqueurs;
    }

    private void remplirComboBox(ComboBox combo) {
        for (Participant p : this.tournoi.getListeParticipantArentrer()) {
            combo.getItems().add(p.getNom());
        }
    }

    @FXML
    public void verifierComboGP1() {
        if (GP1.getItems().contains(GP2.getValue())) {
            GP1.getItems().remove(GP2.getValue());
        }
        if (GP1.getItems().contains(GP3.getValue())) {
            GP1.getItems().remove(GP3.getValue());
        }
        if (GP1.getItems().contains(GP4.getValue())) {
            GP1.getItems().remove(GP4.getValue());
        }
    }

    @FXML
    public void verifierComboGP2() {
        if (GP2.getItems().contains(GP1.getValue())) {
            GP2.getItems().remove(GP1.getValue());
        }
        if (GP2.getItems().contains(GP3.getValue())) {
            GP2.getItems().remove(GP3.getValue());
        }
        if (GP2.getItems().contains(GP4.getValue())) {
            GP2.getItems().remove(GP4.getValue());
        }
    }

    @FXML
    public void verifierComboGP3() {
        if (GP3.getItems().contains(GP1.getValue())) {
            GP3.getItems().remove(GP1.getValue());
        }
        if (GP3.getItems().contains(GP2.getValue())) {
            GP3.getItems().remove(GP2.getValue());
        }
        if (GP3.getItems().contains(GP4.getValue())) {
            GP3.getItems().remove(GP4.getValue());
        }
    }

    @FXML
    public void verifierComboGP4() {
        if (GP4.getItems().contains(GP1.getValue())) {
            GP4.getItems().remove(GP1.getValue());
        }
        if (GP4.getItems().contains(GP3.getValue())) {
            GP4.getItems().remove(GP3.getValue());
        }
        if (GP4.getItems().contains(GP2.getValue())) {
            GP4.getItems().remove(GP2.getValue());
        }
    }

    @FXML
    public void validerlesJoueursChoisis() throws IOException {
        if (!(GP1.getValue() == null) && !(GP1.getValue() == null) && !(GP1.getValue() == null) && !(GP1.getValue() == null)) {
            this.vainqueurs.add(RecupererJoueurtournoi(GP1.getValue()));
            this.vainqueurs.add(RecupererJoueurtournoi(GP2.getValue()));
            this.vainqueurs.add(RecupererJoueurtournoi(GP3.getValue()));
            this.vainqueurs.add(RecupererJoueurtournoi(GP4.getValue()));
            this.tournoi.getListeParticipantArentrer().remove(RecupererJoueurtournoi(GP1.getValue()));
            this.tournoi.getListeParticipantArentrer().remove(RecupererJoueurtournoi(GP2.getValue()));
            this.tournoi.getListeParticipantArentrer().remove(RecupererJoueurtournoi(GP3.getValue()));
            this.tournoi.getListeParticipantArentrer().remove(RecupererJoueurtournoi(GP4.getValue()));
            if (this.vainqueurs.size() ==this.tournoi.getNbVainqueursNecessairesPool()) {
                this.tournoi.getListeParticipantArentrer().clear();
                for (Participant p : this.vainqueurs) {
                    this.tournoi.getListeParticipantArentrer().add(p);
                }
                for (Participant p : this.vainqueurs) {
                    this.tournoi.ajouterMessage("Le participant " + p.getNom() + " est sorti vainqueur de la pool \n");
                }
                ControllerLancement CL = new ControllerLancement(this.tournoi, choix);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("lancementTournoi.fxml"));
                loader.setController(CL);
                Parent root = loader.load();
                Stage window = (Stage) validerPoule.getScene().getWindow();
                window.setScene(new Scene(root, 600, 400));
            } else {
                BouclerPoule();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champs incomplets");
            alert.setHeaderText("Veuillez saisir tous les champs");
            alert.setContentText("Veuillez sélectionner un participant dans chaque champ");
            alert.showAndWait();
        }
    }


    @FXML
    private void BouclerPoule() throws IOException {
        ControllerPoule CP= new ControllerPoule(this.tournoi,this.choix, this.vainqueurs);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GestionPoule.fxml"));
        loader.setController(CP);
        Parent root = loader.load();
        Stage window = (Stage) validerPoule.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));

    }
    @FXML

    private void retourLancement() throws IOException {
        ControllerLancement CL = new ControllerLancement(this.tournoi, choix);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("lancementTournoi.fxml"));
        loader.setController(CL);
        Parent root = loader.load();
        Stage window = (Stage) retourPoule.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }
    private Participant RecupererJoueurtournoi(String nom){
        for(Participant p : this.tournoi.getListeParticipant()){
            if(p.getNom()==nom){
                return p;
            }
        }
        return null;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.textPoule.setText("Choisissez les"+
                (this.tournoi.getNbVainqueursNecessairesPool())
                +"joueurs qui vont continuer le tournoi");
        remplirComboBox(GP1);
        remplirComboBox(GP2);
        remplirComboBox(GP3);
        remplirComboBox(GP4);
    }
}
