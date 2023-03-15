package fr.toulouse.miage.amhe;

import fr.toulouse.miage.amhe.tournoi.Tournoi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

public class ControllerHistorique {

    @FXML
    private Button goAffichageHistorique;
    private Tournoi tournoi;
    @FXML
    private Button choix_du_tournoi;
    @FXML
    private Button retourHistorique;

    @FXML
    public void choisir_fichier() {

        FileChooser dialog = new FileChooser();
        dialog.setInitialDirectory(new File("src/main/java/fr/toulouse/miage/amhe/sauvegarde"));
        final File file = dialog.showOpenDialog(choix_du_tournoi.getScene().getWindow());
        if(file!=null){
            System.out.println("Hello");

        }
    }

    @FXML
    protected void RetourAccueil() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage window = (Stage) retourHistorique.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    protected void goToAffichageHistorique() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AffichageHistorique.fxml")));
        Stage window = (Stage) goAffichageHistorique.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }
}
