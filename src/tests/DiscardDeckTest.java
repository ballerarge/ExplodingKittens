package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.Card;

public class DiscardDeckTest {

	@Test
	public void testGetInstance() {
		DiscardDeck discDeck = DiscardDeck.getInstance();
		
		assertEquals(discDeck, DiscardDeck.discardDeck);
	}

}
