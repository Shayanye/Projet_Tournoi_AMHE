package fr.toulouse.miage.amhe;

import fr.toulouse.miage.amhe.tournoi.Solo;
import fr.toulouse.miage.amhe.tournoi.Tournoi;
import fr.toulouse.miage.amhe.tournoi.TournoiEquipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Objects;


public class ControllerCreationTournoi {

    private int choix;
    private String[] armes={"Epée","EpéeLongue","EpéeBocle","Rapière","RapièreDague"};
    @FXML
    private ComboBox<String> choiceArme=new ComboBox<>();
    @FXML
    private TextField Nbparticipant;
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

    /** Crée un controller avec le choix du type de tournoi passé en paramètre
     *
     *
     * @param choix*/
    public ControllerCreationTournoi(int choix){

        this.choix=choix;
    }

    /** Fonction qui crée un tournoi selon le type choisi, représenté par le choix passé en paramètre du constructeur
     *
     * */
    public void creation_tournoi() throws Exception {
        int nb_part;
        if(Nbparticipant.getText().isEmpty() || NomTournoi.getText().isEmpty() || choiceArme.getValue()==null ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Un champ a été oublié");
            alert.setHeaderText("Un champ n'a pas été rempli");
            alert.setContentText("Veuillez remplir tous les champs");
            alert.showAndWait();
            //permet de vérifier si la chaine de caractère est bien un int
        } else if (!Nbparticipant.getText().matches("-?\\d+")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Nombre invalide");
            alert.setHeaderText("Veuillez ne rentrer que des chiffres");
            alert.setContentText("Veuillez choisir un nombre valide de participants");
            alert.showAndWait();
        } else {
            if ((!Nbparticipant.getText().isEmpty()) && (!this.choiceArme.isShowing()) && (!this.NomTournoi.getText().isEmpty())) {
                nb_part = Integer.parseInt(Nbparticipant.getText());
                if (choix == 0) {
                    // On créer un tournoi solo et on se dirige vers la page pour rentrer des Duellistes
                    this.tournoi = new Solo(nb_part, choiceArme.getValue(), NomTournoi.getText());
                    System.out.println(this.tournoi.getArme());
                    CréerTournoiCSV file = new CréerTournoiCSV(this.tournoi, this.choix);
                    file.CreerFile();
                    ControllerRemplirTournoiSolo CRTS = new ControllerRemplirTournoiSolo(tournoi);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Rentrer_participants_4.fxml"));
                    loader.setController(CRTS);
                    Parent root = loader.load();
                    Stage window = (Stage) validerNbPart.getScene().getWindow();
                    window.setScene(new Scene(root, 600, 400));
                } else if (choix == 1) {
                    // On créer un tournoi Equipe et on se dirige vers la page pour rentrer des Equipes
                    this.tournoi = new TournoiEquipe(nb_part, choiceArme.getValue(), NomTournoi.getText());
                    CréerTournoiCSV file = new CréerTournoiCSV(this.tournoi, this.choix);
                    file.CreerFile();
                    ControllerRemplirTournoiEquipe CRTE = new ControllerRemplirTournoiEquipe(tournoi);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Rentrer_participants_4_Equipe.fxml"));
                    loader.setController(CRTE);
                    Parent root = loader.load();
                    Stage window = (Stage) validerNbPart.getScene().getWindow();
                    window.setScene(new Scene(root, 600, 400));
                }
            }
        }
    }


    private void choisir_arme() {
        if (choiceArme.getItems().isEmpty()) {
            for (int i = 0; i < armes.length; i++) {
                choiceArme.getItems().add(armes[i]);
            }
        }
    }
    /** Fonction qui permet de retour à la page du choix de type de tournoi
     * @throws Exception*/
    @FXML
    protected void retourChoixTypeTournoi() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChoixTypeTournoi.fxml")));
        Stage window = (Stage) retourChoixTypeTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

}
