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
public class MouvementPionBlanc extends MouvementPion{
    
    private MouvementPionBlanc(){};
    private static MouvementPionBlanc instance = null;
    
    public static MouvementPionBlanc getInstance(){
        if (instance == null)
                {
                    instance= new MouvementPionBlanc();
                }
        return instance;
    };
 
    @Override
    public boolean isMoveVertOk(int yInit, int yFinal) {
        if ((yFinal - yInit) < 0){
            return true;
        }else{
            return false;
        }}

    @Override
    public boolean isMoveCatchOk(int xInit, int yInit, int xFinal, int yFinal) {
        if ((yFinal == yInit-1 && xFinal == xInit+1) 
						|| (yFinal == yInit-1 && xFinal == xInit-1)) {
					return true;
	}else{
            return false;
        }
    }
    
}
