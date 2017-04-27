package diceapp.score;

import java.util.List;

import diceapp.diceModel.DiceResult;
import diceapp.player.Player;
import diceapp.strategies.*;

public class PlayerScore {
	private final int id;
	private final TableScore firstTableScore;
	private final TableScore secondTableScore;
	private final StrategyFactory strategyFactory;
	private int lastScore;
	public PlayerScore(Player player) {
		id = player.getId();
		ScoreGeneralUpdater scoreGeneralUpdater = new ScoreGeneralUpdater();
		strategyFactory = new StrategyFactory();
		firstTableScore = new FirstTableScore(scoreGeneralUpdater);
		secondTableScore = new SecondTableScore(scoreGeneralUpdater);
	}
	
	public void saveScore(StrategyType strategyType, List<DiceResult> result) {
		Strategy strategy = strategyFactory.getStrategy(strategyType);
		if(StrategyType.isFirstStrategy(strategyType)) {
			saveTableScore(firstTableScore, strategy, result);
		}
		else {
			saveTableScore(secondTableScore, strategy, result);
		}
	}
	
	private void saveTableScore(TableScore tableScore, Strategy strategy, List<DiceResult> result) {
		tableScore.saveTableScore(strategy, result);
		lastScore = tableScore.getLastScore();
	}
	
	public int getLastScore() {
		return lastScore; 
	}
	
	public int getFirstTableScore() {
		return firstTableScore.getScore();
	}
	
	public int getScore() {
		return firstTableScore.getScore() + secondTableScore.getScore();
	}
	
	public int getSecondTableScore() {
		return secondTableScore.getScore();
	}
	
	public int getTableScoreId(){
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerScore other = (PlayerScore) obj;
		if (getScore() != other.getScore())
			return false;
		return true;
	}

	
	
	
	
	
}
