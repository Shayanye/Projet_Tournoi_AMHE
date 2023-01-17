/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.toulouse.miage.amhe.participant;
import java.util.ArrayList;
import fr.toulouse.miage.amhe.arme.Arme;
/**
 *
 * @author valen
 */
public class Equipe extends Participant {
    private static final int nombre=4;
    private ArrayList<Duelliste> Equipe=new ArrayList<>();
    
    public Equipe(String nom, Arme arme){
        super(nom,arme);
        
    }
    
    
    public void ajouterMembre(String nom){
        Equipe.add(new Duelliste(nom,arme));
    }
}
