
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.Card;
import code.MainDeck;
import code.Player;
import code.ShuffleCard;

public class ShuffleTest {

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

}
