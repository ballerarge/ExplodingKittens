
package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManager {

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

			makePlayerDrawInitialHand(i);
		}
	}

	private void makePlayerDrawInitialHand(int playerIndex) {
		for (int j = 0; j < 4; j++) {
			players.get(playerIndex).drawCard();
		}
		players.get(playerIndex).getHandManager().addDefuseCard();
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
		for (int a = 1; a <= players.size(); a++)
			status.put(new Player(), true);
		return status;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

}
