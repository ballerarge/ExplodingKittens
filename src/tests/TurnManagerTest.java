
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.Player;
import code.PlayerManager;
import code.TurnManager;
import code.TurnPriorityManager;

public class TurnManagerTest {

	@Test
	public void testConstruction() {
		TurnManager manager = new TurnManager();
	}

	@Test
	public void testHandlesPlayerManager() {

		PlayerManager pmgr = new PlayerManager();
		TurnManager manager = new TurnManager();
		manager.setPlayerManager(pmgr);
		assertEquals(pmgr, manager.getPlayerManager());
	}

	@Test
	public void testHandlesPlayers() {

		ArrayList<Player> players = new ArrayList<>();
		players.add(new Player("Adam"));
		players.add(new Player("Bob"));
		players.add(new Player("Charlie"));
		PlayerManager pmgr = new PlayerManager();
		pmgr.players = players;
		TurnManager manager = new TurnManager();
		manager.setPlayerManager(pmgr);
		
		assertEquals("Adam", manager.getCurrentPlayer().getName());
	}
	
	
}
