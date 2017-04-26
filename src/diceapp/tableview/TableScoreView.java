package diceapp.tableview;

import java.util.ArrayList;
import java.util.List;

import diceapp.controllers.MoveController;
import diceapp.diceModel.DiceContainer;
import diceapp.score.PlayerScore;
import javafx.scene.layout.GridPane;

public class TableScoreView extends GridPane {
	public TableScoreView(List<PlayerScore> score, MoveController moveController, DiceContainer diceContainer) {
		initializeFirstColumn();
		initializeScoreColumns(score, moveController, diceContainer);
		this.gridLinesVisibleProperty().set(true);
	}
	
	private void initializeFirstColumn() {
		TableColumnView firstTableColumn = new TableFirstColumnView();
		this.addColumn(1, firstTableColumn.getColumnView());
	}
	
	private void initializeScoreColumns(List<PlayerScore> score, 
			MoveController moveController, DiceContainer diceContainer) {
		for(int i = 2; i < 2 + score.size(); i++) {
			TableColumnView column = new TableScoreColumnView(score.get(i - 2),moveController, diceContainer);
			this.addColumn(i, column.getColumnView());
		}
	}
	

	
	
}
