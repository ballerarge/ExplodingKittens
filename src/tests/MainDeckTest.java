package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.Card;
import code.MainDeck;

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
		Card firstCard = new Card();
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

}
