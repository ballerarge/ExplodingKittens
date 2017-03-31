
package code;

import java.util.ArrayList;
import java.util.List;

public class HandManager {

	private List<Card> hand = new ArrayList<Card>();
	private List<Card> selectedCards = new ArrayList<Card>();
	private MainDeck mainDeck = new MainDeck();
	private CardStack cardStack = new CardStack();

	public HandManager() {
		this.mainDeck.initStartingDeck();
	}

	public void draw() {
		hand.add(mainDeck.draw());
	}

	public List<Card> getHand() {
		return hand;
	}

	public void selectCard(int i) throws CardDoesNotExistException {

		Card toMove;
		try {
			toMove = this.hand.remove(i);
		} catch (Exception e) {
			throw new CardDoesNotExistException("The card index given is invalid!");
		}

		this.selectedCards.add(toMove);
	}

	public List<Card> getSelectedCards() {
		return this.selectedCards;
	}

	public void moveSelectedToStack() throws NoCardsToMoveException {
		if (this.selectedCards.size() == 0) {
			throw new NoCardsToMoveException();
		}

		this.cardStack.moveCardsToStack(this.selectedCards);
		this.selectedCards.clear();
	}

}
