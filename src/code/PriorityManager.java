
package code;

import java.util.ArrayList;

import exceptions.NoSuchPlayerException;

public class PriorityManager {
	private static PriorityManager priorityManager;
	private ArrayList<Player> playerList;

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
		if(this.playerList.contains(player)) {
			this.playerList.remove(player);
		} else {
			throw new NoSuchPlayerException();
		}
	}

	public static void tearDown() {
		// TODO Auto-generated method stub
		
	}
}
