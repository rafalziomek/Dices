package diceapp.game;

import diceapp.buttons.RollDiceButton;
import diceapp.controllers.DiceContainerController;
import diceapp.controllers.MoveController;
import diceapp.labels.PlayerOnMoveLabel;
import diceapp.tableview.TableScoreView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GameWindowBuilder {
	private BorderPane gameWindow;
	private GridPane scoreTable;
	private GridPane diceResultView;
	private Button rollDiceButton;
	private Label playerOnMoveLabel;
	private MoveController moveController;
	
	public GameWindowBuilder(DiceContainerController diceContainerController, GridPane tableScore, MoveController move) {
		gameWindow = new BorderPane();
		this.diceResultView = diceContainerController.getDiceResultView();
		this.scoreTable = tableScore;
		this.moveController = move;
	}
	public BorderPane buildGameWindow() {
		playerOnMoveLabel = new PlayerOnMoveLabel(moveController);
		
		rollDiceButton = getRollDiceButton();
		
		StackPane gameTable = getGameTable();
		
		gameWindow.setLeft(scoreTable);
		gameWindow.setCenter(gameTable);
		gameWindow.setTop(playerOnMoveLabel);
		
		return gameWindow;
	}
	
	private StackPane getGameTable() {
		StackPane stackPane = new StackPane();
		
		stackPane.setPadding(new Insets(100,10,100,10));
		
		stackPane.getChildren().add(diceResultView);
		stackPane.getChildren().add(rollDiceButton);
		
		StackPane.setAlignment(diceResultView, Pos.CENTER);
		StackPane.setAlignment(rollDiceButton, Pos.CENTER);
		
		return stackPane;
	}
	
	private Button getRollDiceButton() {
		Button button = new RollDiceButton(moveController);
		return button;
	}
	
	
}
