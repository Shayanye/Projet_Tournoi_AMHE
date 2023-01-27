/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.toulouse.miage.amhe.participant;

import java.util.Random;

/**
 * @author valen
 */
public class Duelliste {
    protected int rapidité;
    private String nom;
    private String arme;
    public Duelliste(String nom, String arme)
    {

        this.nom=nom;
        this.arme=arme;
        this.rapidité = new Random().nextInt(10) + 1;
    }
    private static final int[] points = {5, 3, 1};

    public int attaquer() {
        Random r = new Random();
        int valeur = r.nextInt(3);
        return points[valeur];
    }

    public int getRapidité() {
        return this.rapidité;
    }

    public String getNom() {
        return this.nom;
    }
    public String getArme(){
        return this.arme;
    }
}
