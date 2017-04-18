
package code;

import java.util.List;
import java.util.Map;

import exceptions.InvalidNumberofPlayersException;

public class Game {

	PlayerManager playerManager;
	MainDeck mainDeck;

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

		mainDeck.populateDeck(n);

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

}
