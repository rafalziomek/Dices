package diceapp.tableview;



import diceapp.controllers.MoveController;
import diceapp.controllers.PlayerScoreController;
import diceapp.labels.TableScoreLabels;
import diceapp.listeners.SaveScoreListener;
import diceapp.score.PlayerScore;
import diceapp.strategies.StrategyType;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class TableScoreColumnView extends TableColumnView {
	
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
	    
	
	private SaveScoreListener saveScoreListener;
	
	public TableScoreColumnView(PlayerScore playerScore, MoveController move) {
		super("resources/playerScore.fxml");
		
		int tableId = playerScore.getTableScoreId();
		
		TableScoreLabels scoreLabels = new TableScoreLabels(firstTableScore, secondTableScore, tableScore);
		PlayerScoreController scoreUpdater = new PlayerScoreController(playerScore, move, scoreLabels);
		saveScoreListener = new SaveScoreListener(scoreUpdater, move);
		
		setColumnHeader(tableId);
		
		initializeListeners();
	}
	
	private void setColumnHeader(int tableId) {
		playerName.setText("#" + tableId);
	}
	
	private void initializeListeners() {
		saveScoreListener.setListenerScoreUpdate(playerOnes, StrategyType.Ones );
		saveScoreListener.setListenerScoreUpdate(playerTwos, StrategyType.Twos);
		saveScoreListener.setListenerScoreUpdate(playerThrees, StrategyType.Threes);
		saveScoreListener.setListenerScoreUpdate(playerFours, StrategyType.Fours);
		saveScoreListener.setListenerScoreUpdate(playerFives, StrategyType.Fives);
		saveScoreListener.setListenerScoreUpdate(playerSixes, StrategyType.Sixes);
		saveScoreListener.setListenerScoreUpdate(playerThreeSame, StrategyType.ThreeTheSame);
		saveScoreListener.setListenerScoreUpdate(playerFourSame, StrategyType.FourTheSame);
		saveScoreListener.setListenerScoreUpdate(playerFull, StrategyType.Full);
		saveScoreListener.setListenerScoreUpdate(playerSmallStraight, StrategyType.SmallStraight);
		saveScoreListener.setListenerScoreUpdate(playerBigStraight, StrategyType.BigStraight);
		saveScoreListener.setListenerScoreUpdate(playerGeneral, StrategyType.General);
		saveScoreListener.setListenerScoreUpdate(playerChance, StrategyType.Chance);
	}
	
	

}
