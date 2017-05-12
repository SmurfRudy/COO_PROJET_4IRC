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
public abstract class AbstractMouvementFactory {
    Map<Integer, Mouvement> mouvements;
    Map<Class, Mouvement> mouvementsDefault;
    
    public AbstractMouvementFactory() {
        mouvementsDefault = new HashMap<>();
        mouvementsDefault.put(Cavalier.class, MouvementCavalier.getInstance());
        mouvementsDefault.put(Fou.class, MouvementFou.getInstance());
        mouvementsDefault.put(PionBlanc.class, MouvementPionBlanc.getInstance());
        mouvementsDefault.put(PionNoir.class, MouvementPionNoir.getInstance());
        mouvementsDefault.put(Reine.class, MouvementReine.getInstance());
        mouvementsDefault.put(Roi.class, MouvementRoi.getInstance());
        mouvementsDefault.put(Tour.class, MouvementTour.getInstance());
    }
    public Mouvement getMouvement(int x, Class className) {
        if (mouvements.get(x) != null) {
            return mouvements.get(x);
        }else{
            return mouvementsDefault.get(className);
        }
    }
}
