package diceapp.game;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameLauncher {
	private Game game;
	private Stage primaryStage;
	private int numberOfPlayers;
	public GameLauncher(Stage primaryStage, int numberOfPlayers) {
	    this.numberOfPlayers = numberOfPlayers;
	    this.primaryStage = primaryStage;
	}
	
	public void startGame() {
		game = new Game(numberOfPlayers, primaryStage);
		BorderPane gameWindow = game.getGameWindow();
		Scene scene = new Scene(gameWindow);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
