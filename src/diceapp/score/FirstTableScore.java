package diceapp.score;

import java.util.List;

import diceapp.diceModel.DiceResult;
import diceapp.strategies.Strategy;

public class FirstTableScore extends TableScore {
	
	public FirstTableScore(ScoreGeneralUpdater scoreGeneralUpdater) {
		super(scoreGeneralUpdater);
	}

	@Override
	public void saveTableScore(Strategy strategy, List<DiceResult> result) {
		super.saveTableScore(strategy, result);
		if(score >= 63) {
			score += 25;
		}
		checkNextGeneralAndUpdateScore(strategy, result);
	}
	
	
}
