
package tests;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import code.Player;
import code.PriorityManager;
import exceptions.NoSuchPlayerException;

public class PriorityManagerTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testPriorityManagerInstanceGet() {
		PriorityManager pm = PriorityManager.getInstance();
	}

	@Test
	public void testRemovePlayerFromEmptyPlayerList() throws NoSuchPlayerException {
		PriorityManager pm = PriorityManager.getInstance();

		exception.expect(NoSuchPlayerException.class);

		pm.removePlayer(new Player("Player 1"));

		PriorityManager.tearDown();
	}

	@Test
	public void getActivePlayer() {
		PriorityManager pm = PriorityManager.getInstance();

		pm.addPlayers(new ArrayList<Player>(new Player("Player 1"), new Player("Player 2")));

		pm.getActivePlayer();

		PriorityManager.tearDown();
	}

}
