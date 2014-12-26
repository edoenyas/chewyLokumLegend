package Game;

import Domain.Lokum;



public class State {
	
	public static int remainingMoves;
	public Lokum[][] boardState;
	public static int currentScore;
	
	
	public Lokum[][] getBoardState() {
		return boardState;
	}

	public void setBoardState(Lokum[][] boardState) {
		this.boardState = boardState;
	}

	public void setRemainingMoves(int remainingMoves) {
		this.remainingMoves = remainingMoves;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	public int getCurrentScore() {
		
		return currentScore;
	}
	
	public int getRemainingMoves() {
		
		return remainingMoves;
	}
	
	
	

}
