package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.*;


public class CardFactoryTest {
	@Test
	public void testCardFactoryCreation() {
		@SuppressWarnings("unused")
		CardFactory cardFactory = new CardFactory();
	}
	
	@Test
	public void testCreateCardSingleNormal() {
		CardFactory cardFactory = new CardFactory();
		
		Card card = cardFactory.createCard(CardFactory.NORMAL_CARD);
		assertTrue(NormalCard.class.isInstance(card));
	}
}
