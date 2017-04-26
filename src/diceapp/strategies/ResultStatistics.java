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
	
	public Map<DiceResult, Integer> getDiceResultOccurences() {
		Map<DiceResult, Integer> diceResultOccurences = new HashMap<DiceResult, Integer>();
		for(int j = 0; j < 6; j++) {
			
			int diceResultToCheck = j + 1;
			int counts = getNumberOfOccurences(diceResultToCheck);
			diceResultOccurences.put(DiceResult.values()[j], counts);
		}
		return diceResultOccurences;
	}
	
	private int getNumberOfOccurences(int diceResultToCheck) {
		return (int) result.stream().filter(diceResultEquals(diceResultToCheck)).count();
	}
	private Predicate<DiceResult> diceResultEquals(int j) {
		return  p -> p.getValue() == j;
	}
}
