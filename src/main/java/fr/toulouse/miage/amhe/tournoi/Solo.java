package fr.toulouse.miage.amhe.tournoi;

import java.util.ArrayList;

import fr.toulouse.miage.amhe.manche.MancheJoueur;
import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.participant.Participant;

/**
 * Classe qui permert des créer des tournois solo
 * @author charles
 *
 */
public class Solo extends Tournoi{
	//private Duelliste duellistes;



	
	/**
	 * Constructeur de tournoi solo
	 */
	public Solo(int nbParticipant, String arme, String nom)  throws  Exception{
		super(nbParticipant, arme, nom);
		//this.duellistes = new Duelliste(this.getNbParticipant());
		//il me faut un constructeur de Duelliste qui prend en paramètre un int (nbParticipant) et qui me créer un tableau de duelliste de cette taille.


	}

	public void addParticipant(Participant d){
		if(this.listeParticipant.size() < this.getNbParticipant() && d instanceof Duelliste) {
			this.listeParticipant.add(d);
			this.listeParticipantArentrer.add(d);
		}
	}


	public String toString(){

		return this.journal;
	}


	/**
	 *  Permet de jouer toutes les manches pour la simulation
	 *
	 *  **/
	public String jouerToutesLesManches(){
		ArrayList<Duelliste> gagnants = new ArrayList<>();
		int tour_a_effectuer = this.calculTourAEffectuer();
		int tour = 1;
		int nbManches = 0;
		for(int i = 0; i<tour_a_effectuer; i++) {
			nbManches = this.listeManche.size();
			this.journal += "\n\nTour " + tour + "\n";
			tour++;
			for (int j = 0; j < nbManches; j++) {
				ajouterMessage(this.listeManche.get(j).toString());
				Duelliste joueurGagnant = (Duelliste) this.listeManche.get(j).jouerManche();
				gagnants.add(joueurGagnant);
				ajouterMessage("le joueur " + joueurGagnant.getNom() + " a gagné sur un score de : " +this.listeManche.get(j).getScore1()+" a " +this.listeManche.get(j).getScore2()+"\n");


			}
			/*for (int it = 0; it < gagnants.size(); it++) {
				journal += "\n**"+gagnants.get(it).getNom()+"\n";
			}*/

			int tailleGagnants = gagnants.size();
			for (int g = 0; g < tailleGagnants /2; g++) {
				this.addManches(new MancheJoueur(gagnants.get(0), gagnants.get(1)));
				this.delManches(0);
				this.delManches(0);
				gagnants.remove(0);
				gagnants.remove(0);

			}
			/*for (int it = 0; it < this.manches.size(); it++) {
				journal += "\n*"+this.manches.get(it).toString()+"\n";
			}*/
		}

		this.journal += "\n\n\nLe gagnant du tournoi : " +this.getNom()+ " est " +gagnants.get(0).getNom();

		return this.journal;

	}






}
