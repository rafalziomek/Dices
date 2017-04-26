package diceapp.tableview;

import java.util.List;

import diceapp.controllers.MoveController;
import diceapp.diceModel.DiceContainer;
import diceapp.score.PlayerScore;
import javafx.scene.layout.GridPane;

public class TableScoreView extends GridPane {
	public TableScoreView(List<PlayerScore> score, MoveController moveController) {
		initializeFirstColumn();
		initializeScoreColumns(score, moveController);
		this.gridLinesVisibleProperty().set(true);
	}
	
	private void initializeFirstColumn() {
		TableColumnView firstTableColumn = new TableFirstColumnView();
		this.addColumn(1, firstTableColumn.getColumnView());
	}
	
	private void initializeScoreColumns(List<PlayerScore> score, 
				MoveController moveController) {
		for(int i = 2; i < 2 + score.size(); i++) {
			TableColumnView column = 
					new TableScoreColumnView(score.get(i - 2), moveController);
			this.addColumn(i, column.getColumnView());
		}
	}
	

	
	
}
