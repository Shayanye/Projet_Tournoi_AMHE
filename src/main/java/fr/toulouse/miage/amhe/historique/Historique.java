package fr.toulouse.miage.amhe.historique;

import fr.toulouse.miage.amhe.tournoi.Tournoi;

import java.util.ArrayList;

public class Historique {
    private Tournoi tournoi;
    private ArrayList<Tournoi> historiqueDeTousLesTournois = new ArrayList<>();


    public void ajouterTournoi(Tournoi tournoi){
        this.historiqueDeTousLesTournois.add(tournoi);
    }
    public ArrayList<Tournoi> getHistoriqueDeTousLesTournois() {
        return historiqueDeTousLesTournois;
    }

    public String toString(){
        return this.tournoi.toString();
    }
}
