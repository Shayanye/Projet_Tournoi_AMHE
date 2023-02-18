package fr.toulouse.miage.amhe.tournoi;

import java.util.ArrayList;

public class Historique {
    private Tournoi tournoi;
    private ArrayList<Tournoi> historiqueDeTousLesTournois = new ArrayList<>();

    public Historique(Tournoi tournoi){

        this.tournoi = tournoi;
        this.historiqueDeTousLesTournois.add(tournoi);
    }

    public String toString(){
        return this.tournoi.toString();
    }
}
