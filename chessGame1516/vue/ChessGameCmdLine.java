package vue;

import model.Coord;
import controler.ChessGameControlers;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import model.ChessGameObserver;
import model.PieceIHMs;



/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 * 
 * Vue console d'un jeu d'échec
 * Cette classe est un observateur et le damier est mis à jour à chaque changement dans la classe métier
 */
public class ChessGameCmdLine implements ChessGameObserver{

	ChessGameControlers chessGameControler;
        

	public   ChessGameCmdLine(ChessGameControlers chessGameControler) {
		this.chessGameControler = chessGameControler;
	}


	public void go() {

		System.out.print("\n Déplacement de 3,6 vers 3,4 :");
		chessGameControler.move(new Coord(3,6), new Coord(3, 4));	// true
		System.out.println(chessGameControler);
		
		System.out.print("\n Déplacement de 3,4 vers 3,6 :");		
		chessGameControler.move(new Coord(3,4), new Coord(3, 6));	// false 
		System.out.println(chessGameControler);
		
		System.out.print("\n Déplacement de 4,1 vers 4,3 :");
		chessGameControler.move(new Coord(4, 1), new Coord(4, 3));	// true
		System.out.println(chessGameControler);
		
		System.out.print("\n Déplacement de 3,4 vers 3,4 :");
		chessGameControler.move(new Coord(3, 4), new Coord(3, 4));	// false	
		System.out.println(chessGameControler);
		
		System.out.print("\n Déplacement de 3,4 vers 4,3 :");
		chessGameControler.move(new Coord(3, 4), new Coord(4, 3));	// true	
		System.out.println(chessGameControler);
	}
        
        @Override
        public void update(LinkedList<PieceIHMs> pieces){
        System.out.println(chessGameControler.getMessage() + "\n");	
        Iterator<PieceIHMs> piecesIterator = pieces.iterator();
        PieceIHMs piece = null;
        System.out.println("    0     1     2     3     4     5    6     7");
        for (int i = 0; i < 8; i++) {
            System.out.print("0 ");
            for (int j = 0; j < 8; j++) {
                boolean trouve = false;
                
                while (piecesIterator.hasNext()) {
                    piece = piecesIterator.next();
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
