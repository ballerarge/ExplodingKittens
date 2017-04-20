
package code;

import java.util.ArrayList;
import java.util.List;

public class TurnManager {

	PlayerManager playerManager;
	ArrayList<Player> turnOrder = new ArrayList<>();// current player is at
	                                                // index 0

	public void setPlayerManager(PlayerManager pm) {
		playerManager = pm;
		List<Player> players = playerManager.getPlayers();
		for (Player player : players)
			turnOrder.add(player);
	}

	public PlayerManager getPlayerManager() {
		return playerManager;
	}

	public Player getCurrentPlayer() {
		return turnOrder.get(0);
	}

}
