
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
			this.playerList.remove(player);
		} else {
			throw new NoSuchPlayerException();
		}
	}

	public static void tearDown() {
		// TODO Auto-generated method stub

	}

	public void addPlayers(List<Player> players) {
		// TODO Auto-generated method stub
		this.playerList.addAll(players);
		if (this.activePlayer == null) {
			this.activePlayer = this.playerList.get(0);
		}
	}

	public Player getActivePlayer() {
		// TODO Auto-generated method stub
		return this.activePlayer;
	}
}
