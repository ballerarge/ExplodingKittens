
package tests;

import static org.junit.Assert.*;

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
		String before="";
		String after="";
		for (Card card:mainDeck.getCards())
			before+=card.getID();
		shuffleCard.cardAction(new Player(), new Player());// Players shouldn't matter
		                                            // with shuffle
		for (Card card:mainDeck.getCards())
			after+=card.getID();
		assertFalse(before.equals(after));
	}

}
