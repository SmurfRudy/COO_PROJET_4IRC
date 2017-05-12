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
public class MouvementRoi implements Mouvement {
    
    private MouvementRoi(){};
    private static MouvementRoi instance = null;
    
    public static MouvementRoi getInstance(){
        if (instance == null)
                {
                    instance= new MouvementRoi();
                }
        return instance;
    };

    @Override
    public boolean isMoveOk(int xInitial, int yInitial, int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible, boolean premierCoup) {
        boolean ret = false;
		
		if ((Math.abs(yFinal - yInitial) <= 1)
				&& (Math.abs(xFinal - xInitial) <= 1)) {
			ret = true;
		}
		
		
		return ret;
    }
    
}
