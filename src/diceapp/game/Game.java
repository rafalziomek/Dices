package diceapp.game;

import java.util.ArrayList;
import java.util.List;

import diceapp.controllers.DiceContainerController;
import diceapp.controllers.MoveController;
import diceapp.diceModel.DiceContainer;
import diceapp.dicesView.DiceContainerView;
import diceapp.player.Player;
import diceapp.score.PlayerScore;
import diceapp.tableview.TableScore;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Game {
	private final Player[] players;
	private final List<PlayerScore> playerScores;
	private final BorderPane gameWindow;
	private final GridPane tableScore;
	private final DiceContainerController diceContainerController;
	private final GameWindowBuilder gameWindowBuilder;
	private final MoveController moveController;
	private final DiceContainer diceContainer;
	private final DiceContainerView diceContainerView;
	
	private Stage primaryStage;
	public Game(int numberOfPlayers, Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		players = initializePlayers(numberOfPlayers);
		playerScores = initializePlayerScores(players);
		
		diceContainer = new DiceContainer(5);
		diceContainerView = new DiceContainerView();
		
		diceContainerController = 
				new DiceContainerController(diceContainerView, diceContainer);
		
		moveController = new MoveController(players, diceContainerController, this);
		
		tableScore = new TableScore(playerScores, moveController, diceContainer);
		
		diceContainerController.rollAllDices();
		
		gameWindowBuilder = new GameWindowBuilder(diceContainerController, tableScore, moveController);
		
		gameWindow = gameWindowBuilder.buildGameWindow();
		
	}	
	public int getNumberOfPlayers() {
		return players.length;
	}
	
	public BorderPane getGameWindow() {
		return gameWindow;
	}
	public void close() {
		primaryStage.close();
	}
	private Player[] initializePlayers(int numberOfPlayers) {
		Player[] players = new Player[numberOfPlayers];
		for(int i = 0; i < numberOfPlayers; i++) {
			players[i] = new Player(i + 1);
		}
		return players;
	}
	
	private List<PlayerScore> initializePlayerScores(Player[] players) {
		List<PlayerScore> playersScore = new ArrayList<PlayerScore>();
		for(int i = 0; i < players.length; i++) {
			playersScore.add(new PlayerScore(players[i]));
		}
		return playersScore;
	}
	
	public int getWinnerId() {
		playerScores.sort((x,y) -> y.getScore() - x.getScore());
		int winnerId = playerScores.get(0).getTableScoreId();
		return winnerId;
	}
}
