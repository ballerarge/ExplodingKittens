
package code;

import java.util.List;
import java.util.Map;

import exceptions.InvalidNumberofPlayersException;

public class Game {

	private PlayerManager playerManager;
	private MainDeck mainDeck;
	private PriorityManager priorityManager;

	public Game() {

	}

	public void start(int n) throws InvalidNumberofPlayersException {
		if (n < 2 || n > 5)
			throw new InvalidNumberofPlayersException();
		MainDeck.tearDown();
		mainDeck = MainDeck.getInstance();
		mainDeck.initStartingDeck();

		playerManager = new PlayerManager();
		playerManager.addPlayers(n);
		
		priorityManager = PriorityManager.getInstance();
		priorityManager.addPlayers(playerManager.getPlayers());

		mainDeck.populateDeck(n);

		turnManager = new TurnManager();
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
	
	// Add to the nextTurn method the passing of priority (change current
	// player in priorityManager

	public void nextTurn() {
		turnManager.endTurnAndDraw();// Change later to allow for ending a turn
		                             // without drawing.
	}

}