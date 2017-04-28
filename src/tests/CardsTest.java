package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import code.NormalCard;

public class CardsTest {

	@Test
	public void testCopyConstructorForNormalCard() {
		NormalCard normal = new NormalCard();
		assertTrue(normal instanceof NormalCard);
		assertTrue(normal.clone() instanceof NormalCard);
	}

}
