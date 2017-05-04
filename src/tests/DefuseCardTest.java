
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.CardStack;
import code.DefuseCard;
import code.ExplodingKittenCard;
import code.Game;
import code.MainDeck;
import code.Player;
import code.PriorityManager;
import code.TurnManager;
import exceptions.InvalidNumberofPlayersException;

public class DefuseCardTest {

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
		deck = MainDeck.getInstance();
		game.start(3);
		removeAllKittens();
		player1 = game.getCurrentTurnPlayer();
		game.nextTurn();
		player2 = game.getCurrentTurnPlayer();
		game.nextTurn();
		player3 = game.getCurrentTurnPlayer();
		game.nextTurn();
	}

	private void removeAllKittens() {
		List<Card> tempCards = new ArrayList<Card>();
		for (Card card : deck.getCards()) {
			if (!(card instanceof ExplodingKittenCard)) {
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
	}

	@Test
	public void testDefusePlayedWithKittenOnStack() {
		Card expk = factory.createCard(CardFactory.EXPLODING_KITTEN_CARD);
		deck.insertCard(expk, 0);

		assertTrue(hasDefuseCardInHand(player1));
		game.nextTurn();
		assertEquals(player2, game.getCurrentTurnPlayer());
		assertEquals(3, game.getPlayers().size());
		assertFalse(hasDefuseCardInHand(player1));
	}

	private boolean hasDefuseCardInHand(Player player) {
		for (Card card : player.getHand()) {
			if (card instanceof DefuseCard) {
				return true;
			}
		}
		return false;
	}

}
