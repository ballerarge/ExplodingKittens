
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.MainDeck;
import code.Player;
import code.ShuffleCard;

public class ShuffleTest {
	
	CardFactory factory;
	
	@Before
	public void initialize() {
		factory = new CardFactory();
	}

	@Test
	public void testShuffle() {
		Card shuffleCard = new ShuffleCard();
		MainDeck.tearDown();
		MainDeck mainDeck=MainDeck.getInstance();
		mainDeck.initStartingDeck();
		String orderBefore="";
		String orderAfter="";
		List<Card> deckBefore;
		List<Card> deckAfter;
		
		deckBefore=mainDeck.getCards();
		for (Card card:deckBefore)
			orderBefore+=card.getID();
		shuffleCard.cardAction(new Player(), new Player());// Players shouldn't matter
		                                            // with shuffle
		deckAfter=mainDeck.getCards();
		for (Card card:deckAfter)
			orderAfter+=card.getID();
		assertFalse(orderBefore.equals(orderAfter));
		assertEquals(orderBefore.length(),orderAfter.length());
		MainDeck.tearDown();
	}
	
	@Test
	public void testShuffleClone() {
		Card shuffle = factory.createCard(CardFactory.SHUFFLE_CARD);
		
		Card clone = shuffle.clone();
		
		assertFalse(clone == null);
	}

}
