package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.Card;
import code.DiscardDeck;

public class DiscardDeckTest {

	@Test
	public void testGetInstance() {
		DiscardDeck discDeck = DiscardDeck.getInstance();
		
		assertEquals(discDeck, DiscardDeck.getInstance());
	}
	
	@Test
	public void testTearDown() {
		DiscardDeck discDeck = DiscardDeck.getInstance();
		
		DiscardDeck.tearDown();
		
		assertNull(discDeck);
	}

}
