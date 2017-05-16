
package code;

import java.util.ArrayList;
import java.util.List;

public class FiveCardBundle extends Card implements Cloneable {

	public static final int BUNDLE_SIZE = 5;
	private List<Card> cards;
	private Class<?> targetCardClass;

	public FiveCardBundle(List<Card> cards) {
		this.cards = cards;
		targetCardClass = NormalCard.class;
	}

	@Override
	public void cardAction(Player active, Player target) {
		// Somehow, let player look at the discard deck and pick a card from it.

		DiscardDeck discardDeck = DiscardDeck.getInstance();

		if (!(discardDeck.getCardCount() == 0)) {
			active.getHand().add(discardDeck.removeCard(targetCardClass));
		}

	}

	public void setDiscardDeckType(Class<?> classType) {
		targetCardClass = classType;
	}

	@Override
	public FiveCardBundle clone() {
		return new FiveCardBundle(new ArrayList<>(cards));
	}

	public static boolean isValidBundle(List<Card> cards) {
		if (cards == null || cards.size() != BUNDLE_SIZE)
			return false;

		for (Card card : cards) {
			if (!(card instanceof NormalCard)) {
				return false;
			}
		}

		for (int i = 1; i < cards.size(); i++) {
			NormalCard firstCard = (NormalCard) cards.get(i - 1);
			NormalCard secondCard = (NormalCard) cards.get(i);
			if (firstCard.getIcon() != secondCard.getIcon()) {
				return false;
			}
		}

		return true;
	}

	public List<Card> getCardsInBundle() {
		return cards;
	}

}
