package diceapp.tableview;

import javafx.scene.layout.GridPane;

public abstract class TableColumnView {
	private GridPane column;
	
	public TableColumnView(String filePath) {
		ViewLoader loader = new ViewLoader(this, filePath);
		loader.loadFXML();
		column = loader.getColumn();
	}
	
	public GridPane getColumnView() {
		return column;
	}

}
