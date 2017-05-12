package launcher.localLauncher;

import controler.ChessGameControler;
import java.awt.Dimension;

import javax.swing.JFrame;

import controler.ChessGameControlers;
import javax.swing.JOptionPane;
import model.ChessGame;
import model.Observer;
import vue.ChessGameGUI;



/**
 * @author francoise.perrin
 * Lance l'exécution d'un jeu d'échec en mode graphique.
 * La vue (ChessGameGUI) observe le modèle (ChessGame)
 * les échanges passent par le contrôleur (ChessGameControlers)
 * 
 */
public class LauncherGUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ChessGame chessGame;	
		ChessGameControlers chessGameControler;
		JFrame frame = new JFrame();	
		Dimension dim;
                Object[] options = {"Normal", "Tempête"};
                int choice = JOptionPane.showOptionDialog(frame, "Quel mode souhaitez-vous lancer", "Choix du mode", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                System.out.println(choice);
		dim = new Dimension(700, 700);
		
		chessGame = new ChessGame();	
		chessGameControler = new ChessGameControler(chessGame);
		
		frame = new ChessGameGUI("Jeu d'échec", chessGameControler,  dim);
		chessGame.addObserver((Observer) frame);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600, 10);
		frame.setPreferredSize(dim);
		frame.pack();
		frame.setVisible(true);
	}
}
