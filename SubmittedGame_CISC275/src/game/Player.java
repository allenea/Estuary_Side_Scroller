package game;

/**
 * @author ericallen 
 * player attributes: score, health, food, verticalVelocity and isAccel
 */
public class Player extends Character {
	static int score = 0;
	int health = 10;
	int food = 0;
	int verticalVelocity;
	boolean isAccel;

	/**
	 * Creates an instance of a player, with attributes xloc,yloc, and lane
	 */
	public Player() {
		xloc = (int) (Main.frameWidth - (Main.frameWidth - Main.frameWidth / 12));
		yloc = (int) (2 * (Main.frameHeight / 5));
		lane = 3;
	}

	/**
	 * moves the character and updates velocity if a key is still held
	 */
	public void updateMovement() {
		if (!isAccel) {
			if (verticalVelocity > 0) {
				verticalVelocity -= 1;
				return;
			}
			if (verticalVelocity < 0) {
				verticalVelocity += 1;
				return;
			}
		}
		if (isAccel)
			accel();
		yloc += verticalVelocity;
		if (yloc >= Main.frameHeight - Main.frameHeight / 6) {
			yloc = Main.frameHeight - (Main.frameHeight / 6);
		}
		if (yloc <= 0) {
			yloc = 0;
		}
	}

	/**
	 * Getter for player health, returns an int
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Increments the number of food that this object has "eaten"
	 */
	public void eatFood() {
		this.food++;
	}

	/**
	 * move upwards
	 */
	public void accelUp() {
		verticalVelocity = -5;
		isAccel = true;
	}

	/**
	 * move downwards
	 */
	public void accelDown() {
		verticalVelocity = 5;
		isAccel = true;
	}

	/**
	 * sets acceleration of vertical Velocity
	 */
	public void accel() {
		if (verticalVelocity < 6)
			verticalVelocity += 2;
		if (verticalVelocity > -6)
			verticalVelocity += -2;
	}

	/**
	 * stop acceleration sets to false
	 */
	public void stop() {
		isAccel = false;
	}

	/**
	 * checks to see if there is a lane above the player. if there is, moves
	 * them up into that lane/increments lane, and updates yloc returns void
	 */
	public void jumpUp() {
		if (lane < 5) {
			lane++;
			yloc = Main.frameHeight - (lane * (Main.frameHeight / 5));
		}
	}

	/**
	 * checks to see if there is a lane under the player. if there is, moves
	 * them down into that lane/decrements lane, and updates yloc returns void
	 */
	public void jumpDown() {
		if (lane > 1) {
			lane--;
			yloc = Main.frameHeight - (lane * (Main.frameHeight / 5));
		}
	}

	/**
	 * getter of x location (non-Javadoc)
	 * 
	 * @see game.Character#getXloc()
	 * @return xloc
	 */
	public int getXloc() {
		return xloc;
	}

	/**
	 * getScore returns the current player objects score
	 */
	public int getScore() {
		return Player.score;
	}

	/**
	 * @param int
	 *            i is the score you want to set for the current player
	 */
	public void setScore(int i) {
		Player.score = i;
	}

	/**
	 * @param changes
	 *            current player objects score by the given value input
	 */
	public void changeScore(int value) {
		score += value;
		if (score <= 0) {
			score = 0;
		}
	}

	/**
	 * @param Decrements
	 *            health. dmg is the amount you decrement the current player
	 *            objects health by
	 */
	public void takeDamage(int dmg) {
		health += dmg;
		if (health <= 0) {
			health = 0;
		}
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "This player at location " + this.yloc + ", their score is " + Player.score + ", and they have "
				+ this.health + " hit points.";
	}

	/**
	 * @return verticalVelocity
	 */
	public int getVerticalVelocity() {
		return verticalVelocity;
	}
}
