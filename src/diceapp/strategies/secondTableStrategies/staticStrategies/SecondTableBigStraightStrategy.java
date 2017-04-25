package diceapp.strategies.secondTableStrategies.staticStrategies;

import java.util.ArrayList;
import java.util.List;

import diceapp.diceModel.DiceResult;

public class SecondTableBigStraightStrategy extends SecondTableStaticStrategy {
	private List<DiceResult> bigStraight1;
	private List<DiceResult> bigStraight2;
	
	@Override
	public int getPoints(List<DiceResult> results) {
		initializeStraights();
		if(resultCheckStraight(results)) {
			return 40;
		}
		return 0;
	}
	
	private boolean resultCheckStraight(List<DiceResult> results) {
		return results.containsAll(bigStraight1) ||
				results.containsAll(bigStraight2);
	}
	private void initializeStraights() {
		bigStraight1 = new ArrayList<DiceResult>();
		bigStraight1.add(DiceResult.One);
		bigStraight1.add(DiceResult.Two);
		bigStraight1.add(DiceResult.Three);
		bigStraight1.add(DiceResult.Four);
		bigStraight1.add(DiceResult.Five);
		bigStraight2 = new ArrayList<DiceResult>();
		bigStraight2.add(DiceResult.Two);
		bigStraight2.add(DiceResult.Three);
		bigStraight2.add(DiceResult.Four);
		bigStraight2.add(DiceResult.Five);
		bigStraight2.add(DiceResult.Six);
	}
}
