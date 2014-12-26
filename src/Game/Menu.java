package Game;

import javax.swing.JLabel;

public class Menu {
	
	private JLabel scoreLabel;
	private JLabel remainingMove;
	private JLabel targetLabel;

	public Menu(int remainingMove, int target) {
		setScoreLabel(0+"");
		setRemainingMove(remainingMove+"");
		setTargetLabel(target+"");
	}

	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	public void setScoreLabel(String score) {
		this.scoreLabel.setText(score);
	}

	public JLabel getRemainingMove() {
		return remainingMove;
	}

	public void setRemainingMove(String remainingMove) {
		this.remainingMove.setText(remainingMove);
	}

	public JLabel getTargetLabel() {
		return targetLabel;
	}

	public void setTargetLabel(String target) {
		this.targetLabel.setText(target);
	}

}
