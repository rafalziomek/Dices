package diceapp.tableview;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class Loader {
	private GridPane column;
	private TableColumn tableColumn;
	private String filePath;
	
	public Loader(TableColumn tableColumn, String filePath) {
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
