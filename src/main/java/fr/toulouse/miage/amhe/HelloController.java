package fr.toulouse.miage.amhe;

import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.participant.Equipe;
import fr.toulouse.miage.amhe.tournoi.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloController {

    @FXML
    private Button remplirTournoi;
    @FXML
    private Button remplirTournoiEquipe;
    @FXML
    private TextField P1;
    @FXML
    private TextField P2;
    @FXML
    private TextField P3;
    @FXML
    private TextField P4;

    @FXML
    private TextField nomEquipe;
    private static int choix;
    @FXML
    private static Tournoi tournoi;
    @FXML
    private Button creerTournoi;

    @FXML
    private Button goSolo;

    @FXML
    private Button Button_Equipe;
    @FXML
    private TextField ArmeTournoi;

    @FXML
    private TextField NomTournoi;
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
    private Button retourRentrerParticipant;

    @FXML
    private Button retourAccueilSolo;

    @FXML
    private Button lancer_tournoi;

    @FXML
    private Button retourRentrer_participants_4;

    @FXML
    private RadioButton radioButton_selectionne;

    @FXML
    private  TextArea console_lancement = new TextArea();

    @FXML
    private Button retourRentrer_participants;

    @FXML
    private Button retourAccueilLancement;

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
    private ComboBox<String> comboBoxHistorique= new ComboBox<>();




    public void creation_tournoi() throws Exception {
        int nb_part;

        if( (Group_nb.getSelectedToggle() != null) && (!this.ArmeTournoi.getText().isEmpty()) && (!this.NomTournoi.getText().isEmpty())){
            RadioButton button = (RadioButton) Group_nb.getSelectedToggle();
            nb_part = Integer.parseInt(button.getText());
            if(choix==0) {
                this.tournoi = new Solo(nb_part, ArmeTournoi.getText(), NomTournoi.getText());
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Rentrer_participants_4.fxml")));
                Stage window = (Stage) validerNbPart.getScene().getWindow();
                window.setScene(new Scene(root, 600, 400));
            }else if (choix==1){
                this.tournoi = new TournoiEquipe(nb_part, ArmeTournoi.getText(), NomTournoi.getText());
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Rentrer_participants_4_Equipe.fxml")));
                Stage window = (Stage) validerNbPart.getScene().getWindow();
                window.setScene(new Scene(root, 600, 400));
            }
        }

    }


    /* Remplis le tournoi et boucle sur la page d'insertion tant qu'on a pas tous les joueurs du tournoi et après on part sur le lancement */
    @FXML
    protected void remplirTournoi() throws Exception {
        if( !P1.getText().isEmpty() && !P1.getText().isEmpty() && !P1.getText().isEmpty() && !P1.getText().isEmpty()) {
            if(tournoi instanceof Solo) {
                this.tournoi.addParticipant(new Duelliste(P1.getText(), this.tournoi.getArme()));
                this.tournoi.addParticipant(new Duelliste(P2.getText(), this.tournoi.getArme()));
                this.tournoi.addParticipant(new Duelliste(P3.getText(), this.tournoi.getArme()));
                this.tournoi.addParticipant(new Duelliste(P4.getText(), this.tournoi.getArme()));
            }else if (tournoi instanceof  TournoiEquipe && !nomEquipe.getText().isEmpty()){
                this.tournoi.addParticipant(new Equipe(nomEquipe.getText(), tournoi.getArme(),
                                new Duelliste(P1.getText(), this.tournoi.getArme()),
                                new Duelliste(P2.getText(), this.tournoi.getArme()),
                                new Duelliste(P3.getText(), this.tournoi.getArme()),
                                new Duelliste(P4.getText(), this.tournoi.getArme())));
            }
        }
        if(tournoi.getListeParticipant().size()!=tournoi.getNbParticipant()){
            if(choix==0) {
                BoucleRentrerParticipant4();
            }else if(choix==1){
                BoucleRentrerParticipant4Equipe();
            }
        }else{
            if(choix==0) {
                int i = 0;
                while (i < tournoi.getNbParticipant()) {
                    tournoi.getListeManche().add(new MancheJoueur((Duelliste) tournoi.getListeParticipant().get(i), (Duelliste) tournoi.getListeParticipant().get(i + 1)));
                    i = i + 2;
                }
                goToLancementTournoi4();
            }else if(choix==1){
                int i = 0;
                while (i < tournoi.getNbParticipant()) {
                    tournoi.getListeManche().add(new MancheEquipe((Equipe) tournoi.getListeParticipant().get(i), (Equipe) tournoi.getListeParticipant().get(i + 1)));
                    i = i + 2;
                }
                goToLancementTournoi4();
            }
        }

    }
    @FXML
    protected void Go_to_CreerTournoi_Solo() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreerTournoi.fxml")));
        Stage window = (Stage) creerTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
        choix = 0;

    }
    @FXML
    protected void Go_to_CreerTournoi_Equipe() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreerTournoi.fxml")));
        Stage window = (Stage) Button_Equipe.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
        choix = 1;

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
    protected void returnToCreerTournoi() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreerTournoi.fxml")));
        Stage window = (Stage) retourRentrerParticipant.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
        this.tournoi=null;
    }



    @FXML
    protected void retourChoixTypeTournoi() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChoixTypeTournoi.fxml")));
        Stage window = (Stage) retourChoixTypeTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }
    @FXML
        protected void BoucleRentrerParticipant4() throws Exception {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Rentrer_participants_4.fxml")));
            Stage window = (Stage) remplirTournoi.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    protected void BoucleRentrerParticipant4Equipe() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Rentrer_participants_4_Equipe.fxml")));
        Stage window = (Stage) remplirTournoiEquipe.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }



    @FXML
    protected void goToLancementTournoi4() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("lancementTournoi.fxml")));
        if(choix==0) {
            Stage window = (Stage) remplirTournoi.getScene().getWindow();
            window.setScene(new Scene(root, 600, 400));
        }else{
            Stage window = (Stage) remplirTournoiEquipe.getScene().getWindow();
            window.setScene(new Scene(root, 600, 400));
        }
    }


    @FXML
    protected void Retour_lancement_tournoi() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreerTournoi.fxml")));
        Stage window = (Stage) retourRentrer_participants.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }
    @FXML
    protected void Retour_Accueil_Lancement() throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage window = (Stage) retourAccueilLancement.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    protected void Affichage_tournoi()throws Exception{
        console_lancement.setText("Bienvenue dans le tournoi AMHE : "+this.tournoi.getNom()+"\n");
        console_lancement.appendText(this.tournoi.jouerToutesLesManches());
        this.historique.ajouterTournoi(this.tournoi);
        this.comboBoxHistorique.getItems().add(this.tournoi.getNom());
        lancer_tournoi.setDisable(true);
    }
    /*@FXML
    protected void Acces_Ancien_Tournoi(Historique historique) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage window = (Stage) .getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }*/
    @FXML
    protected void Affichage_Console_Historique() throws Exception{
        console_historique.setText(this.historique.toString());

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
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AffichageHistorique.fxml")));
        Stage window = (Stage) goAffichageHistorique.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    protected void remplirComboBox() throws Exception {
        for(Tournoi t : historiqueTournoi.getHistoriqueDeTousLesTournois()){
            this.comboBoxHistorique.getItems().add(this.tournoi.getNom());
        }
    }

    @FXML
    protected void recupValComboBox() throws Exception {
        System.out.println(this.comboBoxHistorique.getValue());
    }


}