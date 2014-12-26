package Util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LevelDescriptionsTest {
	LevelDescriptions level;
	int chosenLevel = 2;
	@Before
	public void setUp() throws Exception {
		level = new LevelDescriptions();
	
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNumOfMoves() {
		assertTrue(level.getNumOfMove(chosenLevel)==25);
	}
	@Test
	public void testGoalScore() {
		assertTrue(level.getGoalScore(chosenLevel)== 250);
	}
	@Test
	public void testNumOfSpecialSwaps() {
		assertTrue(level.getNumOfSpecialSwaps(chosenLevel)==5);
	}
}
