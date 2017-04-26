package diceapp.strategies;

import java.util.Arrays;

public enum StrategyType {
	Ones,
	Twos,
	Threes,
	Fours,
	Fives,
	Sixes,
	ThreeTheSame,
	FourTheSame,
	Full,
	SmallStraight,
	BigStraight,
	General,
	Chance;
	
	public static StrategyType[] firstTableStrategies() {
		return new StrategyType[] {
				StrategyType.Ones,
				StrategyType.Twos,
				StrategyType.Threes,
				StrategyType.Fours,
				StrategyType.Fives,
				StrategyType.Sixes
		};
	}
	
	public static StrategyType[] secondTableStrategies() {
		return new StrategyType[] {
				StrategyType.ThreeTheSame,
				StrategyType.FourTheSame,
				StrategyType.Full,
				StrategyType.SmallStraight,
				StrategyType.BigStraight,
				StrategyType.General,
				StrategyType.Chance
		};
	}
	
	public static boolean isFirstStrategy(StrategyType strategyType) {
		return Arrays
				.stream(StrategyType.firstTableStrategies())
				.anyMatch(p -> p == strategyType);
	}
}
