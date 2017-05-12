
package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exceptions.InvalidBundleException;

public class ThreeCardBundle extends Card {

	public static final int BUNDLE_SIZE = 3;
	private List<Card> cards;

	public ThreeCardBundle(List<Card> cards) throws InvalidBundleException {
		if (!ThreeCardBundle.isValidBundle(cards)) {
			throw new InvalidBundleException();
		}
		
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
	public Card clone() {
		ThreeCardBundle clone = null;
		try {
			clone = new ThreeCardBundle(new ArrayList<Card>(cards));
		} catch (InvalidBundleException e) {
			e.printStackTrace();
		}
		
		return clone;
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
