package diceapp.tests;

import java.util.ArrayList;

import org.junit.Test;

import diceapp.diceModel.DiceResult;
import diceapp.strategies.firstTableStrategies.FirstTableFiveStrategy;
import diceapp.strategies.firstTableStrategies.FirstTableFourStrategy;
import diceapp.strategies.firstTableStrategies.FirstTableOneStrategy;
import diceapp.strategies.firstTableStrategies.FirstTableSixStrategy;
import diceapp.strategies.firstTableStrategies.FirstTableThreeStrategy;
import diceapp.strategies.firstTableStrategies.FirstTableTwoStrategy;

public class GetPointsFirstTableStrategyTest extends GetPointsTableStrategyTest {
	
	@Test
	public void TestStrategies() {
		testOneStrategy();
		testTwoStrategy();
		testThreeStrategy();
		testFourStrategy();
		testFiveStrategy();
		testSixStrategy();
	}
	void testOneStrategy() {
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		testPointsStrategy(new FirstTableOneStrategy(), result, 3);
		testPointsStrategy(new FirstTableTwoStrategy(), result, 0);
		testPointsStrategy(new FirstTableSixStrategy(), result, 6);
	}
	void testTwoStrategy() {
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Two);
		result.add(DiceResult.Two);
		result.add(DiceResult.Two);
		result.add(DiceResult.Three);
		result.add(DiceResult.Two);
		testPointsStrategy(new FirstTableTwoStrategy(), result, 8);
	}
	void testThreeStrategy() {
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		result.add(DiceResult.Three);
		testPointsStrategy(new FirstTableThreeStrategy(), result, 15);
	}
	void testFourStrategy() {
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		testPointsStrategy(new FirstTableFourStrategy(), result, 0);
	}
	void testFiveStrategy() {
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.Five);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		testPointsStrategy(new FirstTableFiveStrategy(), result, 5);
	}
	void testSixStrategy() {
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Six);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		testPointsStrategy(new FirstTableSixStrategy(), result, 12);
	}

}
