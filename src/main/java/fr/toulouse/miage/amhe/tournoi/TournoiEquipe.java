package fr.toulouse.miage.amhe.tournoi;

import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.participant.Equipe;
import fr.toulouse.miage.amhe.participant.Participant;

import java.util.ArrayList;

public class TournoiEquipe  extends Tournoi {

    private String journal;



    /**
     * Constructeur de tournoi solo
     */
    public TournoiEquipe(int nbParticipant, String arme, String nom)  throws  Exception{
        super(nbParticipant, arme, nom);
        //this.duellistes = new Duelliste(this.getNbParticipant());
        //il me faut un constructeur de Duelliste qui prend en paramètre un int (nbParticipant) et qui me créer un tableau de duelliste de cette taille.
        this.journal = "";


    }

    @Override
    public void addParticipant(Participant e){
        if(this.listeParticipant.size() < this.getNbParticipant() && e instanceof Equipe) {
            this.listeParticipant.add((Equipe) e);
        }
    }

    @Override
    public String jouerToutesLesManches() {
        ArrayList<Equipe> gagnants = new ArrayList<>();
        int tour_a_effectuer = this.calculTourAEffectuer();
        int tour = 1;
        int nbManches = 0;

        for (int i = 0; i < tour_a_effectuer; i++) {
            nbManches = this.listeManche.size();
            this.journal += "\n\nTour " + tour + "\n";
            tour++;
            for (int j = 0; j < nbManches; j++) {
                this.journal += this.listeManche.get(j).toString();
                Equipe joueurGagnant = (Equipe) this.listeManche.get(j).jouerManche();
                gagnants.add(joueurGagnant);
                this.journal += "l'équipe " + joueurGagnant.getNom() + " a gagné sur un score de : " + this.listeManche.get(j).getScore1() + " a " + this.listeManche.get(j).getScore2() + "\n";


            }

            int tailleGagnants = gagnants.size();
            for (int g = 0; g < tailleGagnants / 2; g++) {
                this.addManches(new MancheEquipe(gagnants.get(0), gagnants.get(1)));
                this.delManches(0);
                this.delManches(0);
                gagnants.remove(0);
                gagnants.remove(0);

            }

        }
        this.journal += "\n\n\nL'équipe gagnante du tournoi : " +this.getNom()+ " est " +gagnants.get(0).getNom();

        return this.journal;
    }

    public String toString(){

        return this.journal;
    }


}
