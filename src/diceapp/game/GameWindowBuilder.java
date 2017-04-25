package diceapp.game;

import diceapp.buttons.RollDiceButton;
import diceapp.controllers.DiceContainerController;
import diceapp.controllers.MoveController;
import diceapp.dicesView.DiceContainerView;
import diceapp.labels.PlayerOnMoveLabel;
import diceapp.tableview.TableScore;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class GameWindowBuilder {
	private BorderPane gameWindow;
	private TableScore scoreTable;
	private DiceContainerView diceContainerView;
	private Button rollDiceButton;
	private Label playerOnMoveLabel;
	private MoveController moveController;
	
	public GameWindowBuilder(DiceContainerController diceContainerController, TableScore table, MoveController move) {
		gameWindow = new BorderPane();
		this.diceContainerView = diceContainerController.getView();
		this.scoreTable = table;
		this.moveController = move;
	}
	public BorderPane buildGameWindow() {
		playerOnMoveLabel = new PlayerOnMoveLabel(moveController);
		rollDiceButton = getRollDiceButton();
		
		StackPane.setAlignment(diceContainerView.getDiceView(), Pos.CENTER);
		StackPane.setAlignment(rollDiceButton, Pos.CENTER);
		
		StackPane gameTable = getGameTable();
		
		gameWindow.setLeft(scoreTable.getTable());
		gameWindow.setCenter(gameTable);
		gameWindow.setTop(playerOnMoveLabel);
		
		return gameWindow;
	}
	
	private StackPane getGameTable() {
		StackPane stackPane = new StackPane();
		
		stackPane.setPadding(new Insets(100,10,100,10));
		
		stackPane.getChildren().add(diceContainerView.getDiceView());
		stackPane.getChildren().add(rollDiceButton);
		
		return stackPane;
	}
	
	private Button getRollDiceButton() {
		Button button = new RollDiceButton(moveController);
		return button;
	}
	
	
}
