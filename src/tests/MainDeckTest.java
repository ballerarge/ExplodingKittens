
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.AttackCard;
import code.Card;
import code.DefuseCard;
import code.ExplodingKittenCard;
import code.FavorCard;
import code.MainDeck;
import code.NopeCard;
import code.NormalCard;
import code.ScryCard;
import code.ShuffleCard;
import code.SkipCard;

public class MainDeckTest {

	@Test
	public void testMainDeckConstructor() {
		MainDeck mDeck = MainDeck.getInstance();

		MainDeck.tearDown();
	}

	@Test
	public void testGetCards() {
		List<Card> cards = new ArrayList<Card>();
		MainDeck.tearDown();
		MainDeck mDeck = MainDeck.getInstance();

		assertEquals(cards, mDeck.getCards());
		MainDeck.tearDown();
	}

	@Test
	public void testGetCardsNonEmpty() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();

		MainDeck mDeck = MainDeck.getInstance();

		cards.add(firstCard);
		mDeck.getCards().add(firstCard);

		assertEquals(cards, mDeck.getCards());
		MainDeck.tearDown();
	}

	@Test
	public void testGetCardCountZeroElements() {
		List<Card> cards = new ArrayList<Card>();
		MainDeck mDeck = MainDeck.getInstance();

		assertEquals(0, mDeck.getCardCount());
		MainDeck.tearDown();
	}

	@Test
	public void testGetCardCountOneElement() {
		MainDeck mDeck = MainDeck.getInstance();
		mDeck.getCards().add(new NormalCard());

		assertEquals(1, mDeck.getCardCount());
		MainDeck.tearDown();
	}

	@Test
	public void testGetCardCountMoreThanOneElement() {
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();

		MainDeck mDeck = MainDeck.getInstance();

		mDeck.getCards().add(firstCard);
		mDeck.getCards().add(secondCard);

		assertEquals(2, mDeck.getCardCount());
		MainDeck.tearDown();
	}

	@Test
	public void testInsertCardOnTop() {
		MainDeck mDeck = MainDeck.getInstance();
		Card firstCard = new NormalCard();

		assertTrue(mDeck.insertCard(firstCard, 0));
		assertEquals(firstCard, mDeck.getCards().get(0));
		MainDeck.tearDown();
	}

	@Test
	public void testInsertCardOnBottom() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		Card thirdCard = new NormalCard();
		MainDeck mDeck = MainDeck.getInstance();
		mDeck.getCards().add(firstCard);
		mDeck.getCards().add(secondCard);

		assertTrue(mDeck.insertCard(thirdCard, 2));
		assertEquals(thirdCard, mDeck.getCards().get(2));
		MainDeck.tearDown();
	}

	@Test
	public void testInsertCardInMiddle() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		Card thirdCard = new NormalCard();

		MainDeck mDeck = MainDeck.getInstance();

		mDeck.getCards().add(firstCard);
		mDeck.getCards().add(secondCard);

		assertTrue(mDeck.insertCard(thirdCard, 1));
		assertEquals(thirdCard, mDeck.getCards().get(1));
		assertEquals(secondCard, mDeck.getCards().get(2));
		MainDeck.tearDown();
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
		MainDeck.tearDown();
	}

	@Test
	public void testDrawCard() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();

		MainDeck mDeck = MainDeck.getInstance();

		mDeck.getCards().add(firstCard);

		int sizeOfDeck = mDeck.getCardCount();

		Card drawnCard = mDeck.draw();

		assertEquals(firstCard, drawnCard);
		assertEquals(sizeOfDeck - 1, mDeck.getCardCount());
		MainDeck.tearDown();
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testDrawFromEmptyDeck() {
		MainDeck mDeck = MainDeck.getInstance();

		Card drawnCard = mDeck.draw();
		MainDeck.tearDown();
	}

	@Test
	public void testInitStartingDeck() {
		MainDeck mDeck = MainDeck.getInstance();

		mDeck.initStartingDeck();

		assertEquals(46, mDeck.getCardCount());
		MainDeck.tearDown();
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
			if (mDeck.getCards().get(i) instanceof AttackCard) {
				attack++;
			} else if (mDeck.getCards().get(i) instanceof FavorCard) {
				favor++;
			} else if (mDeck.getCards().get(i) instanceof NopeCard) {
				nope++;
			} else if (mDeck.getCards().get(i) instanceof NormalCard) {
				normal++;
			} else if (mDeck.getCards().get(i) instanceof ScryCard) {
				scry++;
			} else if (mDeck.getCards().get(i) instanceof ShuffleCard) {
				shuffle++;
			} else if (mDeck.getCards().get(i) instanceof SkipCard) {
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
		MainDeck.tearDown();
	}

	@Test
	public void testPopulateDeckWithMaxPlayers() {
		MainDeck mDeck = MainDeck.getInstance();
		int numPlayers = 4;

		mDeck.initStartingDeck();
		mDeck.populateDeck(numPlayers);

		assertEquals(51, mDeck.getCardCount());
		MainDeck.tearDown();
	}

	@Test
	public void testPopulateDeckWithMinPlayers() {
		MainDeck mDeck = MainDeck.getInstance();
		int numPlayers = 2;

		mDeck.initStartingDeck();
		mDeck.populateDeck(numPlayers);

		assertEquals(51, mDeck.getCardCount());
		MainDeck.tearDown();
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
			if (mDeck.getCards().get(i) instanceof ExplodingKittenCard) {
				kittens++;
			} else if (mDeck.getCards().get(i) instanceof DefuseCard) {
				defuse++;
			}
		}

		assertEquals(3, kittens);
		assertEquals(2, defuse);
		MainDeck.tearDown();
	}

	@Test
	public void testDuplicateInitMainDeck() {
		MainDeck mDeck = MainDeck.getInstance();

		mDeck.initStartingDeck();

		int previousSize = mDeck.getCardCount();

		mDeck.initStartingDeck();

		assertEquals(previousSize, mDeck.getCardCount());
		MainDeck.tearDown();
	}
}
