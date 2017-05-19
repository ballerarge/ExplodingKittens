
package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.CardStack;
import code.DiscardDeck;
import code.MainDeck;
import code.Player;
import code.PriorityManager;
import code.ShuffleCard;
import code.TurnManager;

public class ShuffleTest {
	
	CardFactory factory;
	
	@Before
	public void initialize() {
		MainDeck.tearDown();
		PriorityManager.tearDown();
		TurnManager.tearDown();
		DiscardDeck.tearDown();
		CardStack.tearDown();
		factory = new CardFactory();
	}

	@After
	public void tearDown() {
		MainDeck.tearDown();
		PriorityManager.tearDown();
		TurnManager.tearDown();
		DiscardDeck.tearDown();
		CardStack.tearDown();
	}

	@Test
	public void testShuffle() {
		Card shuffleCard = new ShuffleCard();
		MainDeck mainDeck=MainDeck.getInstance();
		mainDeck.initStartingDeck();
		String orderBefore="";
		String orderAfter="";
		List<Card> deckBefore;
		List<Card> deckAfter;
		
		deckBefore=mainDeck.getCards();
		for (Card card:deckBefore) {
			orderBefore+=card.getID();
		}
		shuffleCard.cardAction(new Player(), new Player());// Players shouldn't matter
		                                            // with shuffle
		deckAfter=mainDeck.getCards();
		for (Card card:deckAfter) {
			orderAfter+=card.getID();
		}
		assertFalse(orderBefore.equals(orderAfter));
		assertEquals(orderBefore.length(),orderAfter.length());
	}
	
	@Test
	public void testShuffleClone() {
		Card shuffle = factory.createCard(CardFactory.SHUFFLE_CARD);
		
		Card clone = shuffle.clone();
		
		assertFalse(clone == null);
	}
	
	@Test
	public void testShuffleActuallyHappens() {
		CardFactory factory = new CardFactory();
		Card shuffleCard = factory.createCard(CardFactory.SHUFFLE_CARD);
		Card card = factory.createCard(CardFactory.NORMAL_CARD);
		MainDeck mainDeck=MainDeck.getInstance();
		Player player1 = new Player();
		Player player2 = new Player();
		mainDeck.initStartingDeck();
		mainDeck.insertCard(card, 0);
		
		while (mainDeck.getCards().get(0).equals(card)) {
			shuffleCard.cardAction(player1, player2);
		}
		
		assertTrue(!mainDeck.getCards().get(0).equals(card));
		
	}

}
