/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.toulouse.miage.amhe.tournoi;

import fr.toulouse.miage.amhe.participant.Equipe;
import fr.toulouse.miage.amhe.participant.Participant;

/**
 * @author valen
 */
public class MancheEquipe extends Manche {
    private final static MancheJoueur[] listeManche = new MancheJoueur[4];
    private final Equipe equipe1;
    private final Equipe equipe2;

    public MancheEquipe(Equipe equipe1, Equipe equipe2) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        for (int i = 0; i < 4; i++) {
            listeManche[i] = new MancheJoueur(equipe1.getEquipe().get(i), equipe2.getEquipe().get(i));
        }
    }

    /**
     * Détermine le gagnant de la manche
     *
     * @return participant1
     */


    @Override
    public Participant jouerManche() {
        for (MancheJoueur manche : listeManche) {
            manche.jouerManche();
            this.score1 = this.score1 + manche.getScore1();
            this.score2 = this.score2 + manche.getScore2();
        }
        if (this.score1 > this.score2) {
            return this.equipe1;
        } else {
            return this.equipe2;
        }
    }
}
