package fr.toulouse.miage.amhe.tournoi;

import java.util.ArrayList;

import fr.toulouse.miage.amhe.participant.Duelliste;
/**
 * Classe qui permert des créer des tournois solo
 * @author charles
 *
 */
public class Solo extends Tournoi{

	//private Manche[] manches;
	//private Duelliste duellistes;
	private ArrayList<Duelliste> duellistes;
	private ArrayList<Manche> manches;
	
	
	/**
	 * Constructeur de tournoi solo
	 */
	public Solo(int nbParticipant, String arme) throws  Exception{
		super(nbParticipant, arme);
		//this.duellistes = new Duelliste(this.getNbParticipant());
		//il me faut un constructeur de Duelliste qui prend en paramètre un int (nbParticipant) et qui me créer un tableau de duelliste de cette taille.
		this.duellistes = new ArrayList<>(this.getNbParticipant());
		this.manches = new ArrayList<>(this.getNbParticipant() / 2);
		
		
	}
	
}
