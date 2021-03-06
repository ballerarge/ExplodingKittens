
package code;

import java.util.ArrayList;
import java.util.List;

public class ThreeCardBundle extends Card implements Cloneable {

	public static final int BUNDLE_SIZE = 3;
	private List<Card> cards;
	private Class<?> targetCardClass;

	public ThreeCardBundle(List<Card> cards) {
		this.cards = cards;
		targetCardClass = AttackCard.class;
	}

	@Override
	public void cardAction(Player active, Player target) {
		// Somehow, prompt active player to name a card from target's hand.
		// If it exists, give it to them. Otherwise, they get nothing.
		List<Card> targetHand = target.getHand();
		int indexOfCardPicked = -1;
		for (int i = 0; i < targetHand.size(); i++) {
			Card card = targetHand.get(i);
			if (card.getClass().equals(CardLogger.class))
				card = ((CardLogger) card).getCard();
			if (card.getClass().equals(targetCardClass)) {
				indexOfCardPicked = i;
				break;
			}
		}

		if (indexOfCardPicked > -1) {
			Card picked = targetHand.remove(indexOfCardPicked);
			active.getHand().add(picked);
		}

		// Otherwise, active won't get a card.
	}

	public void setTargetCardClass(Class<?> cardClass) {
		targetCardClass = cardClass;
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
