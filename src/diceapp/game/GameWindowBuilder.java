package diceapp.game;

import diceapp.buttons.RollDiceButton;
import diceapp.controllers.DiceContainerController;
import diceapp.controllers.MoveController;
import diceapp.dicesView.DiceContainerView;
import diceapp.labels.PlayerOnMoveLabel;
import diceapp.player.Player;
import diceapp.tableview.Table;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class GameWindowBuilder {
	private BorderPane gameWindow;
	private Table table;
	private DiceContainerView diceContainerView;
	private Button button;
	private Label label;
	private MoveController moveController;
	
	public GameWindowBuilder(DiceContainerController diceContainerController, Table table, MoveController move) {
		gameWindow = new BorderPane();
		this.diceContainerView = diceContainerController.getView();
		this.table = table;
		this.moveController = move;
		button = setRollDiceButton();
		label = new PlayerOnMoveLabel(moveController);
	}
	public BorderPane buildGameWindow() {
		BorderPane.setAlignment(label, Pos.CENTER);
		StackPane stackPane = getGameTable();
		
		
		label.setPadding(new Insets(10,10,10,10));
		label.setScaleX(1.2);
		label.setScaleY(1.2);
		StackPane.setAlignment(diceContainerView.getDiceView(), Pos.CENTER);
		StackPane.setAlignment(button, Pos.CENTER);
		gameWindow.setLeft(table.getTable());
		gameWindow.setCenter(stackPane);
		gameWindow.setTop(label);
		
		return gameWindow;
	}
	
	private StackPane getGameTable() {
		StackPane stackPane = new StackPane();
		
		stackPane.setPadding(new Insets(100,10,100,10));
		
		stackPane.getChildren().add(diceContainerView.getDiceView());
		stackPane.getChildren().add(button);
		
		return stackPane;
	}
	
	public void setLabelPlayer(Player player) {
		label.setText("Ruch gracza: " + player.getId());
	}
	
	private Button setRollDiceButton() {
		Button button = new RollDiceButton(moveController);
		return button;
	}
	
	
}
