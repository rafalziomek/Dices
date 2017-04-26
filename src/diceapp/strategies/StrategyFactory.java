package diceapp.strategies;

import java.util.Arrays;

import diceapp.strategies.firstTableStrategies.FirstTableFiveStrategy;
import diceapp.strategies.firstTableStrategies.FirstTableFourStrategy;
import diceapp.strategies.firstTableStrategies.FirstTableOneStrategy;
import diceapp.strategies.firstTableStrategies.FirstTableSixStrategy;
import diceapp.strategies.firstTableStrategies.FirstTableThreeStrategy;
import diceapp.strategies.firstTableStrategies.FirstTableTwoStrategy;
import diceapp.strategies.secondTableStrategies.staticStrategies.SecondTableBigStraightStrategy;
import diceapp.strategies.secondTableStrategies.staticStrategies.SecondTableFullStrategy;
import diceapp.strategies.secondTableStrategies.staticStrategies.SecondTableGeneralStrategy;
import diceapp.strategies.secondTableStrategies.staticStrategies.SecondTableSmallStraightStrategy;
import diceapp.strategies.secondTableStrategies.sumStrategies.SecondTableChanceStrategy;
import diceapp.strategies.secondTableStrategies.sumStrategies.SecondTableFourSameStrategy;
import diceapp.strategies.secondTableStrategies.sumStrategies.SecondTableThreeSameStrategy;

public class StrategyFactory {

	public Strategy getStrategy(StrategyType strategyType) {
		switch(strategyType) {
		case Ones:
			return new FirstTableOneStrategy();
		case Twos:
			return new FirstTableTwoStrategy();
		case Threes:
			return new FirstTableThreeStrategy();
		case Fours:
			return new FirstTableFourStrategy();
		case Fives:
			return new FirstTableFiveStrategy();
		case Sixes:
			return new FirstTableSixStrategy();
		case ThreeTheSame:
			return new SecondTableThreeSameStrategy();
		case FourTheSame:
			return new SecondTableFourSameStrategy();
		case Full:
			return new SecondTableFullStrategy();
		case SmallStraight:
			return new SecondTableSmallStraightStrategy();
		case BigStraight:
			return new SecondTableBigStraightStrategy();
		case General:
			return new SecondTableGeneralStrategy();
		case Chance:
			return new SecondTableChanceStrategy();
		}
		return null;
	}
	
	public boolean isFirstStrategy(StrategyType strategyType) {
		return Arrays
				.stream(StrategyType.firstTableStrategies())
				.anyMatch(p -> p == strategyType);
	}

}
