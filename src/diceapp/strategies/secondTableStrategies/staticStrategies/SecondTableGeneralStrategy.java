package diceapp.strategies.secondTableStrategies.staticStrategies;

import java.util.List;

import diceapp.diceModel.DiceResult;
import diceapp.strategies.secondTableStrategies.NumberOccurenceMatcher;

public class SecondTableGeneralStrategy extends SecondTableStaticStrategy {
	@Override
	public int getPoints(List<DiceResult> results) {
		boolean matchFive = NumberOccurenceMatcher.getLargerThanOccurence(results, 5);
		if(matchFive) {
			return 50;
		}
		return 0;
	}

	
}
