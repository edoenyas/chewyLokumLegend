package Util;

public class LevelDescriptions {

	private int[] goalScores = new int[3];
	private int [] numOfMoves = new int[3];
	private int [] numOfSpecialSwaps = new int[3];
	//private static LevelDescriptions levelDescriptions;
	
	public LevelDescriptions(){
		goalScores[1] = 100;
		goalScores[2] = 250;
		numOfMoves[1] = 20;
		numOfMoves[2] = 25;
		numOfSpecialSwaps[1] = 4;
		numOfSpecialSwaps[2] = 5;
		
	}
	
	

	public int getGoalScore(int level) {
		return goalScores[level];
	}

	public int getNumOfMove(int level) {
		return numOfMoves[level];
	}
	
	public int getNumOfSpecialSwaps(int level) {
		return numOfSpecialSwaps[level];
	}
	

}
