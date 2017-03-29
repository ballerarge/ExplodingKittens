
package code;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
	public final static int NORMAL_CARD = 0;
	public static final int NOPE_CARD = 1;
	public static final int DEFUSE_CARD = 2;
	public static final int ATTACK_CARD = 3;
	public static final int SKIP_CARD = 4;
	public static final int EXPLODING_KITTEN_CARD = 5;

	public CardFactory() {

	}

	public Card createCard(int cardID) {
		switch (cardID) {
			case NORMAL_CARD:
				return new NormalCard();
			case NOPE_CARD:
				return new NopeCard();
			case DEFUSE_CARD:
				return new DefuseCard();
			case ATTACK_CARD:
				return new AttackCard();
			case SKIP_CARD:
				return new SkipCard();
			case EXPLODING_KITTEN_CARD:
				return new ExplodingKittenCard();
		}
		return new NormalCard();
	}

	public List<Card> createCard(int cardID, int numCards) throws IncorrectNumberOfCards {
		if (numCards <= 0) {
			throw new IncorrectNumberOfCards();
		}

		List<Card> cards = new ArrayList<Card>();

		for (int i = 0; i < numCards; i++) {
			cards.add(createCard(cardID));
		}

		return cards;
	}
}
