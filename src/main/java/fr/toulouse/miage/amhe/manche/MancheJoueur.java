/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.toulouse.miage.amhe.manche;

import fr.toulouse.miage.amhe.participant.Duelliste;

/**
 * @author valen
 */
public class MancheJoueur extends Manche {
    private Duelliste premier;
    private Duelliste deuxieme;

    /**
     * Manche entre les deux duellistes et détermine le gagnant (celui qui dépasse 15 points)
     * @param duelliste1
     * @param duelliste2
     */
    public MancheJoueur(Duelliste duelliste1, Duelliste duelliste2) {
        super(duelliste1,duelliste2);
        if (duelliste1.getRapidité() > duelliste2.getRapidité()) {
            this.premier = duelliste1;
            this.deuxieme = duelliste2;
        } else {
            this.premier = duelliste2;
            this.deuxieme = duelliste1;
        }
    }

    public String toString() {

        return this.premier.getNom() + " VS " + this.deuxieme.getNom() + ": ";
    }


    /**
     * Détermine le gagnant de la manche
     *
     * @return participant1
     */
    @Override
    public Duelliste jouerManche() {
        while (this.score1 < 15 & this.score2 < 15) {
            this.score1 = this.score1 + premier.attaquer();
            if(this.score1 >= 15){
                return premier;
            }
            this.score2 = this.score2 + deuxieme.attaquer();
        }
        if (score1 > 15) {
            return premier;
        } else {
            return deuxieme;
        }
    }

    public int getScore1() {

        return this.score1;
    }

    public int getScore2() {

        return this.score2;
    }
}
