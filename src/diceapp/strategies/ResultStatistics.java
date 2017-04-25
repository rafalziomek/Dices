package diceapp.strategies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import diceapp.diceModel.DiceResult;

public class ResultStatistics {
	private List<DiceResult> result;
	
	public ResultStatistics(List<DiceResult> result) {
		this.result = result;
	}
	
	public Map<DiceResult, Integer> counts() {
		Map<DiceResult, Integer> map = new HashMap<DiceResult, Integer>();
		for(int j = 0; j < 6; j++) {
			int counts = (int) result.stream().filter(intEquals(j+1)).count();
			map.put(DiceResult.values()[j], counts);
		}
		return map;
	}
	private Predicate<DiceResult> intEquals(int j) {
		return  p -> p.getValue() == j;
	}
}
