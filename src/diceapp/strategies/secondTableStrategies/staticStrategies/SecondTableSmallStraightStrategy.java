package diceapp.strategies.secondTableStrategies.staticStrategies;

import java.util.ArrayList;
import java.util.List;

import diceapp.diceModel.DiceResult;

public class SecondTableSmallStraightStrategy extends SecondTableStaticStrategy {
	List<DiceResult> smallStraight1;
	List<DiceResult> smallStraight2;
	List<DiceResult> smallStraight3;
	@Override
	public int getPoints(List<DiceResult> results) {
		initializeStraights();
		if(resultCheckStraight(results)) {
			return 30;
		}
		return 0;
	}
	
	private boolean resultCheckStraight(List<DiceResult> results) {
		return results.containsAll(smallStraight1) ||
				results.containsAll(smallStraight2) ||
				results.containsAll(smallStraight3);
	}
	private void initializeStraights() {
		smallStraight1 = new ArrayList<DiceResult>();
		smallStraight1.add(DiceResult.One);
		smallStraight1.add(DiceResult.Two);
		smallStraight1.add(DiceResult.Three);
		smallStraight1.add(DiceResult.Four);
		smallStraight2 = new ArrayList<DiceResult>();
		smallStraight2.add(DiceResult.Two);
		smallStraight2.add(DiceResult.Three);
		smallStraight2.add(DiceResult.Four);
		smallStraight2.add(DiceResult.Five);
		smallStraight3 = new ArrayList<DiceResult>();
		smallStraight3.add(DiceResult.Three);
		smallStraight3.add(DiceResult.Four);
		smallStraight3.add(DiceResult.Five);
		smallStraight3.add(DiceResult.Six);
	}
	
	

}
