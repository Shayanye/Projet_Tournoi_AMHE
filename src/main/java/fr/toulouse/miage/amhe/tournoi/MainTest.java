package fr.toulouse.miage.amhe.tournoi;

import fr.toulouse.miage.amhe.participant.Duelliste;

public class MainTest {
    public static void main(String args[]) throws Exception {
        //Creation du tournoi
        Solo tournoiSolo;
        try {
            tournoiSolo = new Solo(4, "Dague", "tournoiTest");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //creation des 4 duellistes
        Duelliste d1 = new Duelliste("Charles", "Dague");
        Duelliste d2 = new Duelliste("Valentin", "Dague");
        Duelliste d3 = new Duelliste("Khalif", "Dague");
        Duelliste d4 = new Duelliste("Naps", "Dague");

        //ajout des 4 participants
        tournoiSolo.addParticipant(d1);
        tournoiSolo.addParticipant(d2);
        tournoiSolo.addParticipant(d3);
        tournoiSolo.addParticipant(d4);

        //initialisation des manches
        MancheJoueur mj1 = new MancheJoueur(d1, d2);
        MancheJoueur mj2 = new MancheJoueur(d3, d4);
        MancheJoueur mj3 = new MancheJoueur(mj1.jouerManche(), mj2.jouerManche());

        //ajout des manches
       // tournoiSolo.addManches(mj1);
       // tournoiSolo.addManches(mj2);

        //jouer manches
        //mj3.jouerManche();

    }
}
