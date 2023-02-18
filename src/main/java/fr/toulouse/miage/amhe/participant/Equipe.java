package fr.toulouse.miage.amhe.participant;

import java.util.ArrayList;

public class Equipe extends Participant {
    private static final int nombre = 4;
    private final ArrayList<Duelliste> Equipe = new ArrayList<>();

    public Equipe(String nom, String arme) {
        super(nom,arme);

    }

    public ArrayList<Duelliste> getEquipe() {
        return this.Equipe;
    }

    public void ajouterMembre(String nom, String arme) {
        Equipe.add(new Duelliste(nom, arme));
    }
}
