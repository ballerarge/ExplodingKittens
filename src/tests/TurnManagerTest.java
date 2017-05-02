
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.easymock.EasyMock;

import code.Card;
import code.Player;
import code.PlayerManager;
import code.TurnManager;
import code.TurnPriorityManager;
import exceptions.InvalidNumberofPlayersException;

public class TurnManagerTest {

	@Test
	public void testConstruction() {
		TurnManager.tearDown();
		TurnManager manager = TurnManager.getInstance();
		TurnManager.tearDown();
	}

	@Test
	public void testHandlesPlayerManager() {
		TurnManager.tearDown();

		PlayerManager pmgr = EasyMock.mock(PlayerManager.class);
		List<Player> players = new ArrayList<>();
		players.add(new Player());
		EasyMock.expect(pmgr.getPlayers()).andReturn(players);
		EasyMock.replay(pmgr);
		TurnManager manager = TurnManager.getInstance();
		manager.setPlayerManager(pmgr);
		assertEquals(pmgr, manager.getPlayerManager());
		EasyMock.verify(pmgr);
		TurnManager.tearDown();
	}

	@Test
	public void testHandlesPlayers() {
		TurnManager.tearDown();
		ArrayList<Player> players = new ArrayList<>();
		Player mockPlayer1 = EasyMock.mock(Player.class);
		Player mockPlayer2 = EasyMock.mock(Player.class);
		Player mockPlayer3 = EasyMock.mock(Player.class);
		players.add(mockPlayer1);
		players.add(mockPlayer2);
		players.add(mockPlayer3);
		PlayerManager mockPM = EasyMock.mock(PlayerManager.class);
		TurnManager manager = TurnManager.getInstance();

		EasyMock.expect(mockPM.getPlayers()).andReturn(players);

		EasyMock.replay(mockPM, mockPlayer1, mockPlayer2, mockPlayer3);

		manager.setPlayerManager(mockPM);

		EasyMock.verify(mockPM, mockPlayer1, mockPlayer2, mockPlayer3);

		assertEquals(mockPlayer1, manager.getCurrentPlayer());

		TurnManager.tearDown();
	}

	@Test
	public void testEndTurnWithoutDraw() {
		TurnManager.tearDown();
		ArrayList<Player> players = new ArrayList<>();
		Player mockPlayer1 = EasyMock.mock(Player.class);
		Player mockPlayer2 = EasyMock.mock(Player.class);
		Player mockPlayer3 = EasyMock.mock(Player.class);
		players.add(mockPlayer1);
		players.add(mockPlayer2);
		players.add(mockPlayer3);
		PlayerManager mockPM = EasyMock.mock(PlayerManager.class);
		TurnManager manager = TurnManager.getInstance();

		EasyMock.expect(mockPM.getPlayers()).andReturn(players);

		EasyMock.replay(mockPM, mockPlayer1, mockPlayer2, mockPlayer3);

		manager.setPlayerManager(mockPM);
		assertEquals(mockPlayer1, manager.getCurrentPlayer());
		manager.endTurnWithoutDraw();
		assertEquals(mockPlayer2, manager.getCurrentPlayer());
		manager.endTurnWithoutDraw();
		assertEquals(mockPlayer3, manager.getCurrentPlayer());
		manager.endTurnWithoutDraw();
		assertEquals(mockPlayer1, manager.getCurrentPlayer());

		EasyMock.verify(mockPM, mockPlayer1, mockPlayer2, mockPlayer3);

		TurnManager.tearDown();
	}

	@Test
	public void testEndTurnAndDraw() {
		TurnManager.tearDown();
		ArrayList<Player> players = new ArrayList<>();
		Card mockCard = EasyMock.mock(Card.class);
		Player mockPlayer1 = EasyMock.mock(Player.class);
		Player mockPlayer2 = EasyMock.mock(Player.class);
		Player mockPlayer3 = EasyMock.mock(Player.class);
		players.add(mockPlayer1);
		players.add(mockPlayer2);
		players.add(mockPlayer3);
		PlayerManager mockPM = EasyMock.mock(PlayerManager.class);
		TurnManager manager = TurnManager.getInstance();

		EasyMock.expect(mockPM.getPlayers()).andReturn(players);
		EasyMock.expect(mockPlayer1.drawCard()).andReturn(mockCard);
		EasyMock.expect(mockPlayer2.drawCard()).andReturn(mockCard);
		EasyMock.expect(mockPlayer3.drawCard()).andReturn(mockCard);

		EasyMock.replay(mockPM, mockPlayer1, mockPlayer2, mockPlayer3);

		manager.setPlayerManager(mockPM);
		assertEquals(mockPlayer1, manager.getCurrentPlayer());
		manager.endTurnAndDraw();
		assertEquals(mockPlayer2, manager.getCurrentPlayer());
		manager.endTurnAndDraw();
		assertEquals(mockPlayer3, manager.getCurrentPlayer());
		manager.endTurnAndDraw();
		assertEquals(mockPlayer1, manager.getCurrentPlayer());

		EasyMock.verify(mockPM, mockPlayer1, mockPlayer2, mockPlayer3);

		TurnManager.tearDown();
	}
}
