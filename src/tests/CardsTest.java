
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardStack;
import code.DiscardDeck;
import code.MainDeck;
import code.CardFactory;
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

	@Test
	public void testGetImagePath() {
		CardFactory cf = new CardFactory();
		Card card = cf.createCard(CardFactory.DEFUSE_CARD);

		boolean res = false;

		File path = new File(
		        System.getProperty("user.dir") + "/src/gui/card_images/");

		File[] files = path.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				if (files[i].toPath().toString().contains(card.getImagePath())) {
					res = true;
					break;
				}
			}
		}

		assertTrue(res);
	}
}
