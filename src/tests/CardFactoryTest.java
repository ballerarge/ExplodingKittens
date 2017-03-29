package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.*;


public class CardFactoryTest {
	@Test
	public void testCardFactoryCreation() {
		CardFactory cardFactory = new CardFactory();
	}
	
	@Test
	public void testCreateCardSingleNormal() {
		CardFactory cardFactory = new CardFactory();
		
		Card card = cardFactory.createCard(cardFactory.NORMAL_CARD);
		assertTrue(NormalCard.class.isInstance(card));
	}
}
