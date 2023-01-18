/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.toulouse.miage.amhe.tournoi;
import fr.toulouse.miage.amhe.participant.*;
/**
 *
 * @author valen
 */
public abstract class Manche {
    protected int score1;
    protected int score2;
    public abstract Participant jouerManche();
}