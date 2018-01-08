package game;

import java.util.Random;

/**
 * @author Chris N. NPC extends character
 */
public class NPC extends Character {
	int image;
	int[] imagetype = { 1, 2, 3, 4, 5 };
	int value = 100;
	boolean isGarbage;
	int speed;

	/**
	 * Constructor for NPC sets a random imagetype sets the boolean isGarbage
	 * randomly sets the speed randomly between 2 and 4 sets the value to 100 or
	 * -100 depending on isGarbage sets a random lane between 1-5 sets yloc
	 * dependent on the lane (180,360,540,720,900) sets xloc to 650... full
	 * screen it is 1390
	 */
	public NPC() {
		;
		Random random = new Random();
		image = random.nextInt(2);
		isGarbage = random.nextBoolean();
		speed = 6 + random.nextInt(3);
		if (isGarbage)
			value = -100;
		lane = (int) (Math.random() * 5);
		yloc = (int) (lane * (Main.frameHeight / 5));
		xloc = Main.frameWidth - 50;
	}

	/**
	 * Moves the NPC to the left by speed pixels
	 */
	public void moveNPC() {
		xloc -= speed;
	}

	/**
	 * @return isGarbage, a boolean depending on the type of the NPC
	 */
	public boolean getIsGarbage() {
		return isGarbage;
	}

	/**
	 * @return value, the points value of the npc
	 */
	public int getValue() {
		return value;
	}

	/*
	 * @see game.Character#getXloc()
	 */
	public int getXloc() {
		return xloc;
	}

	/**
	 * toString method for any NPC
	 * 
	 * @return String describing the NPC and its location depending on if it is
	 *         garbage or food
	 */
	public String toString() {
		if (this.value == 100) {
			return "This food has lane:" + this.lane + " It's xloc is:" + this.xloc;
		} else {
			return "This garbage has lane:" + this.lane + " It's xloc is:" + this.xloc;
		}
	}
}
