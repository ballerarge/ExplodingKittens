
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import code.Card;
import code.CardFactory;
import code.CardStack;
import code.DiscardDeck;
import code.Game;
import code.MainDeck;
import code.Player;
import code.PriorityManager;
import code.TurnManager;
import exceptions.CardNotFoundException;
import exceptions.IncorrectNumberOfCardsException;
import exceptions.InvalidNumberofPlayersException;

public class CardFactoryTest {
	
	@Before
	public void initialize() {
		PriorityManager.tearDown();
		CardStack.tearDown();
		TurnManager.tearDown();
		MainDeck.tearDown();
		DiscardDeck.tearDown();
	}
	
	@After
	public void tearDown() {
		PriorityManager.tearDown();
		CardStack.tearDown();
		TurnManager.tearDown();
		MainDeck.tearDown();
		DiscardDeck.tearDown();
	}
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testCardFactoryCreation() {
		CardFactory cardFactory = new CardFactory();
		
		assertTrue(cardFactory != null);
	}

	@Test
	public void testCreateCardSingleNormal() {
		CardFactory cardFactory = new CardFactory();

		Card card = cardFactory.createCard(CardFactory.NORMAL_CARD);
		assertEquals(card.getID(), CardFactory.NORMAL_CARD);
	}

	@Test
	public void testCardActionInCreatedCards() throws InvalidNumberofPlayersException {
		Game game = new Game();
		game.start(3);
		
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
		
		CardStack.getInstance().addCard(cardFactory.createCard(CardFactory.SKIP_CARD));

		for (Card card : cards) {
			card.cardAction(p1, p2);
		}
	}

	@Test
	public void testCreateCardMultipleNormal() throws IncorrectNumberOfCardsException {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = cardFactory.createCards(CardFactory.NORMAL_CARD, 10);

		for (Card card : cards) {
			assertEquals(card.getID(), CardFactory.NORMAL_CARD);
		}
		assertEquals(10, cards.size());
	}

	@Test
	public void testCreateCardNegativeMultiple() throws IncorrectNumberOfCardsException {
		CardFactory cardFactory = new CardFactory();

		exception.expect(IncorrectNumberOfCardsException.class);

		@SuppressWarnings("unused")
		List<Card> cards = cardFactory.createCards(CardFactory.NORMAL_CARD, -1);
	}
	
	@Test
	public void testCreateCardZeroMultiple() throws IncorrectNumberOfCardsException {
		CardFactory cardFactory = new CardFactory();
		
		exception.expect(IncorrectNumberOfCardsException.class);
		
		@SuppressWarnings("unused")
		List<Card> cards = cardFactory.createCards(CardFactory.NORMAL_CARD, 0);
	}

	@Test
	public void testCreateCardSingleNope() {
		CardFactory cardFactory = new CardFactory();

		Card card = cardFactory.createCard(CardFactory.NOPE_CARD);
		assertEquals(card.getID(), CardFactory.NOPE_CARD);
	}

	@Test
	public void testCreateCardMultipleNope() throws IncorrectNumberOfCardsException {
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
	public void testCreateCardMultipleDefuse() throws IncorrectNumberOfCardsException {
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
	public void testCreateCardMultipleAttack() throws IncorrectNumberOfCardsException {
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
	public void testCreateCardMultipleSkip() throws IncorrectNumberOfCardsException {
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
	public void testCreateCardMultipleExplodingKitten() throws IncorrectNumberOfCardsException {
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
	public void testCreateCardMultipleShuffle() throws IncorrectNumberOfCardsException {
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
	public void testCreateCardMultipleScry() throws IncorrectNumberOfCardsException {
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
	public void testCreateCardMultipleFavor() throws IncorrectNumberOfCardsException {
		CardFactory cardFactory = new CardFactory();

		List<Card> cards = cardFactory.createCards(CardFactory.FAVOR_CARD, 10);

		for (Card card : cards) {
			assertEquals(card.getID(), CardFactory.FAVOR_CARD);
		}
		assertEquals(10, cards.size());
	}
	
	@Test(expected = CardNotFoundException.class)
	public void testCreateNonExistingCard() {
		CardFactory cardFactory = new CardFactory();
		
		cardFactory.createCard(26);
	}
}
