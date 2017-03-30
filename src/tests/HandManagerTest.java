package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.HandManager;
import code.MainDeck;

public class HandManagerTest {

	private MainDeck mainDeck;
	
	@Test
	public void testHandManagerCreation() {
		HandManager handMng = new HandManager();
	}
	
	@Test
	public void testDrawFromMainDeck() {
		HandManager handMng = new HandManager();
		
		handMng.draw();
		
		assertFalse(handMng.getHand().isEmpty());
		assertEquals(1, handMng.getHand().size());
	}
	
	@Test
	public void testSelectCard() {
		HandManager handMng = new HandManager();
		
		handMng.draw();
		
		assertEquals(1, handMng.getHand().size());
		
		handMng.selectCard(0);
		
		assertEquals(0, handMng.getHand().size());
		assertEquals(1, hangMng.getSelectedCards().size());
		
		
	}

}
