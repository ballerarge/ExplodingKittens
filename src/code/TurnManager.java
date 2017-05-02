
package code;

import java.util.ArrayList;
import java.util.List;

public class TurnManager {

	private static TurnManager turnManager;
	Player currentPlayer;
	PlayerManager playerManager;
	ArrayList<Player> turnOrder = new ArrayList<>();// current player is at
	                                                // index 0

	public static TurnManager getInstance() {
		if (turnManager == null) {
			turnManager = new TurnManager();
		}
		return turnManager;
	}
	
	public static void tearDown() {
		turnManager = null;
	}
	
	private TurnManager() {
		
	}
	
	public void setPlayerManager(PlayerManager pm) {
		playerManager = pm;
		List<Player> players = playerManager.getPlayers();
		for (Player player : players)
			turnOrder.add(player);
		currentPlayer=turnOrder.get(0);
	}

	public PlayerManager getPlayerManager() {
		return playerManager;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void endTurnAndDraw() {
		Player player = turnOrder.remove(0);
		if (!turnOrder.get(turnOrder.size() - 1).equals(player))// Don't
		                                                        // circulate
		                                                        // turns from
		                                                        // attacks
			turnOrder.add(player);
		player.drawCard();
		currentPlayer = turnOrder.get(0);
	}

	public void endTurnWithoutDraw() {
		Player player = turnOrder.remove(0);
		if (!turnOrder.get(turnOrder.size() - 1).equals(player))// Don't
		                                                        // circulate
		                                                        // turns from
		                                                        // attacks
			turnOrder.add(player);
		currentPlayer = turnOrder.get(0);
	}
}
