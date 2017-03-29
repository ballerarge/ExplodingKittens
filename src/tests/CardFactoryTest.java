
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
		assertEquals(card.getID(), CardFactory.NORMAL_CARD);
	}

	@Test
	public void testNormalCardID() {
		CardFactory cardFactory = new CardFactory();

		Card card = cardFactory.createCard(CardFactory.NORMAL_CARD);

		assertEquals(card.getID(), CardFactory.NORMAL_CARD);
	}

	@Test
	public void testCreateCardMultipleNormal() throws IncorrectNumberOfCards {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = cardFactory.createCard(CardFactory.NORMAL_CARD, 10);

		for (Card card : cards) {
			assertEquals(card.getID(), CardFactory.NORMAL_CARD);
		}
		assertEquals(10, cards.size());
	}

	@Test
	public void testCreateCardNegativeMultiple() throws IncorrectNumberOfCards {
		CardFactory cardFactory = new CardFactory();

		exception.expect(IncorrectNumberOfCards.class);

		@SuppressWarnings("unused")
		List<Card> cards = cardFactory.createCard(CardFactory.NORMAL_CARD, -1);
	}

	@Test
	public void testCreateCardSingleNope() {
		CardFactory cardFactory = new CardFactory();

		Card card = cardFactory.createCard(CardFactory.NOPE_CARD);
		assertEquals(card.getID(), CardFactory.NOPE_CARD);
	}

	@Test
	public void testCreateCardMultipleNope() throws IncorrectNumberOfCards {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = cardFactory.createCard(CardFactory.NOPE_CARD, 10);

		for (Card card : cards) {
			assertEquals(card.getID(), CardFactory.NOPE_CARD);
		}
		assertEquals(10, cards.size());
	}

	@Test
	public void testCreateCardSingleDefuse() {
		CardFactory cardFactory = new CardFactory();

		Card card = cardFactory.createCard(CardFactory.DEFUSE_CARD);
		assertEquals(card.getID(), CardFactory.DEFUSE_CARD);
	}

	@Test
	public void testCreateCardMultipleDefuse() throws IncorrectNumberOfCards {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = cardFactory.createCard(CardFactory.DEFUSE_CARD, 10);

		for (Card card : cards) {
			assertEquals(card.getID(), CardFactory.DEFUSE_CARD);
		}
		assertEquals(10, cards.size());
	}

	@Test
	public void testCreateCardSingleAttack() {
		CardFactory cardFactory = new CardFactory();

		Card card = cardFactory.createCard(CardFactory.ATTACK_CARD);
		assertEquals(card.getID(), CardFactory.ATTACK_CARD);
	}

	@Test
	public void testCreateCardMultipleAttack() throws IncorrectNumberOfCards {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = cardFactory.createCard(CardFactory.ATTACK_CARD, 10);

		for (Card card : cards) {
			assertEquals(card.getID(), CardFactory.ATTACK_CARD);
		}
		assertEquals(10, cards.size());
	}

	@Test
	public void testCreateCardSingleSkip() {
		CardFactory cardFactory = new CardFactory();

		Card card = cardFactory.createCard(CardFactory.SKIP_CARD);
		assertEquals(card.getID(), CardFactory.SKIP_CARD);
	}

	@Test
	public void testCreateCardMultipleSkip() throws IncorrectNumberOfCards {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = cardFactory.createCard(CardFactory.SKIP_CARD, 10);

		for (Card card : cards) {
			assertEquals(card.getID(), CardFactory.SKIP_CARD);
		}
		assertEquals(10, cards.size());
	}
}
