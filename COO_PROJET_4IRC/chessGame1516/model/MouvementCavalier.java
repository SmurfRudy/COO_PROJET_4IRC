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
public class MouvementCavalier implements Mouvement{
    
    private MouvementCavalier(){};
    private static MouvementCavalier instance = null;
    
    public static MouvementCavalier getInstance(){
        if (instance == null)
                {
                    instance= new MouvementCavalier();
                }
        return instance;
    };
    
    @Override
    public boolean isMoveOk(int xInitial, int yInitial, int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible, boolean premierCoup) {
        boolean ret = false;
		
		if ((Math.abs(xFinal - xInitial) + Math.abs(yFinal - yInitial)) == 3) {
			
			if ((Math.abs(xFinal - xInitial)<3) && (Math.abs(yFinal - yInitial)<3)) {
				ret  = true;
			}		
		}	
		
		return ret;
    }
    
}
