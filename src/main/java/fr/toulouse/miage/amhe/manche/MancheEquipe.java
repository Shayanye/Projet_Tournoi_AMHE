package fr.toulouse.miage.amhe.manche;

import fr.toulouse.miage.amhe.participant.Equipe;

/**
 *
 */
public class MancheEquipe extends Manche {
    private final static MancheJoueur[] listeManche = new MancheJoueur[4];

    public MancheEquipe(Equipe equipe1, Equipe equipe2) {
        super(equipe1,equipe2);
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
    public Equipe jouerManche() {
        for (MancheJoueur manche : listeManche) {
            manche.jouerManche();
            this.score1 = this.score1 + manche.getScore1();
            this.score2 = this.score2 + manche.getScore2();
        }
        if (this.score1 > this.score2) {
            return (Equipe) this.p1;
        } else {
            return (Equipe) this.p2;
        }
    }

    public String toString() {

        return this.p1.getNom() + " VS " + this.p2.getNom() + ": ";
    }
}
