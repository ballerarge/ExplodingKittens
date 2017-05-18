
package code;

import java.util.ArrayList;
import java.util.List;

import exceptions.NoSuchPlayerException;

public class TurnManager {

	private static TurnManager turnManager;
	Player currentPlayer;
	PlayerManager playerManager;
	ArrayList<Player> turnOrder;// current player is at
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
		turnOrder = new ArrayList<>();
	}

	public void setPlayerManager(PlayerManager pm) {
		Player temp = currentPlayer;
		playerManager = pm;
		List<Player> players = playerManager.getPlayers();
		for (Player player : players)
			turnOrder.add(player);
		if (temp == null) {
			currentPlayer = turnOrder.get(0);
		} else {
			currentPlayer = temp;
		}

	}

	public PlayerManager getPlayerManager() {
		return playerManager;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void endTurnAndDraw() {
		Player player = turnOrder.remove(0);
		Card drawnCard = player.drawCard();
		if (drawnCard instanceof ExplodingKittenCard) {
			CardStack.getInstance().addCard(drawnCard);
			PriorityManager.getInstance().resolveCard();
		} else if (turnOrder.size() > 0 && !turnOrder.get(turnOrder.size() - 1).equals(player)) {// Don't
			// circulate
			// turns from
			// attacks
			turnOrder.add(player);
		}
		if (turnOrder.size() == 0) {
			System.out.println("Game over!");
		} else {
			currentPlayer = turnOrder.get(0);
		}
	}

	public void endTurnWithoutDraw() {
		Player player = turnOrder.remove(0);
		boolean nextTurnIsSamePlayer = turnOrder.get(0).equals(player);
		if (!nextTurnIsSamePlayer) {// Don't
		                            // circulate
		                            // turns from
		                            // attacks
			turnOrder.add(player);
		}

		currentPlayer = turnOrder.get(0);
	}

	public void endTurnWithoutDrawForAttacks() {
		Player player = turnOrder.remove(0);
		boolean nextTurnIsSamePlayer = turnOrder.get(0).equals(player);
		if (turnOrder.get(0).equals(player)) {
			turnOrder.remove(0);
		}
		if (!nextTurnIsSamePlayer) {
			turnOrder.add(player);
		}
		currentPlayer = turnOrder.get(0);
	}

	public void addTurnForCurrentPlayer() {
		turnOrder.add(1, currentPlayer);
	}

	public void makeCurrentPlayerLose() {
		playerManager.removePlayerFromGame(currentPlayer);
		PriorityManager.getInstance().removePlayer(currentPlayer);
		removeAllInstancesFromTurnOrder();
	}

	private void removeAllInstancesFromTurnOrder() {
		for(int i = turnOrder.size() - 1; i >= 0; i--) {
			Player checkPlayer = turnOrder.get(i);
			if (checkPlayer.equals(currentPlayer)) {
				turnOrder.remove(checkPlayer);
			}
		}	
	}

	public List<Player> getTurnOrder() {
		return turnOrder;
	}
}
