package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * @author ericallen 
 * Creates the view for to select character screen, makes 4 buttons
 */
public class CharacterChoice {
	public Rectangle FishButton = new Rectangle(1 * 4*Main.frameWidth / 17, Main.frameHeight / 2, Main.frameWidth / 7,
			Main.frameHeight / 8);
	public Rectangle CrabButton = new Rectangle(2 * 4*Main.frameWidth / 17, Main.frameHeight / 2, Main.frameWidth / 7,
			Main.frameHeight / 8);
	public Rectangle BirdButton = new Rectangle(3 * 4*Main.frameWidth / 17, Main.frameHeight / 2, Main.frameWidth / 7,
			Main.frameHeight / 8);
	public Rectangle MenuButton = new Rectangle(4 * Main.frameWidth / 5, Main.frameHeight / 4 * 3, Main.frameWidth / 7,
			Main.frameHeight / 8);

	/**
	 * Renders the button to the screen
	 * @param g
	 */
	public void render(Graphics g) {
		Font font = new Font("arial", Font.BOLD, Main.frameHeight / 10);
		Font font1 = new Font("arial", Font.BOLD, Main.frameHeight / 16);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("Choose your character", 3*Main.frameWidth / 19, Main.frameHeight / 5);
		g.setFont(font1);
		g.drawString("Fish", (int) Math.round(FishButton.x + FishButton.getWidth() / 5),
				(int) Math.round(FishButton.y + 2 * FishButton.getHeight() / 3));
		g.drawString("Crab", (int) Math.round(CrabButton.x + CrabButton.getWidth() / 5),
				(int) Math.round(CrabButton.y + 2 * CrabButton.getHeight() / 3));
		g.drawString("Bird", (int) Math.round(BirdButton.x + BirdButton.getWidth() / 5),
				(int) Math.round(BirdButton.y + 2 * BirdButton.getHeight() / 3));
		g.drawString("Menu", (int) Math.round(MenuButton.x + MenuButton.getWidth() / 8),
				(int) Math.round(MenuButton.y + 5 * MenuButton.getHeight() / 7));

		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(FishButton);
		g2d.draw(CrabButton);
		g2d.draw(BirdButton);
		g2d.draw(MenuButton);

	}
}
