package fr.toulouse.miage.amhe.tournoi;

import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.participant.Equipe;

import java.util.ArrayList;

public class TournoiEquipe  extends Tournoi {

    private ArrayList<Equipe> equipes;
    private ArrayList<MancheEquipe> manches;
    private String journal;



    /**
     * Constructeur de tournoi solo
     */
    public TournoiEquipe(int nbParticipant, String arme, String nom)  throws  Exception{
        super(nbParticipant, arme, nom);
        //this.duellistes = new Duelliste(this.getNbParticipant());
        //il me faut un constructeur de Duelliste qui prend en paramètre un int (nbParticipant) et qui me créer un tableau de duelliste de cette taille.
        this.equipes = new ArrayList<>(this.getNbParticipant());
        this.manches = new ArrayList<>(this.getNbParticipant()-1);
        this.journal = "";


    }
    public void addParticipant(Equipe e){
        if(this.equipes.size() < this.getNbParticipant()) {
            this.equipes.add(e);
        }
    }
    public void addManches(MancheEquipe m ){

        this.manches.add(m);
    }

    public void delManches(int i){

        this.manches.remove(i);
    }



    public ArrayList<Equipe> getListeDuelliste(){

        return this.equipes;
    }

    public ArrayList<MancheEquipe> getListeManches(){

        return this.manches;
    }

    public String toString(){

        return this.journal;
    }
}
