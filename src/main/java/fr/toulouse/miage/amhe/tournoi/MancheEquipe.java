/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.toulouse.miage.amhe.tournoi;
import fr.toulouse.miage.amhe.participant.Equipe;
import fr.toulouse.miage.amhe.participant.Participant;
/**
 *
 * @author valen
 */
public class MancheEquipe extends Manche {
    private final Equipe equipe1;
    private final Equipe equipe2;

    public MancheEquipe(Equipe equipe1, Equipe equipe2){
        this.equipe1=equipe1;
        this.equipe2=equipe2;
    }

    /** Détermine le gagnant de la manche
     * @return participant1*/


    @Override
    public Participant jouerManche() {
        return this.equipe1;
    }
}
