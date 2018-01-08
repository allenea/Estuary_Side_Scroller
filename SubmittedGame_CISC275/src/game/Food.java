package game;

/**
 * @author ericallen
 */
public class Food extends NPC {

	/**
	 * Food sets value 100 for the NPC class.
	 */
	public Food() {
		value = 100;
	}

	/*
	 * @see game.NPC#getValue() Returns value for food
	 */
	public int getValue() {
		return value;
	}
}
