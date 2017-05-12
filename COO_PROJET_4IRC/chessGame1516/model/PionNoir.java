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
public class PionNoir extends AbstractPion{

    public PionNoir(Couleur couleur_de_piece, Coord coord) {
        super(couleur_de_piece, coord);
        this.setMouvementByDefault(MouvementPionNoir.getInstance());
        //this.setMouvement(MouvementPionNoir.getInstance());
        this.setMouvement(this.getMouvementForModeTempete().get(coord.x));
    }
    
}
