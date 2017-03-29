
package code;

import java.util.Map;

public class Game {

	PlayerManager playerManager;

	public Game() {
	}

	public void start(int n) {
		playerManager = new PlayerManager();
		playerManager.addPlayers(n);
	}

	public Map getPlayerHands() {
		return playerManager.getHands();
	}
}
