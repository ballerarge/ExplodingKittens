
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.CardLogger;
import code.Entry;
import code.Game;
import code.GameLogger;
import code.Log;
import code.MainDeck;
import code.Player;
import code.PlayerManager;
import code.PriorityManager;
import code.ScryCard;
import code.TurnManager;
import exceptions.InvalidBundleException;
import exceptions.InvalidNumberofPlayersException;
import exceptions.NoCardsToMoveException;
import exceptions.NoSuchPlayerException;

public class LogTest {

	@Before
	public void initialize() {
		Log.tearDown();
		TurnManager.tearDown();
		PriorityManager.tearDown();
		MainDeck.tearDown();
	}

	@Test
	public void testLogWithEntry() {
		Entry entry0 = new Entry("message 1");
		Entry entry1 = new Entry("message 2");
		Entry entry2 = new Entry("message 3");
		Log log = Log.getInstance();
		log.addEntry(entry0);
		log.addEntry(entry1);
		log.addEntry(entry2);
		ArrayList<Entry> entries = log.getEntries();
		assertEquals(entries.get(2), entry0);
		assertEquals(entries.get(1), entry1);
		assertEquals(entries.get(0), entry2);
	}

	@Test
	public void testCardEntry() throws InvalidNumberofPlayersException {
		Log mockLog = EasyMock.mock(Log.class);
		mockLog.locale = Locale.ENGLISH;
		Game game = new Game();
		game.start(3);
		List<Player> players = game.getPlayers();
		players.get(0).setName("Example Player1");
		players.get(1).setName("Example Player2");
		players.get(2).setName("Example Player3");
		Card card = new CardLogger(new ScryCard());

		Log.setLog(mockLog);
		mockLog.addEntry(EasyMock.anyObject());
		EasyMock.replay(mockLog);

		card.cardAction(null, null);
		EasyMock.verify(mockLog);
	}

	@Test
	public void testPlayerLosesGame() throws NoSuchPlayerException, InvalidNumberofPlayersException {
		Game game = new GameLogger(new Game());
		game.start(3);
		TurnManager manager = TurnManager.getInstance();
		Log log = EasyMock.mock(Log.class);
		log.locale = Locale.ENGLISH;
		Log.setLog(log);
		log.addEntry(EasyMock.anyObject());
		EasyMock.replay(log);
		manager.makeCurrentPlayerLose();
		EasyMock.verify(log);
	}

	@Test
	public void testStartofTurn() throws InvalidNumberofPlayersException, NoCardsToMoveException, InvalidBundleException {
		Log log = EasyMock.mock(Log.class);
		log.locale = Locale.ENGLISH;
		Log.setLog(log);
		Game game = new GameLogger(new Game());
		game.start(3);
		log.addEntry(EasyMock.anyObject());
		EasyMock.replay(log);
		game.nextTurn();
		EasyMock.verify(log);
	}
	
	@Test
	public void testGetPlayerHands() throws InvalidNumberofPlayersException {
		Game game = new GameLogger(new Game());
		game.start(3);
		
		assertEquals(3, game.getPlayerHands().keySet().size());
		assertEquals(3, game.getPlayerHands().values().size());
	}
	
	@Test
	public void testGetPlayerStatus() throws InvalidNumberofPlayersException {
		Game game = new GameLogger(new Game());
		game.start(3);
		
		assertEquals(3, game.getPlayerStatus().keySet().size());
		assertEquals(3, game.getPlayerStatus().values().size());
	}
	
	@Test
	public void testIsMainDeckEmptyFalse() throws InvalidNumberofPlayersException {
		Game game = new GameLogger(new Game());
		game.start(3);
		
		assertFalse(game.isMainDeckEmpty());
	}
	
	@Test
	public void testIsMainDeckEmptyTrue() throws InvalidNumberofPlayersException {
		Game game = new GameLogger(new Game());
		
		assertTrue(game.isMainDeckEmpty());
	}
	
	@Test
	public void testGetCurrentPlayer() throws InvalidNumberofPlayersException {
		Game game = new GameLogger(new Game());
		game.start(3);
		
		Player player = game.getCurrentPlayer();
		
		assertTrue(player instanceof Player);
	}
	
	@Test
	public void testGetActivePlayer() throws InvalidNumberofPlayersException {
		Game game = new GameLogger(new Game());
		game.start(3);
		
		Player player = game.getActivePlayer();
		
		assertTrue(player instanceof Player);
	}
	
	@Test
	public void testGetPlayers() throws InvalidNumberofPlayersException {
		Game game = new GameLogger(new Game());
		game.start(3);
		
		assertEquals(3, game.getPlayers().size());
	}
	
	@Test
	public void testGetPlayerManager() throws InvalidNumberofPlayersException {
		Game game = new GameLogger(new Game());
		game.start(3);
		
		assertTrue(game.getPlayerManager() instanceof PlayerManager);
		assertTrue(game.getPlayerManager() != null);
	}
	
	@Test
	public void testGetTurnManager() throws InvalidNumberofPlayersException {
		Game game = new GameLogger(new Game());
		game.start(3);
		
		assertTrue(game.getTurnManager() instanceof TurnManager);
		assertTrue(game.getTurnManager() != null);
	}
	
	@Test
	public void testToString() {
		CardFactory factory = new CardFactory();
		Card card = new CardLogger(factory.createCard(CardFactory.NORMAL_CARD));
		
		assertEquals("code.NormalCard", card.toString());
	}
	
	

	@After
	public void tearDown() {
		Log.tearDown();
		TurnManager.tearDown();
		PriorityManager.tearDown();
		MainDeck.tearDown();
	}
}
