/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.toulouse.miage.amhe.tournoi;
import fr.toulouse.miage.amhe.arme.Arme;
/**
 * Classe abstraite qui permet de représenter un tournoi
 *
 * @author Charles
 */

public abstract class Tournoi {

    private String arme;
    private int nbParticipant;
    
    public Tournoi(int nbParticipant, String arme) throws Exception{
    	try {
    		if(nbParticipant % 2 != 0) {
        		Exception e = new Exception("Le nombre de participant n'est pas une puissance de 2");
        		throw e;
        	}
        }
    	catch (Exception e){
    		System.out.println(e);
    	}
    	
    	
    	
    	
    	this.nbParticipant = nbParticipant;
    	this.arme = arme;
    }
     
    
    public int getNbParticipant() {
    	return this.nbParticipant;
    }
    
}
