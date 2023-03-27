package fr.toulouse.miage.amhe;
import fr.toulouse.miage.amhe.tournoi.Solo;
import fr.toulouse.miage.amhe.tournoi.Tournoi;
import fr.toulouse.miage.amhe.tournoi.TournoiEquipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class HelloController {
    // Rentrer_Manches.fxml


    @FXML
    private Button charger;
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


    /** Fonction de choix type tournoi qui permet d'aller à une creation de tournoi solo
     * @throws Exception**/
    @FXML
    protected void Go_to_CreerTournoi_Solo() throws Exception {
        ControllerCreationTournoi CCT= new ControllerCreationTournoi(0);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreerTournoi.fxml"));
        loader.setController(CCT);
        Parent root = loader.load();
        Stage window = (Stage) creerTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));

    }

    /**
     * Permet de directement charger un tournoi qu'on a crée et donc de vouloir le remplir ( dans la page du choixdetypedetournoi )
     * @throws Exception
     */
    @FXML
    protected void charger_tournoi() throws Exception {
        Tournoi tournoi;
        int choix;
        FileChooser dialog = new FileChooser();
        dialog.setInitialDirectory(new File("src/main/java/fr/toulouse/miage/amhe/sauvegardeDebut"));
        File file = dialog.showOpenDialog(charger.getScene().getWindow());
        if (file != null) {
            charger.setText(file.getName());
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;
            String[] fields;
            line = br.readLine();
            //choix du type de tournoi
            if (line.equals("NbParticipants,Arme,Nom,0")) {
                choix=0;
                line = br.readLine();
                fields = line.split(",", -1);
                tournoi = new Solo(parseInt(fields[0]), fields[1], fields[2]);
            } else {
                line = br.readLine();
                fields = line.split(",", -1);
                tournoi = new TournoiEquipe(parseInt(fields[0]), fields[1], fields[2]);
                choix=1;
            }
            if(choix==0) {
                ControllerRemplirTournoiSolo CRTS= new ControllerRemplirTournoiSolo(tournoi);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Rentrer_participants_4.fxml"));
                loader.setController(CRTS);
                Parent root = loader.load();
                Stage window = (Stage) charger.getScene().getWindow();
                window.setScene(new Scene(root, 600, 400));
            }else{
                ControllerRemplirTournoiEquipe CRTE= new ControllerRemplirTournoiEquipe(tournoi);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Rentrer_participants_4_Equipe.fxml"));
                loader.setController(CRTE);
                Parent root = loader.load();
                Stage window = (Stage) charger.getScene().getWindow();
                window.setScene(new Scene(root, 600, 400));
            }

        }
    }

    /**
     * Fonction de choix type tournoi qui permet d'aller à une creation de tournoi equipe
     * @throws Exception
     */
    @FXML
    protected void Go_to_CreerTournoi_Equipe() throws Exception {
        ControllerCreationTournoi CCT= new ControllerCreationTournoi(1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreerTournoi.fxml"));
        loader.setController(CCT);
        Parent root = loader.load();
        Stage window = (Stage) Button_Equipe.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));

    }

    /**
     * Permet de retourner à l'accueil pour recommencer
     * @throws Exception
     */
    @FXML
    protected void RetourAccueilSolo() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage window = (Stage) retourAccueilSolo.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    /**
     * Fonction qui amène  à la page ChoixTypeTournoi
     * @throws Exception
     */
    @FXML
    protected void goToChoixTypeTournoi() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChoixTypeTournoi.fxml")));
        Stage window = (Stage) goSolo.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    /**
     * Permet d'aller dans la page Historique de l'application
     * @throws Exception
     */
    @FXML
    protected void goToHistorique() throws Exception {
        ControllerHistorique CH= new ControllerHistorique();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Historique.fxml"));
        loader.setController(CH);
        Parent root = loader.load();
        Stage window = (Stage) goHistorique.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }
}