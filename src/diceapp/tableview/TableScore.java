package diceapp.tableview;

import java.util.ArrayList;
import java.util.List;

import diceapp.controllers.MoveController;
import diceapp.diceModel.DiceContainer;
import diceapp.score.PlayerScore;
import javafx.scene.layout.GridPane;

public class TableScore {
	private GridPane table;
	private GridPane firstColumn;
	private List<TableColumn> controllers;
	public TableScore(List<PlayerScore> score, MoveController moveController, DiceContainer diceContainer) {
		table = new GridPane();
		controllers = new ArrayList<TableColumn>();
		initializeFirstColumn();
		initializeScoreColumns(score, moveController, diceContainer);
		table.gridLinesVisibleProperty().set(true);
	}
	
	private void initializeFirstColumn() {
		TableColumn firstTableColumn = new TableFirstColumn();
		firstColumn = firstTableColumn.getTable();
		table.addColumn(1, firstColumn);
	}
	
	private void initializeScoreColumns(List<PlayerScore> score, 
			MoveController moveController, DiceContainer diceContainer) {
		for(int i = 2; i < 2 + score.size(); i++) {
			TableColumn column = new TableScoreColumn(score.get(i - 2),moveController, diceContainer);
			controllers.add(column);
			table.addColumn(i, controllers.get(i-2).getTable());
		}
	}
	
	public GridPane getTable() {
		return table;
	}
	
	
}
