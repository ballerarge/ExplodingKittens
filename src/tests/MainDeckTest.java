
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.CardStack;
import code.DiscardDeck;
import code.MainDeck;
import code.NormalCard;
import code.PriorityManager;
import code.TurnManager;

public class MainDeckTest {

	@Before
	public void initialize() {
		MainDeck.tearDown();
		PriorityManager.tearDown();
		TurnManager.tearDown();
		DiscardDeck.tearDown();
		CardStack.tearDown();
	}

	@After
	public void tearDown() {
		MainDeck.tearDown();
		PriorityManager.tearDown();
		TurnManager.tearDown();
		DiscardDeck.tearDown();
		CardStack.tearDown();
	}

	@Test
	public void testMainDeckConstructor() {
		@SuppressWarnings("unused")
		MainDeck mDeck = MainDeck.getInstance();
	}

	@Test
	public void testGetCards() {
		List<Card> cards = new ArrayList<Card>();
		MainDeck mDeck = MainDeck.getInstance();

		assertEquals(cards, mDeck.getCards());
	}

	@Test
	public void testGetCardsNonEmpty() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();

		MainDeck mDeck = MainDeck.getInstance();

		cards.add(firstCard);
		mDeck.insertCard(firstCard, 0);

		assertEquals(cards, mDeck.getCards());
	}

	@Test
	public void testGetCardCountZeroElements() {
		MainDeck mDeck = MainDeck.getInstance();

		assertEquals(0, mDeck.getCardCount());
	}

	@Test
	public void testGetCardCountOneElement() {
		MainDeck mDeck = MainDeck.getInstance();
		mDeck.insertCard(new NormalCard(), 0);

		assertEquals(1, mDeck.getCardCount());
	}

	@Test
	public void testGetCardCountMoreThanOneElement() {
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();

		MainDeck mDeck = MainDeck.getInstance();

		mDeck.insertCard(firstCard, 0);
		mDeck.insertCard(secondCard, 0);

		assertEquals(2, mDeck.getCardCount());
	}

	@Test
	public void testInsertCardOnTop() {
		MainDeck mDeck = MainDeck.getInstance();
		Card firstCard = new NormalCard();

		assertTrue(mDeck.insertCard(firstCard, 0));
		assertEquals(firstCard, mDeck.getCards().get(0));
	}

	@Test
	public void testInsertCardOnBottom() {
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		Card thirdCard = new NormalCard();
		MainDeck mDeck = MainDeck.getInstance();
		mDeck.insertCard(firstCard, 0);
		mDeck.insertCard(secondCard, 0);

		assertTrue(mDeck.insertCard(thirdCard, 2));
		assertEquals(thirdCard, mDeck.getCards().get(2));
	}

	@Test
	public void testInsertCardInMiddle() {
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		Card thirdCard = new NormalCard();

		MainDeck mDeck = MainDeck.getInstance();

		mDeck.insertCard(firstCard, 0);
		mDeck.insertCard(secondCard, 0);

		assertTrue(mDeck.insertCard(thirdCard, 1));
		assertEquals(thirdCard, mDeck.getCards().get(1));
		assertEquals(secondCard, mDeck.getCards().get(0));
	}

	@Test
	public void testInsertOutsideOfDeck() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		Card thirdCard = new NormalCard();
		cards.add(firstCard);
		cards.add(secondCard);
		MainDeck mDeck = MainDeck.getInstance();

		assertFalse(mDeck.insertCard(thirdCard, mDeck.getCardCount() + 1));
	}

	@Test
	public void testDrawCard() {
		Card firstCard = new NormalCard();

		MainDeck mDeck = MainDeck.getInstance();

		mDeck.insertCard(firstCard, 0);

		int sizeOfDeck = mDeck.getCardCount();

		Card drawnCard = mDeck.draw();

		assertEquals(firstCard, drawnCard);
		assertEquals(sizeOfDeck - 1, mDeck.getCardCount());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testDrawFromEmptyDeck() {
		MainDeck mDeck = MainDeck.getInstance();

		mDeck.draw();
	}

	@Test
	public void testInitStartingDeck() {
		MainDeck mDeck = MainDeck.getInstance();

		mDeck.initStartingDeck();

		assertEquals(46, mDeck.getCardCount());
	}

	@Test
	public void testCorrectCardsInInit() {
		MainDeck mDeck = MainDeck.getInstance();
		int attack = 0;
		int favor = 0;
		int nope = 0;
		int normal = 0;
		int scry = 0;
		int shuffle = 0;
		int skip = 0;

		mDeck.initStartingDeck();
		for (int i = 0; i < mDeck.getCardCount(); i++) {
			if (mDeck.getCards().get(i).getID() == 3) {
				attack++;
			} else if (mDeck.getCards().get(i).getID() == 8) {
				favor++;
			} else if (mDeck.getCards().get(i).getID() == 1) {
				nope++;
			} else if (mDeck.getCards().get(i).getID() == 0) {
				normal++;
			} else if (mDeck.getCards().get(i).getID() == 7) {
				scry++;
			} else if (mDeck.getCards().get(i).getID() == 6) {
				shuffle++;
			} else {
				skip++;
			}
		}

		assertEquals(4, attack);
		assertEquals(4, favor);
		assertEquals(5, nope);
		assertEquals(20, normal);
		assertEquals(5, scry);
		assertEquals(4, shuffle);
		assertEquals(4, skip);
	}

	@Test
	public void testPopulateDeckWithMaxPlayers() {
		MainDeck mDeck = MainDeck.getInstance();
		int numPlayers = 4;

		mDeck.initStartingDeck();
		mDeck.populateDeck(numPlayers);

		assertEquals(51, mDeck.getCardCount());
	}

	@Test
	public void testPopulateDeckWithMinPlayers() {
		MainDeck mDeck = MainDeck.getInstance();
		int numPlayers = 2;

		mDeck.initStartingDeck();
		mDeck.populateDeck(numPlayers);

		assertEquals(51, mDeck.getCardCount());
	}

	@Test
	public void testCorrectCardsInPopulate() {
		MainDeck mDeck = MainDeck.getInstance();
		int numPlayers = 4;
		int kittens = 0;
		int defuse = 0;

		mDeck.initStartingDeck();
		mDeck.populateDeck(numPlayers);
		for (int i = 0; i < mDeck.getCardCount(); i++) {
			if (mDeck.getCards().get(i).getID() == 5) {
				kittens++;
			} else if (mDeck.getCards().get(i).getID() == 2) {
				defuse++;
			}
		}

		assertEquals(3, kittens);
		assertEquals(2, defuse);
	}

	@Test
	public void testDuplicateInitMainDeck() {
		MainDeck mDeck = MainDeck.getInstance();

		mDeck.initStartingDeck();

		int previousSize = mDeck.getCardCount();

		mDeck.initStartingDeck();

		assertEquals(previousSize, mDeck.getCardCount());
	}

	@Test
	public void testCorrectIcons() {
		MainDeck mDeck = MainDeck.getInstance();
		boolean zero = false, one = false, two = false, three = false;

		mDeck.initStartingDeck();

		for (Card card : mDeck.getCards()) {
			if (card instanceof NormalCard) {
				if (((NormalCard) card).getIcon() == 0) {
					zero = true;
				} else if (((NormalCard) card).getIcon() == 1) {
					one = true;
				} else if (((NormalCard) card).getIcon() == 2) {
					two = true;
				} else if (((NormalCard) card).getIcon() == 3) {
					three = true;
				}
			}

		}

		assertTrue(zero);
		assertTrue(one);
		assertTrue(two);
		assertTrue(three);
	}

	@Test
	public void testShuffleOccursInit() {
		MainDeck mainDeck = MainDeck.getInstance();
		CardFactory factory = new CardFactory();
		ArrayList<Card> cards = new ArrayList<>();
		Card card1 = factory.createCard(CardFactory.NORMAL_CARD);
		Card card2 = factory.createCard(CardFactory.NORMAL_CARD);
		Card card3 = factory.createCard(CardFactory.NORMAL_CARD);
		Card card4 = factory.createCard(CardFactory.NORMAL_CARD);
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		cards.add(card4);
		mainDeck.setCards(cards);

		while (mainDeck.getCards().get(0).equals(card1)) {
			mainDeck.initStartingDeck();
		}

		assertTrue(!mainDeck.getCards().get(0).equals(card1));
	}

	@Test
	public void testShuffleOccursPopulateDeck() {
		MainDeck mainDeck = MainDeck.getInstance();
		CardFactory factory = new CardFactory();
		Card card = factory.createCard(CardFactory.NORMAL_CARD);
		mainDeck.insertCard(card, 0);

		while (mainDeck.getCards().get(mainDeck.getCardCount() - 1).equals(card)) {
			mainDeck.populateDeck(3);
		}

		assertTrue(!(mainDeck.getCards().get(mainDeck.getCardCount() - 1) == card));
	}
}
