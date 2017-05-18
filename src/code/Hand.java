
package code;

import java.util.ArrayList;
import java.util.List;

import exceptions.IncorrectNumberOfCardsException;
import exceptions.InvalidBundleException;
import exceptions.NoCardsToMoveException;

public class Hand {

	private List<Card> hand;
	private List<Card> selectedCards;
	private MainDeck mainDeck;
	private CardStack cardStack;

	public Hand() {
		hand = new ArrayList<Card>();
		selectedCards = new ArrayList<Card>();
		mainDeck = MainDeck.getInstance();
		cardStack = CardStack.getInstance();
	}

	public Card draw() {
		Card ret = mainDeck.draw();
		hand.add(ret);
		return ret;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void selectCard(int i) throws IncorrectNumberOfCardsException {

		Card toMove;
		try {
			toMove = this.hand.remove(i);
		} catch (Exception e) {
			throw new IncorrectNumberOfCardsException("The card index given is invalid!");
		}

		this.selectedCards.add(toMove);
	}

	public List<Card> getSelectedCards() {
		return this.selectedCards;
	}

	public void moveSelectedToStack() throws NoCardsToMoveException, InvalidBundleException {
		if (this.selectedCards.size() == 0) {
			throw new NoCardsToMoveException();
		}

		if (this.allNormalCards()) {
			if (TwoCardBundle.isValidBundle(selectedCards)) {
				this.cardStack.moveCardsToStack(this.makeBundle(2));
			} else if (ThreeCardBundle.isValidBundle(selectedCards)) {
				this.cardStack.moveCardsToStack(this.makeBundle(3));
			} else if (FiveCardBundle.isValidBundle(selectedCards)) {
				this.cardStack.moveCardsToStack(this.makeBundle(5));
			}

		} else {
			this.cardStack.moveCardsToStack(this.selectedCards);
		}
		this.selectedCards.clear();
	}

	private List<Card> makeBundle(int sizeOfBundle) throws InvalidBundleException {
		ArrayList<Card> toSendToStack = new ArrayList<Card>();

		if (sizeOfBundle == 2) {
			toSendToStack.add(new TwoCardBundle(selectedCards));
		} else if (sizeOfBundle == 3) {
			toSendToStack.add(new ThreeCardBundle(selectedCards));
		} else {
			toSendToStack.add(new FiveCardBundle(selectedCards));
		}
		return toSendToStack;
	}

	private boolean allNormalCards() {
		for (Card card : selectedCards) {
			if (!(card instanceof NormalCard)) {
				return false;
			}
		}
		return true;
	}

	public void addDefuseCard() {
		this.hand.add(new CardFactory().createCard(CardFactory.DEFUSE_CARD));
	}

	public void addCards(List<Card> cards) {
		this.hand.addAll(cards);
	}

	public void clearSelectedCards() {
		this.selectedCards.clear();
	}
}
