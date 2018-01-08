package game;

/**
 * @author ericallen Attributes: xloc, yloc, lane
 */
public class Character {
	int xloc;
	int yloc;
	int lane;

	/**
	 * Character constructor.
	 */
	public Character() {
	}

	/**
	 * get lane position
	 * 
	 * @return lane
	 */
	public int getLane() {
		return this.lane;
	}

	/**
	 * set x location
	 * 
	 * @param xloc
	 */
	public void setXloc(int xloc) {
		this.xloc = xloc;
	}

	/**
	 * set y location
	 * 
	 * @param yloc
	 */
	public void setYloc(int yloc) {
		this.yloc = yloc;

	}

	/**
	 * get x location
	 * 
	 * @return xloc
	 */
	public int getXloc() {
		return this.xloc;
	}

	/**
	 * get's y location
	 * 
	 * @return yloc
	 */
	public int getYloc() {
		return this.yloc;
	}

	/**
	 * It moves
	 */
	public void Move() {
	}
}
