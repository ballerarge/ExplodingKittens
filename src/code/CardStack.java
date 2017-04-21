
package code;

import java.util.List;
import java.util.Stack;

public class CardStack {

	private static CardStack cardStack;
	private Stack<Card> stack;
	
	private CardStack() {
		this.stack = new Stack<Card>();
	}

	public static CardStack getInstance() {
		if (cardStack == null) {
			cardStack = new CardStack();
		}
		return cardStack;
	}

	public void moveCardsToStack(List<Card> cardsToMove) {
	}

	public Stack<Card> getStack() {
		return this.stack;
	}
	
	public void addCard(Card card) {
		this.stack.add(card);
	}

	public Card peek() {
		return null;
	}

	public void resolveTopCard() {
		this.stack.pop().cardAction(null, null);
		
	}

	public void moveCardToDiscardDeck() {
	}

	public static void tearDown() {
		cardStack = null;
	}

}
