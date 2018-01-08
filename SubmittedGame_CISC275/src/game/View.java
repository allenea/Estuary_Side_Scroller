package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author ericallen
 * Load in cartoony images
 */

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private GamePanel panel;
	private ArrayList<NPC> obstacles;
	private Player player;
	// private Board board;
	public static BufferedImage RedKnotPlayerImage;
	public static BufferedImage TutorialBackground;
	public static BufferedImage FishPlayerImage;
	public static BufferedImage CrabPlayerImage;
	public static BufferedImage BirdPlayerImage;
	public static BufferedImage FishNPCImage;
	public static BufferedImage PowerUpNPCImage;
	public static BufferedImage[] TrashNPCImages;
	public static BufferedImage[] FoodNPCImages;
	public static BufferedImage TrashNPCImage2;
	public static BufferedImage FoodNPCImage;
	public static BufferedImage SmogNPCImage;
	public static BufferedImage EggNPCImage;
	public static BufferedImage FlyNPCImage;

	public static BufferedImage Background;
	public static BufferedImage BackgroundFish;
	public static BufferedImage BackgroundBird;
	public static BufferedImage BackgroundCrab;
	public Menu menu;
	public HighScorePage hiscores;

	/**
	 * Creates the view screen
	 * 
	 * @param width
	 * @param height
	 * @param obstacles
	 * @param player
	 * @param hiscores
	 */
	public View(int width, int height, ArrayList<NPC> obstacles, Player player, Board board, HighScorePage hiscores) {
		try {
			RedKnotPlayerImage = ImageIO.read(new File("Resources/images/Flying-Bird-Transparent-Background.png"));
			TutorialBackground = ImageIO.read(new File("Resources/images/underwater-vector-background_73437.jpg"));
			FishPlayerImage = ImageIO.read(new File("Resources/images/Fish_East_1.png"));
			CrabPlayerImage = ImageIO.read(new File("Resources/images/Crab_Transparent_PNG_Image.png"));
			BirdPlayerImage = ImageIO.read(new File("Resources/images/Flying-Bird-Transparent-Background.png"));
			TrashNPCImages = new BufferedImage[2];
			TrashNPCImages[0] = ImageIO.read(new File("Resources/images/trash-bag.png"));
			TrashNPCImages[1] = ImageIO.read(new File("Resources/images/car-tire-png-479.png"));
			FoodNPCImage = ImageIO.read(new File("Resources/images/Fish_dead_east.png"));
			Background = ImageIO.read(new File("Resources/images/background.PNG"));
			FoodNPCImages = new BufferedImage[2];
			PowerUpNPCImage = ImageIO.read(new File("Resources/images/2000px-Red_exclamation_mark.svg.png"));
			FishNPCImage = ImageIO.read(new File("Resources/images/Fish_dead_east.png"));
			FoodNPCImages[0] = FishNPCImage;
			FoodNPCImages[1] = PowerUpNPCImage;
			BackgroundFish = ImageIO.read(new File("Resources/images/backgroundfinal.png"));
			BackgroundBird = ImageIO.read(new File("Resources/images/background bird final.png"));
			SmogNPCImage = ImageIO.read(new File("Resources/images/Smog_Cloud.png"));
			EggNPCImage = ImageIO.read(new File("Resources/images/Mirelurk_Eggs.png"));
			FlyNPCImage = ImageIO.read(new File("Resources/images/4-fly-png-image.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setObstacles(obstacles);
		panel = new GamePanel();
		panel.obstacles = obstacles;
		panel.player = player;
		panel.board = board;
		panel.hiscores = hiscores;
		panel.addKeyListener(panel);
		panel.addMouseListener(new MouseInput());
		getContentPane().add(panel);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		panel.setPreferredSize(new Dimension(width, height));
		// panel.addMouseMotionListener((KeyListener) this);
		panel.setOpaque(true);
		pack();
		setVisible(true);
	}

	/**
	 * Lets UI delegate paint first, which includes background filling since the
	 * component is square
	 * 
	 * @param g
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);

	}

	/**
	 * Handle the key-released event from the text field.
	 * 
	 * @param obstacles
	 */
	public void passCharacters(ArrayList<game.NPC> obstacles) {
		this.setObstacles(obstacles);
	}

	/**
	 * This redraws all the views once an object is added or deleted, the layer
	 * is modified or object display attributes.
	 */

	/**
	 * redraw view
	 */
	public void redraw() {

	}

	/**
	 * @param player
	 */
	public void passPlayer(Player player) {
		this.setPlayer(player);
	}

	/**
	 * Retrieves the obstacles
	 * @return obstacles
	 */
	public ArrayList<NPC> getObstacles() {
		return obstacles;
	}

	/**
	 * Places and updates the obstacles onto the map for render
	 * @param obstacles
	 */
	public void setObstacles(ArrayList<NPC> obstacles) {
		this.obstacles = obstacles;
	}

	/**
	 * Retrieves the player
	 * @return player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Places and updates the player onto the map for render
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
}

/**
 * @author ericallen
 */
class GamePanel extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;
	ArrayList<game.NPC> obstacles;
	Player player;
	int[] lanes;
	int lanesTall;
	Menu menu = new Menu();
	Board board;
	HighScorePage hiscores = new HighScorePage();
	Tutorial tutorial = new Tutorial();
	CharacterChoice choice = new CharacterChoice();

	/**
	 * Lets UI delegate paint first, which includes background filling since the
	 * component is square
	 */

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (Board.STATE == "GameFish") {
			g.drawImage(View.BackgroundFish, -Board.timer % Main.frameWidth, 0, Main.frameWidth, Main.frameHeight,
					this);
			g.drawImage(View.BackgroundFish, Main.frameWidth - Board.timer % Main.frameWidth, 0, Main.frameWidth,
					Main.frameHeight, this);
			for (NPC o : obstacles) {
				if (o.getIsGarbage()) {
					g.drawImage(View.TrashNPCImages[o.image], o.getXloc(), o.getYloc(), Main.frameWidth / 14,
							Main.frameHeight / 10, null);
				} else {
					g.drawImage(View.FoodNPCImages[o.image], o.getXloc(), o.getYloc(), Main.frameWidth / 14,
							Main.frameHeight / 10, null);
				}
			}
			g.drawImage(View.FishPlayerImage, player.getXloc() - Player.score / 100,
					player.getYloc() - Player.score / 100, Main.frameWidth / 14 + Player.score / 50,
					Main.frameHeight / 10 + Player.score / 50, this);
			g.setColor(Color.BLACK);
			g.drawString("Score: " + player.getScore(), Main.frameWidth / 14, Main.frameHeight / 10);
			g.drawString("Health: " + player.getHealth(), Main.frameWidth / 14, Main.frameHeight / 8);
			g.drawString("Time left: " + Integer.toString(3000 - Board.timer % 3000), 10 * Main.frameWidth / 14,
					Main.frameHeight / 10);

		} else if (Board.STATE == "GameCrab") {
			g.drawImage(View.BackgroundFish, -Board.timer % Main.frameWidth, 0, Main.frameWidth, Main.frameHeight,
					this);
			g.drawImage(View.BackgroundFish, Main.frameWidth - Board.timer % Main.frameWidth, 0, Main.frameWidth,
					Main.frameHeight, this);
			for (NPC o : obstacles) {
				if (o.getIsGarbage()) {
					g.drawImage(View.TrashNPCImages[o.image], o.getXloc(), o.getYloc(), Main.frameWidth / 14,
							Main.frameHeight / 10, null);
				} else {
					g.drawImage(View.FoodNPCImages[o.image], o.getXloc(), o.getYloc(), Main.frameWidth / 14,
							Main.frameHeight / 10, null);
				}
			}
			g.drawImage(View.CrabPlayerImage, player.getXloc() - Player.score / 100,
					player.getYloc() - Player.score / 100, Main.frameWidth / 14 + Player.score / 50,
					Main.frameHeight / 10 + Player.score / 50, this);
			g.setColor(Color.BLACK);
			g.drawString("Score: " + player.getScore(), Main.frameWidth / 14, Main.frameHeight / 10);
			g.drawString("Health: " + player.getHealth(), Main.frameWidth / 14, Main.frameHeight / 8);
			g.drawString("Time left: " + Integer.toString(3000 - Board.timer % 3000), 10 * Main.frameWidth / 14,
					Main.frameHeight / 10);
		} else if (Board.STATE == "GameBird") {
			g.drawImage(View.BackgroundBird, -Board.timer % Main.frameWidth, 0, Main.frameWidth, Main.frameHeight,
					this);
			g.drawImage(View.BackgroundBird, Main.frameWidth - Board.timer % Main.frameWidth, 0, Main.frameWidth,
					Main.frameHeight, this);
			for (NPC o : obstacles) {
				if (o.getIsGarbage()) {
					g.drawImage(View.SmogNPCImage, o.getXloc(), o.getYloc(), Main.frameWidth / 14,
							Main.frameHeight / 10, null);
				} else if (View.FoodNPCImages[o.image] == View.PowerUpNPCImage) {
					g.drawImage(View.PowerUpNPCImage, o.getXloc(), o.getYloc(), Main.frameWidth / 14,
							Main.frameHeight / 10, null);
				} else {
					if (o.getLane() == 4) {
						g.drawImage(View.EggNPCImage, o.getXloc(), o.getYloc(), Main.frameWidth / 14,
								Main.frameHeight / 10, null);
					} else {
						g.drawImage(View.FlyNPCImage, o.getXloc(), o.getYloc(), Main.frameWidth / 20,
								Main.frameHeight / 17, null);
					}
				}
			}
			g.drawImage(View.RedKnotPlayerImage, player.getXloc() - Player.score / 100,
					player.getYloc() - Player.score / 100, Main.frameWidth / 14 + Player.score / 50,
					Main.frameHeight / 10 + Player.score / 50, this);
			g.setColor(Color.BLACK);
			g.drawString("Score: " + player.getScore(), Main.frameWidth / 14, Main.frameHeight / 10);
			g.drawString("Health: " + player.getHealth(), Main.frameWidth / 14, Main.frameHeight / 8);
			g.drawString("Time left: " + Integer.toString(3000 - Board.timer % 3000), 10 * Main.frameWidth / 14,
					Main.frameHeight / 10);

		} else if (Board.STATE == "Menu") {
			g.drawImage(View.BackgroundFish, 0, 0, Main.frameWidth, Main.frameHeight, this);
			menu.render(g);
		} else if (Board.STATE == "Tutorial") {
			g.drawImage(View.TutorialBackground, 0, 0, Main.frameWidth, Main.frameHeight, this);
			g.drawImage(View.FishPlayerImage, Main.frameWidth / 35 + Main.frameWidth / 14,
					Main.frameHeight / 6 + Main.frameHeight / 12, Main.frameWidth / 10, Main.frameHeight / 8, this);
			g.drawImage(View.RedKnotPlayerImage, Main.frameWidth / 35 + Main.frameWidth / 14,
					2 * Main.frameHeight / 6 + Main.frameHeight / 12, Main.frameWidth / 10, Main.frameHeight / 8, this);
			g.drawImage(View.CrabPlayerImage, Main.frameWidth / 35 + Main.frameWidth / 14,
					3 * Main.frameHeight / 6 + Main.frameHeight / 12, Main.frameWidth / 10, Main.frameHeight / 8, this);
			tutorial.render(g);
		} else if (Board.STATE == "TutorialFish") {
			Rectangle menuButton = new Rectangle(5 * Main.frameWidth / 6, Main.frameHeight / 4 * 3, Main.frameWidth / 8,
					Main.frameHeight / 12);
			g.drawImage(View.BackgroundFish, -Board.timer % Main.frameWidth, 0, Main.frameWidth, Main.frameHeight,
					this);
			g.drawImage(View.BackgroundFish, Main.frameWidth - Board.timer % Main.frameWidth, 0, Main.frameWidth,
					Main.frameHeight, this);
			for (NPC o : obstacles) {
				if (o.getIsGarbage()) {
					g.drawImage(View.TrashNPCImages[o.image], o.getXloc(), o.getYloc(), Main.frameWidth / 14,
							Main.frameHeight / 10, null);
				} else {
					g.drawImage(View.FoodNPCImages[o.image], o.getXloc(), o.getYloc(), Main.frameWidth / 14,
							Main.frameHeight / 10, null);
				}
			}
			g.drawImage(View.FishPlayerImage, player.getXloc() - Player.score / 100,
					player.getYloc() - Player.score / 100, Main.frameWidth / 14 + Player.score / 50,
					Main.frameHeight / 10 + Player.score / 50, this);
			g.setColor(Color.BLACK);
			g.drawString("Score: " + player.getScore(), Main.frameWidth / 14, Main.frameHeight / 10);
			g.drawString("Health: " + player.getHealth(), Main.frameWidth / 14, Main.frameHeight / 8);
			g.drawString("Time left: " + Integer.toString(3000 - Board.timer % 3000), 10 * Main.frameWidth / 14,
					Main.frameHeight / 10);
			Font font1 = new Font("calibri", Font.BOLD, Main.frameHeight / 40);
			Font font2 = new Font("calibri", Font.BOLD, Main.frameHeight / 14);
			g.setFont(font1);
			g.drawString("Press up and down on the arrowkeys to move.", Main.frameWidth / 3, Main.frameHeight / 3);
			g.drawString("Avoid the pollution! Aim for the powerups and fish!", Main.frameWidth / 3,
					Main.frameHeight / 3 + Main.frameHeight / 12);

			g.drawString("One last thing, make sure to use lower-case letters when answering questions to get credit.",
					Main.frameWidth / 3, Main.frameHeight / 3 + Main.frameHeight / 6);

			g.drawString("Press the button in the bottom right when you are ready to play", Main.frameWidth / 3,
					2 * Main.frameHeight / 3 - Main.frameHeight / 12);

			g.drawString("You can't die in the tutorial, but if you hit two pieces of garbage for real...",
					Main.frameWidth / 4, 2 * Main.frameHeight / 3 + Main.frameHeight / 12);
			g.drawString("it's game over!", Main.frameWidth / 3, 2 * Main.frameHeight / 3 + Main.frameHeight / 7);
			g.setFont(font2);
			g.drawString("Got it!", (int) Math.round(menuButton.x + menuButton.getWidth() / 20),
					(int) Math.round(menuButton.y + 5 * menuButton.getHeight() / 7));
			Graphics2D g2d = (Graphics2D) g;
			g2d.draw(menuButton);
		} else if (Board.STATE == "Over") {
			g.drawImage(View.TutorialBackground, 0, 0, Main.frameWidth, Main.frameHeight, this);
			hiscores.render(g);
		} else if (Board.STATE == "Character") {
			g.drawImage(View.TutorialBackground, 0, 0, Main.frameWidth, Main.frameHeight, this);
			g.drawImage(View.FishPlayerImage, 4 * Main.frameWidth / 17 + Main.frameWidth / 32,
					Main.frameHeight / 3 + Main.frameHeight / 14, Main.frameWidth / 10, Main.frameHeight / 12, this);
			g.drawImage(View.CrabPlayerImage, 2 * 4 * Main.frameWidth / 17 + Main.frameWidth / 32,
					Main.frameHeight / 3 + Main.frameHeight / 14, Main.frameWidth / 10, Main.frameHeight / 12, this);
			g.drawImage(View.RedKnotPlayerImage, 3 * 4 * Main.frameWidth / 17 + Main.frameWidth / 32,
					Main.frameHeight / 3 + Main.frameHeight / 14, Main.frameWidth / 10, Main.frameHeight / 12, this);
			choice.render(g);
		}
	}

	/**
	 * Told the panel that it was updated, and is required.
	 */
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}

	@Override
	/**
	 * Handles the key-pressed event from the text field. Once a key is pressed,
	 * either up or down, the player will move accordingly in that direction.
	 * Prints out "Player has jumped to land, once a key is pressed.
	 */
	public void keyPressed(KeyEvent key) {
		int keyCode = key.getKeyCode();
		if (KeyEvent.VK_UP == keyCode)
			player.accelUp();
		if (KeyEvent.VK_DOWN == keyCode)
			player.accelDown();
		System.out.println("Player is moving with a velocity of " + player.getVerticalVelocity());
		repaint();
	}

	@Override
	/**
	 * Handle the key-released event from the text field.
	 */
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (KeyEvent.VK_UP == keyCode)
			player.stop();
		if (KeyEvent.VK_DOWN == keyCode)
			player.stop();
		System.out.println("Player has stopped moving");
		repaint();
	}

	@Override
	/**
	 * Handles the key typed event from the text field.
	 */
	public void keyTyped(KeyEvent e) {
		return;
	}
}
