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
public abstract class MouvementPion implements Mouvement{
    
    
  
   @Override
   public boolean isMoveOk(int xInit,int yInit,int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible, boolean premierCoup){
            boolean ret = false;

		// Déplacement vertical
		if (!isCatchOk && !isCastlingPossible){

			if ((xFinal == xInit)
					&& (Math.abs(yFinal - yInit) <= 1 || 
					(Math.abs(yFinal - yInit) <= 2 && premierCoup==true))) {
                                if (isMoveVertOk(yInit, yFinal))
                                        ret = true;
			}
		}
		else {
                        if (isMoveCatchOk(xInit,yInit, xFinal, yFinal))
                                ret = true;	
		}

		return ret;
   };
   
   public abstract boolean isMoveVertOk(int yInit, int yFinal);
   public abstract boolean isMoveCatchOk(int xInit, int yInit, int xFinal, int yFinal);
    
    
}
