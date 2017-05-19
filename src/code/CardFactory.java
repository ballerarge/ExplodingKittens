
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

	public int attackCardCount;
	public int defuseCardCount;
	public int explodingKittenCardCount;
	public int favorCardCount;
	public int nopeCardCount;
	public int normalCardCount;
	public int scryCardCount;
	public int shuffleCardCount;
	public int skipCardCount;

	public final int attackCardMax = 4;
	public final int defuseCardMax = 5;
	public final int explodingKittenCardMax = 3;
	public final int favorCardMax = 4;
	public final int nopeCardMax = 4;
	public final int normalCardMax = 4;
	public final int scryCardMax = 3;
	public final int shuffleCardMax = 3;
	public final int skipCardMax = 3;

	public Card createCard(int cardID) {
		Card card;
		switch (cardID) {
			case NORMAL_CARD:
				normalCardCount = (normalCardCount) % normalCardMax + 1;
				return new NormalCard("card_images\\NormalCard" + normalCardCount + ".png");
			case NOPE_CARD:
				nopeCardCount = (nopeCardCount) % nopeCardMax + 1;
				card = new NopeCard("card_images\\NopeCard" + nopeCardCount + ".png");
				break;
			case DEFUSE_CARD:
				defuseCardCount = (defuseCardCount) % defuseCardMax + 1;
				card = new DefuseCard("card_images\\DefuseCard" + defuseCardCount + ".png");
				break;
			case ATTACK_CARD:
				attackCardCount = (attackCardCount) % attackCardMax + 1;
				card = new AttackCard("card_images\\AttackCard" + attackCardCount + ".png");
				break;
			case SKIP_CARD:
				skipCardCount = (skipCardCount) % skipCardMax + 1;
				card = new SkipCard("card_images\\SkipCard" + skipCardCount + ".png");
				break;
			case EXPLODING_KITTEN_CARD:
				explodingKittenCardCount = (explodingKittenCardCount) % explodingKittenCardMax + 1;
				card = new ExplodingKittenCard("card_images\\ExplodingKittenCard" + explodingKittenCardCount + ".png");
				break;
			case SHUFFLE_CARD:
				shuffleCardCount = (shuffleCardCount) % shuffleCardMax + 1;
				card = new ShuffleCard("card_images\\ShuffleCard" + shuffleCardCount + ".png");
				break;
			case SCRY_CARD:
				scryCardCount = (scryCardCount) % scryCardMax + 1;
				card = new ScryCard("card_images\\ScryCard" + scryCardCount + ".png");
				break;
			case FAVOR_CARD:
				favorCardCount = (favorCardCount) % favorCardMax + 1;
				card = new FavorCard("card_images\\FavorCard" + favorCardCount + ".png");
				break;
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
