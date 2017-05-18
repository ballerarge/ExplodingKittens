
package code;

import java.util.ArrayList;
import java.util.List;

import exceptions.CardNotFoundException;
import exceptions.IncorrectNumberOfCardsException;

public class CardFactory {
	public static final int NORMAL_CARD = 0;
	public static final int NOPE_CARD = 1;
	public static final int DEFUSE_CARD = 2;
	public static final int ATTACK_CARD = 3;
	public static final int SKIP_CARD = 4;
	public static final int EXPLODING_KITTEN_CARD = 5;
	public static final int SHUFFLE_CARD = 6;
	public static final int SCRY_CARD = 7;
	public static final int FAVOR_CARD = 8;

	public CardFactory() {

	}

	public Card createCard(int cardID) {
		Card card;
		switch (cardID) {
			case NORMAL_CARD:
				return new NormalCard();
			case NOPE_CARD:
				card = new NopeCard(); break;
			case DEFUSE_CARD:
				card = new DefuseCard(); break;
			case ATTACK_CARD:
				card = new AttackCard(); break;
			case SKIP_CARD:
				card = new SkipCard(); break;
			case EXPLODING_KITTEN_CARD:
				card = new ExplodingKittenCard(); break;
			case SHUFFLE_CARD:
				card = new ShuffleCard(); break;
			case SCRY_CARD:
				card = new ScryCard(); break;
			case FAVOR_CARD:
				card = new FavorCard(); break;
			default:
				throw new CardNotFoundException("CardID incorrect for create card in Card Factory");
		}
		return new CardLogger(card);
	}

	public List<Card> createCards(int cardID, int numCards) throws IncorrectNumberOfCardsException {
		if (numCards <= 0) {
			throw new IncorrectNumberOfCardsException();
		}

		List<Card> cards = new ArrayList<Card>();

		for (int i = 0; i < numCards; i++) {
			cards.add(createCard(cardID));
		}

		return cards;
	}
}
