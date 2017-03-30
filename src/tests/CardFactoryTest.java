
package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import code.Card;
import code.CardFactory;
import code.IncorrectNumberOfCards;
import code.Player;

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
	public void testCardActionInCreatedCards() {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = new ArrayList<Card>();
		cards.add(cardFactory.createCard(CardFactory.NORMAL_CARD));
		cards.add(cardFactory.createCard(CardFactory.NOPE_CARD));
		cards.add(cardFactory.createCard(CardFactory.DEFUSE_CARD));
		cards.add(cardFactory.createCard(CardFactory.ATTACK_CARD));
		cards.add(cardFactory.createCard(CardFactory.SKIP_CARD));
		cards.add(cardFactory.createCard(CardFactory.EXPLODING_KITTEN_CARD));
		cards.add(cardFactory.createCard(CardFactory.SHUFFLE_CARD));
		cards.add(cardFactory.createCard(CardFactory.SCRY_CARD));

		Player p1 = null, p2 = null;

		for (Card card : cards) {
			card.cardAction(p1, p2);
		}
	}

	@Test
	public void testCreateCardMultipleNormal() throws IncorrectNumberOfCards {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = cardFactory.createCards(CardFactory.NORMAL_CARD, 10);

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
		List<Card> cards = cardFactory.createCards(CardFactory.NORMAL_CARD, -1);
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

		List<Card> cards = cardFactory.createCards(CardFactory.NOPE_CARD, 10);

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

		List<Card> cards = cardFactory.createCards(CardFactory.DEFUSE_CARD, 10);

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

		List<Card> cards = cardFactory.createCards(CardFactory.ATTACK_CARD, 10);

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

		List<Card> cards = cardFactory.createCards(CardFactory.SKIP_CARD, 10);

		for (Card card : cards) {
			assertEquals(card.getID(), CardFactory.SKIP_CARD);
		}
		assertEquals(10, cards.size());
	}

	@Test
	public void testCreateCardSingleExplodingKitten() {
		CardFactory cardFactory = new CardFactory();

		Card card = cardFactory.createCard(CardFactory.EXPLODING_KITTEN_CARD);
		assertEquals(card.getID(), CardFactory.EXPLODING_KITTEN_CARD);
	}

	@Test
	public void testCreateCardMultipleExplodingKitten() throws IncorrectNumberOfCards {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = cardFactory.createCards(CardFactory.EXPLODING_KITTEN_CARD, 10);

		for (Card card : cards) {
			assertEquals(card.getID(), CardFactory.EXPLODING_KITTEN_CARD);
		}
		assertEquals(10, cards.size());
	}

	@Test
	public void testCreateCardSingleShuffle() {
		CardFactory cardFactory = new CardFactory();

		Card card = cardFactory.createCard(CardFactory.SHUFFLE_CARD);
		assertEquals(card.getID(), CardFactory.SHUFFLE_CARD);
	}

	@Test
	public void testCreateCardMultipleShuffle() throws IncorrectNumberOfCards {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = cardFactory.createCards(CardFactory.SHUFFLE_CARD, 10);

		for (Card card : cards) {
			assertEquals(card.getID(), CardFactory.SHUFFLE_CARD);
		}
		assertEquals(10, cards.size());
	}

	@Test
	public void testCreateCardSingleScry() {
		CardFactory cardFactory = new CardFactory();

		Card card = cardFactory.createCard(CardFactory.SCRY_CARD);
		assertEquals(card.getID(), CardFactory.SCRY_CARD);
	}

	@Test
	public void testCreateCardMultipleScry() throws IncorrectNumberOfCards {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = cardFactory.createCards(CardFactory.SCRY_CARD, 10);

		for (Card card : cards) {
			assertEquals(card.getID(), CardFactory.SCRY_CARD);
		}
		assertEquals(10, cards.size());
	}

	@Test
	public void testCreateCardSingleFavor() {
		CardFactory cardFactory = new CardFactory();

		Card card = cardFactory.createCard(CardFactory.FAVOR_CARD);
		assertEquals(card.getID(), CardFactory.FAVOR_CARD);
	}

	@Test
	public void testCreateCardMultipleFavor() throws IncorrectNumberOfCards {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = cardFactory.createCards(CardFactory.FAVOR_CARD, 10);

		for (Card card : cards) {
			assertEquals(card.getID(), CardFactory.FAVOR_CARD);
		}
		assertEquals(10, cards.size());
	}
}