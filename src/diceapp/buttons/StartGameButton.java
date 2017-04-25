package diceapp.buttons;

import diceapp.game.GameCreator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class StartGameButton extends Button {

	public StartGameButton(Stage primaryStage, ChoiceBox<Integer> choiceBox) {
		this.textProperty().set("Start!");
		
		this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	GameCreator gameCreator = new GameCreator(primaryStage, choiceBox.getSelectionModel().getSelectedItem());
		    	gameCreator.create();
		    	
		    }
		});
	}

}
