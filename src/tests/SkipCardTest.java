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

public class SkipCardTest {
	
	@Before
	public void initialize() {
		TurnManager.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
	}
	
	@After
	public void tearDown() {
		TurnManager.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
	}
	

	@Test
	public void testSkipEndsTurnWithNoDraw() throws InvalidNumberofPlayersException {
		
		Game game = new Game();
		CardFactory factory = new CardFactory();
		game.start(3);
		Card skipCard = factory.createCard(CardFactory.SKIP_CARD);
		CardStack stack = CardStack.getInstance();
		Player player1 = game.getCurrentTurnPlayer();
		Player player2 = game.getPlayers().get(1);
		int handSize = player1.getHand().size();
		
		stack.addCard(skipCard);
		stack.resolveTopCard(player1, null);
		
		assertEquals(player1, game.getPlayers().get(0));
		assertEquals(handSize, player1.getHand().size());
		assertEquals(player2, game.getCurrentTurnPlayer());
	}

}
