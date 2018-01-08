package game;

/**
 * @author Bruce The controller class of our mvc, holds Board and View objects.
 *         Updates the board with the tick() method, and passes the board to the
 *         view so it can draw the list of characters.
 */

public class Controller {
	private Board board;
	private View view;

	/**
	 * Takes in a given board and view and initiates the controller.
	 * 
	 * @param board
	 * @param view
	 * @return Board
	 */
	public Controller(Board board, View view) {
		this.board = board;
		this.view = view;
	}

	/**
	 * Calls the update() method in board.
	 * 
	 * @return void
	 */
	public void tick() {
		if (Board.STATE == "GameFish" || Board.STATE == "GameCrab" || Board.STATE == "GameBird"
				|| Board.STATE == "TutorialFish") {// update for any game
			board.update();
		}
	}

	/**
	 * @return void Passes the list of obstacles, and player locations to the
	 *         view, then tells the view to repaint.
	 */
	public void updateView() {
		view.passCharacters(board.getObstacles());
		view.passPlayer(board.getPlayer());
		view.repaint();
	}
}
