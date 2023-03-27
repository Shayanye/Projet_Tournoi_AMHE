package fr.toulouse.miage.amhe.participant;

/**
 *
 */
public abstract class Participant {

    protected String nom;

    protected String arme;

    /**
     * Constructeur de la classe abstraite
     * @param nom
     * @param arme
     */
    public Participant(String nom,String arme){
        this.nom=nom;
        this.arme=arme;
    }

    public String getNom(){
        return this.nom;
    }

    protected String getArme(){
        return this.arme;
    }
}
