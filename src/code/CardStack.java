
package code;

import java.util.List;
import java.util.Stack;

import exceptions.InvalidNopeTargetException;

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
		discardDeck.addAll(stack);
		stack.clear();
	}

	public static void tearDown() {
		cardStack = null;
	}

	@SuppressWarnings("unchecked")
	public Stack<Card> getStack() {
		return (Stack<Card>) stack.clone();
	}

	public Card peek() {
		return stack.peek().clone();
	}

	public void setStack(Stack<Card> stack) {
		this.stack = stack;
	}

	public void moveCardsToStack(List<Card> cardsToMove) {
		stack.addAll(cardsToMove);
	}

	public void counterTopCard() {
		if (stack.isEmpty() || stack.peek().getID() == CardFactory.EXPLODING_KITTEN_CARD
		        || stack.peek().getID() == CardFactory.DEFUSE_CARD) {

			throw new InvalidNopeTargetException();
		}
		stack.pop();
	}

}
