package JUNIT_TESTS;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Main;
import game.Player;
import game.Board;
import game.Character;

public class PlayerTest {

	// Tests Player and Character Class

	@Test
	public void testJumpUp() {
		Player p1 = new Player();
		assertEquals("Move Up 1 to lane 3", 3, p1.getLane());
		p1.jumpUp();
		p1.Move();
		assertEquals("Move Up 1 to lane 4", 4, p1.getLane());
		p1.jumpUp();
		p1.Move();
		assertEquals("Move Up 1 to lane 5", 5, p1.getLane());
		p1.jumpUp();
		p1.Move();
		assertEquals("Move Up 1 to lane 5", 5, p1.getLane());
	}

	@Test
	public void testJumpDown() {
		Player p1 = new Player();
		assertEquals("Move Down 1 to lane 3", 3, p1.getLane());
		p1.jumpDown();
		p1.Move();
		assertEquals("Move Down 1 to lane 2", 2, p1.getLane());
		p1.jumpDown();
		p1.Move();
		assertEquals("Move Down 1 to lane 1", 1, p1.getLane());
		p1.jumpDown();
		p1.Move();
		assertEquals("Move Down 1 to lane 1", 1, p1.getLane());
	}

	@SuppressWarnings("static-access")
	@Test
	public void testEatFood() {
		Board b1 = new Board();
		b1.reset();
		Player p1 = new Player();
		assertEquals("0", 0, p1.getScore());
		p1.eatFood();
		p1.changeScore(100);
		assertEquals("100", 100, p1.getScore());
		p1.eatFood();
		p1.changeScore(100);
		assertEquals("200", 200, p1.getScore());
		p1.eatFood();
		p1.changeScore(100);
		assertEquals("300", 300, p1.getScore());
	}

	@Test
	public void testGetScore() {
		Player p1 = new Player();
		p1.getHealth();
		assertEquals("Check Damage", 10, p1.getHealth());
		assertNotEquals("Check Damage", 5, p1.getHealth());
		assertNotEquals("Check Damage", 0, p1.getHealth());
		p1.takeDamage(-5);
		p1.getHealth();
		assertEquals("Check Damage", 5, p1.getHealth());
		assertNotEquals("Check Damage", 10, p1.getHealth());
		assertNotEquals("Check Damage", 0, p1.getHealth());
		assertNotEquals("Check Damage", 15, p1.getHealth());
		p1.takeDamage(-5);
		p1.getHealth();
		assertEquals("Check Damage", 0, p1.getHealth());
		assertNotEquals("Check Damage", 10, p1.getHealth());
		assertNotEquals("Check Damage", 5, p1.getHealth());
		assertNotEquals("Check Damage", 20, p1.getHealth());
	}

	@Test
	public void testToString() {
		Player p1 = new Player();
		/*
		 * p1.toString(); assertEquals("Test to see if model is X (Player)",
		 * "This player has lane:3 Their score is:0 Player Health:10"
		 * ,p1.toString()); p1.takeDamage(-5); p1.changeScore(-100);
		 * p1.getScore(); p1.getHealth(); p1.toString(); assertEquals(
		 * "Test to see if model is X (Player)",
		 * "This player has lane:3 Their score is:-100 Player Health:5"
		 * ,p1.toString());
		 */
		/// *p1.toString();
		assertEquals("Test to see if model is X (Player)",
				"This player at location 360, their score is 0, and they have 10 hit points.", p1.toString());
		p1.eatFood();
		p1.changeScore(100);
		p1.eatFood();
		p1.changeScore(100);
		p1.getScore();
		p1.jumpUp();
		p1.Move();
		assertEquals("Test to see if model is X (Player)",
				"This player at location 180, their score is 200, and they have 10 hit points.", p1.toString());
		p1.jumpDown();
		p1.jumpDown();
		p1.jumpDown();
		p1.Move();
		p1.eatFood();
		p1.eatFood();
		p1.changeScore(100);
		p1.getScore();
		p1.takeDamage(-5);
		p1.changeScore(-100);
		p1.getScore();
		p1.getHealth();
		assertEquals("Test to see if model is X (Player)",
				"This player at location 720, their score is 200, and they have 5 hit points.", p1.toString());
		p1.jumpDown();
		p1.Move();
		p1.eatFood();
		p1.changeScore(100);
		p1.getScore();
		assertEquals("Test to see if model is X (Player)",
				"This player at location 720, their score is 300, and they have 5 hit points.", p1.toString());
		p1.takeDamage(-5);
		p1.changeScore(-100);
		p1.getHealth();
		System.out.println(p1.toString());
		assertEquals("Test to see if model is X (Player)",
				"This player at location 720, their score is 200, and they have 0 hit points.", p1.toString());
		// */
	}

	@Test
	public void testGetXLoc() {
		Player p1 = new Player();
		assertEquals("Test Starting X Location of Player", Main.frameWidth - (Main.frameWidth - Main.frameWidth / 12),
				p1.getXloc());
		assertEquals("Test Starting X Location of Player", 120, p1.getXloc());
		assertNotEquals("Test Wrong Starting X Location of Player", Main.frameWidth - 750, p1.getXloc());
		assertNotEquals("Test Wrong Starting X Location of Player", Main.frameWidth - 550, p1.getXloc());
		assertNotEquals("Test Wrong Starting X Location of Player", 0, p1.getXloc());
		p1.setXloc(Main.frameWidth - 600);
		p1.getXloc();
		assertEquals("Test STarting X Location of Player", 840, p1.getXloc());
	}

