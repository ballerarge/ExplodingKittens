
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import code.CardFactory;
import code.CardStack;

public class NopeCardTest {
	private CardStack cardStack;
	private CardFactory factory;

	@Before
	public void init() {
		cardStack = CardStack.getInstance();
		factory = new CardFactory();
	}

	@Test
	public void testResolveNopeWithOneCardUnderneath() {
		cardStack.addCard(factory.createCard(CardFactory.ATTACK_CARD));
		cardStack.addCard(factory.createCard(CardFactory.NORMAL_CARD));

		cardStack.resolveTopCard();

		assertEquals(0, cardStack.getStack().size());
	}
}
