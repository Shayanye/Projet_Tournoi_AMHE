package fr.toulouse.miage.amhe.participant;

public class Participant {

    protected String nom;

    protected String arme;

    public Participant(String nom,String arme){
        this.nom=nom;
        this.arme=arme;
    }

    protected String getNom(){
        return this.nom;
    }

    protected String getArme(){
        return this.arme;
    }
}
