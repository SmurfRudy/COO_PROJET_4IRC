/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rudy_DEAL
 */
public class MouvementTour implements Mouvement {
    
    private MouvementTour(){};
    private static MouvementTour instance = null;
    
    public static MouvementTour getInstance(){
        if (instance == null)
                {
                    instance= new MouvementTour();
                }
        return instance;
    };

    @Override
    public boolean isMoveOk(int xInitial, int yInitial, int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible, boolean premierCoup) {
		
		boolean ret = false;
		
		if ((yFinal == yInitial) || (xFinal == xInitial)) {
			ret = true;
		}
		
		return ret;
	}

    
}
