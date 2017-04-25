
package code;

import java.util.List;
import java.util.Stack;

public class CardStack {

	private static CardStack cardStack;
	private Stack<Card> stack;
	
	private CardStack() {
		this.stack = new Stack<Card>();
	}
	
	MainDeck mainDeck = MainDeck.getInstance();	
	// Instantiate DiscardDeck as part of integration testing.
	
	public static CardStack getInstance() {
		if (cardStack == null) {
			cardStack = new CardStack();
		}
		return cardStack;
	}
	
	public void addCard(Card card) {
		this.stack.add(card);
	}

	public void resolveTopCard() {
		this.stack.pop().cardAction(null, null);
		
	}

	public void moveCardToDiscardDeck() {
	    // Implement this as part of integration testing.
	}

	public static void tearDown() {
		cardStack = null;
	}
	
	public Stack<Card> getStack() {
		return (Stack<Card>) stack.clone();
	}

	public Card peek() {
		// Consider returning a clone or even just the card ID.
		// Figure out in integration testing.
		return stack.peek();
	}
	
	public void setStack(Stack<Card> stack) {
		this.stack = stack;
	}
	
	public void moveCardsToStack(List<Card> cardsToMove) {
		stack.addAll(cardsToMove);
	}
	
}
