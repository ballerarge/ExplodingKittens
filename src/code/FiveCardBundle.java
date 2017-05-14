
package code;

import java.util.ArrayList;
import java.util.List;

public class FiveCardBundle extends Card implements Cloneable {

	public static final int BUNDLE_SIZE = 5;
	private List<Card> cards;

	public FiveCardBundle(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public void cardAction(Player active, Player target) {
		// Somehow, let player look at the discrad deck and pick a dars from it.

		DiscardDeck discardDeck = DiscardDeck.getInstance();

		active.getHand().add(discardDeck.getCards().remove(0)); // Placeholder
	}

	@Override
	public Card clone() {
		return new FiveCardBundle(new ArrayList<>(cards));
	}

	protected static boolean isValidBundle(List<Card> cards) {
		if (cards == null || cards.size() != BUNDLE_SIZE)
			return false;

		for (Card card : cards) {
			if (!(card instanceof NormalCard)) {
				return false;
			}
		}

		return true;
	}

}
