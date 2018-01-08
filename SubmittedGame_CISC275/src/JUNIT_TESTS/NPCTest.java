package JUNIT_TESTS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import game.Main;
import game.NPC;

public class NPCTest {

	@Test
	public void testMoveNPC() {
		NPC n1 = new NPC();
		assertEquals("Get X Location before placed", 1390, n1.getXloc());
		int original = n1.getXloc();
		n1.moveNPC();
		int right = n1.getXloc();
		assertEquals("Test moving NPC", right, n1.getXloc());
		assertNotEquals("Test to see if NPC was not moved", original, n1.getXloc());
	}

	@Test
	public void testGetIsGarbage() {
		NPC n1 = new NPC();
		n1.getIsGarbage();
		int right = n1.getValue() * 1;
		int wrong = n1.getValue() * -1;
		assertEquals("Check to see if it is garbage or food boolean if it's wrong its opposite", right, n1.getValue());
		assertNotEquals("Check to see if it thinks the NPC is opposite of what it is", wrong, n1.getValue());
	}

	@Test
	public void testGetValue() {
		NPC n1 = new NPC();
		int right = n1.getValue();
		int wrong = n1.getValue() * -1;
		assertEquals("Get Value", right, n1.getValue());
		assertNotEquals("Get Value", wrong, n1.getValue());
		assertNotEquals("Get Value", 0, n1.getValue());
	}

	@Test
	public void testGetXloc() {
		NPC n1 = new NPC();
		assertEquals("Starting X Location", 1390, n1.getXloc());
		assertNotEquals("Not Starting X Location", Main.frameWidth - 450, n1.getXloc());
		assertNotEquals("Not Starting X Location", Main.frameWidth - 750, n1.getXloc());
	}

	@Test
	public void testToString() {
		NPC n1 = new NPC();
		if (n1.getIsGarbage()) {
			n1.toString();
			assertEquals("Test to string method", "This garbage has lane:" + n1.getLane() + " It's xloc is:1390",
					n1.toString());
		} else
			assertEquals("Test to string method", "This food has lane:" + n1.getLane() + " It's xloc is:1390",
					n1.toString());
	}
}
