package diceapp.game;


import diceapp.Main;
import diceapp.buttons.NextGameButton;
import diceapp.buttons.StartGameButton;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameOver {
	private Game game;
	private int winnerId;
	public GameOver(Game game) {
		this.game = game;
		this.winnerId = game.getWinnerId();
	}
	
	public void endOfGame() {
		
		Stage nextGameStage = new Stage();
		StackPane gameOverWindow = createGameOverWindow(nextGameStage);
		Scene scene = new Scene(gameOverWindow, 200, 100);
		nextGameStage.setScene(scene);
		nextGameStage.show();
	}
	
	private StackPane createGameOverWindow(Stage stage) {
		StackPane gameOverWindow = new StackPane();
		Label label = new Label("Wygra³ gracz #" + winnerId + "!");
		Button button = new NextGameButton(game, stage);
		StackPane.setAlignment(label, Pos.TOP_CENTER);
		StackPane.setAlignment(button, Pos.BOTTOM_CENTER);
		
		gameOverWindow.getChildren().add(label);
		gameOverWindow.getChildren().add(button);
		return gameOverWindow;
	}
}
