package diceapp.tableview;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class ViewLoader {
	private GridPane column;
	private TableColumnView tableColumn;
	private String filePath;
	
	public ViewLoader(TableColumnView tableColumn, String filePath) {
		this.filePath = filePath;
		this.tableColumn = tableColumn;
		column = new GridPane();
	}
	
	public void loadFXML() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(filePath));
				        fxmlLoader.setController(tableColumn);
				        try {
				            column = fxmlLoader.load();
				        } catch (IOException exception) {
				            throw new RuntimeException(exception);
				        }
	}
	
	public GridPane getColumn() {
		return column;
	}
}
