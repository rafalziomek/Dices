package diceapp.buttons;

import diceapp.game.Game;
import diceapp.game.GameLauncher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NextGameButton extends Button {

	public NextGameButton(Game lastGame, Stage winnerWindowStage) {
		this.textProperty().set("Start!");
		
		this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	Stage primaryStage = new Stage();
		    	GameLauncher gameLauncher = new GameLauncher(primaryStage, 
						lastGame.getNumberOfPlayers());
		    	gameLauncher.startGame();
		    	lastGame.close();
		    	winnerWindowStage.close();
		    }
		});
	}

}
