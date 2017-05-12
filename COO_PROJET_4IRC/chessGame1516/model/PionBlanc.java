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
        this.setMouvementByDefault(MouvementPionBlanc.getInstance());
        this.setMouvement(MouvementPionBlanc.getInstance());
    }
}
