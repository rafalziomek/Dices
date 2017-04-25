package diceapp.tableview;

import javafx.scene.layout.GridPane;

public abstract class TableColumn {
	private GridPane column;
	
	public TableColumn(String filePath) {
		Loader loader = new Loader(this, filePath);
		loader.loadFXML();
		column = loader.getColumn();
	}
	
	public GridPane getColumnView() {
		return column;
	}

}
