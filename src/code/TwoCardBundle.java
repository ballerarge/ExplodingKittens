package code;

import java.util.ArrayList;
import java.util.List;

import exceptions.InvalidBundleException;

public class TwoCardBundle extends Card {

	public static final int BUNDLE_SIZE = 2;
	private List<Card> cards;
	
	public TwoCardBundle(List<Card> cards) throws InvalidBundleException {
		if (!TwoCardBundle.isValidBundle(cards)) {
			throw new InvalidBundleException();
		}
		
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
	public Card clone() {
		TwoCardBundle clone = null;
		try {
			clone = new TwoCardBundle(new ArrayList<Card>(cards));
		} catch (InvalidBundleException e) {
			e.printStackTrace();
		}
		
		return clone;
	}

	protected static boolean isValidBundle(List<Card> cards) {
		if (cards == null || cards.size() != BUNDLE_SIZE) return false;
		
		for (Card card : cards) {
			if(!(card instanceof NormalCard)) {
				return false;
			}
		}
		
		return true;
	}
}
