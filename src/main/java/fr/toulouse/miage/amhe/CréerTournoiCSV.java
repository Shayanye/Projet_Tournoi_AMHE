package fr.toulouse.miage.amhe;

import fr.toulouse.miage.amhe.manche.Manche;
import fr.toulouse.miage.amhe.manche.MancheJoueur;
import fr.toulouse.miage.amhe.participant.Duelliste;
import fr.toulouse.miage.amhe.participant.Participant;
import fr.toulouse.miage.amhe.tournoi.Solo;
import fr.toulouse.miage.amhe.tournoi.Tournoi;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CréerTournoiCSV {

    private final Tournoi tournoi;
    private final String journal;
    private ArrayList<Participant> participants=new ArrayList<>();
    private ArrayList<Manche> manches=new ArrayList<>();
    private  String delimiteur = ",";
    private  String separator = "\n";
    private int choix;
    private int numberM=0;
    private FileWriter file;

    public CréerTournoiCSV(Tournoi tournoi, int choix){
        this.tournoi=tournoi;
        this.choix=choix;
        this.journal=tournoi.toString();
    }

    /** Créer un fichier CVS avec toutes les infos du tournoi ( le fichier se place dans le dossier sauvegarde)**/
    public void CréerFile() throws IOException {
        if(choix==0) {
            file = new FileWriter("src/main/java/fr/toulouse/miage/amhe/sauvegarde/" + this.tournoi.getNom()+"(Solo)", true);
        }else{
            file = new FileWriter("src/main/java/fr/toulouse/miage/amhe/sauvegarde/" + this.tournoi.getNom()+"(Equipe)", true);
        }
        file.append("NbParticipants,Arme,Nom,"+choix);
        file.append(separator);
        file.append(String.valueOf(this.tournoi.getNbParticipant()));
        file.append(delimiteur);
        file.append(this.tournoi.getArme());
        file.append(delimiteur);
        file.append(this.tournoi.getNom());
        file.append(separator);
        file.append("ListeJoueur");
        file.append(separator);
        for(Participant p: this.tournoi.getListeParticipant()){
            file.append(p.getNom());
            file.append(separator);
        }
        file.append("ListeManche");
        file.append(separator);
        for(Manche m: this.tournoi.getListeManche()){
            file.append(String.valueOf(numberM)+","+m.getP1().getNom()+","+m.getP2().getNom());
            file.append(separator);
            numberM=numberM+1;
        }
        file.append("resultatTournoi");
        file.append(separator);
        file.append(this.tournoi.toString());
        file.close();

    }

}
