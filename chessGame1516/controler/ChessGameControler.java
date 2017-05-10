/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import controler.ChessGameControlers;
import model.BoardGames;
import model.Coord;

/**
 *
 * @author Maxime
 */
public class ChessGameControler implements ChessGameControlers{
    
    BoardGames chessGame;

    public ChessGameControler(BoardGames model) {
        this.chessGame = model;
    }

    @Override
    public boolean move(Coord initCoord, Coord finalCoord) {
       return this.chessGame.move(initCoord.x, initCoord.y, finalCoord.x, finalCoord.y);
    }

    @Override
    public String getMessage() {
        return this.chessGame.getMessage();
    }

    @Override
    public boolean isEnd() {
        return this.chessGame.isEnd();
    }

    @Override
    public boolean isPlayerOK(Coord initCoord) {
        return chessGame.getColorCurrentPlayer().equals(chessGame.getPieceColor(initCoord.x, initCoord.y));
    }
    
    @Override
    public String toString(){
        return this.chessGame.toString();
    }
    
}
