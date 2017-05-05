
package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import code.CardFactory;
import code.CardStack;
import code.Player;
import code.PriorityManager;
import exceptions.NoSuchPlayerException;

public class PriorityManagerTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testPriorityManagerInstanceGet() {
		@SuppressWarnings("unused")
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
	public void testRemovePlayerNotInPlayerList() throws NoSuchPlayerException {
		PriorityManager pm = PriorityManager.getInstance();

		exception.expect(NoSuchPlayerException.class);

		List<Player> players = new ArrayList<Player>();
		players.add(new Player("Player 1"));
		players.add(new Player("Player 2"));

		pm.removePlayer(new Player("Player 3"));

		PriorityManager.tearDown();
	}

	@Test
	public void testRemoveActivePlayerFromPlayerList() throws NoSuchPlayerException {
		PriorityManager pm = PriorityManager.getInstance();

		List<Player> players = new ArrayList<Player>();
		players.add(new Player("Player 1"));
		players.add(new Player("Player 2"));

		pm.addPlayers(players);

		pm.removePlayer(pm.getActivePlayer());

		assertEquals("Player 2", pm.getActivePlayer().getName());
		assertEquals(1, pm.getPlayerCount());

		PriorityManager.tearDown();
	}

	@Test
	public void testRemoveNonActivePlayerFromPlayerList() throws NoSuchPlayerException {
		PriorityManager pm = PriorityManager.getInstance();

		List<Player> players = new ArrayList<Player>();
		players.add(new Player("Player 1"));
		players.add(new Player("Player 2"));

		pm.addPlayers(players);

		pm.removePlayer(players.get(1));

		assertEquals("Player 1", pm.getActivePlayer().getName());
		assertEquals(1, pm.getPlayerCount());

		PriorityManager.tearDown();
	}

	@Test
	public void getActivePlayer() {
		PriorityManager pm = PriorityManager.getInstance();

		List<Player> players = new ArrayList<Player>();
		players.add(new Player("Player 1"));
		players.add(new Player("Player 2"));

		pm.addPlayers(players);

		assertEquals("Player 1", pm.getActivePlayer().getName());

		PriorityManager.tearDown();
	}

	@Test
	public void testNextPlayer() {
		PriorityManager pm = PriorityManager.getInstance();

		List<Player> players = new ArrayList<Player>();
		players.add(new Player("Player 1"));
		players.add(new Player("Player 2"));

		pm.addPlayers(players);

		assertEquals("Player 1", pm.getActivePlayer().getName());

		pm.nextPlayer();

		assertEquals("Player 2", pm.getActivePlayer().getName());

		pm.nextPlayer();

		assertEquals("Player 1", pm.getActivePlayer().getName());

		PriorityManager.tearDown();
	}

	@Test
	public void testResolveCard() {
		CardFactory cf = new CardFactory();
		PriorityManager pm = PriorityManager.getInstance();

		List<Player> players = new ArrayList<Player>();
		players.add(new Player("Player 1"));
		players.add(new Player("Player 2"));
		players.add(new Player("Player 3"));
		players.add(new Player("Player 4"));

		pm.addPlayers(players);

		CardStack.tearDown();
		CardStack.getInstance().addCard(cf.createCard(CardFactory.NORMAL_CARD));
		assertEquals(1, CardStack.getInstance().getStack().size());

		pm.resolveCard();

		assertEquals(0, CardStack.getInstance().getStack().size());

		PriorityManager.tearDown();
		CardStack.tearDown();
	}
}
