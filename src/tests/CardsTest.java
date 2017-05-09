
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Card;
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

}
