package model;




/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD*
 */
public abstract class AbstractPion extends AbstractPiece  {

	private boolean premierCoup;

	/**
	 * @param name
	 * @param couleur_de_piece
	 * @param coord
	 */
	public AbstractPion(Couleur couleur_de_piece, Coord coord, AbstractMouvementFactory factory) {
		super(couleur_de_piece, coord, factory);
		this.premierCoup = true;
	}

	/* (non-Javadoc)
	 * @see model.AbstractPiece#isMoveOk(int, int)
	 */
	@Override
	public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk,
			boolean isCastlingPossible) {
	
		return getFactory().getMouvement().isMoveOk(this.getX(), this.getY(), xFinal, yFinal, isCatchOk, isCastlingPossible, this.premierCoup);
	
	}



	/* (non-Javadoc)
	 * @see model.AbstractPiece#move(int, int)
	 */
	@Override
	public boolean move(int x, int y){

		boolean ret = false;

		if(Coord.coordonnees_valides(x,y)){
			this.premierCoup = false;
			ret = super.move(x, y);
		}
		return ret;
	}



}
