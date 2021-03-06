package diceapp.controllers;


import java.util.List;

import diceapp.diceModel.DiceContainer;
import diceapp.diceModel.DiceResult;
import diceapp.dicesView.DiceContainerView;
import javafx.scene.layout.GridPane;
public class DiceContainerController {
	private final DiceContainerView diceContainerView;
	private final DiceContainer diceContainer;
	private boolean isFirstRoll;
	
	public DiceContainerController(DiceContainerView diceContainerView, 
			DiceContainer diceContainer) {
		this.diceContainer = diceContainer;
		this.diceContainerView = diceContainerView;
		isFirstRoll = true;
	}
	
	public void rollAllDices() {
		 if(isFirstRoll) {
			 firstRoll();
			 isFirstRoll = false;
		 } else {
			 nextRoll();
		 }
	}
	
	public void isFirstMove() {
		isFirstRoll = true;
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
	
	public GridPane getDiceResultView() {
		return diceContainerView.getDiceResultView();
	}
	
	public List<DiceResult> getResult() {
		return diceContainer.getTopOfDices();
	}
}
