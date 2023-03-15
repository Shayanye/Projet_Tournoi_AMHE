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
        FileChooser fileChooser = new FileChooser();final FileChooser dialog = new FileChooser();
        final File file = dialog.showSaveDialog(choix_du_tournoi.getScene().getWindow());
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
