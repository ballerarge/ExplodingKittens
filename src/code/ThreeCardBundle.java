
package code;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.encoding.policy.SelectOptimalEncodingFeatureConfigurator;

public class ThreeCardBundle extends Card implements Cloneable {

	public static final int BUNDLE_SIZE = 3;
	private List<Card> cards;

	public ThreeCardBundle(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public void cardAction(Player active, Player target) {
		// Somehow, prompt active player to name a card from target's hand.
		// If it exists, give it to them. Otherwise, they get nothing.
		List<Card> targetHand = target.getHand();
		int indexOfCardPicked = targetHand.indexOf(new AttackCard());

		if (indexOfCardPicked > -1) {
			Card picked = targetHand.remove(indexOfCardPicked);
			active.getHand().add(picked);
		}

		// Otherwise, active won't get a card.
	}

	@Override
	public ThreeCardBundle clone() {
		return new ThreeCardBundle(new ArrayList<Card>(cards));
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
