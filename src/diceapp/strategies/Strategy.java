package diceapp.strategies;

import java.util.List;

import diceapp.diceModel.DiceResult;

public interface Strategy {
	public int getPoints(List<DiceResult> results);
}
