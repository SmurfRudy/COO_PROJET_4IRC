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
public class MouvementPionNoir extends MouvementPion{
    
    private MouvementPionNoir(){};
    private static MouvementPionNoir instance = null;
    
    public static MouvementPionNoir getInstance(){
        if (instance == null)
                {
                    instance= new MouvementPionNoir();
                }
        return instance;
    };
    
    @Override
    public boolean isMoveVertOk(int yInit, int yFinal) {
        if (yFinal - yInit > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isMoveCatchOk(int xInit, int yInit, int xFinal, int yFinal) {
        if ((yFinal == yInit+1 && xFinal == xInit+1) 
						|| (yFinal == yInit+1 && xFinal == xInit-1)) {
					return true;
	}else{
            return false;
        }
    }
    
}
