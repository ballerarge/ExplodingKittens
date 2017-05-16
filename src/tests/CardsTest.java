
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Iterator;

import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.NormalCard;
import code.SkipCard;

public class CardsTest {

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
		getClass().getResource("main_deck_3.png").toString();

		File path = new File("/exploding-kittens/src/gui/card_images/");

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
