
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

public class DefuseCardTest {

	CardFactory factory;
	CardStack stack;
	Game game;

	@Before
	public void initialize() throws InvalidNumberofPlayersException {
		TurnManager.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
		MainDeck.tearDown();
		factory = new CardFactory();
		stack = CardStack.getInstance();
		game = new Game();
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
	public void testDefusePlayedWithKittenOnStack() {
		Card kittenCard = factory.createCard(CardFactory.EXPLODING_KITTEN_CARD);
		Card defuseCard = factory.createCard(CardFactory.DEFUSE_CARD);	
		stack.addCard(kittenCard);
		stack.addCard(defuseCard);
		
		stack.resolveTopCard();
		
		assertEquals(0, stack.getStack().size());		
	}
	
	@Test
	public void testDefusePlayedNoKitten() {
		Card defuseCard = factory.createCard(CardFactory.DEFUSE_CARD);
		Card skipCard = factory.createCard(CardFactory.SKIP_CARD);
		stack.addCard(skipCard);
		stack.addCard(defuseCard);
		
		stack.resolveTopCard();
		
		assertEquals(1, stack.getStack().size());
	}
}
