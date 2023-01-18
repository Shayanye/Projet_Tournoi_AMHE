/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.toulouse.miage.amhe.participant;

import fr.toulouse.miage.amhe.arme.Arme;
import java.util.Random;

/**
 *
 * @author valen
 */
public class Duelliste extends Participant {

    private static final int[] points = {5, 3, 1};

    public Duelliste(String nom, Arme arme) {
        super(nom, arme);
    }

    public int attaquer() {
        Random r = new Random();
        int valeur = r.nextInt(3);
        return points[valeur];
    }

}
