package fr.toulouse.miage.amhe.test;

import fr.toulouse.miage.amhe.manche.MancheJoueur;
import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.tournoi.Solo;

public class MainTest {
    public static void main(String[] args) throws Exception {
        //Creation du tournoi
        Solo tournoiSolo;
        try {
            tournoiSolo = new Solo(16, "Dague", "tournoiTest");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //creation des 4 duellistes
        Duelliste d1 = new Duelliste("Charles", "Dague");
        Duelliste d2 = new Duelliste("Valentin", "Dague");
        Duelliste d3 = new Duelliste("Khalif", "Dague");
        Duelliste d4 = new Duelliste("Naps", "Dague");

        Duelliste d5 = new Duelliste("Estelle", "Dague");
        Duelliste d6 = new Duelliste("Gros Babe", "Dague");
        Duelliste d7 = new Duelliste("Mathilde", "Dague");
        Duelliste d8 = new Duelliste("Iaro", "Dague");

        Duelliste d9 = new Duelliste("Pierre", "Dague");
        Duelliste d10 = new Duelliste("Paul", "Dague");
        Duelliste d11 = new Duelliste("Guillaume", "Dague");
        Duelliste d12= new Duelliste("Nicolas", "Dague");

        Duelliste d13 = new Duelliste("Marvin", "Dague");
        Duelliste d14 = new Duelliste("Sylvain", "Dague");
        Duelliste d15 = new Duelliste("Tsito", "Dague");
        Duelliste d16 = new Duelliste("Lilian", "Dague");

        //ajout des 4 participants
        tournoiSolo.addParticipant(d1);
        tournoiSolo.addParticipant(d2);
        tournoiSolo.addParticipant(d3);
        tournoiSolo.addParticipant(d4);
        tournoiSolo.addParticipant(d5);
        tournoiSolo.addParticipant(d6);
        tournoiSolo.addParticipant(d7);
        tournoiSolo.addParticipant(d8);
        tournoiSolo.addParticipant(d9);
        tournoiSolo.addParticipant(d10);
        tournoiSolo.addParticipant(d11);
        tournoiSolo.addParticipant(d12);
        tournoiSolo.addParticipant(d13);
        tournoiSolo.addParticipant(d14);
        tournoiSolo.addParticipant(d15);
        tournoiSolo.addParticipant(d16);

        tournoiSolo.addManches(new MancheJoueur(d1, d2));
        tournoiSolo.addManches(new MancheJoueur(d3, d4));

        tournoiSolo.addManches(new MancheJoueur(d5, d6));
        tournoiSolo.addManches(new MancheJoueur(d7, d8));

        tournoiSolo.addManches(new MancheJoueur(d9, d10));
        tournoiSolo.addManches(new MancheJoueur(d11, d12));
        tournoiSolo.addManches(new MancheJoueur(d13,d14));
        tournoiSolo.addManches(new MancheJoueur(d15, d16));


        //test methode jouerManches
        /*System.out.println(tournoiSolo.toString());
        System.out.println(tournoiSolo.jouerToutesLesManches());
        System.out.println(tournoiSolo.toString());*/

// Expected output: 42



        //initialisation des manches
        /*MancheJoueur mj1 = new MancheJoueur(d1, d2);
        MancheJoueur mj2 = new MancheJoueur(d3, d4);
        MancheJoueur mj3 = new MancheJoueur(mj1.jouerManche(), mj2.jouerManche());*/

        //ajout des manches
       // tournoiSolo.addManches(mj1);
       // tournoiSolo.addManches(mj2);

        //jouer manches
        //mj3.jouerManche();

    }
}
