package diceapp.score;

import java.util.List;

import diceapp.diceModel.DiceResult;
import diceapp.strategies.Strategy;
import diceapp.strategies.StrategyFactory;
import diceapp.strategies.StrategyType;
import diceapp.strategies.secondTableStrategies.staticStrategies.SecondTableGeneralStrategy;

public class ScoreGeneralUpdater {
	private boolean generalIsChoosed;
	
	public ScoreGeneralUpdater() {
		generalIsChoosed = false;
	}
	
	public void chooseGeneralStrategy() {
		generalIsChoosed = true;
	}
	
	public boolean nextGeneralOccurence(List<DiceResult> result, Strategy strategy) {
		return generalIsChoosed && resultIsGeneral(result) && strategyIsNotGeneral(strategy);
	}
	
	public boolean strategyIsNotGeneral(Strategy strategy) {
		return strategy.getClass() != SecondTableGeneralStrategy.class;
	}
	
	public boolean resultIsGeneral(List<DiceResult> result) {
		StrategyFactory strategyFactory = new StrategyFactory();
		Strategy general = strategyFactory.getStrategy(StrategyType.General);
		return general.getPoints(result) == 50;
	}
}
