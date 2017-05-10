/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Maxime
 */
public class PionBlanc extends AbstractPion{

    public PionBlanc(Couleur couleur_de_piece, Coord coord) {
        super(couleur_de_piece, coord);
    }
    
    @Override
    public boolean isMoveVertOk(int yFinal){
        if (yFinal - this.getY() < 0){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean isMoveCatchOk(int xFinal, int yFinal){
        if ((yFinal == this.getY()-1 && xFinal == this.getX()+1) 
						|| (yFinal == this.getY()-1 && xFinal == this.getX()-1)) {
					return true;
	}else{
            return false;
        }
    }
}
