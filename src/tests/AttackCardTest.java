
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
import code.ExplodingKittenCard;
import code.Game;
import code.MainDeck;
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
	}

	@Test
	public void testAttackEndsTurn() {
		Card attackCard = factory.createCard(CardFactory.ATTACK_CARD);

		stack.addCard(attackCard);
		pManager.resolveCard();

		assertEquals(player2, game.getCurrentPlayer());
	}

	@Test
	public void testNextPlayerHasTwoTurns() {
		Card attackCard = factory.createCard(CardFactory.ATTACK_CARD);

		//stack.addCard(attackCard);
		//pManager.resolveCard();
		attackCard.cardAction(null, null);

		assertEquals(player2, game.getCurrentPlayer());
		game.nextTurn();
		assertEquals(player2, game.getCurrentPlayer());
	}

	@Test
	public void testTurnsNotScrewyAfterAttack() {
		Card attackCard = factory.createCard(CardFactory.ATTACK_CARD);

		attackCard.cardAction(null, null);

		assertEquals(player2, game.getCurrentPlayer());
		game.nextTurn();
		assertEquals(player2, game.getCurrentPlayer());
		game.nextTurn();
		assertEquals(player3, game.getCurrentPlayer());
		game.nextTurn();
		assertEquals(player1, game.getCurrentPlayer());
		game.nextTurn();
		assertEquals(player2, game.getCurrentPlayer());
		game.nextTurn();
		assertEquals(player3, game.getCurrentPlayer());
	}

	@Test
	public void testAttackPlayedAfterAttack() {
		Card attack1 = factory.createCard(CardFactory.ATTACK_CARD);
		Card attack2 = factory.createCard(CardFactory.ATTACK_CARD);

		attack1.cardAction(null, null);
		attack2.cardAction(null, null);
		
//		stack.addCard(attack1);
//		pManager.resolveCard();
//		stack.addCard(attack2);
//		pManager.resolveCard();

		assertEquals(player3, game.getCurrentPlayer());
		game.nextTurn();
		assertEquals(player3, game.getCurrentPlayer());
		game.nextTurn();
		assertEquals(player1, game.getCurrentPlayer());
	}
	
	@Test
	public void testAttackClone() {
		Card attack = factory.createCard(CardFactory.ATTACK_CARD);
		
		Card clone = attack.clone();
		
		assertFalse(clone == null);
	}

}
