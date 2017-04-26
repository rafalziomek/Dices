package diceapp.strategies.firstTableStrategies;

import java.util.List;
import java.util.Map;

import diceapp.diceModel.DiceResult;
import diceapp.strategies.ResultStatistics;
import diceapp.strategies.Strategy;

public abstract class FirstTableStrategy implements Strategy {
	private DiceResult diceResult;
	
	public FirstTableStrategy(DiceResult diceResult) {
		this.diceResult = diceResult;
	}
	
	@Override
	public int getPoints(List<DiceResult> results) {
		ResultStatistics resultStat = new ResultStatistics(results);
		Map<DiceResult, Integer> map = resultStat.getDiceResultOccurences();
		int points = map.get(diceResult)*diceResult.getValue();
		return points;
	}
	


	

}
