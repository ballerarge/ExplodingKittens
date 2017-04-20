
package code;

import java.util.ArrayList;
import java.util.List;

import exceptions.NoSuchPlayerException;

public class PriorityManager {
	private static PriorityManager priorityManager;
	private ArrayList<Player> playerList;
	private Player activePlayer;

	private PriorityManager() {
		this.playerList = new ArrayList<Player>();
	}

	public static PriorityManager getInstance() {
		if (priorityManager == null) {
			priorityManager = new PriorityManager();
		}
		return priorityManager;
	}

	public void removePlayer(Player player) throws NoSuchPlayerException {
		if (this.playerList.contains(player)) {
			if (this.activePlayer.equals(player)) {
				this.activePlayer = this.playerList.get((this.playerList.indexOf(player) + 1) % getPlayerCount());
			}
			this.playerList.remove(player);
		} else {
			throw new NoSuchPlayerException();
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
}
