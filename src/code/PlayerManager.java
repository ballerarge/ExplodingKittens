
package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.InvalidNumberofPlayersException;

public class PlayerManager {

	private static final int INITIAL_HAND_NUMBER_OF_CARDS_TO_DRAW = 4;
	public List<Player> players;

	public PlayerManager() {
		players = new ArrayList<Player>();
	}

	public void addPlayers(int numPlayers) throws InvalidNumberofPlayersException {
		if (numPlayers < 2 || numPlayers > 5) {
			throw new InvalidNumberofPlayersException();
		}

		for (int i = 0; i < numPlayers; i++) {
			players.add(new Player());
		}
	}

	public void makePlayerDrawInitialHand() {

		for (int i = 0; i < players.size(); i++) {
			for (int j = 0; j < INITIAL_HAND_NUMBER_OF_CARDS_TO_DRAW; j++) {
				players.get(i).drawCard();
			}
			players.get(i).addDefuseCardToHand();
		}
	}

	// to be re-implemented after merge
	public Map<Player, List<Card>> getHands() {
		Map<Player, List<Card>> hands = new HashMap<Player, List<Card>>();
		for (int a = 0; a < players.size(); a++)
			hands.put(players.get(a), players.get(a).getHand());
		return hands;
	}

	public Map<Player, Boolean> getPlayerStatus() {
		Map<Player, Boolean> status = new HashMap<Player, Boolean>();
		for (int a = 0; a < players.size(); a++)
			status.put(players.get(a), true);
		return status;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public void removePlayerFromGame(Player player) {
		players.remove(player);
	}
}
