
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.MainDeck;
import code.NormalCard;
import code.Player;
import code.ScryCard;

public class ScryCardTest {
	
	CardFactory factory;
	
	@Before
	public void initialize() {
		factory = new CardFactory();
		MainDeck.tearDown();
	}
	
	@After
	public void tearDown() {
		MainDeck.tearDown();
	}

	@Test
	public void testScry4CardDeck() {
		MainDeck mainDeck = MainDeck.getInstance();
		List<Card> order = new ArrayList<>();
		order.add(new NormalCard());
		order.add(new NormalCard());
		order.add(new NormalCard());
		order.add(new NormalCard());
		for (int i = 0; i < 4; i++)
			mainDeck.insertCard(order.get(i), i);
		ScryCard scry = new ScryCard();
		scry.cardAction(new Player(), new Player());
		List<Card> prediction = scry.cardsToReveal;
		assertEquals(3, prediction.size());
		for (int i = 0; i < prediction.size(); i++)
			assertEquals(mainDeck.draw(), prediction.get(i));
	}

	@Test
	public void testScry3CardDeck() {
		MainDeck mainDeck = MainDeck.getInstance();
		List<Card> order = new ArrayList<>();
		order.add(new NormalCard());
		order.add(new NormalCard());
		order.add(new NormalCard());
		for (int i = 0; i < 3; i++)
			mainDeck.insertCard(order.get(i), i);
		ScryCard scry = new ScryCard();
		scry.cardAction(new Player(), new Player());
		List<Card> prediction = scry.cardsToReveal;
		assertEquals(3, prediction.size());
		for (int i = 0; i < prediction.size(); i++)
			assertEquals(mainDeck.draw(), prediction.get(i));
	}

	@Test
	public void testScry2CardDeck() {
		MainDeck mainDeck = MainDeck.getInstance();
		List<Card> order = new ArrayList<>();
		order.add(new NormalCard());
		order.add(new NormalCard());
		for (int i = 0; i < 2; i++)
			mainDeck.insertCard(order.get(i), i);
		ScryCard scry = new ScryCard();
		scry.cardAction(new Player(), new Player());
		List<Card> prediction = scry.cardsToReveal;
		assertEquals(2, prediction.size());
		for (int i = 0; i < prediction.size(); i++)
			assertEquals(mainDeck.draw(), prediction.get(i));
	}

	@Test
	public void testScry1CardDeck() {
		MainDeck mainDeck = MainDeck.getInstance();
		List<Card> order = new ArrayList<>();
		order.add(new NormalCard());
		order.add(new NormalCard());
		order.add(new NormalCard());
		order.add(new NormalCard());
		for (int i = 0; i < 1; i++) {
			mainDeck.insertCard(order.get(i), i);
		}
		ScryCard scry = new ScryCard();
		scry.cardAction(new Player(), new Player());
		List<Card> prediction = scry.cardsToReveal;
		assertEquals(1, prediction.size());
		for (int i = 0; i < prediction.size(); i++) {
			assertEquals(mainDeck.draw(), prediction.get(i));
		}
	}
	
	@Test
	public void testScry0CardDeck() {
		MainDeck mainDeck = MainDeck.getInstance();
		ScryCard scry = new ScryCard();
		Player player1 = new Player();
		Player player2 = new Player();
		mainDeck.setCards(new ArrayList<Card>());
		scry.cardAction(player1, player2);
		List<Card> prediction = scry.cardsToReveal;
		assertEquals(0, prediction.size());
	}
	
	@Test
	public void testScryClone() {
		Card scry = factory.createCard(CardFactory.SCRY_CARD);
		
		Card clone = scry.clone();
		
		assertFalse(clone == null);
	}

}
