
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.Card;
import code.MainDeck;
import code.NormalCard;
import code.Player;
import code.ScryCard;

public class ScryCardTest {

	@Test
	public void testScry4CardDeck() {
		MainDeck.tearDown();
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
		MainDeck.tearDown();
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
		MainDeck.tearDown();
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
		MainDeck.tearDown();
		MainDeck mainDeck = MainDeck.getInstance();
		List<Card> order = new ArrayList<>();
		order.add(new NormalCard());
		order.add(new NormalCard());
		order.add(new NormalCard());
		order.add(new NormalCard());
		for (int i = 0; i < 1; i++)
			mainDeck.insertCard(order.get(i), i);
		ScryCard scry = new ScryCard();
		scry.cardAction(new Player(), new Player());
		List<Card> prediction = scry.cardsToReveal;
		assertEquals(1, prediction.size());
		for (int i = 0; i < prediction.size(); i++)
			assertEquals(mainDeck.draw(), prediction.get(i));
	}

}
