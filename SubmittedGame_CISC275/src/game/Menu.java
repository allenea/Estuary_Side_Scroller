package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * @author ericallen Creates menu page with 3 buttons to start the game, go to
 *         tutorial and quit once clicked with the mouse input it directs to
 *         that location. Menu drawn in paint
 */

public class Menu {

	public Rectangle PlayButton = new Rectangle(3 * Main.frameWidth / 7, 3 * Main.frameHeight / 12, Main.frameWidth / 8,
			Main.frameHeight / 10);
	public Rectangle HelpButton = new Rectangle(3 * Main.frameWidth / 7, 5 * Main.frameHeight / 12, Main.frameWidth / 8,
			Main.frameHeight / 10);
	public Rectangle QuitButton = new Rectangle(3 * Main.frameWidth / 7, 7 * Main.frameHeight / 12, Main.frameWidth / 8,
			Main.frameHeight / 10);

	/**
	 * Renders the menu to view
	 * @param g
	 */
	public void render(Graphics g) {

		Font font = new Font("arial", Font.BOLD, Main.frameHeight / 9);
		Font font1 = new Font("arial", Font.BOLD, Main.frameHeight / 14);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("Estuary Adventure", 2 * Main.frameWidth / 10, Main.frameHeight / 5);
		g.setFont(font1);
		if (Board.plays == 0) {
			g.drawString("Click me --->", (int) Math.round(HelpButton.x - 9 * HelpButton.getWidth() / 4),
					(int) Math.round(HelpButton.getY() + 2 * HelpButton.getHeight() / 3));
		}
		g.drawString("Play", (int) Math.round(PlayButton.x + PlayButton.getWidth() / 10),
				(int) Math.round(PlayButton.y + PlayButton.getWidth() / 3));
		g.drawString("Help", (int) Math.round(HelpButton.x + HelpButton.getWidth() / 10),
				(int) Math.round(HelpButton.y + HelpButton.getWidth() / 3));
		g.drawString("Quit", (int) Math.round(QuitButton.x + QuitButton.getWidth() / 10),
				(int) Math.round(QuitButton.y + QuitButton.getWidth() / 3));
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(PlayButton);
		g2d.draw(HelpButton);
		g2d.draw(QuitButton);
	}
}
