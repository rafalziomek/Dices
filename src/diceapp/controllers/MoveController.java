package diceapp.controllers;

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
	public boolean playerCanRoll() {
		return numberOfRolls < 2;
	}
	
	public void rollAllDices() {
		diceContainerController.rollAllDices();
		numberOfRolls++;
	}
	
	public void move() {
		numberOfRolls = 0;
		moveCounter++;
		int playerOnMoveIndex = moveCounter % numberOfPlayers;
		playerOnMove = players[playerOnMoveIndex];
		playerRoundLabel.setPlayerOnMove(playerOnMove);
		diceContainerController.isFirstMove();
		diceContainerController.rollAllDices();
		if(isEndOfGame()) {
			endGame();
		}
	}
	
	private void endGame() {
		GameOver gameOver = new GameOver(game);
		gameOver.endOfGame();
	}
	public boolean isEndOfGame() {
		return moveCounter == maximumNumberOfMoves;
	}
	
	public void setPlayerRoundLabel(PlayerOnMoveLabel label) {
		this.playerRoundLabel = label;
	}
	
	public Player getPlayerOnMove() {
		return playerOnMove;
	}
}
