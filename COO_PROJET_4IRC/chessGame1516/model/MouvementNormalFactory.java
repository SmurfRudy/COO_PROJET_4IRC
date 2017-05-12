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
public class MouvementNormalFactory extends AbstractMouvementFactory{

    public MouvementNormalFactory() {
        this.mouvements = new HashMap<>();
        this.mouvements.put(0,null);
        this.mouvements.put(1,null);
        this.mouvements.put(2,null);
        this.mouvements.put(3,null);
        this.mouvements.put(4,null);
        this.mouvements.put(5,null);
        this.mouvements.put(6,null);
        this.mouvements.put(7,null);
    }
    
}
