package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.CardStack;
import code.Game;
import code.Player;
import code.PriorityManager;
import code.TurnManager;
import exceptions.InvalidNumberofPlayersException;

public class AttackCardTest {
	CardFactory factory;
	Game game;
	Player player1;
	Player player2;
	Player player3;
	CardStack stack;
	TurnManager turnManager;
	PriorityManager pManager;

	@Before
	public void initialize() throws InvalidNumberofPlayersException {
		TurnManager.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
		factory = new CardFactory();
		game = new Game();
		stack = CardStack.getInstance();
		turnManager = TurnManager.getInstance();
		pManager = PriorityManager.getInstance();
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
	}
	
	@Test
	public void testAttackEndsTurn() {
		Card attackCard = factory.createCard(CardFactory.ATTACK_CARD);
		
		stack.addCard(attackCard);
		pManager.resolveCard();
		
		assertEquals(player2, game.getCurrentTurnPlayer());
	}
	
	@Test
	public void testNextPlayerHasTwoTurns() {
		Card attackCard = factory.createCard(CardFactory.ATTACK_CARD);
		
		stack.addCard(attackCard);
		pManager.resolveCard();
		
		assertEquals(player2, game.getCurrentTurnPlayer());
		game.nextTurn();
		assertEquals(player2, game.getCurrentTurnPlayer());	
	}
	
	@Test
	public void testTurnsNotScrewyAfterAttack() {
		Card attackCard = factory.createCard(CardFactory.ATTACK_CARD);
		
		stack.addCard(attackCard);
		pManager.resolveCard();
		
		assertEquals(player2, game.getCurrentTurnPlayer());
		game.nextTurn();
		assertEquals(player2, game.getCurrentTurnPlayer());	
		game.nextTurn();
		assertEquals(player3, game.getCurrentTurnPlayer());
		game.nextTurn();
		assertEquals(player1, game.getCurrentTurnPlayer());
		game.nextTurn();
		assertEquals(player2, game.getCurrentTurnPlayer());
		game.nextTurn();
		assertEquals(player3, game.getCurrentTurnPlayer());
	}

}
