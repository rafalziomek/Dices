package diceapp.diceModel;

import java.util.Random;

public class Dice {
    private DiceResult topOfDice;
    private Random random;
    
    public Dice() {
    	random = new Random();
    }
    public void RollADice() {
    	int randomInt = random.nextInt(6);
    	int result = randomInt + 1;
    	topOfDice = DiceResult.getResult(result);
    }
    
    public DiceResult getTopOfDice() {
    	return topOfDice;
    }
}
