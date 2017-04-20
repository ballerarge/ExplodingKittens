
package code;

import java.util.List;
import java.util.Stack;

public class CardStack {

	private static CardStack cardStack;

	public static CardStack getInstance() {
		if (cardStack == null) {
			cardStack = new CardStack();
		}
		return cardStack;
	}

	public void moveCardsToStack(List<Card> cardsToMove) {
	}

	public Stack<Card> getStack() {
		return null;
	}

	public Card peek() {
		return null;
	}

	public void resolveTopCard() {
	}

	public void moveCardToDiscardDeck() {
	}

}
