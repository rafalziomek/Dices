package diceapp.menu;

import diceapp.buttons.StartGameButton;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Menu {
	
	private Stage primaryStage;
	private ChoiceBox<Integer> choiceBox;
	private Label playersTextLabel;
	private Button startButton;
	
	private final int menuHeight;
	private final int menuWidth;
	
	public Menu(Stage primaryStage) {
		this.primaryStage = primaryStage;
		menuHeight = 100;
		menuWidth = 200;
	}
	
	public Scene buildMenu() {
		StackPane menuNodes = new StackPane();
		
		Node[] childrens = createChildrens();
		menuNodes.getChildren().addAll(childrens);
		
		setPositionChildren();
		
		Scene menu = new Scene(menuNodes, menuWidth, menuHeight);
	
		return menu;
	}
	
	private Node[] createChildrens() {
		playersTextLabel = new Label("Iloœæ graczy:");
		
		choiceBox = getNumberOfPlayersChoiceBox();
		choiceBox.getSelectionModel().selectFirst();
		
		startButton = getStartButton();
		
		Node[] childrens = new Node[] { playersTextLabel, choiceBox, startButton };
		
		return childrens;
	}
	
	private ChoiceBox<Integer> getNumberOfPlayersChoiceBox() {
		return new ChoiceBox<Integer>(FXCollections.observableArrayList(
			    2,3,4));
	}
	
	private Button getStartButton() {
		Button button = new StartGameButton(primaryStage, choiceBox);
		return button;
	}
	
	private void setPositionChildren() {
		StackPane.setAlignment(playersTextLabel, Pos.TOP_CENTER);
		StackPane.setAlignment(choiceBox, Pos.CENTER);
		StackPane.setAlignment(startButton, Pos.BOTTOM_CENTER);
		StackPane.setMargin(startButton, new Insets(5));
	}

}
