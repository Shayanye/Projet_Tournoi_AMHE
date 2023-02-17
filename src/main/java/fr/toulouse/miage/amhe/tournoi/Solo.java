package fr.toulouse.miage.amhe.tournoi;

import java.util.ArrayList;
import java.lang.Math;

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
	private ArrayList<MancheJoueur> manches;

	private ArrayList<MancheJoueur> manches_effectuees;


	
	/**
	 * Constructeur de tournoi solo
	 */
	public Solo(int nbParticipant, String arme, String nom)  throws  Exception{
		super(nbParticipant, arme, nom);
		//this.duellistes = new Duelliste(this.getNbParticipant());
		//il me faut un constructeur de Duelliste qui prend en paramètre un int (nbParticipant) et qui me créer un tableau de duelliste de cette taille.
		this.duellistes = new ArrayList<>(this.getNbParticipant());
		this.manches = new ArrayList<>(this.getNbParticipant()-1);
		this.manches_effectuees  = new ArrayList<>();


	}

	public void addParticipant(Duelliste d){
		if(this.duellistes.size() < this.getNbParticipant()) {
			this.duellistes.add(d);
		}
	}
	public void addManches(MancheJoueur m ){
		this.manches.add(m);
	}

	public void delManches(int i){
		this.manches.remove(i);
	}



	public ArrayList<Duelliste> getListeDuelliste(){
		return this.duellistes;
	}

	public String AfficherDuellistes(){
		String msg ="";
		for(Duelliste d1: this.duellistes){
			msg+=d1.getNom()+"\n";
		}
		return msg;
	}

	public ArrayList<MancheJoueur> getListeManches(){
		return this.manches;
	}

	private int calculTourAEffectuer(){
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


	public String jouerToutesLesManches(){
		ArrayList<Duelliste> gagnants = new ArrayList<>();
		String journal = "";
		int tour_a_effectuer = this.calculTourAEffectuer();
		int tour = 1;
		int nbManches = 0;

		for(int i = 0; i<tour_a_effectuer; i++) {
			nbManches = this.manches.size();
			journal += "\n\nTour " + tour + "\n";
			tour++;
			for (int j = 0; j < nbManches; j++) {
				journal += this.manches.get(j).toString();
				Duelliste joueurGagnant = this.manches.get(j).jouerManche();
				gagnants.add(joueurGagnant);
				journal += "le joueur " + joueurGagnant.getNom() + " a gagné sur un score de : " +this.manches.get(j).getScore1()+" a " +this.manches.get(j).getScore2()+"\n";
				this.manches_effectuees.add(this.manches.get(j));


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
		for (int it = 0; it < this.manches_effectuees.size(); it++) {
			journal += "\n*"+this.manches_effectuees.get(it).toString()+"\n";
		}

		journal += "\n\n\nLe gagnant du tournoi : " +this.getNom()+ " est " +gagnants.get(0).getNom();

		return journal;

	}






}
