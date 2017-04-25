package diceapp.buttons;

import diceapp.controllers.MoveController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class RollDiceButton extends Button{

	public RollDiceButton(MoveController moveController) {
		this.textProperty().set("Losuj!");
		
		this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	if(moveController.playerCanRoll()) {
		    		moveController.rollAllDices();
		    	}
		    }
		});
		this.setScaleX(1.5);
		this.setScaleY(1.5);
	}
	
}
