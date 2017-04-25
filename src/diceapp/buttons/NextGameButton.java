package diceapp.buttons;

import diceapp.game.Game;
import diceapp.game.GameCreator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NextGameButton extends Button {

	public NextGameButton(Game lastGame, Stage winnerWindowStage) {
		this.textProperty().set("Start!");
		Stage primaryStage = new Stage();
		GameCreator gameCreator = new GameCreator(primaryStage, 
				lastGame.getNumberOfPlayers());
		
		this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	gameCreator.create();
		    	lastGame.close();
		    	winnerWindowStage.close();
		    }
		});
	}

}
