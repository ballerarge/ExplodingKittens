
package tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import code.InvalidNumberofPlayersException;
import code.PlayerManager;

public class PlayerManagerTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

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

	@Test
	public void testAddPlayersSingle() throws InvalidNumberofPlayersException {
		PlayerManager playerManager = new PlayerManager();

		exception.expect(InvalidNumberofPlayersException.class);

		playerManager.addPlayers(1);
	}

	@Test
	public void testAddPlayersTwo() throws InvalidNumberofPlayersException {
		PlayerManager playerManager = new PlayerManager();

		playerManager.addPlayers(2);

		assertEquals(playerManager.getPlayers().size(), 2);

	}

	@Test
	public void testAddPlayersFive() throws InvalidNumberofPlayersException {
		PlayerManager playerManager = new PlayerManager();

		playerManager.addPlayers(5);

		assertEquals(playerManager.getPlayers().size(), 5);

	}
}
