package launcher.localLauncher;

import vue.ChessGameCmdLine;
import controler.ChessGameControlers;
import controler.ChessGameControler;
import model.ChessGame;



/**
 * @author francoise.perrin
 * Lance l'exécution d'un jeu d'échec en mode console.
 */
public class LauncherCmdLine {
	
	public static void main(String[] args) {		
		
		ChessGame model;
		ChessGameControlers controler;	
		ChessGameCmdLine vue;
		
		model = new ChessGame(0);	
		controler = new ChessGameControler(model);
		
		new ChessGameCmdLine(controler);
		
		vue = new ChessGameCmdLine(controler);
                model.addObserver(vue);
	
		vue.go();
	}

}
