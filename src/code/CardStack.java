
package code;

import java.util.List;
import java.util.Stack;

public interface CardStack {

	public void moveCardsToStack(List<Card> cardsToMove);

	public Stack<Card> getStack();

	public Card peek();

	public void resolveTopCard();

	public void moveCardToDiscardDeck();

}
