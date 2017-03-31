
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
		MainDeck mDeck = new MainDeck();
	}

	@Test
	public void testGetCards() {
		List<Card> cards = new ArrayList<Card>();
		MainDeck mDeck = new MainDeck(cards);

		assertEquals(cards, mDeck.getCards());
	}

	@Test
	public void testGetCardsNonEmpty() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		cards.add(firstCard);
		MainDeck mDeck = new MainDeck(cards);

		assertEquals(cards, mDeck.getCards());
	}

	@Test
	public void testGetCardCountZeroElements() {
		List<Card> cards = new ArrayList<Card>();
		MainDeck mDeck = new MainDeck(cards);

		assertEquals(0, mDeck.getCardCount());
	}

	@Test
	public void testGetCardCountOneElement() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		cards.add(firstCard);
		MainDeck mDeck = new MainDeck(cards);

		assertEquals(1, mDeck.getCardCount());
	}

	@Test
	public void testGetCardCountMoreThanOneElement() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		cards.add(firstCard);
		cards.add(secondCard);
		MainDeck mDeck = new MainDeck(cards);

		assertEquals(2, mDeck.getCardCount());
	}

	@Test
	public void testInsertCardOnTop() {
		MainDeck mDeck = new MainDeck();
		Card firstCard = new NormalCard();

		assertTrue(mDeck.insertCard(firstCard, 0));
		assertEquals(firstCard, mDeck.getCards().get(0));
	}

	@Test
	public void testInsertCardOnBottom() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		Card thirdCard = new NormalCard();
		cards.add(firstCard);
		cards.add(secondCard);
		MainDeck mDeck = new MainDeck(cards);

		assertTrue(mDeck.insertCard(thirdCard, 2));
		assertEquals(thirdCard, mDeck.getCards().get(2));
	}

	@Test
	public void testInsertCardInMiddle() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		Card thirdCard = new NormalCard();
		cards.add(firstCard);
		cards.add(secondCard);
		MainDeck mDeck = new MainDeck(cards);

		assertTrue(mDeck.insertCard(thirdCard, 1));
		assertEquals(thirdCard, mDeck.getCards().get(1));
		assertEquals(secondCard, mDeck.getCards().get(2));
	}

	@Test
	public void testInsertOutsideOfDeck() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		Card thirdCard = new NormalCard();
		cards.add(firstCard);
		cards.add(secondCard);
		MainDeck mDeck = new MainDeck(cards);

		assertFalse(mDeck.insertCard(thirdCard, mDeck.getCardCount() + 1));
	}

	@Test
	public void testDrawCard() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		cards.add(firstCard);
		MainDeck mDeck = new MainDeck(cards);
		int sizeOfDeck = mDeck.getCardCount();

		Card drawnCard = mDeck.draw();

		assertEquals(firstCard, drawnCard);
		assertEquals(sizeOfDeck - 1, mDeck.getCardCount());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testDrawFromEmptyDeck() {
		MainDeck mDeck = new MainDeck();

		Card drawnCard = mDeck.draw();
	}

	@Test
	public void testInitStartingDeck() {
		MainDeck mDeck = new MainDeck();

		mDeck.initStartingDeck();

		assertEquals(46, mDeck.getCardCount());
	}

	@Test
	public void testCorrectCardsInInit() {
		MainDeck mDeck = new MainDeck();
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
	}

	@Test
	public void testPopulateDeckWithMaxPlayers() {
		MainDeck mDeck = new MainDeck();
		int numPlayers = 4;

		mDeck.initStartingDeck();
		mDeck.populateDeck(numPlayers);

		assertEquals(51, mDeck.getCardCount());
	}

	@Test
	public void testPopulateDeckWithMinPlayers() {
		MainDeck mDeck = new MainDeck();
		int numPlayers = 2;

		mDeck.initStartingDeck();
		mDeck.populateDeck(numPlayers);

		assertEquals(51, mDeck.getCardCount());
	}

	@Test
	public void testCorrectCardsInPopulate() {
		MainDeck mDeck = new MainDeck();
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
	}

	@Test
	public void testDuplicateInitMainDeck() {
		MainDeck mDeck = new MainDeck();

		mDeck.initStartingDeck();

		int previousSize = mDeck.getCardCount();

		mDeck.initStartingDeck();

		assertEquals(previousSize, mDeck.getCardCount());
	}
}
