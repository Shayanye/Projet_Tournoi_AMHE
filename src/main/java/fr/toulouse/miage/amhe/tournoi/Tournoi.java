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

    protected ArrayList<Participant> listeParticipantGagnant;
    protected ArrayList<Participant> listeParticipantArentrer;
    protected ArrayList<Participant> listeParticipant;
    protected ArrayList<Manche> listeManche;
	private String nom;
    private int nbParticipant;
    protected String journal="";
    private String arme;
    
    public Tournoi(int nbParticipant, String arme, String nom) {
    	this.nom=nom;
    	this.nbParticipant = nbParticipant;
        this.arme = arme;
        this.listeParticipant = new ArrayList<>(this.getNbParticipant());
        this.listeManche = new ArrayList<>(this.getNbParticipant()-1);
        this.listeParticipantGagnant=new ArrayList<>(this.getNbParticipant()-1);
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

    protected int calculTourAEffectuer(){
        int nbParticipant = this.getNbParticipant();
        int i = 1;
        while(i < 5){
            if(Math.pow(2, i) == nbParticipant){
                break;
            }
            i++;

        }
        return i;
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
