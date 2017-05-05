package tests;

import org.junit.Before;
import org.junit.Test;

import code.CardFactory;
import code.NormalCard;

public class NormalCardTest {
	CardFactory cardFactory;
	
	@Before
	public void init() {
		cardFactory = new CardFactory();
	}
	
	@Test
	public void testNormalCardHasIcon() {
		NormalCard normalCard = (NormalCard) cardFactory.createCard(CardFactory.NORMAL_CARD);
		
		assertEquals(normalCard.getIcon(), 0);
	}
}
