package code;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import exceptions.InvalidBundleException;
import exceptions.InvalidNumberofPlayersException;
import exceptions.NoCardsToMoveException;

public class GameLogger extends Game{
	
	Game game;
	
	public GameLogger(Game game){
		super(0);
		this.game = game;
	}
	
	@Override
	public void nextTurn() throws NoCardsToMoveException, InvalidBundleException{
		game.nextTurn();
		logStartofTurn();
	}
	
	private void logStartofTurn(){
		Log log = Log.getInstance();
		ResourceBundle bundle = ResourceBundle.getBundle("resources/resources",log.locale);
		String message = bundle.getString("TURN_MESSAGE_1");
		Player player = TurnManager.getInstance().getCurrentPlayer();
		message += player.getName();
		message += bundle.getString("TURN_MESSAGE_2");
		log.addEntry(new Entry(message));
	}
	
	@Override
	public void start(int n) throws InvalidNumberofPlayersException {
		game.start(n);
	}
	
	@Override
	public Map<Player, List<Card>> getPlayerHands() {
		return game.getPlayerHands();
	}
	
	@Override
	public Map<Player, Boolean> getPlayerStatus() {
		return game.getPlayerStatus();
	}
	
	@Override
	public boolean isMainDeckEmpty() {
		return game.isMainDeckEmpty();
	}
	
	@Override
	public Player getCurrentPlayer() {
		return game.getCurrentPlayer();
	}
	
	@Override
	public Player getActivePlayer() {
		return game.getActivePlayer();
	}
	
	@Override
	public List<Player> getPlayers() {
		return game.getPlayers();
	}
	
	@Override
	public PlayerManager getPlayerManager() {
		return game.getPlayerManager();
	}
	
	@Override
	public TurnManager getTurnManager() {
		return game.getTurnManager();
	}
}
