package code;

import java.util.List;

public class Deck {
	private List<Card> cards;
	
	public Deck() {
		
	}

	public Deck(List<Card> cards) {
		this.cards = cards;
	}

	public List<Card> getCards() {
		return cards;
	}
}
