package diceapp.dicesView;

import java.io.InputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class DiceView {
	private ImageView imageView;
	
	public DiceView(String imagePath) {
		String path = "resources/" + imagePath;
		InputStream url = this.getClass().getResourceAsStream(path);
		Image image = new Image(url);
		imageView = new ImageView(image);
	}
	
	public ImageView getImageView() {
		return imageView;
	}
}
