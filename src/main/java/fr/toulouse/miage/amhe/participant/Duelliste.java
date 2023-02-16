/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.toulouse.miage.amhe.participant;

import java.util.Random;

/**
 *
 * @author valen
 */
public class Duelliste {

    private static final int[] points = {5, 3, 1};
    private String arme;
    private int rapidité;
    private String nom;
    private Random rand = new Random();

    public Duelliste(String nom, String arme) {
       this.nom = nom;
       this.arme = arme;
       this.rapidité = this.rand.nextInt(10)+1;
    }
    
    

    public int attaquer() {
        int valeur = this.rand.nextInt(3);
        return points[valeur];
    }

    public int getRapidité(){

        return this.rapidité;
    }

    public String getNom(){

        return this.nom;
    }

    public String getArme(){

        return this.arme;
    }



}
