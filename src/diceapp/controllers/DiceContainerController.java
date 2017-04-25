package diceapp.controllers;

import diceapp.diceModel.DiceContainer;
import diceapp.dicesView.DiceContainerView;
public class DiceContainerController {
	private final DiceContainerView diceContainerView;
	private final DiceContainer diceContainer;
	private boolean isFirstMove;
	
	public DiceContainerController(DiceContainerView diceContainerView, 
			DiceContainer diceContainer) {
		this.diceContainer = diceContainer;
		this.diceContainerView = diceContainerView;
		isFirstMove = true;
	}
	
	public void rollAllDices() {
		 if(isFirstMove) {
			 firstRoll();
			 isFirstMove = false;
		 } else {
			 nextRoll();
		 }
	}
	
	public void isFirstMove() {
		isFirstMove = true;
	}
	
	private void firstRoll() {
		diceContainer.rollAllDices();
		diceContainerView.updateFirstRollView(diceContainer.getTopOfDices());
	}
	
	private void nextRoll() {
		boolean[] selected = diceContainerView.getSelected();
		diceContainer.rollAllDicesExclude(selected);
		diceContainerView.updateDiceView(diceContainer.getTopOfDices());
	}
	
	public DiceContainerView getView() {
		return diceContainerView;
	}
}
