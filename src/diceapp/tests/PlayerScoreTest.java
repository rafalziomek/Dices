package diceapp.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import diceapp.diceModel.DiceResult;
import diceapp.player.Player;
import diceapp.score.PlayerScore;
import diceapp.strategies.StrategyType;

public class PlayerScoreTest {
	private Player player;
	private PlayerScore playerScore;
	private List<DiceResult> result;
	@Before
	public void initialize() {
		player = new Player(1);
	}
	
	@Test
	public void testAll() {
		testFirstTableScore();
		testSecondTableScore();
		testAbove63();
	}
	//Example game of one player with results
	private void testFirstTableScore() {
		playerScore = new PlayerScore(player);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		
		testFirstTableScore(StrategyType.Ones, result, 3);
		// the same strategy should do not add score
		testFirstTableScore(StrategyType.Ones, result, 3);
		
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Two);
		result.add(DiceResult.One);
		result.add(DiceResult.Two);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		
		testFirstTableScore(StrategyType.Sixes, result, 9);
	}
	
	private void testSecondTableScore() {
		playerScore = new PlayerScore(player);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		result.add(DiceResult.One);
		
		testSecondTableScore(StrategyType.General, result, 50);
		// the same strategy should do not add score
		testSecondTableScore(StrategyType.General, result, 50);
		
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.Two);
		result.add(DiceResult.Four);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		
		testSecondTableScore(StrategyType.SmallStraight, result, 80);
	}
	
	public void testScore() {
		playerScore = new PlayerScore(player);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.Two);
		result.add(DiceResult.Three);
		result.add(DiceResult.Five);
		result.add(DiceResult.Six);
		
		testScore(StrategyType.General, result, 50);
		//the result do not has three same it should do not add
		testScore(StrategyType.ThreeTheSame, result, 50);
		
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.One);
		result.add(DiceResult.Two);
		result.add(DiceResult.Four);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		
		testScore(StrategyType.Sixes, result, 46);
	}
	
	private void testAbove63() {
		playerScore = new PlayerScore(player);
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Six);
		result.add(DiceResult.Six);
		result.add(DiceResult.Six);
		result.add(DiceResult.Six);
		result.add(DiceResult.Six);
		
		testScore(StrategyType.Sixes, result, 30);
		
		testScore(StrategyType.ThreeTheSame, result, 60);
		
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Five);
		result.add(DiceResult.Five);
		result.add(DiceResult.Five);
		result.add(DiceResult.Five);
		result.add(DiceResult.Five);
		
		testScore(StrategyType.Fives, result, 85);
		
		result = new ArrayList<DiceResult>();
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		result.add(DiceResult.Three);
		result.add(DiceResult.Six);
		result.add(DiceResult.Three);
		
		testScore(StrategyType.Threes, result, 119);
	}
	
	private void testFirstTableScore(StrategyType strategyType, List<DiceResult> result, int expected) {
		playerScore.saveScore(strategyType, result);
		int score = playerScore.getFirstTableScore();
		assertEquals(score, expected);
	}
	private void testSecondTableScore(StrategyType strategyType, List<DiceResult> result, int expected) {
		playerScore.saveScore(strategyType, result);
		int score = playerScore.getSecondTableScore();
		assertEquals(score, expected);
	}
	private void testScore(StrategyType strategyType, List<DiceResult> result, int expected) {
		playerScore.saveScore(strategyType, result);
		int score = playerScore.getScore();
		assertEquals(score, expected);
	}
}
