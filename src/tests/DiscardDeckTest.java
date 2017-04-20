package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.Card;
import code.DiscardDeck;
import code.NormalCard;
import code.SkipCard;
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
		discDeck.getCards().add(firstCard);
		
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
		discDeck.getCards().add(new NormalCard());
		
		assertEquals(1, discDeck.getCardCount());
		DiscardDeck.tearDown();
	}
	
	@Test
	public void testGetCardCountMoreThanOneElement() {
		DiscardDeck.tearDown();
		Card firstCard = new NormalCard();
		Card secondCard = new NormalCard();
		
		DiscardDeck discDeck = DiscardDeck.getInstance();
		discDeck.getCards().add(firstCard);
		discDeck.getCards().add(secondCard);
		
		assertEquals(2, discDeck.getCardCount());
		DiscardDeck.tearDown();
	}
	
	@Test
	public void testRemoveNormalCard() {
		DiscardDeck.tearDown();
		DiscardDeck discDeck = DiscardDeck.getInstance();
		Card firstCard = new NormalCard();
		discDeck.getCards().add(firstCard);
		
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
		discDeck.getCards().add(firstCard);
		discDeck.getCards().add(secondCard);
		
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
		discDeck.getCards().add(firstCard);
		discDeck.getCards().add(secondCard);
		
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
		discDeck.getCards().add(firstCard);
		discDeck.getCards().add(secondCard);
		
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
	}
	
}
