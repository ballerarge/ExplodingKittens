
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.easymock.EasyMock;

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

}
