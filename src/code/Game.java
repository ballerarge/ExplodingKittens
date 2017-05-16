
package code;

import java.util.List;
import java.util.Map;
import exceptions.InvalidNumberofPlayersException;

public class Game {
	private PlayerManager playerManager;
	private MainDeck mainDeck;
	private PriorityManager priorityManager;
	private TurnManager turnManager;

	public Game() {
		MainDeck.tearDown();
		mainDeck = MainDeck.getInstance();
		priorityManager = PriorityManager.getInstance();
		turnManager = TurnManager.getInstance();
	}

	public void start(int n) throws InvalidNumberofPlayersException {
		if (n < 2 || n > 5)
			throw new InvalidNumberofPlayersException();
		mainDeck.initStartingDeck();
		playerManager = new PlayerManager();
		playerManager.addPlayers(n);
		priorityManager.addPlayers(playerManager.getPlayers());
		mainDeck.populateDeck(n);
		turnManager.setPlayerManager(playerManager);
	}

	public Map<Player, List<Card>> getPlayerHands() {
		return playerManager.getHands();
	}

	public Map<Player, Boolean> getPlayerStatus() {
		return playerManager.getPlayerStatus();
	}

	public boolean isMainDeckEmpty() {
		return (mainDeck.getCardCount() == 0);
	}

	public void nextTurn() {
		turnManager.endTurnAndDraw();// Change later to allow for ending a turn
		                             // without drawing.
		priorityManager.nextPlayer();
	}

	public Player getActivePlayer() {
		return priorityManager.getActivePlayer();
	}

	public Player getCurrentPlayer() {
		return turnManager.getCurrentPlayer();
	}

	public List<Player> getPlayers() {
		return playerManager.getPlayers();
	}
}