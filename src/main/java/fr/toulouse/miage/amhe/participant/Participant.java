/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.toulouse.miage.amhe.participant;
import fr.toulouse.miage.amhe.arme.Arme;

/**
 *
 * @author valen
 */
public abstract class Participant {

    private String nom;
    protected Arme arme;

    public Participant(String nom, Arme arme) {
        this.nom = nom;
        this.arme = arme;
    }

    public Arme getArme(){
        return this.arme;
    }
}
