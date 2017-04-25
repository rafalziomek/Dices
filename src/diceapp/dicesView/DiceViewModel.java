package diceapp.dicesView;

import java.util.stream.IntStream;

import diceapp.diceModel.DiceResult;
import diceapp.dicesView.diceSide.*;
import javafx.scene.image.ImageView;

public class DiceViewModel {
	
	private DiceView[] diceViews;
	private DiceView one;
	private DiceView two;
	private DiceView three;
	private DiceView four;
	private DiceView five;
	private DiceView six;
	
	private DiceView oneSelected;
	private DiceView twoSelected;
	private DiceView threeSelected;
	private DiceView fourSelected;
	private DiceView fiveSelected;
	private DiceView sixSelected;
	
	
	private DiceView thisView;
	
	private boolean isSelected;
	
	private DiceContainerView parentContainerView;
	
	
	public DiceViewModel(DiceContainerView parent) {
		this.parentContainerView = parent;
		isSelected = false;
		
		one = new One();
		two = new Two();
		three = new Three();
		four = new Four();
		five = new Five();
		six = new Six();
		
		oneSelected = new OneSelected();
		twoSelected = new TwoSelected();
		threeSelected = new ThreeSelected();
		fourSelected = new FourSelected();
		fiveSelected = new FiveSelected();
		sixSelected = new SixSelected();
		
		thisView = one;
		
		diceViews = new DiceView[] {
				one,two,three,four,five,six,
				oneSelected, twoSelected, threeSelected,
				fourSelected, fiveSelected, sixSelected
		};
		
		setViewsHandlers();
	}
	public boolean isSelected() {
		return isSelected;
	}
	
	public ImageView getDiceViewAsImageView() {
		return thisView.getImageView();
	}
	
	public void setDiceViewAsFirstRoll(DiceResult result) {
		isSelected = false;
		updateDiceView(result);
	}
	
	public void updateDiceView(DiceResult result) {
		if(isSelected) {
			setSelectedImage(result);
		}
		else {
			setNormalImage(result);
		}
	}
	
	private void setNormalImage(DiceResult result) {
		isSelected = false;
		switch(result) {
		case One:
				thisView = one;
				break;
		case Two:
				thisView = two;
				break;
		case Three:
				thisView = three;
				break;
		case Four:
				thisView = four;
				break;
		case Five:
				thisView = five;
				break;
		case Six:
				thisView = six;
				break;
		}
	}
	
	private void setSelectedImage(DiceResult result) {
		isSelected = true;
		switch(result) {
		case One:
				thisView = oneSelected;
				break;
		case Two:
				thisView = twoSelected;
				break;
		case Three:
				thisView = threeSelected;
				break;
		case Four:
				thisView = fourSelected;
				break;
		case Five:
				thisView = fiveSelected;
				break;
		case Six:
				thisView = sixSelected;
				break;
		}
	}
	
	private void select() {
		isSelected = true;
		if(thisView.equals(one)) {
			thisView = oneSelected;
		} else if(thisView.equals(two)) {
			thisView = twoSelected;
		} else if(thisView.equals(three)) {
			thisView = threeSelected;
		} else if(thisView.equals(four)) {
			thisView = fourSelected;
		} else if(thisView.equals(five)) {
			thisView = fiveSelected;
		} else if(thisView.equals(six)) {
			thisView = sixSelected;
		}
	}
	
	private void unselect() {
		isSelected = false;
		if(thisView.equals(oneSelected)) {
			thisView = one;
		} else if(thisView.equals(twoSelected)) {
			thisView = two;
		} else if(thisView.equals(threeSelected)) {
			thisView = three;
		} else if(thisView.equals(fourSelected)) {
			thisView = four;
		} else if(thisView.equals(fiveSelected)) {
			thisView = five;
		} else if(thisView.equals(sixSelected)) {
			thisView = six;
		}
	}
	
	private void setViewsHandlers() {
		IntStream
		.range(0, diceViews.length)
		.forEach(i -> setSelectViewHandler(diceViews[i]));
	}
	
	private void setSelectViewHandler(DiceView diceView) {
		ImageView imgView = diceView.getImageView();
		imgView.setOnMouseClicked(event -> {
			if(isSelected) {
	        	 unselect();
	         } 
	         else {
	        	 select();
	         }
			parentContainerView.refreshView();
		});
	}
}
