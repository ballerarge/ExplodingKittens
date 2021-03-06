
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
import code.CardFactory;
import code.CardStack;
import code.DiscardDeck;
import code.Game;
import code.MainDeck;
import code.Player;
import code.PriorityManager;
import code.TurnManager;
import exceptions.InvalidBundleException;
import exceptions.InvalidNumberofPlayersException;
import exceptions.NoCardsToMoveException;

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
		Game game = new Game();

		assertTrue(game != null);
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
	public void testNextTurnDrawing()
	        throws InvalidNumberofPlayersException, NoCardsToMoveException, InvalidBundleException {
		Game game = new Game();
		game.start(3);
		removeAllKittens();
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

		Player player1 = game.getActivePlayer();

		assertTrue(player1 instanceof Player);
	}

	@Test
	public void testNextTurnDifferentPlayer()
	        throws InvalidNumberofPlayersException, NoCardsToMoveException, InvalidBundleException {
		Game game = new Game();
		game.start(3);
		Player player1 = game.getActivePlayer();

		game.nextTurn();

		assertFalse(player1.equals(game.getActivePlayer()));
	}

	@Test
	public void testPlayerRotation()
	        throws InvalidNumberofPlayersException, NoCardsToMoveException, InvalidBundleException {
		Game game = new Game();
		game.start(3);
		removeAllKittens();
		Player player1 = game.getActivePlayer();

		game.nextTurn();
		game.nextTurn();
		game.nextTurn();

		assertEquals(player1, game.getActivePlayer());
	}

	private void removeAllKittens() {
		List<Card> tempCards = new ArrayList<Card>();
		for (Card card : MainDeck.getInstance().getCards()) {
			if (!(card.getID() == 5)) {
				tempCards.add(card);
			}
		}

		MainDeck.getInstance().setCards(tempCards);
	}

	@Test
	public void testDeckEmptyBeforeGameInitialized() {
		Game game = new Game();
		MainDeck.getInstance();

		assertTrue(game.isMainDeckEmpty());
	}

	@Test
	public void testDeckNotEmptyBeforeGameInitialized() {
		MainDeck deck = MainDeck.getInstance();
		deck.populateDeck(3);

		Game game = new Game();

		assertTrue(game.isMainDeckEmpty());
	}

	@Test
	public void testDeckInitializedOnStart() throws InvalidNumberofPlayersException {

		Game game = new Game();
		game.start(3);

		MainDeck deck = MainDeck.getInstance();

		assertTrue(verifyAllTypesInitialized(deck, game.getPlayerHands()));
	}

	private boolean verifyAllTypesInitialized(MainDeck deck, Map<Player, List<Card>> map) {
		boolean attack = false, favor = false, normal = false, nope = false, scry = false, shuffle = false,
		        skip = false;

		for (Card card : deck.getCards()) {
			if (card.getID() == CardFactory.ATTACK_CARD) {
				attack = true;
			} else if (card.getID() == CardFactory.FAVOR_CARD) {
				favor = true;
			} else if (card.getID() == CardFactory.NORMAL_CARD) {
				normal = true;
			} else if (card.getID() == CardFactory.NOPE_CARD) {
				nope = true;
			} else if (card.getID() == CardFactory.SCRY_CARD) {
				scry = true;
			} else if (card.getID() == CardFactory.SHUFFLE_CARD) {
				shuffle = true;
			} else if (card.getID() == CardFactory.SKIP_CARD) {
				skip = true;
			}
		}

		for (List<Card> cards : map.values()) {
			for (Card card : cards) {
				if (card.getID() == CardFactory.ATTACK_CARD) {
					attack = true;
				} else if (card.getID() == CardFactory.FAVOR_CARD) {
					favor = true;
				} else if (card.getID() == CardFactory.NORMAL_CARD) {
					normal = true;
				} else if (card.getID() == CardFactory.NOPE_CARD) {
					nope = true;
				} else if (card.getID() == CardFactory.SCRY_CARD) {
					scry = true;
				} else if (card.getID() == CardFactory.SHUFFLE_CARD) {
					shuffle = true;
				} else if (card.getID() == CardFactory.SKIP_CARD) {
					skip = true;
				}
			}
		}

		return attack && favor && normal && nope && scry && shuffle && skip;
	}

	@Test
	public void testDeckStaysSameIfExistsAlready() throws InvalidNumberofPlayersException {
		MainDeck deck = MainDeck.getInstance();
		CardFactory factory = new CardFactory();

		Game game = new Game();
		for (int i = 0; i < 30; i++) {
			deck.insertCard(factory.createCard(CardFactory.ATTACK_CARD), 0);
		}
		game.start(3);

		assertEquals(23, deck.getCardCount());
	}
}
