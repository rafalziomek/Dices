package diceapp.tableview;



import diceapp.controllers.MoveController;
import diceapp.diceModel.DiceContainer;
import diceapp.score.PlayerScore;
import diceapp.strategies.StrategyType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class TableScoreColumn extends TableColumn{
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
	    
	private PlayerScore playerScore;
	private MoveController move;
	private DiceContainer diceContainer;
	public TableScoreColumn(PlayerScore playerScore, MoveController move, DiceContainer diceContainer) {
		super("resources/playerScore.fxml");
		this.move = move;
		this.playerScore = playerScore;
		this.diceContainer = diceContainer;
		playerName.setText("#" + playerScore.getTableScoreId());
		initializeListeners();
	}
	
	private void addListenerScoreUpdate(CheckBox strategyCheckBox, StrategyType strategy) {
		strategyCheckBox
			.selectedProperty()
			.addListener(new ChangeListener<Boolean>() {
		        public void changed(ObservableValue<? extends Boolean> ov,
		            Boolean old_val, Boolean new_val) {
		        		if(thisPlayerIsOnMove()) {
		        			acceptMove(strategyCheckBox, strategy);
		        		} else {
		        			dontAcceptMove(strategyCheckBox);
		        		}
		        }
			});
	}
	
	private boolean thisPlayerIsOnMove() {
		return playerScore.getTableScoreId() == move.getPlayerOnMove().getId();
	}
	
	private void acceptMove(CheckBox checkBox, StrategyType strategy) {
		checkBox.setDisable(true);
		saveScore(strategy);
        updateViewScore(checkBox);
        updateScores(playerScore);
        move.endOfMove();
	}
	
	private void dontAcceptMove(CheckBox checkBox) {
		checkBox.selectedProperty().set(false);
	}
	
	private void saveScore(StrategyType strategy) {
		playerScore.saveScore(strategy, diceContainer.getTopOfDices());
	}
	
	private void updateViewScore(CheckBox checkBox) {
		checkBox.setText(Integer.toString(playerScore.getLastScore()));
	}
	
	private void updateScores(PlayerScore playerScore) {
		firstTableScore.setText(Integer.toString(playerScore.getFirstTableScore()));
        secondTableScore.setText(Integer.toString(playerScore.getSecondTableScore()));
        tableScore.setText(Integer.toString(playerScore.getScore()));
	}
	
	private void initializeListeners() {
		addListenerScoreUpdate(playerOnes, StrategyType.Ones );
		addListenerScoreUpdate(playerTwos, StrategyType.Twos);
		addListenerScoreUpdate(playerThrees, StrategyType.Threes);
		addListenerScoreUpdate(playerFours, StrategyType.Fours);
		addListenerScoreUpdate(playerFives, StrategyType.Fives);
		addListenerScoreUpdate(playerSixes, StrategyType.Sixes);
		addListenerScoreUpdate(playerThreeSame, StrategyType.ThreeTheSame);
		addListenerScoreUpdate(playerFourSame, StrategyType.FourTheSame);
		addListenerScoreUpdate(playerFull, StrategyType.Full);
		addListenerScoreUpdate(playerSmallStraight, StrategyType.SmallStraight);
		addListenerScoreUpdate(playerBigStraight, StrategyType.BigStraight);
		addListenerScoreUpdate(playerGeneral, StrategyType.General);
		addListenerScoreUpdate(playerChance, StrategyType.Chance);
	}
	
	

}
