
package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManager {

	int c;
	public List<Player> players;

	public PlayerManager() {
		players = new ArrayList<Player>();
	}

	public void addPlayers(int numPlayers) {
		c += numPlayers;
	}

	// to be re-implemented after merge
	public Map<Player, List<Card>> getHands() {
		Map<Player, List<Card>> hands = new HashMap<Player, List<Card>>();
		for (int a = 1; a <= c; a++)
			hands.put(new Player(), null);
		return hands;
	}

	public Map<Player, Boolean> getPlayerStatus() {
		Map<Player, Boolean> status = new HashMap<Player, Boolean>();
		for (int a = 1; a <= c; a++)
			status.put(new Player(), true);
		return status;
	}

}
