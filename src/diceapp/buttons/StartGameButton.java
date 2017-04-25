package diceapp.buttons;

import diceapp.game.GameCreator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartGameButton extends Button {

	public StartGameButton(Stage primaryStage, int numberOfPlayers) {
		this.textProperty().set("Start!");
		
		GameCreator gameCreator = new GameCreator(primaryStage, numberOfPlayers);
		
		this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	gameCreator.create();
		    }
		});
	}

}
