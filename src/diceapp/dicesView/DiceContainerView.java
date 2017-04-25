package diceapp.dicesView;

import java.util.List;
import java.util.stream.IntStream;

import diceapp.diceModel.DiceResult;
import javafx.scene.layout.GridPane;

public class DiceContainerView {
	private GridPane gameTable;
	
	private final DiceViewModel firstDice;
	private final DiceViewModel secondDice;
	private final DiceViewModel thirdDice;
	private final DiceViewModel fourthDice;
	private final DiceViewModel fifthDice;
	
	private DiceViewModel[] diceContainerViews;
	private List<DiceResult> lastResult;
	
	boolean[] selected;
	
	public DiceContainerView() {
		
		gameTable = new GridPane();
		gameTable.setHgap(10);
		
		firstDice = new DiceViewModel(this);
		secondDice = new DiceViewModel(this);
		thirdDice = new DiceViewModel(this);
		fourthDice = new DiceViewModel(this);
		fifthDice = new DiceViewModel(this);
		
		diceContainerViews = new DiceViewModel[] { firstDice, secondDice, thirdDice, fourthDice, fifthDice };
		
	}

	public void updateFirstRollView(List<DiceResult> result) {
		gameTable.getChildren().clear();
		this.lastResult = result;
		setFirstRollViews(result);
		addColumns();
	}
	
	public void refreshView() {
		updateDiceView(lastResult);
	}
	
	public void updateDiceView(List<DiceResult> result) {
		gameTable.getChildren().clear();
		this.lastResult = result;
		setUpdateViews(result);
		addColumns();
	}

	private void setFirstRollViews(List<DiceResult> result) {
		IntStream
			.range(0, diceContainerViews.length)
			.forEach(i -> diceContainerViews[i].setDiceViewAsFirstRoll(result.get(i)));
	}
	
	private void setUpdateViews(List<DiceResult> result) {
		IntStream
			.range(0, diceContainerViews.length)
			.forEach(i -> diceContainerViews[i].updateDiceView(result.get(i)));
	}
	
	private void addColumns() {
		IntStream
			.range(0, diceContainerViews.length)
			.forEach(i -> 
				gameTable.addColumn(i+1, diceContainerViews[i].getDiceViewAsImageView()));
	}
	
	public boolean[] getSelected() {
		selected = new boolean[5];
		IntStream
			.range(0, diceContainerViews.length)
			.forEach(i -> selected[i] = diceContainerViews[i].isSelected());
		return selected;
	}
	
	public GridPane getDiceView() {
		return gameTable;
	}
}
