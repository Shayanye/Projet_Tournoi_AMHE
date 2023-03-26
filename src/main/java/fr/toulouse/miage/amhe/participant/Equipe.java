package fr.toulouse.miage.amhe.participant;

import java.util.ArrayList;

public class Equipe extends Participant {
    private static final int nombre = 4;
    private final ArrayList<Duelliste> Equipe = new ArrayList<>();

    public Equipe(String nom, String arme, Duelliste d1, Duelliste d2, Duelliste d3, Duelliste d4) {
        super(nom,arme);
        this.ajouterMembre(d1);
        this.ajouterMembre(d2);
        this.ajouterMembre(d3);
        this.ajouterMembre(d4);

    }

    public ArrayList<Duelliste> getEquipe() {
        return this.Equipe;
    }

    /**
     * @param d
     */
    public void ajouterMembre(Duelliste d) {

        Equipe.add(d);
    }
}
