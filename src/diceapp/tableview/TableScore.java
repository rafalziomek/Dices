package diceapp.tableview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import diceapp.controllers.MoveController;
import diceapp.diceModel.DiceContainer;
import diceapp.score.PlayerScore;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class TableScore {
	private GridPane table;
	private GridPane firstTable;
	private List<TableScoreController> controllers;
	
	public TableScore(List<PlayerScore> score, MoveController move, DiceContainer diceContainer) {
		
		table = new GridPane();
		controllers = new ArrayList<TableScoreController>();
		loadFXML();
		table.addColumn(1, firstTable);
		for(int i = 2; i < 2 + score.size(); i++) {
			controllers.add(new TableScoreController(score.get(i - 2),move, diceContainer));
			table.addColumn(i, controllers.get(i-2).getTable());
		}
		table.gridLinesVisibleProperty().set(true);
	}
	
	public GridPane getTable() {
		return table;
	}
	
	private void loadFXML() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/firstColumnScore.fxml"));
				        fxmlLoader.setController(this);
				        try {
				            firstTable = fxmlLoader.load();
				        } catch (IOException exception) {
				            throw new RuntimeException(exception);
				        }
	}
}
