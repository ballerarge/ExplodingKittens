
package code;

import java.util.ArrayList;
import java.util.List;

public class TwoCardBundle extends Card implements Cloneable {

	public static final int BUNDLE_SIZE = 2;
	private List<Card> cards;

	public TwoCardBundle(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public void cardAction(Player active, Player target) {
		// Somehow, prompt active player to pick a card from target's hand.

		Card targetCard = target.getHand().get(0);
		// 0 is a placeholder here.
		active.getHand().add(targetCard);
	}

	@Override
	public TwoCardBundle clone() {
		return new TwoCardBundle(new ArrayList<Card>(cards));
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
			if (cards.get(i - 1).cardID != cards.get(i).cardID) {
				return false;
			}
		}

		return true;
	}

	public List<Card> getCardsInBundle() {
		return cards;
	}
}
