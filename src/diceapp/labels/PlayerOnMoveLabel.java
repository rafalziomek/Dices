package diceapp.labels;

import diceapp.controllers.MoveController;
import diceapp.player.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class PlayerOnMoveLabel extends Label{

	public PlayerOnMoveLabel(MoveController moveController) {
		moveController.setPlayerRoundLabel(this);
		this.setPlayerOnMoveId(moveController.getPlayerOnMoveId());
		this.setPadding(new Insets(10,10,10,10));
		this.setScaleX(1.2);
		this.setScaleY(1.2);
		BorderPane.setAlignment(this, Pos.CENTER);
	}
	
	public void setPlayerOnMoveId(int playerOnMoveId) {
		this.setText("Ruch gracza: #" + playerOnMoveId);
	}
}
