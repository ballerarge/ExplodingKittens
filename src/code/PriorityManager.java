
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

		nextPlayer();

		while (!startingPlayer.equals(getActivePlayer())) {
			nextPlayer();
			// Something else needs to happen here. Will probably be in the GUI
			// where if a button is pressed, then this method will be called
			// again. If not, there needs to be a method call here that waits
			// for further input to be given from the GUI. It can't just loop
			// through the players when called without giving them a chance
			// to respond.
		}

		CardStack.getInstance().resolveTopCard();
	}
}