	@Test
	public void testGetLane() {
		Player p1 = new Player();
		assertEquals("Start Lane", 3, p1.getLane());
		assertNotEquals("Start Lane", 2, p1.getLane());
		assertNotEquals("Start Lane", 4, p1.getLane());
		assertNotEquals("Start Lane", 1, p1.getLane());
		assertNotEquals("Start Lane", 5, p1.getLane());
		p1.jumpUp();
		assertEquals("Move Up to Lane 4", 4, p1.getLane());
		assertNotEquals("Doesn't move ", 3, p1.getLane());
	}

	@Test
	public void testGetYLoc() {
		Player p1 = new Player();
		assertEquals("Test get Y location at original", 360, p1.getYloc());
		p1.setYloc(2 * (Main.frameHeight / 5) + 5);
		p1.getYloc();
		assertEquals("+5 from original Y location", 365, p1.getYloc());
	}

	@Test
	public void testSetScore() {
		Player p1 = new Player();
		p1.setScore(0);
		assertEquals("Score should be 0", 0, p1.getScore());
		p1.setScore(100);
		assertEquals("Score should be 100", 100, p1.getScore());
	}

	@Test
	public void testTakeDamage() {
		Player p1 = new Player();
		assertEquals("Score should be 10", 10, p1.getHealth());
		p1.takeDamage(-5);
		p1.getHealth();
		assertEquals("Score should be 5", 5, p1.getHealth());
		p1.takeDamage(-5);
		p1.getHealth();
		assertEquals("Score should be 0", 0, p1.getHealth());

	}

	public void testChangeScore() {
		Player p1 = new Player();
		assertEquals("Score is 0", 0, p1.getScore());
		p1.changeScore(-100);
		assertEquals("Score is -100", -100, p1.getScore());
		p1.changeScore(100);
		assertEquals("Score is 0", 0, p1.getScore());
		p1.changeScore(100);
		assertEquals("Score is 100", 100, p1.getScore());
		assertEquals("Score is NOT 200", 200, p1.getScore());
		assertEquals("Score is NOT 0", 0, p1.getScore());
		p1.changeScore(100);
		assertEquals("Score is 200", 200, p1.getScore());
		assertEquals("Score is NOT 300", 300, p1.getScore());
		assertEquals("Score is NOT 100", 100, p1.getScore());
		assertEquals("Score is NOT 0", 0, p1.getScore());
	}

	@Test
	public void testGetXLocChar() {
		Character c1 = new Character();
		c1.setXloc(Main.frameWidth - 650);
		assertEquals("Starting X Location", 790, c1.getXloc());
		assertNotEquals("Not Starting X Location", Main.frameWidth - 450, c1.getXloc());
		assertNotEquals("Not Starting X Location", Main.frameWidth - 750, c1.getXloc());
		c1.setXloc(50);
		assertEquals("Starting X Location", 50, c1.getXloc());
		assertNotEquals("Not Starting X Location", 0, c1.getXloc());
		assertNotEquals("Not Starting X Location", 49.95, c1.getXloc());
		assertNotEquals("Not Starting X Location", 50.05, c1.getXloc());
	}

	@Test
	public void testGetYLocChar() {
		Character c1 = new Character();
		c1.setYloc(2 * (Main.frameHeight / 5)); // starting player position
		assertEquals("Starting Y Location", 360, c1.getYloc());
		c1.setYloc(2 * (Main.frameHeight / 5) + 5);
		assertEquals("Starting Y Location", 365, c1.getYloc());
		assertNotEquals("NOT Starting Y Location", 0, c1.getYloc());
		assertNotEquals("NOT Starting Y Location", 2 * (Main.frameHeight / 5) - 5, c1.getYloc());
	}

	@Test
	public void testSetXLocChar() {
		Character c1 = new Character();
		c1.setXloc(Main.frameWidth - 650);
		assertEquals("Starting X Location", 790, c1.getXloc());
		assertNotEquals("Not Starting X Location", Main.frameWidth - 450, c1.getXloc());
		assertNotEquals("Not Starting X Location", Main.frameWidth - 750, c1.getXloc());
		c1.setXloc(50);
		assertEquals("Starting X Location", 50, c1.getXloc());
		assertNotEquals("Not Starting X Location", 0, c1.getXloc());
		assertNotEquals("Not Starting X Location", 49.95, c1.getXloc());
		assertNotEquals("Not Starting X Location", 50.05, c1.getXloc());
	}

	@Test
	public void testSetYLocChar() {
		Character c1 = new Character();
		c1.setYloc(45);
		assertEquals("Starting Y Location, 45", 45, c1.getYloc());
		assertNotEquals("NOT Starting Y Location", 0, c1.getYloc());
		assertNotEquals("NOT Starting Y Location", 50, c1.getYloc());
		assertNotEquals("NOT Starting Y Location", 2 * (Main.frameHeight / 5), c1.getYloc());
		c1.setYloc(0);
		assertEquals("Starting Y Location, 0", 0, c1.getYloc());
	}
}