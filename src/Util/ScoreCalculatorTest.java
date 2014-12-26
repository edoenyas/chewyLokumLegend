package Util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ScoreCalculatorTest {
	
	ScoreCalculator calc;

	@Before
	public void setUp() throws Exception {
		calc = new ScoreCalculator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test3() {
		assertTrue(calc.calculateCombinationScore(3)==10);
	}
	@Test
	public void test4() {
		assertTrue(calc.calculateCombinationScore(4)==15);
	}

	@Test
	public void test5() {
		assertTrue(calc.calculateCombinationScore(5)==25);
	}
	
	public void test6() {
		calc.calculateCombinationScore(4);
		assertTrue(calc.calculateCombinationScore(5)==40);
	}
	public void test7() {
		calc.calculateCombinationScore(4);
		calc.calculateCombinationScore(3);
		calc.calculateCombinationScore(4);
		assertTrue(calc.calculateCombinationScore(5)==65);
	}


}
