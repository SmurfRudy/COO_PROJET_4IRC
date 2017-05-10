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
    
    ChessGameObserver observer;
    
    public ChessGame(){
        this.echiquier = new Echiquier();
    }
    
    @Override
    public void setObserver(ChessGameObserver observer) {
        this.observer = observer;
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
            observer.update(echiquier.getPiecesIHM());
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
    
    
    
    
}
