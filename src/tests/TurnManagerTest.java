
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
import code.MainDeck;
import code.Player;
import code.PlayerManager;
import code.PriorityManager;
import code.TurnManager;
import exceptions.InvalidNumberofPlayersException;

public class TurnManagerTest {
	
	@Before
	public void initialize() {
		TurnManager.tearDown();
		MainDeck.tearDown();
		DiscardDeck.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
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
	}

	@Test
	public void testEndTurnAndDrawWithKittenOnTop() throws InvalidNumberofPlayersException {
		TurnManager turnManager = TurnManager.getInstance();
		CardFactory factory = new CardFactory();
		MainDeck mainDeck = MainDeck.getInstance();
		Game game = new Game();
		game.start(3);

		mainDeck.insertCard(factory.createCard(CardFactory.EXPLODING_KITTEN_CARD), 0);
		turnManager.endTurnAndDraw();

		assertEquals(2, game.getPlayers().size());

	}
	
	@Test
	public void testPlayerDoesNotRotateOnAttack() throws InvalidNumberofPlayersException {
		TurnManager turnManager = TurnManager.getInstance();
		CardFactory factory = new CardFactory();
		MainDeck mainDeck = MainDeck.getInstance();
		Game game = new Game();
		game.start(3);
		Player player1 = game.getPlayers().get(0);
		Player player2 = game.getPlayers().get(1);
		Player player3 = game.getPlayers().get(2);
		
		
		mainDeck.insertCard(factory.createCard(CardFactory.NORMAL_CARD), 0);
		turnManager.addTurnForCurrentPlayer();
		turnManager.endTurnAndDraw();
		
		//Player 1's turn again.
		turnManager.endTurnWithoutDraw();
		//Player 2's turn.
		turnManager.endTurnWithoutDraw();
		//Player 3's turn.
		turnManager.endTurnWithoutDraw();
		//Player 1's turn.
		turnManager.endTurnWithoutDraw();
		
		assertEquals(player1, turnManager.getCurrentPlayer());
	}
	
	@Test
	public void testGameOver() throws InvalidNumberofPlayersException {
		TurnManager turnManager = TurnManager.getInstance();
		CardFactory factory = new CardFactory();
		PriorityManager priorityManager = PriorityManager.getInstance();
		MainDeck mainDeck = MainDeck.getInstance();
		Game game = new Game();
		game.start(3);
		Player player1 = game.getPlayers().get(0);
		Player player2 = game.getPlayers().get(1);
		Player player3 = game.getPlayers().get(2);
		mainDeck.insertCard(factory.createCard(CardFactory.NORMAL_CARD), 0);
		mainDeck.insertCard(factory.createCard(CardFactory.NORMAL_CARD), 0);
		
		turnManager.makeCurrentPlayerLose();
		turnManager.makeCurrentPlayerLose();
		
		assertTrue(priorityManager.getActivePlayer().equals(player3));
		assertEquals(1, priorityManager.getPlayerCount());
		turnManager.endTurnAndDraw();
		assertEquals(player3, turnManager.getCurrentPlayer());
		turnManager.endTurnAndDraw();
		assertEquals(0, turnManager.getTurnOrder().size());
		
	}
	
}
