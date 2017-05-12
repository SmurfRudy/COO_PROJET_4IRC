package model;



/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 */
public class Cavalier extends AbstractPiece  {
	

	/**
	 * @param name
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Cavalier( Couleur couleur_de_piece, Coord coord, AbstractMouvementFactory factory) {
		super(couleur_de_piece, coord, factory);
                this.setMouvementByDefault(MouvementCavalier.getInstance());
                //this.setMouvement(MouvementCavalier.getInstance());
                this.getMouvementForModeTempete().put(3,this.getMouvementByDefault());
                this.getMouvementForModeTempete().put(4,this.getMouvementByDefault());
                this.setMouvement(this.getMouvementForModeTempete().get(coord.x));
	}
        
	/* (non-Javadoc)
	 * @see model.AbstractPiece#isMoveOk(int, int)
	 */
        /*
	@Override
	public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk,
			boolean isCastlingPossible) {
		
		return this.getMouvement().isMoveOk(this.getX(), this.getY(), xFinal, yFinal, isCatchOk, isCastlingPossible, false);
	
	}
*/

	

	
}
