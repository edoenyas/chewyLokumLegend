package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Set;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JPanel;

import Util.LevelDescriptions;
import Util.ScoreCalculator;
import Domain.Lokum;
import Game.State;

public class Board extends JPanel implements ActionListener {

	private int BoardWidth;
	private int BoardHeight;
	public Lokum firstPressedLokum;
	public Lokum secondPressedLokum;
	private int LokumWidth;
	private int LokumHeight;
	String combinationType;
	public int combinationCode;
	private State state;
	private int goalScore;
	public int numOfMoves;
	private int count = 0;
	public Lokum[][] boardState;
	public int remainingMoves;
	public Lokum last = new Lokum();
	public boolean isSpecialSwap = false;
	public int numOfSpecialSwaps;
	public int level;
	ScoreCalculator calc;
	LevelDescriptions levelchosen;

	public Board() {
		setFocusable(true);
		start();

	}

	public void start() {

		levelchosen = new LevelDescriptions();
		remainingMoves = levelchosen.getNumOfMove(level);
		goalScore = levelchosen.getGoalScore(level);
		numOfSpecialSwaps = levelchosen.getNumOfSpecialSwaps(level);
		calc = new ScoreCalculator();

		numOfMoves = 0;
		boardState = new Lokum[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				boardState[i][j] = generateRandomLokum(i, j);
				// task.getAppContext().put("Generated diagram image",
				// boardState[i][j]);
			}
		}
		// moveDown(boardState);

	}

	public void paint(Graphics g) {
		super.paint(g);

	}

	protected void swap(Lokum lokum1, Lokum lokum2) {

		if (isSpecialSwap == true) {
			Lokum tempLokum;

			tempLokum = lokum1;
			lokum1 = lokum2;
			lokum2 = tempLokum;

			if (isCombinationGenerated()) {

				numOfMoves++;
				calc.calculateCombinationScore(combinationCode);
				if (combinationType == "horiz") {

					destroyLokumsHoriz();
					numOfSpecialSwaps--;
				} else if (combinationType == "vertical") {
					destroyLokumsVert();
					numOfSpecialSwaps--;
				}
			} else {
				tempLokum = lokum1;
				lokum1 = lokum2;
				lokum2 = tempLokum;
			}

		}

		if (isAdjacent(lokum1, lokum2)) {
			Lokum tempLokum1;

			tempLokum1 = lokum1;
			lokum1 = lokum2;
			lokum2 = tempLokum1;

			if (isCombinationGenerated()) {

				numOfMoves++;
				calc.calculateCombinationScore(combinationCode);
				if (combinationType == "horiz") {

					destroyLokumsHoriz();
				} else {
					destroyLokumsVert();
				}
			} else {
				tempLokum1 = lokum1;
				lokum1 = lokum2;
				lokum2 = tempLokum1;
			}

		}

	}

	protected boolean hasDownMoves() {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (boardState[i][j] == null)
					return true;
			}
		}

		return false;
	}

	protected void moveDown() {

		while (hasDownMoves()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (boardState[i][j] == null) {
						if (i == 0) {
							boardState[0][j] = generateRandomLokum(i, j);
						} else {
							boardState[i][j] = boardState[i - 1][j];
							boardState[i - 1][j] = null;
						}
					}

				}
			}

		}

	}

	public Lokum generateRandomLokum(int x, int y) {
		int id;
		Lokum lok = new Lokum();
		Random rn = new Random();
		id = rn.nextInt(4) + 0;
		lok.setLokum(id, x, y);
		JButton loki = new JButton();

		loki.setBackground(Color.black);

		loki.setBounds(100 + (x * 10), 100 + (y * 10), 10, 10);
		loki.setVisible(true);

		lok.setButton(loki);

		return lok;

	}

	public void paint() {

	}

	protected boolean isAdjacent(Lokum lok1, Lokum lok2) {

		int x1 = lok1.getCoordX();
		int y1 = lok1.getCoordY();
		int x2 = lok2.getCoordX();
		int y2 = lok2.getCoordY();

		if (x1 == x2 && (y1 == (y2 + 1) || y1 == (y2 - 1))) {
			return true;
		} else if (y1 == y2 && (x1 == (x2 + 1) || x1 == (x2 - 1))) {
			return true;
		} else if (x1 == (x2 + 1) && y1 == (y2 - 1)) {
			return true;
		} else if (x1 == (x2 + 1) && y1 == (y2 + 1)) {
			return true;
		} else if (x1 == (x2 - 1) && y1 == (y2 + 1)) {
			return true;
		} else if (x1 == (x2 - 1) && y1 == (y2 - 1)) {
			return true;
		} else {
			return false;
		}

	}

	boolean isCombinationGenerated() {

		if (loopForHoriz() == true) {
			return true;
		} else {
			combinationCode = 0;
			combinationType = "";
			if (loopForVert() == true)
				return true;
		}
		return false;
	}

	boolean loopForHoriz() {
		int c = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if (j == 8 && c > 1) {
					last = boardState[i][j];
					combinationCode = c + 1;
					combinationType = "horiz";
					c = 0;
					return true;
				} else if (j == 8) {
					c = 0;
					continue;
				} else if (c == 4) {
					last = boardState[i][j];
					combinationCode = 5;
					combinationType = "horiz";
					c = 0;
					return true;
				} else if (boardState[i][j + 1] == null) {
					c = 0;
					continue;
				}
				// else if (c==4) {last=boardState[i][j-1];combinationCode=5;
				// combinationType = "horiz"; c=0; return true;}
				if (boardState[i][j].getLokumID() == boardState[i][j + 1]
						.getLokumID()) {
					c++;
				}

				else if (c > 1) {
					last = boardState[i][j];
					combinationCode = c + 1;
					combinationType = "horiz";
					c = 0;
					return true;
				} else {
					c = 0;
				}
			}
		}
		combinationCode = 0;
		return false;
	}

	boolean loopForVert() {
		int x = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (j == 8 && x > 1) {
					last = boardState[j][i];
					combinationCode = x + 1;
					combinationType = "vertical";
					x = 0;
					return true;
				} else if (j == 8) {
					x = 0;
					continue;
				} else if (boardState[j + 1][i] == null) {
					x = 0;
					continue;
				} else if (boardState[j][i] == null) {
					x = 0;
					continue;
				}

				else if (boardState[j][i].getLokumID() == boardState[j + 1][i]
						.getLokumID()) {
					x++;
				}

				else if (x > 1) {
					last = boardState[j][i];
					combinationCode = x + 1;
					combinationType = "vertical";
					x = 0;
					return true;
				} else {
					x = 0;
				}
			}
		}
		combinationCode = 0;
		return false;
	}

	// int c=0;
	// for (int i=0; i<9; i++) {
	// for (int j=0; j<9; j++) {
	// if (j==8 && c>1) {last=boardState[j][i];combinationCode = c+1;
	// combinationType = "vertical"; return true;}
	// else if(j==8) {c=0; continue;}
	// else if (boardState[j+1][i] == null) {c=0; continue;}
	// if(boardState[j][i].getLokumID() == boardState[j+1][i].getLokumID()) {
	// c++;}
	// else if(c>1) {last=boardState[j][i];combinationCode=c+1; combinationType
	// = "vertical"; return true;}
	// else {c=0;}}}return false;}

	// boolean loopForDiagon(Lokum[][] bs) {
	// int c=0;
	// for (int i=0; i<9; i++) {
	// {
	// if (i==8 && c>1){last=boardState[i][i];combinationCode=c+1;
	// combinationType = "diagonal"; c=0; return true;}
	// else if(i==8) return false;
	// if(bs[i][i].getLokumID() == bs[i+1][i+1].getLokumID()) {
	// c++;}
	// else if(c>1) {last=boardState[i][i];combinationCode=c+1; combinationType
	// = "diagonal"; c=0; return true;}
	// else {c=0;}}}return false;}
	//
	//

	void destroyLokumAt(Lokum[][] bs, int x, int y) {
		bs[x][y] = null;
	}

	void destroyLokumsHoriz() {

		if (combinationType.equals("horiz")) {
			int x1 = last.getCoordX();
			int y1 = last.getCoordY();

			System.out.println("x1 : " + x1 + ", y1 : " + y1 + " cod : "
					+ combinationCode + ", " + combinationType);
			if (combinationCode == 3) {
				boardState[x1][y1] = null;
				boardState[x1][y1 - 1] = null;
				boardState[x1][y1 - 2] = null;

			} else if (combinationCode == 4) {
				boardState[x1][y1] = null;
				boardState[x1][y1 - 1] = null;
				boardState[x1][y1 - 2] = null;
				boardState[x1][y1 - 3] = null;

			} else if (combinationCode == 5) {
				boardState[x1][y1] = null;
				boardState[x1][y1 - 1] = null;
				boardState[x1][y1 - 2] = null;
				boardState[x1][y1 - 3] = null;
				boardState[x1][y1 - 4] = null;

			} else
				return;

		}
	}

	void destroyLokumsVert() {
		if (combinationType.equals("vertical")) {
			int x1 = last.getCoordX();
			int y1 = last.getCoordY();
			System.out.println("x1 : " + x1 + ", y1 : " + y1 + " cod : "
					+ combinationCode + ", " + combinationType);

			if (combinationCode == 3) {
				boardState[x1][y1] = null;
				boardState[x1 - 1][y1] = null;
				boardState[x1 - 2][y1] = null;

			} else if (combinationCode == 4) {
				boardState[x1][y1] = null;
				boardState[x1 - 1][y1] = null;
				boardState[x1 - 2][y1] = null;
				boardState[x1 - 3][y1] = null;

			} else if (combinationCode == 5) {
				boardState[x1][y1] = null;
				boardState[x1 - 1][y1] = null;
				boardState[x1 - 2][y1] = null;
				boardState[x1 - 3][y1] = null;
				boardState[x1 - 4][y1] = null;
			} else
				return;

		}

	}

	void updateState() {

		while (isCombinationGenerated() == true) {

			if (combinationType == "horiz") {
				destroyLokumsHoriz();
				moveDown();

			} else {
				combinationType = "";
				combinationCode = 0;
				if (combinationType == "vertical") {

					destroyLokumsVert();
					moveDown();
				}
			}
			return;

		}
		return;
	}

	//
	// private boolean checkLevelCompletion() {
	//
	// if (goalScore == state.currentScore) {
	// return true;
	// }else return false;
	//
	// }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public int getNumOfMoves() {
		return numOfMoves;
	}

}
