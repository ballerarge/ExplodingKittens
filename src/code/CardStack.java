
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
	DiscardDeck discardDeck = DiscardDeck.getInstance();

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

	public void resolveTopCard(Player player1, Player player2) {
		this.stack.pop().cardAction(player1, player2);
	}

	public void moveCardsToDiscardDeck() {
		// Implement this as part of integration testing.
		discardDeck.addAll(stack);
		stack.clear();
	}

	public static void tearDown() {
		cardStack = null;
	}

	@SuppressWarnings("unchecked") // Cloning a stack will always return a
	                               // stack.
	public Stack<Card> getStack() {
		return (Stack<Card>) stack.clone();
	}

	public Card peek() {
		// Consider returning a clone or even just the card ID.
		// Figure out in integration testing.
		return stack.peek().clone();
	}

	public void setStack(Stack<Card> stack) {
		this.stack = stack;
	}

	public void moveCardsToStack(List<Card> cardsToMove) {
		stack.addAll(cardsToMove);
	}

}
