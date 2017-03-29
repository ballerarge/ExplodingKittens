package code;

import java.util.ArrayList;
import java.util.List;

public class MainDeck {
	
	Deck deck;
	
	public MainDeck() {
		this.deck = new Deck(new ArrayList<Card>());
	}

	public MainDeck(List<Card> cards) {
		this.deck = new Deck(cards);
	}

	public List<Card> getCards() {
		return this.deck.getCards();
	}

	public int getCardCount() {
		return deck.getCards().size();
	}

	public boolean insertCard(Card card, int position) {
		return deck.addCard(card, position);		
	}

}
