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
public class ChessGame extends Observable implements BoardGames{
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
        }
        this.notifies(echiquier.getPiecesIHM());
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

    @Override
    public List<Coord> getMovesOk(Coord initCoord) {
        return this.echiquier.getMovesOk(initCoord);
    }
    
    
    
}
