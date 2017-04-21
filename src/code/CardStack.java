
package code;

import java.util.List;
import java.util.Stack;

public class CardStack {

	private static CardStack cardStack;
	
	Stack<Card> stack = new Stack<Card>();
	MainDeck mainDeck = MainDeck.getInstance();	
	
	public static CardStack getInstance() {
		if (cardStack == null) {
			cardStack = new CardStack();
		}
		return cardStack;
	}

	public static void tearDown() {
		cardStack = null;
	}
	
	public Stack<Card> getStack() {
		return (Stack<Card>) stack.clone();
	}

	public Card peek() {
		// Consider returning a clone or even just the card ID.
		return stack.peek();
	}
	
	public void setStack(Stack<Card> stack) {
		this.stack = stack;
	}

	public static void resolveTopCard() {
		
	}
	
	public void moveCardsToStack(List<Card> cardsToMove) {
		stack.addAll(cardsToMove);
	}
	
}
