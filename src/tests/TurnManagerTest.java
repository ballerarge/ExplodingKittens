
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.CardStack;
import code.DiscardDeck;
import code.Game;
import code.Log;
import code.MainDeck;
import code.Player;
import code.PlayerManager;
import code.PriorityManager;
import code.TurnManager;
import code.TurnManagerLogger;
import exceptions.InvalidNumberofPlayersException;

public class TurnManagerTest {
	
	@Before
	public void initialize() {
		TurnManager.tearDown();
		MainDeck.tearDown();
		DiscardDeck.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
		Log.tearDown();
	}
	
	@After
	public void tearDown() {
		TurnManager.tearDown();
		MainDeck.tearDown();
		DiscardDeck.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
	}

	@Test
	public void testConstruction() {
		TurnManager manager = TurnManager.getInstance();
	}

	@Test
	public void testHandlesPlayerManager() {PlayerManager pmgr = EasyMock.mock(PlayerManager.class);
		List<Player> players = new ArrayList<>();
		players.add(new Player());
		EasyMock.expect(pmgr.getPlayers()).andReturn(players);
		EasyMock.replay(pmgr);
		TurnManager manager = TurnManager.getInstance();
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
		TurnManager manager = TurnManager.getInstance();

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
	}

	@Test
	public void testEndTurnAndDraw() {
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
		EasyMock.expect(mockCard.getID()).andReturn(0);
		EasyMock.expect(mockPlayer2.drawCard()).andReturn(mockCard);
		EasyMock.expect(mockCard.getID()).andReturn(0);
		EasyMock.expect(mockPlayer3.drawCard()).andReturn(mockCard);
		EasyMock.expect(mockCard.getID()).andReturn(0);

		EasyMock.replay(mockPM, mockPlayer1, mockPlayer2, mockPlayer3, mockCard);

		manager.setPlayerManager(mockPM);
		assertEquals(mockPlayer1, manager.getCurrentPlayer());
		manager.endTurnAndDraw();
		assertEquals(mockPlayer2, manager.getCurrentPlayer());
		manager.endTurnAndDraw();
		assertEquals(mockPlayer3, manager.getCurrentPlayer());
		manager.endTurnAndDraw();
		assertEquals(mockPlayer1, manager.getCurrentPlayer());

		EasyMock.verify(mockPM, mockPlayer1, mockPlayer2, mockPlayer3, mockCard);
	}

	@Test
	public void testEndTurnAndDrawWithKittenOnTop() throws InvalidNumberofPlayersException {
		CardFactory factory = new CardFactory();
		MainDeck mainDeck = MainDeck.getInstance();
		Game game = new Game();
		game.start(3);
		TurnManager turnManager = TurnManager.getInstance();

		mainDeck.insertCard(factory.createCard(CardFactory.EXPLODING_KITTEN_CARD), 0);
		turnManager.endTurnAndDraw();

		assertEquals(2, game.getPlayers().size());

	}
	
}
