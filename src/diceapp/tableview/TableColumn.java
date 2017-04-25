package diceapp.tableview;

import javafx.scene.layout.GridPane;

public abstract class TableColumn {
	private GridPane table;
	
	public TableColumn(String filePath) {
		Loader loader = new Loader(this, filePath);
		loader.loadFXML();
		table = loader.getColumn();
	}
	
	public GridPane getTable() {
		return table;
	}

}
