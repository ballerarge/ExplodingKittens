
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.*;

public class PlayerManagerTest {

	@Test
	public void testPlayerManagerCreation() {
		PlayerManager playerManager = new PlayerManager();
	}

	@Test
	public void testPlayerManagerListCreation() {
		PlayerManager playerManager = new PlayerManager();

		assertTrue(playerManager.players != null);
	}

	@Test
	public void testGetPlayersEmpty() {
		PlayerManager playerManager = new PlayerManager();

		assertTrue(playerManager.getPlayers().size() == 0);
	}
}
