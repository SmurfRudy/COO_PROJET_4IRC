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
public class MouvementFou implements Mouvement {

    private MouvementFou(){};
    private static MouvementFou instance = null;
    
    public static MouvementFou getInstance(){
        if (instance == null)
                {
                    instance= new MouvementFou();
                }
        return instance;
    };
    @Override
    public boolean isMoveOk(int xInitial, int yInitial, int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible, boolean premierCoup) {
       boolean ret = false;
		
		if (Math.abs(yFinal - yInitial) == Math.abs(xFinal - xInitial)) {
			ret  = true;
		}		
		
		return ret;
    }
    
}
