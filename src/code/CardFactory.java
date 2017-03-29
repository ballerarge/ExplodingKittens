
package code;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
	public final static int NORMAL_CARD = 0;
	public static final int NOPE_CARD = 1;

	public CardFactory() {

	}

	public Card createCard(int cardID) {
		switch (cardID) {
			case NORMAL_CARD:
				return new NormalCard();
			case NOPE_CARD:
				return new NopeCard();
		}
		return new NormalCard();
	}

	public List<Card> createCard(int cardID, int numCards) throws IncorrectNumberOfCards {
		if (numCards <= 0) {
			throw new IncorrectNumberOfCards();
		}

		List<Card> cards = new ArrayList<Card>();

		for (int i = 0; i < numCards; i++) {
			cards.add(new NormalCard());
		}

		return cards;
	}
}
