package diceapp.diceModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DiceContainer {
	private Dice[] dices;
	private List<DiceResult> result;
	
	public DiceContainer(int numberOfDices) {
		dices = new Dice[numberOfDices];
		for(int i = 0; i < numberOfDices; i++) {
			dices[i] = new Dice();
		}
	}
	
	public void rollAllDices() {
		Arrays.stream(dices).forEach(p -> p.RollADice());
	}
	
	public List<DiceResult> getTopOfDices() {
		List<DiceResult> topOfDices = Arrays.stream(dices).map(p -> p.getTopOfDice()).collect(Collectors.toList());
		result = topOfDices;
		return result;
	}
	
	public void rollAllDicesExclude(boolean[] dicesToStay) {
		for(int i = 0; i < dicesToStay.length; i++) {
			if(!dicesToStay[i]){
				dices[i].RollADice();
			}
		}
	}
}
