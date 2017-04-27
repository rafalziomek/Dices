package diceapp.score;

import java.util.List;

import diceapp.diceModel.DiceResult;
import diceapp.strategies.Strategy;
import diceapp.strategies.secondTableStrategies.staticStrategies.SecondTableGeneralStrategy;

public class SecondTableScore extends TableScore {
	

	public SecondTableScore(ScoreGeneralUpdater scoreGeneralUpdater) {
		super(scoreGeneralUpdater);
	}

	@Override
	public void saveTableScore(Strategy strategy, List<DiceResult> result) {
		if(strategyIsGeneral(strategy)) {
			scoreGeneralUpdater.chooseGeneralStrategy();
		}
		super.saveTableScore(strategy, result);
		checkNextGeneralAndUpdateScore(strategy, result);
	}
	
	private boolean strategyIsGeneral(Strategy strategy) {
		return strategy.getClass() == SecondTableGeneralStrategy.class;
	}
}
