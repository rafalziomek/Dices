package diceapp.strategies.secondTableStrategies.sumStrategies;

import java.util.List;

import diceapp.diceModel.DiceResult;
import diceapp.strategies.secondTableStrategies.SecondTableStrategy;

public abstract class SecondTableSumStrategy extends SecondTableStrategy {
	protected boolean condition;
	public SecondTableSumStrategy(boolean condition) {
		this.condition = condition;
	}

	@Override
	public int getPoints(List<DiceResult> results) {
		if(condition) {
			return getSum(results);
		}
		return 0;
		
	}
	
	protected int getSum(List<DiceResult> results) {
		int points = results.stream().mapToInt(p -> p.getValue()).sum();
		return points;
	}
}
