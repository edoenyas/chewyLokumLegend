package Util;

public class ScoreCalculator {

	private static ScoreCalculator calculator;
	int score =0;

	public ScoreCalculator(){}



	public int calculateCombinationScore(int combinationCode) {
		
			if (combinationCode == 3){
				score += 10;
			} else if (combinationCode == 4) {
				score += 15;
			} else if (combinationCode == 5) {
				score += 25;
			} 
		
		return score;
	}

	
}
