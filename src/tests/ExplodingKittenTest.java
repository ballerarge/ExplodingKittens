
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.CardStack;
import code.Game;
import code.MainDeck;
import code.PriorityManager;
import code.TurnManager;
import exceptions.InvalidNumberofPlayersException;

public class ExplodingKittenTest {
	CardFactory factory;
	Game game;
	CardStack stack;

	@Before
	public void initialize() throws InvalidNumberofPlayersException {
		TurnManager.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
		MainDeck.tearDown();
		factory = new CardFactory();
		game = new Game();
		stack = CardStack.getInstance();
		game.start(3);
	}

	@After
	public void tearDown() {
		TurnManager.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
		MainDeck.tearDown();
	}

	@Test
	public void testKittenDrawnNoDefuse() {
		Card expk = factory.createCard(CardFactory.EXPLODING_KITTEN_CARD);
		stack.addCard(expk);

		stack.resolveTopCard();
		assertEquals(2, game.getPlayers().size());
	}

}
