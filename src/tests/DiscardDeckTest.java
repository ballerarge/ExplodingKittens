package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.Card;
import code.DiscardDeck;
import code.NormalCard;

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
		discDeck.getCards().add(firstCard);
		
		assertEquals(cards, discDeck.getCards());
		DiscardDeck.tearDown();
	}
	
	@Test
	public void testGetCardCountZeroElements() {
		List<Card> cards = new ArrayList<Card>();
		DiscardDeck discDeck = DiscardDeck.getInstance();
		
		assertEquals(0, discDeck.getCardCount());
		DiscardDeck.tearDown();
	}
	
	@Test
	public void testGetCardCountOneElement() {
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();
		discDeck.getCards().add(new NormalCard());
		
		assertEquals(1, discDeck.getCardCount());
		DiscardDeck.tearDown();
	}

}
