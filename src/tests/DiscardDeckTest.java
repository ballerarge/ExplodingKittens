
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import code.Card;
import code.DiscardDeck;
import code.NormalCard;
import code.SkipCard;
import exceptions.CardNotInDiscardDeckException;
import exceptions.EmptyDiscardDeckException;

public class DiscardDeckTest {

	@Test
	public void testGetInstance() {
		DiscardDeck discDeck = DiscardDeck.getInstance();

		assertEquals(discDeck, DiscardDeck.getInstance());
	}

	@Test
	public void testGetCards() {
		List<Card> cards = new ArrayList<Card>();
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();

		assertEquals(cards, discDeck.getCards());
		DiscardDeck.tearDown();
	}

	@Test
	public void testGetCardsNonEmpty() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();

		cards.add(firstCard);
		discDeck.addCard(firstCard);

		assertEquals(cards, discDeck.getCards());
		DiscardDeck.tearDown();
	}

	@Test
	public void testGetCardCountZeroElements() {
		DiscardDeck.tearDown();
		List<Card> cards = new ArrayList<Card>();
		DiscardDeck discDeck = DiscardDeck.getInstance();

		assertEquals(0, discDeck.getCardCount());
		DiscardDeck.tearDown();
	}

	@Test
	public void testGetCardCountOneElement() {
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();
		discDeck.addCard(new NormalCard());

		assertEquals(1, discDeck.getCardCount());
		DiscardDeck.tearDown();
	}

	@Test
	public void testGetCardCountMoreThanOneElement() {
		DiscardDeck.tearDown();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();

		DiscardDeck discDeck = DiscardDeck.getInstance();
		discDeck.addCard(firstCard);
		discDeck.addCard(secondCard);

		assertEquals(2, discDeck.getCardCount());
		DiscardDeck.tearDown();
	}

	@Test
	public void testRemoveNormalCard() {
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();
		Card firstCard = new NormalCard();
		discDeck.addCard(firstCard);

		Card ret = discDeck.removeCard(NormalCard.class);

		assertEquals(firstCard.getClass(), ret.getClass());
		assertEquals(0, discDeck.getCardCount());
		DiscardDeck.tearDown();
	}

	@Test
	public void testRemoveFromMultiCardTypes() {
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();
		Card firstCard = new NormalCard();
		Card secondCard = new SkipCard();
		discDeck.addCard(firstCard);
		discDeck.addCard(secondCard);

		Card ret = discDeck.removeCard(NormalCard.class);

		assertEquals(firstCard.getClass(), ret.getClass());
		assertEquals(1, discDeck.getCardCount());
		DiscardDeck.tearDown();
	}

	@Test
	public void testRemoveMultiOutOfOrder() {
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();
		Card firstCard = new NormalCard();
		Card secondCard = new SkipCard();
		discDeck.addCard(firstCard);
		discDeck.addCard(secondCard);

		Card ret = discDeck.removeCard(SkipCard.class);

		assertEquals(secondCard.getClass(), ret.getClass());
		assertEquals(1, discDeck.getCardCount());
		DiscardDeck.tearDown();
	}

	@Test
	public void testRemoveFromDuplicates() {
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		discDeck.addCard(firstCard);
		discDeck.addCard(secondCard);

		Card ret = discDeck.removeCard(NormalCard.class);

		assertEquals(secondCard.getClass(), ret.getClass());
		assertEquals(1, discDeck.getCardCount());
		DiscardDeck.tearDown();
	}

	@Test(expected = EmptyDiscardDeckException.class)
	public void testRemoveFromEmpty() {
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();

		Card ret = discDeck.removeCard(NormalCard.class);
		DiscardDeck.tearDown();
	}

	@Test(expected = CardNotInDiscardDeckException.class)
	public void testRemoveCardNotFound() {
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();
		Card firstCard = new NormalCard();
		discDeck.addCard(firstCard);

		Card ret = discDeck.removeCard(SkipCard.class);
		DiscardDeck.tearDown();
	}

	@Test
	public void testAddCard() {
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();

		discDeck.addCard(new NormalCard());

		assertEquals(1, discDeck.getCardCount());
		assertEquals(NormalCard.class, discDeck.getCards().get(0).getClass());
		DiscardDeck.tearDown();
	}

	@Test
	public void testAddNonNormalCard() {
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();

		discDeck.addCard(new SkipCard());

		assertEquals(1, discDeck.getCardCount());
		assertEquals(SkipCard.class, discDeck.getCards().get(0).getClass());
		DiscardDeck.tearDown();
	}

	@Test
	public void testRemoveAllCards() {
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();

		discDeck.addCard(new SkipCard());
		discDeck.addCard(new SkipCard());
		discDeck.addCard(new SkipCard());
		discDeck.addCard(new SkipCard());
		discDeck.removeAllCards();

		assertEquals(0, discDeck.getCardCount());
		DiscardDeck.tearDown();
	}

	@Test
	public void testRemoveAllFromEmptyDeck() {
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();

		discDeck.removeAllCards();

		assertEquals(0, discDeck.getCardCount());
		DiscardDeck.tearDown();
	}

	@Test
	public void testAddAll() {
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();
		Card firstCard = new NormalCard();
		Card secondCard = new SkipCard();
		ArrayList<Card> cardHolderForTesting = new ArrayList<>(Arrays.asList(firstCard, secondCard));

		discDeck.addAll(cardHolderForTesting);
		List<Card> discPile = discDeck.getCards();

		for (int i = 0; i < cardHolderForTesting.size(); i++) {
			assertEquals(discPile.get(i), cardHolderForTesting.get(i));
		}
	}

}
