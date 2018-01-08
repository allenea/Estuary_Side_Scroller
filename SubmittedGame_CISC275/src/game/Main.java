package game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * @author ericallen
 * Main runs the application
 */

/**
 * NOTE FOR FULLSCREEN VS PARTIAL SCREEN 
 * If doing anything other than full screen make sure the values 
 * for frameWidth and frameHeights are commented out or removed.
 * EXAMPLE:
 *  public static int frameWidth;// = 700; //delete the = 700 
 *  public static int frameHeight;// = 500; //delete the = 500 
 *  
 *  ALSO COMMENT OUT THE screenSize.getHeight/Width
 * 
 * ***** MAINTAIN A 1.4 to 1.6 Width to Height ratio for best game experience ******
 * Game buttons and functions still work outside of these dimensions
 ** ****** Recommended Alternate Screen Size Dimensions******
 * Not limited to:
 * 1440 Width to 900 Height
 * 1000 Width to 625 Height
 *  900 Width to 600 Height
 *  700 Width to 450 Height
 *  600 Width to 400 Height
 *  500 Width to 300 Height
 * 
 * If you are doing partial screen make sure you make sure you have the
 * frameHeight and Width commented out in the main also comment out the
 * view.setExtendedState(JFrame.MAXIMIZED_BOTH); AND assign the
 * frameHeight/Width a value above the main
 * 
 * On Mac's under settings you should click the box to hide dock
 * Window users do not need to make any changes
 * 
 * Lastly, for larger screens you may want to increase the speed as it slows as screen size increases.
 * @author ericallen
 */


public class Main {
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	// Declares variables and assigns values for testing, reassigned at runtime
	// to screen dimensions
	public static int frameWidth = 1440;// delete unless partial
										// screen// keep for testing
	public static int frameHeight = 900;// delete unless partial
										// screen// keep for testing

	/**
	 * Run from Main
	 * @param args
	 */
	public static void main(String[] args) {
		frameWidth = (int) screenSize.getWidth();
		frameHeight = (int) screenSize.getHeight();

		Board board = new Board();
		HighScorePage hiscores = new HighScorePage();
		View view = new View(frameWidth, frameHeight, board.getObstacles(), board.getPlayer(), board, hiscores);
		Controller controller = new Controller(board, view);

		// COMMENT OUT, IF NOT USING FULL SCREEN
		view.setExtendedState(JFrame.MAXIMIZED_BOTH);

		while (true) {
			controller.tick();
			controller.updateView();
			/*
			 * System.out.println(board.player); for (NPC n :
			 * board.getObstacles()) { System.out.println(n); }
			 */
			try {
				Thread.sleep(18);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
