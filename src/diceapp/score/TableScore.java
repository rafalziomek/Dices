package diceapp.score;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import diceapp.diceModel.DiceResult;
import diceapp.strategies.Strategy;

public abstract class TableScore {
	protected Map<Strategy, Boolean> usedStrategy;
	protected int score;
	protected int lastScore;
	
	public TableScore() {
		score = 0;
		usedStrategy = new HashMap<Strategy, Boolean>();
	}
	
	public void saveTableScore(Strategy strategy, List<DiceResult> result) {
		if(!strategyIsUsed(strategy)) {
			int points = strategy.getPoints(result);
			score += points;
			lastScore = points;
			useStrategy(strategy);
		}
	}
	
	private void useStrategy(Strategy strategy) {
		usedStrategy.put(strategy, true);
	}
	
	protected boolean strategyIsUsed(Strategy strategy) {
		return usedStrategy.keySet()
				.stream()
				.anyMatch(p -> p.getClass() == strategy.getClass());
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLastScore() {
		return lastScore;
	}

}
