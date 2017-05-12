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
public interface Mouvement {
    public boolean isMoveOk(int xInit,int yInit,int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible, boolean premierCoup);
}
