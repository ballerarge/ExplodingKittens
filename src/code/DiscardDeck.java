package code;

import java.util.List;

public class DiscardDeck {

	private static DiscardDeck discardDeck;
	
	Deck deck;

	public static DiscardDeck getInstance() {
		if (discardDeck == null) {
			discardDeck = new DiscardDeck();
		}
		return discardDeck;
	}
	
	private DiscardDeck() {
		deck = new Deck();
	}

	public static void tearDown() {
		discardDeck = null;
	}

	public List<Card> getCards() {
		// TODO Auto-generated method stub
		return discardDeck.deck.getCards();
	}

	public int getCardCount() {
		// TODO Auto-generated method stub
		return discardDeck.deck.getCards().size();
	}

}
