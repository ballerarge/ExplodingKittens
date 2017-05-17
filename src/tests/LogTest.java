
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardLogger;
import code.Entry;
import code.Game;
import code.Log;
import code.Player;
import code.PriorityManager;
import code.ScryCard;
import code.TurnManager;
import code.TurnManagerLogger;
import exceptions.InvalidNumberofPlayersException;
import exceptions.NoSuchPlayerException;

public class LogTest {

	@Before
	public void initialize() {
		Log.tearDown();
		TurnManager.tearDown();
		PriorityManager.tearDown();
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
		assertEquals(entries.get(0), entry0);
		assertEquals(entries.get(1), entry1);
		assertEquals(entries.get(2), entry2);
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
	public void testPlayerLosesGame() throws NoSuchPlayerException {
		Player player = new Player();
		player.setName("example player");
		TurnManager.InstantiateLogger();
		TurnManagerLogger manager = (TurnManagerLogger) TurnManager.getInstance();
		manager.currentPlayer = player;
		TurnManager mockManager = EasyMock.mock(TurnManager.class);
		manager.turnManager = mockManager;
		Log mockLog = EasyMock.mock(Log.class);
		mockLog.locale = Locale.ENGLISH;
		Log.setLog(mockLog);
		mockLog.addEntry(EasyMock.anyObject());
		mockManager.makeCurrentPlayerLose();
		EasyMock.replay(mockLog, mockManager);
		manager.makeCurrentPlayerLose();
		EasyMock.verify(mockLog, mockManager);
	}

}
