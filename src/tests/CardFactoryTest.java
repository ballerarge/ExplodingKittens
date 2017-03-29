
package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import code.*;

public class CardFactoryTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

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

	@Test
	public void testCreateCardMultipleNormal() throws IncorrectNumberOfCards {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = cardFactory.createCard(CardFactory.NORMAL_CARD, 10);

		for (Card card : cards) {
			assertTrue(NormalCard.class.isInstance(card));
		}
		assertEquals(10, cards.size());
	}

	@Test
	public void testCreateCardNegativeMultiple() throws IncorrectNumberOfCards {
		CardFactory cardFactory = new CardFactory();

		exception.expect(IncorrectNumberOfCards.class);
		List<Card> cards = cardFactory.createCard(CardFactory.NORMAL_CARD, -1);
	}

	@Test
	public void testCreateCardSingleNope() {
		CardFactory cardFactory = new CardFactory();

		Card card = cardFactory.createCard(CardFactory.NOPE_CARD);
		assertTrue(NopeCard.class.isInstance(card));
	}

	@Test
	public void testCreateCardMultipleNope() throws IncorrectNumberOfCards {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = cardFactory.createCard(CardFactory.NOPE_CARD, 10);

		for (Card card : cards) {
			assertTrue(NopeCard.class.isInstance(card));
		}
		assertEquals(10, cards.size());
	}
}
