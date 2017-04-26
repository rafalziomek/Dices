package diceapp.score;

import diceapp.controllers.MoveController;
import diceapp.labels.TableScoreLabels;
import diceapp.strategies.StrategyType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class PlayerScoreUpdater {
	
	private PlayerScore playerScore;
	private MoveController moveController;
	private TableScoreLabels tableScoreLabels;
	public PlayerScoreUpdater(PlayerScore playerScore, MoveController moveController, TableScoreLabels scoreLabels) {
		this.playerScore = playerScore;
		this.moveController = moveController;
		this.tableScoreLabels = scoreLabels;
	}
	public void update(StrategyType strategy, CheckBox checkBox) {
		saveScore(strategy);
		updateViewScore(checkBox);
		tableScoreLabels.updateViews(playerScore);
	}

	private void saveScore(StrategyType strategy) {
		playerScore.saveScore(strategy, moveController.getResult());
	}
	
	private void updateViewScore(CheckBox checkBox) {
		checkBox.setText(Integer.toString(playerScore.getLastScore()));
	}
	
	public int getPlayerId() {
		return playerScore.getTableScoreId();
	}
	
	
	
}
