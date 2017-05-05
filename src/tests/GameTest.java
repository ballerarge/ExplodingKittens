
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardStack;
import code.DiscardDeck;
import code.ExplodingKittenCard;
import code.Game;
import code.MainDeck;
import code.Player;
import code.PriorityManager;
import code.TurnManager;
import exceptions.InvalidNumberofPlayersException;

public class GameTest {

	@Before
	public void initialize() {
		CardStack.tearDown();
		PriorityManager.tearDown();
		TurnManager.tearDown();
		MainDeck.tearDown();
		DiscardDeck.tearDown();
	}

	@After
	public void tearDown() {
		CardStack.tearDown();
		PriorityManager.tearDown();
		TurnManager.tearDown();
		MainDeck.tearDown();
		DiscardDeck.tearDown();
	}

	@Test
	public void testGameCreation() {
		@SuppressWarnings("unused")
		Game game = new Game();
	}

	@Test
	public void testStartRuns() throws InvalidNumberofPlayersException {
		Game game = new Game();
		try {
			game.start(3);
		} catch (InvalidNumberofPlayersException e) {
			fail("threw an InvalidNumberofPlayersException");
		}
	}

	@Test
	public void testPriorityManagerPopulatedAfterStart() throws InvalidNumberofPlayersException {
		Game game = new Game();
		try {
			game.start(3);

			assertTrue(PriorityManager.getInstance().getActivePlayer() != null);
		} catch (InvalidNumberofPlayersException e) {
			fail("threw an InvalidNumberOfPlayersException");
		}
	}

	@Test
	public void testInvalidNumberofPlayers() {
		Game game1 = new Game();
		Game game2 = new Game();
		Game game3 = new Game();
		Game game4 = new Game();
		try {
			game1.start(1);
			fail("Starting with 1 players didn't return an error");
		} catch (InvalidNumberofPlayersException e) {
		}
		try {
			game2.start(2);
		} catch (InvalidNumberofPlayersException e) {
			fail("Starting with 2 players returns an error");
		}
		try {
			game3.start(5);
		} catch (InvalidNumberofPlayersException e) {
			fail("Starting with 5 players returns an error");
		}
		try {
			game4.start(6);
			fail("Starting with 6 players didn't return an error");
		} catch (InvalidNumberofPlayersException e) {
		}
	}

	@Test
	public void testStartNumberofPlayers() throws InvalidNumberofPlayersException {
		Game game = new Game();
		game.start(3);
		Map<Player, List<Card>> hands = game.getPlayerHands();
		assertEquals(hands.size(), 3);
	}

	@Test
	public void testGetPlayerStatus() throws InvalidNumberofPlayersException {
		Game game = new Game();
		game.start(3);
		Map<Player, Boolean> status = game.getPlayerStatus();
		assertEquals(status.size(), 3);
	}

	@Test
	public void testIsMainDeckEmptyStartofGame() throws InvalidNumberofPlayersException {
		Game game = new Game();
		game.start(3);
		assertFalse(game.isMainDeckEmpty());
	}

	@Test
	public void testNextTurnDrawing() throws InvalidNumberofPlayersException {
		Game game = new Game();
		game.start(3);
		Map<Player, List<Card>> handsBefore = game.getPlayerHands();
		int cardCountBefore = 0;
		for (Player player : handsBefore.keySet())
			cardCountBefore += handsBefore.get(player).size();
		game.nextTurn();
		int cardCountAfter = 0;
		Map<Player, List<Card>> handsAfter = game.getPlayerHands();
		for (Player player : handsAfter.keySet())
			cardCountAfter += handsAfter.get(player).size();
		assertEquals(cardCountBefore + 1, cardCountAfter);
	}

	@Test
	public void testGetCurrentPlayer() throws InvalidNumberofPlayersException {
		Game game = new Game();
		game.start(3);

		Player player1 = game.getCurrentPlayer();

		assertTrue(player1 instanceof Player);
	}

	@Test
	public void testNextTurnDifferentPlayer() throws InvalidNumberofPlayersException {
		Game game = new Game();
		game.start(3);
		Player player1 = game.getCurrentPlayer();

		game.nextTurn();

		assertFalse(player1.equals(game.getCurrentPlayer()));
	}

	@Test
	public void testPlayerRotation() throws InvalidNumberofPlayersException {
		Game game = new Game();
		game.start(3);
		removeAllKittens();
		Player player1 = game.getCurrentPlayer();

		game.nextTurn();
		game.nextTurn();
		game.nextTurn();

		assertEquals(player1, game.getCurrentPlayer());
	}

	private void removeAllKittens() {
		List<Card> tempCards = new ArrayList<Card>();
		for (Card card : MainDeck.getInstance().getCards()) {
			if (!(card instanceof ExplodingKittenCard)) {
				tempCards.add(card);
			}
		}

		MainDeck.getInstance().setCards(tempCards);
	}
}
