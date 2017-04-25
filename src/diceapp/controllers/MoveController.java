package diceapp.controllers;

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
	
	public MoveController(Player[] players, DiceContainerController diceContainerController) {
		this.players = players;
		this.diceContainerController = diceContainerController;
		moveCounter = 0;
		playerOnMove = players[moveCounter];
		this.numberOfPlayers = players.length;
	}
	public boolean playerCanRoll() {
		return numberOfRolls < 2;
	}
	
	public void rollAllDices() {
		diceContainerController.rollAllDices();
		numberOfRolls++;
	}
	
	public void endOfMove() {
		numberOfRolls = 0;
		moveCounter++;
		int playerOnMoveIndex = moveCounter % numberOfPlayers;
		playerOnMove = players[playerOnMoveIndex];
		playerRoundLabel.setPlayerOnMove(playerOnMove);
		diceContainerController.isFirstMove();
		diceContainerController.rollAllDices();
	}
	
	public void setPlayerRoundLabel(PlayerOnMoveLabel label) {
		this.playerRoundLabel = label;
	}
	
	public Player getPlayerOnMove() {
		return playerOnMove;
	}
}
