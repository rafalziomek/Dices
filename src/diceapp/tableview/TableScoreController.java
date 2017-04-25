package diceapp.tableview;


import java.io.IOException;

import diceapp.controllers.MoveController;
import diceapp.diceModel.DiceContainer;
import diceapp.score.PlayerScore;
import diceapp.strategies.StrategyType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TableScoreController {
	 @FXML
	    private Label playerName;

	    @FXML
	    private CheckBox playerOnes;

	    @FXML
	    private CheckBox playerTwos;

	    @FXML
	    private CheckBox playerThrees;

	    @FXML
	    private CheckBox playerFours;

	    @FXML
	    private CheckBox playerFives;

	    @FXML
	    private CheckBox playerSixes;

	    @FXML
	    private Label firstTableScore;

	    @FXML
	    private CheckBox playerThreeSame;

	    @FXML
	    private CheckBox playerFourSame;

	    @FXML
	    private CheckBox playerFull;

	    @FXML
	    private CheckBox playerSmallStraight;

	    @FXML
	    private CheckBox playerBigStraight;

	    @FXML
	    private CheckBox playerGeneral;

	    @FXML
	    private CheckBox playerChance;

	    @FXML
	    private Label secondTableScore;

	    @FXML
	    private Label tableScore;
	    
	private GridPane table;
	private PlayerScore playerScore;
	private MoveController move;
	private DiceContainer diceContainer;
	public TableScoreController(PlayerScore playerScore, MoveController move, DiceContainer diceContainer) {
		loadFXML();
		this.move = move;
		this.playerScore = playerScore;
		this.diceContainer = diceContainer;
		playerName.setText("#" + playerScore.getTableScoreId());
		addListener(playerOnes, StrategyType.Ones );
		addListener(playerTwos, StrategyType.Twos);
		addListener(playerThrees, StrategyType.Threes);
		addListener(playerFours, StrategyType.Fours);
		addListener(playerFives, StrategyType.Fives);
		addListener(playerSixes, StrategyType.Sixes);
		addListener(playerThreeSame, StrategyType.ThreeTheSame);
		addListener(playerFourSame, StrategyType.FourTheSame);
		addListener(playerFull, StrategyType.Full);
		addListener(playerSmallStraight, StrategyType.SmallStraight);
		addListener(playerBigStraight, StrategyType.BigStraight);
		addListener(playerGeneral, StrategyType.General);
		addListener(playerChance, StrategyType.Chance);
	}
	
	private boolean thisPlayerIsOnMove() {
		return playerScore.getTableScoreId() == move.getPlayerOnMove().getId();
	}
	
	private void addListener(CheckBox cb, StrategyType strategy) {
		cb.selectedProperty().addListener(new ChangeListener<Boolean>() {
	        public void changed(ObservableValue<? extends Boolean> ov,
	            Boolean old_val, Boolean new_val) {
	        		if(thisPlayerIsOnMove()) {
	        			cb.setDisable(true);
	        			playerScore.saveScore(strategy, diceContainer.getTopOfDices());
		                cb.setText(Integer.toString(playerScore.getLastScore()));
		                updateScores(playerScore);
		                
		                move.moveIsDone();
	        		} else {
	        			cb.selectedProperty().set(false);
	        		}
	                
	        }
	    });
	}
	
	private void updateScores(PlayerScore playerScore) {
		firstTableScore.setText(Integer.toString(playerScore.getFirstTableScore()));
        secondTableScore.setText(Integer.toString(playerScore.getSecondTableScore()));
        tableScore.setText(Integer.toString(playerScore.getScore()));
	}
	private void loadFXML() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"resources/playerScore.fxml"));
				        fxmlLoader.setController(this);
				        try {
				            table = fxmlLoader.load();
				        } catch (IOException exception) {
				            throw new RuntimeException(exception);
				        }
	}
	public GridPane getTable() {
		return table;
	}
	

}
