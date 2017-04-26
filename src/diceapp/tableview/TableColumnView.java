package diceapp.tableview;

import javafx.scene.layout.GridPane;

public abstract class TableColumnView {
	private GridPane column;
	
	public TableColumnView(String filePath) {
		ViewLoader viewLoader = new ViewLoader(this, filePath);
		viewLoader.loadFXML();
		column = viewLoader.getColumn();
	}
	
	public GridPane getColumnView() {
		return column;
	}

}
