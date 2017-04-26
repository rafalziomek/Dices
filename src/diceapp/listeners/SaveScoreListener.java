package diceapp.listeners;

import diceapp.controllers.MoveController;
import diceapp.score.PlayerScoreUpdater;
import diceapp.strategies.StrategyType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;

public class SaveScoreListener {
	
	private MoveController moveController;
	private PlayerScoreUpdater playerScoreUpdater;
	public SaveScoreListener(PlayerScoreUpdater scoreUpdater, MoveController moveController) {
		this.playerScoreUpdater = scoreUpdater;
		this.moveController = moveController;
	}
	
	public void setListenerScoreUpdate(CheckBox strategyCheckBox, StrategyType strategy) {
		strategyCheckBox
			.selectedProperty()
			.addListener(new ChangeListener<Boolean>() {
		        public void changed(ObservableValue<? extends Boolean> ov,
		            Boolean old_val, Boolean new_val) {
		        		if(thisPlayerIsOnMove()) {
		        			acceptMove(strategyCheckBox, strategy);
		        		} else {
		        			dontAcceptMove(strategyCheckBox);
		        		}
		        }
			});
	}

	private boolean thisPlayerIsOnMove() {
		return playerScoreUpdater.getPlayerId() == moveController.getPlayerOnMoveId();
	}
	
	private void acceptMove(CheckBox checkBox, StrategyType strategy) {
		checkBox.setDisable(true);
		playerScoreUpdater.update(strategy, checkBox);
        moveController.move();
	}
	
	private void dontAcceptMove(CheckBox checkBox) {
		checkBox.selectedProperty().set(false);
	}
	
	
}
