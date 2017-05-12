/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rudy_DEAL
 */
public class MouvementTempeteFactory implements AbstractMouvementFactory{
    
   // private static MouvementTempeteFactory instance;

    private Map<Integer, Mouvement> mouvements;

    public MouvementTempeteFactory() {
        this.mouvements = new HashMap<>();
        
        this.mouvements.put(0,MouvementTour.getInstance());
        this.mouvements.put(1,MouvementCavalier.getInstance());
        this.mouvements.put(2,MouvementFou.getInstance());
        //this.mouvementForModeTempete.put(3,this.getMouvementByDefault());
        //this.mouvementForModeTempete.put(4,this.getMouvementByDefault());
        this.mouvements.put(5,MouvementFou.getInstance());
        this.mouvements.put(6,MouvementCavalier.getInstance());
        this.mouvements.put(7,MouvementTour.getInstance());
    }
    
    /*
    public MouvementTempeteFactory getInstance() {
        if (instance == null) {
            instance = new MouvementTempeteFactory();
        }
        return this.instance;
    }*/
    
    
    
    @Override
    public Mouvement getMouvement() {
        return this.mouvements.get(0);
    }
    
}
