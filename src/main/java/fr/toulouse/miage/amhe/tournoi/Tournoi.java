/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.toulouse.miage.amhe.tournoi;

import fr.toulouse.miage.amhe.manche.Manche;
import fr.toulouse.miage.amhe.participant.Participant;

import java.util.ArrayList;

/**
 * Classe abstraite qui permet de représenter un tournoi
 *
 * @author Charles
 */

public abstract class Tournoi {

    public int getNbVainqueursNecessairesPool() {
        return nbVainqueursNecessairesPool;
    }

    /**
     * Donne le nombre de vainqueurs que l'on doit donner dans la pool
     */
    private int nbVainqueursNecessairesPool;
    protected ArrayList<Participant> listeParticipantGagnant;
    protected ArrayList<Participant> listeParticipantArentrer;
    protected ArrayList<Participant> listeParticipant;
    protected ArrayList<Manche> listeManche;
	private String nom;
    private int nbParticipant;
    protected String journal="";
    private String arme;

    /**
     *
     * @param nbParticipant
     * @param arme
     * @param nom
     */
    public Tournoi(int nbParticipant, String arme, String nom) {
    	this.nom=nom;
    	this.nbParticipant = nbParticipant;
        this.arme = arme;
        this.listeParticipant = new ArrayList<>(this.getNbParticipant());
        this.listeParticipantArentrer = new ArrayList<>(this.getNbParticipant());
        initialisationListe(nbParticipant);
        this.listeParticipantGagnant=new ArrayList<>(this.getNbParticipant());
    }

    /**
     * Permet d'initialiser la capacité de la liste des manches et le nombre de vainqueurs de la pool
     * selon le nombre de participants
     * @param nbParticipant
     */
    private void initialisationListe(int nbParticipant) {
        if ( nbParticipant < 16 && nbParticipant>=8) {
            this.listeManche = new ArrayList<>(7);
            this.nbVainqueursNecessairesPool=8;
        } else if (nbParticipant >= 16) {
            this.listeManche = new ArrayList<>(15);
            this.nbVainqueursNecessairesPool=16;
        } else if (nbParticipant < 8) {
            this.listeManche = new ArrayList<>(3);
            this.nbVainqueursNecessairesPool=4;
        }
    }
    public int getNbParticipant() {

        return this.nbParticipant;
    }

    public String getArme(){

        return arme;
    }

    public String toString(){

        return this.arme + this.nom;
    }
    public String getNom(){

        return this.nom;
    }

    /**
     * Permet de calculer le nombre de tour à effectuer ( donc chaque paquet de joueurs ayant gagné des manches)
     * @return
     */
    protected int calculTourAEffectuer(){
        int nbParticipant = this.getNbVainqueursNecessairesPool();
        int i = 1;
        while(i < 5){
            if(Math.pow(2, i) == nbParticipant){
                break;
            }
            i++;

        }
        return i;
    }

    /**
     *
     */
    public void clearJournal(){
        this.journal="";
    }
    public void ajouterMessage(String msg){
        this.journal=this.journal+msg;
    }
    public abstract void addParticipant(Participant p);

    public  void addManches(Manche m){
        this.listeManche.add(m);
    };


    public  void delManches(int index){
        this.listeManche.remove(index);
    };

    public ArrayList<Participant> getListeParticipant(){

        return this.listeParticipant;
    }

    public ArrayList<Participant> getListeParticipantGagnant(){

        return this.listeParticipantGagnant;
    }

    public ArrayList<Manche> getListeManche(){

        return this.listeManche;
    }

    public ArrayList<Participant> getListeParticipantArentrer() {
        return this.listeParticipantArentrer;
    }

    public abstract String jouerToutesLesManches();
}
