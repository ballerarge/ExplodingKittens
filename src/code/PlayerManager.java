
package code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManager {

	int c;

	public PlayerManager() {
		c = 0;
	}

	public void addPlayers(int numPlayers) {
		c += numPlayers;
	}

	// to be re-implemented after merge
	public Map getHands() {
		Map<Player, List> hands = new HashMap();
		for (int a = 1; a <= c; a++)
			hands.put(new Player(), null);
		return hands;
	}

	public Map getPlayerStatus() {
		Map<Player, Boolean> status = new HashMap();
		for (int a = 1; a <= c; a++)
			status.put(new Player(), true);
		return status;
	}

}
