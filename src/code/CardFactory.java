
package code;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
	public final static int NORMAL_CARD = 0;

	public CardFactory() {

	}

	public Card createCard(int cardID) {
		return new NormalCard();
	}

	public List<Card> createCard(int cardID, int numCards) {
		List<Card> cards = new ArrayList<Card>();
		
		for (int i = 0; i < numCards; i++) {
			cards.add(new NormalCard());
		}
		
		return cards;
	}
}
