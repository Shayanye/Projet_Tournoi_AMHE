package fr.toulouse.miage.amhe;

import fr.toulouse.miage.amhe.ControllerRemplirTournoiEquipe;
import fr.toulouse.miage.amhe.ControllerRemplirTournoiSolo;
import fr.toulouse.miage.amhe.tournoi.Solo;
import fr.toulouse.miage.amhe.tournoi.Tournoi;
import fr.toulouse.miage.amhe.tournoi.TournoiEquipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.util.Objects;

public class ControllerCreationTournoi {
    private int choix;
    @FXML
    private ToggleGroup Group_nb=new ToggleGroup();
    @FXML
    private RadioButton nb_16=new RadioButton("16");

    @FXML
    private RadioButton nb_8=new RadioButton("8");
    @FXML
    private RadioButton nb_4=new RadioButton("4");
    @FXML
    private Button validerNbPart;
    @FXML
    private Button retourChoixTypeTournoi;

    @FXML
    private TextField ArmeTournoi;

    @FXML
    private TextField NomTournoi;
    @FXML
    private Tournoi tournoi;

    /** Crée un controller avec le choix du type de tournoi passé en paramètre **/
    public ControllerCreationTournoi(int choix){

        this.choix=choix;
    }

    /** Fonction qui crée un tournoi selon le type choisi, représenté par le choix passé en paramètre du constructeur**/
    public void creation_tournoi() throws Exception {
        int nb_part;
        if( (Group_nb.getSelectedToggle() != null) && (!this.ArmeTournoi.getText().isEmpty()) && (!this.NomTournoi.getText().isEmpty())){
            RadioButton button = (RadioButton) Group_nb.getSelectedToggle();
            nb_part = Integer.parseInt(button.getText());
            if(choix==0) {
                // On créer un tournoi solo et on se dirige vers la page pour rentrer des Duellistes
                this.tournoi = new Solo(nb_part, ArmeTournoi.getText(), NomTournoi.getText());
                CréerTournoiCSV file=new CréerTournoiCSV(this.tournoi,this.choix);
                file.CreerFile();
                ControllerRemplirTournoiSolo CRTS= new ControllerRemplirTournoiSolo(tournoi);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Rentrer_participants_4.fxml"));
                loader.setController(CRTS);
                Parent root = loader.load();
                Stage window = (Stage) validerNbPart.getScene().getWindow();
                window.setScene(new Scene(root, 600, 400));
            }else if (choix==1){
                // On créer un tournoi Equipe et on se dirige vers la page pour rentrer des Equipes
                this.tournoi = new TournoiEquipe(nb_part, ArmeTournoi.getText(), NomTournoi.getText());
                CréerTournoiCSV file=new CréerTournoiCSV(this.tournoi,this.choix);
                file.CreerFile();
                ControllerRemplirTournoiEquipe CRTE= new ControllerRemplirTournoiEquipe(tournoi);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Rentrer_participants_4_Equipe.fxml"));
                loader.setController(CRTE);
                Parent root = loader.load();
                Stage window = (Stage) validerNbPart.getScene().getWindow();
                window.setScene(new Scene(root, 600, 400));
            }
        }

    }

    /** Fonction qui permet de retour à la page du choix de type de tournoi**/
    @FXML
    protected void retourChoixTypeTournoi() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChoixTypeTournoi.fxml")));
        Stage window = (Stage) retourChoixTypeTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

}
