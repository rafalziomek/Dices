package diceapp.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import diceapp.diceModel.DiceResult;
import diceapp.strategies.ResultStatistics;

public class ResultStatisticsTest {
	List<DiceResult> result;
	ResultStatistics stat;
	@Before
	public void initialize() {
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		stat = new ResultStatistics(result);
	}
	@Test
	public void testCounter() {
		Map<DiceResult, Integer> map = stat.getDiceResultOccurences();
		Map<DiceResult, Integer> mapToCheck = new HashMap<DiceResult, Integer>();
		mapToCheck.put(DiceResult.One, 3);
		mapToCheck.put(DiceResult.Two, 0);
		mapToCheck.put(DiceResult.Three, 1);
		mapToCheck.put(DiceResult.Four, 0);
		mapToCheck.put(DiceResult.Five, 0);
		mapToCheck.put(DiceResult.Six, 1);
		assertThat(map, is(mapToCheck));
	}
}
