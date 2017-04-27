package diceapp.controllers;

import java.util.List;

import diceapp.diceModel.DiceResult;
import diceapp.game.Game;
import diceapp.game.GameOver;
import diceapp.labels.PlayerOnMoveLabel;
import diceapp.player.Player;

public class MoveController {
	
	private Player playerOnMove;
	private int moveCounter;
	private Player[] players;
	private int numberOfPlayers;
	private int numberOfRolls;
	private PlayerOnMoveLabel playerRoundLabel;
	private DiceContainerController diceContainerController;
	private Game game;
	private final int maximumNumberOfMoves;
	
	public MoveController(Player[] players, DiceContainerController diceContainerController, Game game) {
		this.players = players;
		this.diceContainerController = diceContainerController;
		this.game = game;
		moveCounter = 0;
		
		playerOnMove = players[moveCounter];
		this.numberOfPlayers = players.length;
		maximumNumberOfMoves = numberOfPlayers * 13;
	}
	
	public void moveIsDone() {
		numberOfRolls = 0;
		moveCounter++;
		nextPlayerMove();
		prepareDicesForNextPlayer();
		if(isEndOfGame()) {
			endGame();
		}
	}
	
	private void nextPlayerMove() {
		int playerOnMoveIndex = moveCounter % numberOfPlayers;
		playerOnMove = players[playerOnMoveIndex];
		playerRoundLabel.setPlayerOnMoveId(getPlayerOnMoveId());
	}
	
	private void prepareDicesForNextPlayer() {
		diceContainerController.isFirstMove();
		diceContainerController.rollAllDices();
	}
	
	public void rollAllDices() {
		diceContainerController.rollAllDices();
		numberOfRolls++;
	}
	
	
	private void endGame() {
		GameOver gameOver = new GameOver(game);
		gameOver.endOfGame();
	}
	
	private boolean isEndOfGame() {
		return moveCounter == maximumNumberOfMoves;
	}
	
	public boolean playerCanRoll() {
		return numberOfRolls < 2;
	}
	
	public void setPlayerRoundLabel(PlayerOnMoveLabel label) {
		this.playerRoundLabel = label;
	}
	
	public int getPlayerOnMoveId() {
		return playerOnMove.getId();
	}
	
	public List<DiceResult> getResult() {
		return diceContainerController.getResult();
	}
}
