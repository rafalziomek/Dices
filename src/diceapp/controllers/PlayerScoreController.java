package diceapp.controllers;

import diceapp.labels.TableScoreLabels;
import diceapp.score.PlayerScore;
import diceapp.strategies.StrategyType;
import javafx.scene.control.CheckBox;

public class PlayerScoreController {
	
	private PlayerScore playerScore;
	private MoveController moveController;
	private TableScoreLabels tableScoreLabels;
	public PlayerScoreController(PlayerScore playerScore, MoveController moveController, TableScoreLabels scoreLabels) {
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
