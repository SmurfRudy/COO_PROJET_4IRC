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
public class MouvementTempeteFactory extends AbstractMouvementFactory{

    public MouvementTempeteFactory() {
        this.mouvements = new HashMap<>();
        
        this.mouvements.put(0,MouvementTour.getInstance());
        this.mouvements.put(1,MouvementCavalier.getInstance());
        this.mouvements.put(2,MouvementFou.getInstance());
        this.mouvements.put(3,null);
        this.mouvements.put(4,null);
        this.mouvements.put(5,MouvementFou.getInstance());
        this.mouvements.put(6,MouvementCavalier.getInstance());
        this.mouvements.put(7,MouvementTour.getInstance());
    }    
}
