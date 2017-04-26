package diceapp.labels;

import diceapp.score.PlayerScore;
import javafx.scene.control.Label;

public class TableScoreLabels {
	private Label firstTableScore;
	private Label secondTableScore;
	private Label tableScore;
	
	public TableScoreLabels(Label firstLabel, Label secondLabel, Label scoreLabel) {
		firstTableScore = firstLabel;
		secondTableScore = secondLabel;
		tableScore = scoreLabel;
	}
	
	public void updateViews(PlayerScore playerScore) {
		firstTableScore.setText(Integer.toString(playerScore.getFirstTableScore()));
        secondTableScore.setText(Integer.toString(playerScore.getSecondTableScore()));
        tableScore.setText(Integer.toString(playerScore.getScore()));
	}
	
}
