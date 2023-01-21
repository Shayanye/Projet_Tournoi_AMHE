/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.toulouse.miage.amhe.tournoi;

import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.participant.Participant;

/**
 * @author valen
 */
public class MancheJoueur extends Manche {
    private Duelliste premier;
    private Duelliste deuxieme;

    public MancheJoueur(Duelliste duelliste1, Duelliste duelliste2) {
        if (duelliste1.getRapidité() > duelliste2.getRapidité()) {
            this.premier = duelliste1;
            this.deuxieme = duelliste2;
        } else {
            this.premier = duelliste2;
            this.deuxieme = duelliste1;
        }
    }


    @Override
    public Participant jouerManche() {
        while (score1 < 15 & score2 < 15) {
            this.score1 = this.score1 + premier.attaquer();
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