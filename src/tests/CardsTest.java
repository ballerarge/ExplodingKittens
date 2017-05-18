
package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardStack;
import code.DiscardDeck;
import code.MainDeck;
import code.NormalCard;
import code.PriorityManager;
import code.SkipCard;
import code.TurnManager;

public class CardsTest {
	
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
	public void testCopyConstructorForNormalCard() {
		NormalCard normal = new NormalCard();
		assertTrue(normal instanceof NormalCard);
		assertTrue(normal.clone() instanceof NormalCard);
	}
	
	@Test
	public void testGetString() {
		Card card = new SkipCard();
		
		assertEquals("code.SkipCard", card.toString());
	}

}
