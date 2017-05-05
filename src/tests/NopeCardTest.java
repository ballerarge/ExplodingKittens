
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import code.CardFactory;
import code.CardStack;
import exceptions.InvalidNopeTargetException;

public class NopeCardTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
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
	public void testResolveNopeWithNoCardsUnderneath() {
		cardStack.addCard(factory.createCard(CardFactory.NOPE_CARD));

		exception.expect(InvalidNopeTargetException.class);
		
		cardStack.resolveTopCard();
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
	
	@Test
	public void testResolveNopeWithExplodingKittenUnderneath() {
		cardStack.addCard(factory.createCard(CardFactory.EXPLODING_KITTEN_CARD));
		cardStack.addCard(factory.createCard(CardFactory.NOPE_CARD));
		
		exception.expect(InvalidNopeTargetException.class);
		
		cardStack.resolveTopCard();
	}
	
	@Test
	public void testResolveNopeWithDefuseUnderneath() {
		cardStack.addCard(factory.createCard(CardFactory.DEFUSE_CARD));
		cardStack.addCard(factory.createCard(CardFactory.NOPE_CARD));
		
		exception.expect(InvalidNopeTargetException.class);
		
		cardStack.resolveTopCard();
	}
}
