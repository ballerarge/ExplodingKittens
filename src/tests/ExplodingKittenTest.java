package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.CardStack;
import code.Game;
import code.MainDeck;
import code.Player;
import code.PriorityManager;
import code.TurnManager;
import exceptions.InvalidNumberofPlayersException;

public class ExplodingKittenTest {
	CardFactory factory;
	Game game;
	Player player1;
	Player player2;
	Player player3;
	CardStack stack;
	TurnManager turnManager;
	PriorityManager pManager;
	MainDeck mDeck;

	@Before
	public void initialize() throws InvalidNumberofPlayersException {
		TurnManager.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
		MainDeck.tearDown();
		factory = new CardFactory();
		game = new Game();
		stack = CardStack.getInstance();
		turnManager = TurnManager.getInstance();
		pManager = PriorityManager.getInstance();
		mDeck = MainDeck.getInstance();
		game.start(3);
		player1 = game.getCurrentTurnPlayer();
		game.nextTurn();
		player2 = game.getCurrentTurnPlayer();
		game.nextTurn();
		player3 = game.getCurrentTurnPlayer();
		game.nextTurn();
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
		mDeck.insertCard(expk, 0);
		player1.getHandManager().selectCard(5);
		player1.getHandManager().moveSelectedToStack();
		pManager.resolveCard();
		
		assertEquals(5, player1.getHand().size());
		assertEquals(0, stack.getStack().size());
		game.nextTurn();
		assertEquals(player2, game.getCurrentTurnPlayer());
		assertEquals(2, game.getPlayers().size());
	}

}
