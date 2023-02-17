/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.toulouse.miage.amhe.tournoi;
/**
 * Classe abstraite qui permet de représenter un tournoi
 *
 * @author Charles
 */

public abstract class Tournoi {

	private String nom;
    private int nbParticipant;

    private String arme;
    
    public Tournoi(int nbParticipant, String arme, String nom) {
    	this.nom=nom;
    	this.nbParticipant = nbParticipant;
        this.arme = arme;
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

    
}
