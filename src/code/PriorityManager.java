
package code;

import java.util.ArrayList;
import java.util.List;

public class PriorityManager {
	private static PriorityManager priorityManager;
	private ArrayList<Player> playerList;
	private Player activePlayer;
	private int cycleCount;

	private PriorityManager() {
		this.playerList = new ArrayList<Player>();
	}

	public static PriorityManager getInstance() {
		if (priorityManager == null) {
			priorityManager = new PriorityManager();
		}
		return priorityManager;
	}

	public void removePlayer(Player player) {
		if (this.playerList.contains(player)) {
			this.playerList.remove(player);
		}
	}

	public static void tearDown() {
		PriorityManager.priorityManager = null;
	}

	public void addPlayers(List<Player> players) {
		this.playerList.addAll(players);
		if (this.activePlayer == null) {
			this.activePlayer = this.playerList.get(0);
		}
	}

	public Player getActivePlayer() {
		return this.activePlayer;
	}

	public int getPlayerCount() {
		return this.playerList.size();
	}

	public void nextPlayer() {
		this.activePlayer = this.playerList.get((this.playerList.indexOf(getActivePlayer()) + 1) % getPlayerCount());
	}

	public void resolveCard() {
		Player startingPlayer = getActivePlayer();
		do {
			nextPlayer();
			setCycleCount(getCycleCount() + 1);
		} while (!startingPlayer.equals(getActivePlayer()));

		CardStack.getInstance().resolveTopCard();
	}

	public void setCycleCount(int i) {
		cycleCount = i;

	}

	public int getCycleCount() {
		return cycleCount;
	}
}
