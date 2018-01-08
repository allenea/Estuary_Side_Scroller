package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * @author ericallen creates the view for the tutorial screen
 */

public class Tutorial {
	public Rectangle menuButton = new Rectangle(5 * Main.frameWidth / 6, Main.frameHeight / 4 * 3, Main.frameWidth / 8,
			Main.frameHeight / 12);
	public Rectangle characterButton = new Rectangle(4 * Main.frameWidth / 6, Main.frameHeight / 4 * 3,
			Main.frameWidth / 8, Main.frameHeight / 12);
	public Rectangle GoBackButton = new Rectangle(2 * Main.frameWidth / 5, Main.frameHeight / 4 * 3,
			Main.frameWidth / 5, Main.frameHeight / 8);

	/**
	 * Renders the graphics to the view
	 * 
	 * @param g
	 */
	public void render(Graphics g) {
		Font font3 = new Font("arial", Font.BOLD, Main.frameHeight / 40);
		Font font2 = new Font("calibri", Font.BOLD, Main.frameHeight / 14);
		Font font1 = new Font("calibri", Font.BOLD, Main.frameHeight / 16);

		g.setFont(font3);
		g.setColor(Color.black);
		g.drawString("This is a Striped Bass. It grows big and strong by eating smaller fish. ", Main.frameWidth / 4,
				Main.frameHeight / 3 - Main.frameWidth / 29);
		g.drawString("*It gets weak if it eats any type of garbage like tires and trashbags.*", Main.frameWidth / 4,
				Main.frameHeight / 3 + Main.frameHeight / 15 - Main.frameWidth / 29);

		g.drawString("This is a Red Knot. It is a small bird that fattens up by eating horseshoe crab eggs and bugs.",
				Main.frameWidth / 4, Main.frameHeight / 2 - Main.frameWidth / 34);
		g.drawString("*To stay big, avoid clouds of pollution!*", Main.frameWidth / 4,
				Main.frameHeight / 2 + Main.frameHeight / 15 - Main.frameWidth / 27); 

		g.drawString("This is a Horseshoe Crab. It grows big and strong by eating fish.", Main.frameWidth / 4,
				Main.frameHeight / 2 + Main.frameWidth / 12);
		g.drawString("*It gets weak if it eats any type of garbage like tires and trashbags.*", Main.frameWidth / 4,
				Main.frameHeight / 2 + Main.frameHeight / 16 + Main.frameWidth / 12);
		g.drawString("*Up and down arrow keys control the players movement*", Main.frameWidth / 5,
				Main.frameHeight / 2 + Main.frameHeight / 6 + Main.frameWidth / 10); 
		g.drawString("**Eating powerups also increases your score, so look out for them!**", Main.frameWidth / 6,
				Main.frameHeight / 2 + Main.frameHeight / 4 + Main.frameWidth / 14);

		g.setFont(font2);
		g.setColor(Color.black);
		g.drawString("HOW TO PLAY", 2 * Main.frameWidth / 7, Main.frameHeight / 7);
		g.setFont(font1);
		g.drawString("Menu", (int) Math.round(menuButton.x + menuButton.getWidth() / 8),
				(int) Math.round(menuButton.y + 5 * menuButton.getHeight() / 7));
		g.drawString("Next", (int) Math.round(characterButton.x + characterButton.getWidth() / 8),
				(int) Math.round(characterButton.y + 5 * characterButton.getHeight() / 7));
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(menuButton);
		g2d.draw(characterButton);

	}

}
