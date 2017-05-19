
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Deck;
import code.DiscardDeck;
import code.MainDeck;
import code.NormalCard;
import code.PriorityManager;
import code.TurnManager;
import code.Card;
import code.CardStack;

public class DeckTest {
	
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
	public void testDeckConstructor() {
		Deck deck = new Deck();
		assertTrue(deck instanceof Deck);
	}

	@Test
	public void testGetCards() {
		List<Card> cards = new ArrayList<Card>();
		Deck deck = new Deck(cards);

		assertEquals(cards, deck.getCards());
	}

	@Test
	public void testGetCardsWithNonEmpty() {
		List<Card> cards = new ArrayList<Card>();
		Card cardOne = new NormalCard();
		cards.add(cardOne);
		Deck deck = new Deck(cards);

		assertEquals(cards, deck.getCards());
	}

	@Test
	public void testSetCards() {
		List<Card> cards = new ArrayList<Card>();
		Deck deck = new Deck();

		deck.setCards(cards);

		assertEquals(cards, deck.getCards());
	}

	@Test
	public void testSetCardsWithNonEmpty() {
		List<Card> cards = new ArrayList<Card>();
		Card cardOne = new NormalCard();
		cards.add(cardOne);
		Deck deck = new Deck();

		deck.setCards(cards);

		assertEquals(cards, deck.getCards());
	}

	@Test
	public void testAddCardToZeroElements() {
		Deck deck = new Deck();
		Card firstCard = new NormalCard();

		deck.addCard(firstCard, 0);

		assertEquals(1, deck.getCards().size());
		assertEquals(firstCard, deck.getCards().get(0));
	}

	@Test
	public void testAddCardToOneElement() {
		Deck deck = new Deck();
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		cards.add(firstCard);

		deck.setCards(cards);
		deck.addCard(secondCard, 1);

		assertEquals(2, deck.getCards().size());
		assertEquals(secondCard, deck.getCards().get(1));
	}

	@Test
	public void testAddCardToOneElementOddOrder() {
		Deck deck = new Deck();
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		cards.add(firstCard);

		deck.setCards(cards);
		deck.addCard(secondCard, 0);

		assertEquals(2, deck.getCards().size());
		assertEquals(secondCard, deck.getCards().get(0));
	}

	@Test
	public void testRemoveCard() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		cards.add(firstCard);
		Deck deck = new Deck(cards);

		deck.removeCard(firstCard);

		assertEquals(0, deck.getCards().size());
	}

	@Test
	public void testRemoveCardAtOddPosition() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		cards.add(firstCard);
		cards.add(secondCard);
		Deck deck = new Deck(cards);

		deck.removeCard(firstCard);

		assertEquals(1, deck.getCards().size());
		assertEquals(secondCard, deck.getCards().get(0));
	}

	@Test
	public void testRemoveFromDuplicates() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		cards.add(firstCard);
		cards.add(firstCard);
		Deck deck = new Deck(cards);

		deck.removeCard(firstCard);

		assertEquals(1, deck.getCards().size());
		assertEquals(firstCard, deck.getCards().get(0));
	}

	@Test
	public void testRemoveAllDuplicates() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		cards.add(firstCard);
		cards.add(firstCard);
		Deck deck = new Deck(cards);

		deck.removeCard(firstCard);
		deck.removeCard(firstCard);

		assertEquals(0, deck.getCards().size());
	}

	@Test
	public void testRemoveFromZeroElements() {
		List<Card> cards = new ArrayList<Card>();
		Deck deck = new Deck(cards);
		Card firstCard = new NormalCard();

		boolean check = deck.removeCard(firstCard);

		assertEquals(0, deck.getCards().size());
		assertFalse(check);
	}
	
	@Test
	public void testAddCardFirst() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		Card thirdCard = new NormalCard();
		cards.add(firstCard);
		cards.add(secondCard);
		Deck deck = new Deck(cards);
		
		boolean check = deck.addCardFirst(thirdCard);
		
		assertTrue(check);
		assertEquals(3, deck.getCards().size());
		assertEquals(thirdCard, deck.getCards().get(0));
	}
	
	@Test
	public void testAddCardLast() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		Card thirdCard = new NormalCard();
		cards.add(firstCard);
		cards.add(secondCard);
		Deck deck = new Deck(cards);
		
		boolean check = deck.addCardLast(thirdCard);
		
		assertTrue(check);
		assertEquals(3, deck.getCards().size());
		assertEquals(thirdCard, deck.getCards().get(2));
	}
	
	@Test
	public void testAddAll() {
		List<Card> cards = new ArrayList<Card>();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		Card thirdCard = new NormalCard();
		cards.add(firstCard);
		cards.add(secondCard);
		cards.add(thirdCard);
		Deck deck = new Deck();
		
		boolean check = deck.addAll(cards);
		
		assertTrue(check);
		assertEquals(3, deck.getCards().size());
		
	}

}
