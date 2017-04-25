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
		this.setPlayerOnMove(moveController.getPlayerOnMove());
		this.setPadding(new Insets(10,10,10,10));
		this.setScaleX(1.2);
		this.setScaleY(1.2);
		BorderPane.setAlignment(this, Pos.CENTER);
	}
	
	public void setPlayerOnMove(Player player) {
		this.setText("Ruch gracza: #" + player.getId());
	}
}
