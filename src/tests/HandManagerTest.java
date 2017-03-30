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
	}
	

}
