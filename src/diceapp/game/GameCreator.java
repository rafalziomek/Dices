package diceapp.game;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameCreator {
	private Game game;
	private Stage primaryStage;
	public GameCreator(Stage primaryStage, int numberOfPlayers) {
	    game = new Game(numberOfPlayers, primaryStage);
	    this.primaryStage = primaryStage;
	}
	
	public void create() {
		BorderPane gameWindow = game.getGameWindow();
		Scene scene = new Scene(gameWindow);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void close() {
		primaryStage.close();
	}
}
