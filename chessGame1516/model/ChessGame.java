/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Rudy_DEAL
 */
public class ChessGame implements BoardGames{
    Echiquier echiquier;
    
    public ChessGame(){
        this.echiquier = new Echiquier();
    }
    
    @Override
    public String toString(){
        return this.echiquier.toString();
    }
    
    @Override
    public boolean isEnd(){
        return this.echiquier.isEnd();
    }
    
    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal){
        boolean moveDone = false;
        if (this.echiquier.isMoveOk(xInit, yInit, xFinal, yFinal)){
            moveDone = this.echiquier.move(xInit, yInit, xFinal, yFinal);
            this.echiquier.switchJoueur();
            update();
        }
        return moveDone;
    }
    
    @Override
    public String getMessage(){
        return this.echiquier.getMessage();
    }
    
    @Override
    public Couleur getColorCurrentPlayer(){
        return this.echiquier.getColorCurrentPlayer();
    }

    @Override
    public Couleur getPieceColor(int x, int y) {
        return this.echiquier.getPieceColor(x, y);
    }
    
    public void update(){
        System.out.println(getMessage() + "\n");	
        LinkedList<PieceIHMs> pieces = (LinkedList<PieceIHMs>) this.echiquier.getPiecesIHM();
        PieceIHMs piece = null;
        System.out.println("    0     1     2     3     4     5    6     7");
        for (int i = 0; i < 8; i++) {
            System.out.print("0 ");
            for (int j = 0; j < 8; j++) {
                boolean trouve = false;
                while (pieces.iterator().hasNext()) {
                    piece = pieces.iterator().next();
                    if ( piece.getX()==j && piece.getY()==i) {
                        System.out.print(piece.getCouleur().toString().substring(0,1)+"_");
                        System.out.print(piece.getNamePiece().substring(0, 2));
                        trouve = true;
                    }
                }
                if (!trouve) {
                    System.out.print("____");
                }
                System.out.print("  ");
            }
            System.out.print("\n");
            
        }
        
        
    }
    
    
}
