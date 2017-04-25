package diceapp.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;


import diceapp.diceModel.DiceResult;
import diceapp.strategies.Strategy;
import diceapp.strategies.firstTableStrategies.FirstTableStrategy;

public abstract class GetPointsTableStrategyTest {

	protected List<DiceResult> result;
	FirstTableStrategy firstTableStrategy;

	public GetPointsTableStrategyTest() {
		super();
	}

	protected void testPointsStrategy(Strategy strategy, List<DiceResult> result, int expectedPoints) {
		int points = strategy.getPoints(result);
		assertEquals(points, expectedPoints);
	}

}