package fr.toulouse.miage.amhe;

import fr.toulouse.miage.amhe.manche.MancheEquipe;
import fr.toulouse.miage.amhe.manche.MancheJoueur;
import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.participant.Equipe;
import fr.toulouse.miage.amhe.participant.Participant;
import fr.toulouse.miage.amhe.tournoi.Solo;
import fr.toulouse.miage.amhe.tournoi.Tournoi;
import fr.toulouse.miage.amhe.tournoi.TournoiEquipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class ControllerHistorique {

    @FXML
    private TextArea affichageresume;
    @FXML
    private Button goAffichageHistorique;
    private Tournoi tournoi;
    @FXML
    private Button choix_du_tournoi;
    /**
     *
     */
    @FXML
    private Button retourHistorique;

    /**
     * Fonction qui selon le fichier choisi, le transforme en tournoi, le rempli avec les informations puis affiche son résumé
     * @throws Exception
     */
    @FXML
    public void choisir_fichier() throws Exception {

        FileChooser dialog = new FileChooser();
        dialog.setInitialDirectory(new File("src/main/java/fr/toulouse/miage/amhe/sauvegarde"));
        File file = dialog.showOpenDialog(choix_du_tournoi.getScene().getWindow());
        if (file != null) {
            choix_du_tournoi.setText(file.getName());
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;
            String[] fields;
            line = br.readLine();
            //choix du type de tournoi
            if (line.equals("NbParticipants,Arme,Nom,0")) {
                line = br.readLine();
                fields = line.split(",", -1);
                this.tournoi = new Solo(parseInt(fields[0]), fields[1], fields[2]);
            } else {
                line = br.readLine();
                fields = line.split(",", -1);
                this.tournoi = new TournoiEquipe(parseInt(fields[0]), fields[1], fields[2]);
            }
            br.readLine();
            while (!((line = br.readLine()).equals("ListeManche"))) {
                if (this.tournoi instanceof Solo) {
                    this.tournoi.getListeParticipant().add(new Duelliste(line, this.tournoi.getArme()));
                } else if (this.tournoi instanceof TournoiEquipe) {
                    fields = line.split(",", -1);
                    this.tournoi.getListeParticipant().add(new Equipe(fields[0], this.tournoi.getArme(),
                            new Duelliste(fields[1], this.tournoi.getArme()),
                            new Duelliste(fields[2], this.tournoi.getArme()),
                            new Duelliste(fields[3], this.tournoi.getArme()),
                            new Duelliste(fields[4], this.tournoi.getArme())));
                }
            }
            while (!((line = br.readLine()).equals("resultatTournoi"))) {
                fields = line.split(",", -1);
                if (this.tournoi instanceof Solo) {
                    this.tournoi.getListeManche().add(new MancheJoueur((Duelliste) RecupererJoueurtournoi(fields[1]), (Duelliste) RecupererJoueurtournoi(fields[2])));
                } else if (this.tournoi instanceof TournoiEquipe) {
                    fields = line.split(",", -1);
                    this.tournoi.getListeManche().add(new MancheEquipe((Equipe) RecupererJoueurtournoi(fields[1]), (Equipe) RecupererJoueurtournoi(fields[2])));
                }
            }
            while ((line = br.readLine()) != null) {
                this.tournoi.ajouterMessage(line+"\n");
            }
        }
        affichageresume.setText(this.tournoi.toString());
    }


    /**
     * Permet de récupérer le joueur du tournoi avec un nom passé en paramètre
     * @param nom
     * @return
     */
    private Participant RecupererJoueurtournoi(String nom){
        for(Participant p : this.tournoi.getListeParticipant()){

            if(p.getNom().equals(nom)){
                return p;
            }
        }
        return null;
    }

    /**
     * Fonction qui permet de retourner à l'accueil
     * @throws Exception
     */
    @FXML
    protected void RetourAccueil() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage window = (Stage) retourHistorique.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }
}
