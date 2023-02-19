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
        return null;
    }

    public void addManches(MancheEquipe m ){

        this.listeManche.add(m);
    }

    public void delManches(int i){

        this.listeManche.remove(i);
    }



    public ArrayList<Participant> getListeDuelliste(){

        return this.listeParticipant;
    }

    public ArrayList<Manche> getListeManches(){

        return this.listeManche;
    }

    public String toString(){

        return this.journal;
    }


}
