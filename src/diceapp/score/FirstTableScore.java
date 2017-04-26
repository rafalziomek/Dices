package diceapp.score;

import java.util.List;

import diceapp.diceModel.DiceResult;
import diceapp.strategies.Strategy;

public class FirstTableScore extends TableScore {
	@Override
	public void saveTableScore(Strategy strategy, List<DiceResult> result) {
		super.saveTableScore(strategy, result);
		if(score >= 63) {
			score += 25;
		}
	}
	
	
}
