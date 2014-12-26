package Game;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Domain.Lokum;

public class BoardTest {

	private static Lokum lokum1, lokum2;
	Board board;

	@Before
	public void setUp() throws Exception {
		lokum1 = new Lokum();
		lokum2 = new Lokum();
		board = new Board();

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	/** 
	 * Test method for {@link Board#destroyLokumsHoriz()}
	 */
	public void testDestroyLokumsHoriz() {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.println("ID :" + board.boardState[i][j].getLokumID()
						+ "(" + i + "," + j + ")");
			}
		}
		board.combinationCode = 4;
		board.combinationType = "horiz";
		board.last = board.boardState[3][5];
		board.destroyLokumsHoriz();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board.boardState[i][j] != null) {
					System.out.println("ID :"
							+ board.boardState[i][j].getLokumID() + "(" + i
							+ "," + j + ")");
				} else {
					System.out.println("null");
				}
			}
		}

		assertTrue(board.boardState[3][5] == null
				&& board.boardState[3][4] == null
				&& board.boardState[3][3] == null
				&& board.boardState[3][2] == null);
	}

	@Test
	/** 
	 * Test method for {@link Board#destroyLokumsVert()}
	 */
	public void testDestroyLokumsVert() {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.println("ID :" + board.boardState[i][j].getLokumID()
						+ "(" + i + "," + j + ")");
			}
		}
		board.combinationCode = 4;
		board.combinationType = "vertical";
		board.last = board.boardState[5][3];
		board.destroyLokumsVert();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board.boardState[i][j] != null) {
					System.out.println("ID :"
							+ board.boardState[i][j].getLokumID() + "(" + i
							+ "," + j + ")");
				} else {
					System.out.println("null");
				}
			}
		}

		assertTrue(board.boardState[5][3] == null
				&& board.boardState[4][3] == null
				&& board.boardState[3][3] == null
				&& board.boardState[2][3] == null);
	}

	@Test
	/** 
	 *
	 */
	public void testNull() {

		assertTrue(board.boardState[8][8] != null);
	}

	@Test
	/** 
	 * Test method for {@link Board#isAdjacent()}
	 */
	public void testIsAdjacent1() {
		lokum1 = board.boardState[2][3];
		lokum2 = board.boardState[2][4];
		assertTrue(board.isAdjacent(lokum1, lokum2) == true);
	}

	@Test
	/** 
	 * Test method for {@link Board#isAdjacent()}
	 */
	public void testIsAdjacent2() {
		lokum1 = board.boardState[2][3];
		lokum2 = board.boardState[2][2];
		assertTrue(board.isAdjacent(lokum1, lokum2) == true);
	}

	@Test
	/** 
	 * Test method for {@link Board#isAdjacent()}
	 */
	public void testIsAdjacent3() {
		lokum1 = board.boardState[2][3];
		lokum2 = board.boardState[3][3];
		assertTrue(board.isAdjacent(lokum1, lokum2) == true);
	}

	@Test
	/** 
	 * Test method for {@link Board#isAdjacent()}
	 */
	public void testIsAdjacent4() {
		lokum1 = board.boardState[2][3];
		lokum2 = board.boardState[2][5];
		assertTrue(board.isAdjacent(lokum1, lokum2) == false);
	}

	@Test
	/** 
	 * Test method for {@link Board#isAdjacent()}
	 */
	public void testIsAdjacent5() {
		lokum1 = board.boardState[2][2];
		lokum2 = board.boardState[3][3];
		assertTrue(board.isAdjacent(lokum1, lokum2) == true);
	}

	@Test
	/**
	 * Test method for {@link Boar#loopForVert()}
	 */
	public void testLoopForVert() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.println("id :" + board.boardState[i][j].getLokumID()
						+ "coords (" + i + "," + j + ")");

			}
		}
		while (board.loopForVert() == true) {
			board.destroyLokumsVert();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (board.boardState[i][j] == null) {
						System.out.println("null");
					} else
						System.out.println("id :"
								+ board.boardState[i][j].getLokumID()
								+ "coords (" + i + "," + j + ")");

				}
			}
		}
		assertTrue(board.combinationType == "vertical");

	}

	@Test
	/** 
	 * Test method for {@link Board#hasDownMoves()}
	 */
	public void testHasDownMoves1() {
		board.boardState[2][2] = null;
		assertTrue(board.hasDownMoves() == true);

		// fail("Not yet implemented");
	}

	@Test
	/** 
	 * Test method for {@link Board#hasDownMoves(Lokum[][])}
	 */
	public void testHasDownMoves2() {
		board.boardState[7][2] = null;
		assertTrue(board.hasDownMoves() == true);

		// fail("Not yet implemented");
	}

	@Test
	/** 
	 * Test method for {@link Board#moveDown(Lokum[][])}
	 */
	public void testMoveDown1() {
		board.boardState[2][2] = null;
		board.moveDown();
		assertTrue(board.hasDownMoves() == false);

		// fail("Not yet implemented");
	}

	@Test
	/** 
	 * Test method for {@link Board#moveDown(Lokum[][])}
	 */
	public void testMoveDown2() {
		board.boardState[2][3] = null;
		board.boardState[2][4] = null;
		board.boardState[2][5] = null;

		board.moveDown();
		assertTrue(board.hasDownMoves() == false);

		// fail("Not yet implemented");
	}

	@Test
	/** 
	 * Test method for {@link Board#moveDown(Lokum[][])}
	 */
	public void testMoveDown3() {
		board.destroyLokumAt(board.boardState, 2, 2);
		board.moveDown();
		assertTrue(board.boardState[2][2] != null);

		// fail("Not yet implemented");
	}

	@Test
	/** 
	 * Test method for {@link Board#isCombinationGenerated(Lokum[][])}
	 */
	public void testIsCombinationGenerated() {

		lokum1 = board.boardState[0][5];
		lokum1.setLokumID(0);
		lokum2 = board.boardState[0][6];
		lokum2.setLokumID(0);
		Lokum lokum3 = new Lokum();
		lokum3 = board.boardState[0][7];
		lokum3.setLokumID(0);

		assertTrue(board.isCombinationGenerated());

	}

	@Test
	/** 
	 * Test method for {@link Board#loopForHoriz(Lokum[][])}
	 */
	public void testLoopForHoriz() {
		// board.boardState[5][1].setLokumID(0);
		// board.boardState[5][2].setLokumID(0);
		// board.boardState[5][3].setLokumID(0);
		lokum1 = board.boardState[5][1];
		lokum1.setLokumID(0);
		lokum2 = board.boardState[5][2];
		lokum2.setLokumID(0);
		Lokum lokum3 = new Lokum();
		lokum3 = board.boardState[5][3];
		lokum3.setLokumID(0);
		// for (int i=0; i<9; i++) {
		// for (int j=0; j<9; j++) {
		// System.out.println("id : " + board.boardState[i][j].getLokumID() +
		// " (" + i + "," + j +")" );
		// }}
		//
		// while(board.loopForHoriz(board.boardState)){
		// board.destroyLokumAthor(board.boardState, "horiz",
		// board.combinationCode);
		// if (board.hasDownMoves(board.boardState)){
		// board.moveDown(board.boardState);
		// }else continue;}
		// for (int i=0; i<9; i++) {
		// for (int j=0; j<9; j++) {
		// System.out.println("id : " + board.boardState[i][j].getLokumID() +
		// " (" + i + "," + j +")" );
		// }}

		//
		assertTrue(board.loopForHoriz() == true);

	}

	// @Test
	// /**
	// * Test method for {@link Board#loopForVert(Lokum[][])}
	// */
	// public void testLoopForVert() {
	// // board.boardState[6][0].setLokumID(0);
	// // board.boardState[7][0].setLokumID(0);
	// // board.boardState[8][0].setLokumID(0);
	// // lokum3.setLokumID(0);
	// for (int i=0; i<9; i++) {
	// for (int j=0; j<9; j++) {
	// System.out.println("id : " + board.boardState[i][j].getLokumID() + " (" +
	// i + "," + j +")" );
	// }}
	//
	// while(board.loopForVert()){
	// board.destroyLokums();
	//
	// if (board.hasDownMoves()){
	// board.moveDown();
	//
	// }else continue;}
	// for (int i=0; i<9; i++) {
	// for (int j=0; j<9; j++) {
	// System.out.println("id : " + board.boardState[i][j].getLokumID() + " (" +
	// i + "," + j +")" );
	// }}
	//
	//
	// assertTrue(board.loopForVert()==false);
	// //System.out.println("combination type :" + board.combinationType);
	// }

	@Test
	/** 
	 * Test method for {@link Board#swap(Lokum[][],Lokum,Lokum)}
	 */
	public void testSwap1() {

		lokum1 = board.boardState[6][0];
		lokum2 = board.boardState[6][2];
		Lokum lokum3;

		Lokum lokum4;
		lokum4 = board.boardState[6][1];
		lokum3 = board.boardState[6][3];
		lokum1.setLokumID(0);
		lokum2.setLokumID(0);
		lokum3.setLokumID(0);
		lokum4.setLokumID(1);

		board.swap(lokum1, lokum4);
		assertTrue(board.boardState[6][3] == null
				&& board.boardState[6][1] == null
				&& board.boardState[6][2] == null);

		// fail("Not yet implemented");
	}

	@Test
	/** 
	 * Test method for {@link Board#swap(Lokum[][],Lokum,Lokum)}
	 */
	public void testSwap2() {
		lokum1 = board.boardState[2][3];
		lokum2 = board.boardState[3][5];

		board.swap(lokum1, lokum2);
		assertTrue(lokum1.getCoordX() == 2 && lokum1.getCoordY() == 3);

		// fail("Not yet implemented");
	}

	@Test
	/** 
	 * Test method for {@link Board#swap(Lokum[][],Lokum,Lokum)}
	 */
	public void testSwap3() {
		lokum1 = board.boardState[2][1];
		lokum2 = board.boardState[3][3];

		Lokum lokum3 = new Lokum();
		lokum3 = board.boardState[2][2];
		Lokum lokum4 = new Lokum();
		lokum4 = board.boardState[4][4];
		lokum1.setLokumID(1);
		lokum2.setLokumID(1);
		lokum4.setLokumID(1);
		board.swap(lokum1, lokum3);
		assertTrue(board.boardState[2][2] == null);

		// fail("Not yet implemented");
	}

	@Test
	/** 
	 * Test method for {@link Board#updateState()}
	 */
	public void testUpdateState() {
		// lokum1 = board.boardState[2][1];
		// lokum2 = board.boardState[3][3];
		//
		// Lokum lokum3 = new Lokum();
		// lokum3 = board.boardState[2][2];
		// Lokum lokum4 = new Lokum();
		// lokum4 = board.boardState[4][4];
		// lokum1.setLokumID(1);
		// lokum2.setLokumID(1);
		// lokum4.setLokumID(1);
		// board.swap(board.boardState,lokum1,lokum3);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.println("id : "
						+ board.boardState[i][j].getLokumID() + " (" + i + ","
						+ j + ")");
			}
		}

		while (board.loopForHoriz() == true) {
			board.destroyLokumsHoriz();
			board.moveDown();

		}

		//
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board.boardState[i][j] == null) {
					System.out.println("null");
				} else
					System.out.println("id : "
							+ board.boardState[i][j].getLokumID() + " (" + i
							+ "," + j + ")");
			}
		}
		assertTrue(board.loopForHoriz() == false);

		// fail("Not yet implemented");
	}

	@Test
	/** 
	 * Test method for {@link Board#start()}
	 */
	public void testStart1() {

		assertTrue(board.remainingMoves == 25);
	}

	@Test
	/** 
	 * Test method for {@link Board#start()}
	 */
	public void testStart2() {

		assertTrue(board.numOfSpecialSwaps == 5);
	}

	@Test
	/** 
	 * Test method for {@link Board#start()}
	 */
	public void testStart3() {

		assertTrue(board.hasDownMoves() == false);
	}

}
