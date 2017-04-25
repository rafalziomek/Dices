package diceapp.strategies.secondTableStrategies.sumStrategies;

import java.util.List;

import diceapp.diceModel.DiceResult;
import diceapp.strategies.secondTableStrategies.NumberOccurenceMatcher;

public abstract class SecondTableSameStrategy extends SecondTableSumStrategy {
	private int numberOfSame;
	
	public SecondTableSameStrategy(int numberOfSame) {
		super(false);
		this.numberOfSame = numberOfSame;
	}
	
	
	@Override
	public int getPoints(List<DiceResult> results) {
		this.condition = NumberOccurenceMatcher.getLargerThanOccurence(results, numberOfSame);
		return super.getPoints(results);
	}
	
	
	
	

}
