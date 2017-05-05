
package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;

import code.Player;
import code.PlayerManager;
import code.TurnManager;

public class TurnManagerTest {

	@Test
	public void testConstruction() {
		@SuppressWarnings("unused")
		TurnManager manager = new TurnManager();
	}

	@Test
	public void testHandlesPlayerManager() {

		PlayerManager pmgr = EasyMock.mock(PlayerManager.class);
		List<Player> players = new ArrayList<>();
		players.add(new Player());
		EasyMock.expect(pmgr.getPlayers()).andReturn(players);
		EasyMock.replay(pmgr);
		TurnManager manager = new TurnManager();
		manager.setPlayerManager(pmgr);
		assertEquals(pmgr, manager.getPlayerManager());
		EasyMock.verify(pmgr);
	}

	@Test
	public void testHandlesPlayers() {
		ArrayList<Player> players = new ArrayList<>();
		Player mockPlayer1 = EasyMock.mock(Player.class);
		Player mockPlayer2 = EasyMock.mock(Player.class);
		Player mockPlayer3 = EasyMock.mock(Player.class);
		players.add(mockPlayer1);
		players.add(mockPlayer2);
		players.add(mockPlayer3);
		PlayerManager mockPM = EasyMock.mock(PlayerManager.class);
		TurnManager manager = new TurnManager();

		EasyMock.expect(mockPM.getPlayers()).andReturn(players);

		EasyMock.replay(mockPM, mockPlayer1, mockPlayer2, mockPlayer3);

		manager.setPlayerManager(mockPM);

		EasyMock.verify(mockPM, mockPlayer1, mockPlayer2, mockPlayer3);

		assertEquals(mockPlayer1, manager.getCurrentPlayer());
	}

	@Test
	public void testEndTurnWithoutDraw() {
		ArrayList<Player> players = new ArrayList<>();
		Player mockPlayer1 = EasyMock.mock(Player.class);
		Player mockPlayer2 = EasyMock.mock(Player.class);
		Player mockPlayer3 = EasyMock.mock(Player.class);
		players.add(mockPlayer1);
		players.add(mockPlayer2);
		players.add(mockPlayer3);
		PlayerManager mockPM = EasyMock.mock(PlayerManager.class);
		TurnManager manager = new TurnManager();

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
	}

	@Test
	public void testEndTurnAndDraw() {
		ArrayList<Player> players = new ArrayList<>();
		Player mockPlayer1 = EasyMock.mock(Player.class);
		Player mockPlayer2 = EasyMock.mock(Player.class);
		Player mockPlayer3 = EasyMock.mock(Player.class);
		players.add(mockPlayer1);
		players.add(mockPlayer2);
		players.add(mockPlayer3);
		PlayerManager mockPM = EasyMock.mock(PlayerManager.class);
		TurnManager manager = new TurnManager();

		EasyMock.expect(mockPM.getPlayers()).andReturn(players);
		mockPlayer1.drawCard();
		mockPlayer2.drawCard();
		mockPlayer3.drawCard();

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
	}
}
