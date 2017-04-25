package diceapp.labels;

import diceapp.controllers.MoveController;
import diceapp.player.Player;
import javafx.scene.control.Label;

public class PlayerOnMoveLabel extends Label{

	public PlayerOnMoveLabel(MoveController moveController) {
		moveController.setPlayerRoundLabel(this);
	}
	
	public void setPlayerOnMove(Player player) {
		this.setText("Ruch gracza: " + player.getId());
	}
}
