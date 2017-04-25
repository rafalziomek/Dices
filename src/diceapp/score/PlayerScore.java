package diceapp.score;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import diceapp.diceModel.DiceResult;
import diceapp.player.Player;
import diceapp.strategies.Strategy;
import diceapp.strategies.StrategyFactory;
import diceapp.strategies.StrategyType;
import diceapp.strategies.firstTableStrategies.FirstTableStrategy;
import diceapp.strategies.secondTableStrategies.SecondTableStrategy;


public class PlayerScore {
	private int id;
	private int firstTableScore;
	private int secondTableScore;
	private Map<Strategy, Boolean> usedStrategy;
	private StrategyFactory strategyFactory;
	private int lastPoints;
	public PlayerScore(Player player) {
		firstTableScore = 0;
		secondTableScore = 0;
		id = player.getId();
		usedStrategy = new HashMap<Strategy, Boolean>();
		strategyFactory = new StrategyFactory();
	}
	
	public void saveScore(StrategyType strategyType, List<DiceResult> result) {
		boolean isFirstStrategy = Arrays.stream(StrategyType.firstTableStrategies()).anyMatch(p -> p == strategyType);
		Strategy strategy = strategyFactory.getStrategy(strategyType);
		if(isFirstStrategy) {
			FirstTableStrategy firstTableStrategy = (FirstTableStrategy) strategy;
			saveFirstTableScore(firstTableStrategy, result);
		}
		else {
			SecondTableStrategy secondTableStrategy = (SecondTableStrategy) strategy;
			saveSecondTableScore(secondTableStrategy, result);
		}
	}
	private void saveFirstTableScore(FirstTableStrategy strategy, List<DiceResult> result) {
		if(!matchClass(strategy)) {
			firstTableScore += strategy.getPoints(result);
			lastPoints = strategy.getPoints(result);
			usedStrategy.put(strategy, true);
		}
		if(firstTableScore >= 63) {
			firstTableScore += 25;
		}
	}
	
	private void saveSecondTableScore(SecondTableStrategy strategy, List<DiceResult> result) {
		if(!matchClass(strategy)) {
			secondTableScore += strategy.getPoints(result);
			lastPoints = strategy.getPoints(result);
			usedStrategy.put(strategy, true);
		}
	}
	
	public int getLastScore() {
		return lastPoints;
	}
	
	private boolean matchClass(Strategy strategy) {
		return usedStrategy.keySet()
				.stream()
				.anyMatch(p -> p.getClass() == strategy.getClass());
	}
	
	public int getFirstTableScore() {
		return firstTableScore;
	}
	
	public int getScore() {
		return firstTableScore + secondTableScore;
	}
	
	public int getSecondTableScore() {
		return secondTableScore;
	}
	
	public int getTableScoreId(){
		return id;
	}
	
	
	
}
