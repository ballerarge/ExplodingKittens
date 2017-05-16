
package code;

import java.util.ArrayList;
import java.util.List;

import exceptions.IncorrectNumberOfCardsException;
import exceptions.InvalidBundleException;
import exceptions.NoCardsToMoveException;

public class Hand {

	private List<Card> hand = new ArrayList<Card>();
	private List<Card> selectedCards = new ArrayList<Card>();
	private MainDeck mainDeck = MainDeck.getInstance();
	private CardStack cardStack = CardStack.getInstance();

	public Hand() {
		this.mainDeck.initStartingDeck();
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
			this.cardStack.moveCardsToStack(this.makeBundle());
		} else {
			this.cardStack.moveCardsToStack(this.selectedCards);
		}
		this.selectedCards.clear();
	}

	private List<Card> makeBundle() throws InvalidBundleException {
		ArrayList<Card> toSendToStack = new ArrayList<Card>();
		
		int sizeOfBundle = this.selectedCards.size();
		if (sizeOfBundle == 2) {
			if (!TwoCardBundle.isValidBundle(selectedCards)) {
				throw new InvalidBundleException();
			} else {
				toSendToStack.add(new TwoCardBundle(selectedCards));
			}
		} else if (sizeOfBundle == 3) {
			if (!ThreeCardBundle.isValidBundle(selectedCards)) {
				throw new InvalidBundleException();
			} else {
				toSendToStack.add(new ThreeCardBundle(selectedCards));
			}
		} else if (sizeOfBundle == 5) {
			if (!FiveCardBundle.isValidBundle(selectedCards)) {
				throw new InvalidBundleException();
			} else {
				toSendToStack.add(new FiveCardBundle(selectedCards));
			}
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
	
	public void clearSelectedCards(){
		this.selectedCards.clear();
	}
}
