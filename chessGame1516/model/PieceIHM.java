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
public class PieceIHM implements PieceIHMs{
    Pieces piece;
	
	public PieceIHM(Pieces piece) {
		this.piece = piece;
	}
        
	@Override
	public String toString() {
		return "Name=" + getNamePiece() + ", Couleur=" + getCouleur() + ", X="
				+ getX() + ", Y=" + getY();
	}

	@Override
	public int getX() {
		return piece.getX();
	}

	@Override
	public int getY() {
		return piece.getY();
	}

	@Override
	public String getNamePiece() {
		return piece.getName();
	}

        @Override
	public Couleur getCouleur() {
		return piece.getCouleur();
	}
}
