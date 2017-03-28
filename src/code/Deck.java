
package code;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		this.cards = new ArrayList<Card>();
	}

	public Deck(List<Card> cards) {
		this.cards = cards;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void addCard(Card card, int i) {
		this.cards.add(i, card);
	}

	public boolean removeCard(Card card) {
		return this.cards.remove(card);
	}
}
