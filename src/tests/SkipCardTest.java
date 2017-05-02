package tests;

import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.CardStack;
import code.Game;
import code.Player;
import exceptions.InvalidNumberofPlayersException;

public class SkipCardTest {

	@Test
	public void testSkipEndsTurnWithNoDraw() throws InvalidNumberofPlayersException {
		Game game = new Game();
		CardFactory factory = new CardFactory();
		game.start(3);
		Card skipCard = factory.createCard(CardFactory.SKIP_CARD);
		CardStack stack = CardStack.getInstance();
		Player player1 = game.getCurrentPlayer();
		Player player2 = game.getPlayers().get(1);
		int handSize = player1.getHand().size();
		
		stack.addCard(skipCard);
		stack.resolveTopCard(player1, player2);
		game.nextTurn();
		
		assertEquals(player1, game.getPlayers().get(0));
		assertEquals(handSize, player1.getHand().size());
		assertEquals(player2, game.getCurrentPlayer());
	}

}
