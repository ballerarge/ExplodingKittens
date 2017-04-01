
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

	public boolean addCard(Card card, int i) {
		try {
			this.cards.add(i, card);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}

	}

	public boolean removeCard(Card card) {
		return this.cards.remove(card);
	}
}
