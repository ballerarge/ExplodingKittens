
package code;

import java.util.Map;

public class Game {

	PlayerManager playerManager;
	MainDeck mainDeck;

	public Game() {
	}

	public void start(int n) {
		playerManager = new PlayerManager();
		playerManager.addPlayers(n);
		mainDeck = new MainDeck();
		mainDeck.populateDeck(n);

	}

	public Map getPlayerHands() {
		return playerManager.getHands();
	}

	public Map getPlayerStatus() {
		return playerManager.getPlayerStatus();
	}

	public boolean isMainDeckEmpty() {
		return (mainDeck.getCardCount() != 0);
	}

}
