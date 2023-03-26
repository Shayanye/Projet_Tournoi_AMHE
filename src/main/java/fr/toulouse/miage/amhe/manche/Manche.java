/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.toulouse.miage.amhe.manche;
import fr.toulouse.miage.amhe.participant.*;
/**
 *
 * @author valen
 */
public abstract class Manche {

    protected Participant p1;

    protected Participant p2;
    protected int score1;
    protected int score2;

    public Manche(Participant p1, Participant p2){
        this.p1=p1;
        this.p2=p2;
    }

    public abstract Participant jouerManche();

    /**
     * @return
     */
    public int getScore1(){

        return score1;
    }

    public int getScore2(){

        return score2;
    }

    public Participant getP1() {
        return p1;
    }

    public Participant getP2() {
        return p2;
    }
}