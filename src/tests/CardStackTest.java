
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.CardStack;
import code.DiscardDeck;
import code.Game;
import code.MainDeck;
import code.NormalCard;
import code.Player;
import code.PriorityManager;
import code.TurnManager;
import exceptions.InvalidNumberofPlayersException;

public class CardStackTest {
	
	@Before
	public void initialize() {
		TurnManager.tearDown();
		MainDeck.tearDown();
		DiscardDeck.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
	}
	
	@After
	public void tearDown() {
		TurnManager.tearDown();
		MainDeck.tearDown();
		DiscardDeck.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
	}

	@Test
	public void testCardstackConstructor() {
		CardStack cardStack = CardStack.getInstance();
		assertEquals(cardStack, CardStack.getInstance());
	}

	@Test
	public void testGetStack() {
		CardStack cardStack = CardStack.getInstance();

		assertTrue(cardStack.getStack() instanceof Stack<?>);
	}

	@Test
	public void testPeekStack() {
		CardStack cardStack = CardStack.getInstance();
		Stack<Card> testingStack = new Stack<Card>();
		NormalCard testingCard = new NormalCard();

		testingStack.push(testingCard);

		cardStack.setStack(testingStack);

		assertTrue(cardStack.peek() instanceof NormalCard);
	}

	@Test
	public void testMoveCardToDiscardDeck() {
		CardStack cardStack = CardStack.getInstance();
		DiscardDeck discardDeck = DiscardDeck.getInstance();

		cardStack.addCard(new NormalCard());
		cardStack.moveCardsToDiscardDeck();

		assertTrue(cardStack.getStack().isEmpty());
		assertEquals(discardDeck.getCardCount(), 1);
	}
	
	@Test
	public void testResolveTopCard() throws InvalidNumberofPlayersException {
		Game game = new Game();
		game.start(3);
		CardStack stack = CardStack.getInstance();
		CardFactory factory = new CardFactory();
		Player player1 = new Player();
		Player player2 = new Player();
		stack.addCard(factory.createCard(CardFactory.DEFUSE_CARD));
		
		stack.resolveTopCard(player1, player2);
		
		assertEquals(0, stack.getStack().size());
	}
}
