package diceapp.diceModel;

public enum DiceResult {
	One(1),
	Two(2),
	Three(3),
	Four(4),
	Five(5),
	Six(6);
	
	private final int value;
	
	private DiceResult(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public static DiceResult getResult(int value) {
		int index = value;
		index--;
		return DiceResult.values()[index];
	}
}
