
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.CardStack;
import code.DiscardDeck;
import code.Game;
import code.MainDeck;
import code.Player;
import code.PriorityManager;
import code.TurnManager;
import exceptions.InvalidBundleException;
import exceptions.InvalidNumberofPlayersException;
import exceptions.NoCardsToMoveException;

public class SkipCardTest {
	CardFactory factory;
	Game game;
	Player player1;
	Player player2;
	Player player3;
	CardStack stack;
	TurnManager turnManager;
	PriorityManager pManager;
	MainDeck deck;

	@Before
	public void initialize() throws InvalidNumberofPlayersException, NoCardsToMoveException, InvalidBundleException {
		TurnManager.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
		MainDeck.tearDown();
		factory = new CardFactory();
		game = new Game();
		stack = CardStack.getInstance();
		turnManager = TurnManager.getInstance();
		pManager = PriorityManager.getInstance();
		deck = MainDeck.getInstance();
		game.start(3);

		removeAllKittens();

		player1 = game.getCurrentPlayer();
		game.nextTurn();
		player2 = game.getCurrentPlayer();
		game.nextTurn();
		player3 = game.getCurrentPlayer();
		game.nextTurn();
	}

	private void removeAllKittens() {
		List<Card> tempCards = new ArrayList<Card>();
		for (Card card : deck.getCards()) {
			if (!(card.getID() == 5)) {
				tempCards.add(card);
			}
		}

		deck.setCards(tempCards);
	}

	@After
	public void tearDown() {
		TurnManager.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
		MainDeck.tearDown();
		DiscardDeck.tearDown();
	}

	@Test
	public void testSkipEndsTurnWithNoDraw() {
		Card skipCard = factory.createCard(CardFactory.SKIP_CARD);
		int handSize = player1.getHand().size();

		stack.addCard(skipCard);
		pManager.resolveCard();

		assertEquals(player1, game.getPlayers().get(0));
		assertEquals(handSize, player1.getHand().size());
		assertEquals(player2, game.getCurrentPlayer());
	}

	@Test
	public void testSkipPlayedAfterAttack() throws NoCardsToMoveException, InvalidBundleException {
		Card skipCard = factory.createCard(CardFactory.SKIP_CARD);
		Card attackCard = factory.createCard(CardFactory.ATTACK_CARD);

		stack.addCard(attackCard);
		pManager.resolveCard();
		stack.addCard(skipCard);
		pManager.resolveCard();

		assertEquals(player2, game.getCurrentPlayer());
		game.nextTurn();
		assertEquals(player3, game.getCurrentPlayer());
	}

	@Test
	public void testSkipClone() {
		Card skip = factory.createCard(CardFactory.SKIP_CARD);

		Card clone = skip.clone();

		assertFalse(clone == null);
	}

}
