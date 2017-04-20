
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

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

		PlayerManager pmgr = new PlayerManager();
		TurnManager manager = new TurnManager();
		manager.setPlayerManager(pmgr);

	}
}
