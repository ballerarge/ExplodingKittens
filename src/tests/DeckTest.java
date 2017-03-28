package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.Deck;
import code.Card;

public class DeckTest {

	@Test
	public void testDeckConstructor() {
		Deck deck = new Deck();
	}
	
	@Test
	public void testGetCards() {
		List<Card> cards = new ArrayList<Card>();
		Deck deck = new Deck(cards);
		
		assertEquals(cards, deck.getCards());
	}

}
