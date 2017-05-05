
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
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

	@After
	public void teardown() {
		CardStack.tearDown();
	}

	@Test
	public void testResolveNopeWithOneCardUnderneath() {
		cardStack.addCard(factory.createCard(CardFactory.ATTACK_CARD));
		cardStack.addCard(factory.createCard(CardFactory.NOPE_CARD));

		cardStack.resolveTopCard();

		assertEquals(0, cardStack.getStack().size());
	}

	@Test
	public void testResolveNopeWithMultipleCardUnderneath() {
		cardStack.addCard(factory.createCard(CardFactory.ATTACK_CARD));
		cardStack.addCard(factory.createCard(CardFactory.SKIP_CARD));
		cardStack.addCard(factory.createCard(CardFactory.EXPLODING_KITTEN_CARD));
		cardStack.addCard(factory.createCard(CardFactory.SCRY_CARD));
		cardStack.addCard(factory.createCard(CardFactory.NOPE_CARD));

		cardStack.resolveTopCard();

		assertEquals(3, cardStack.getStack().size());
	}
}
