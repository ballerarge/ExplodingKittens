
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

	private int attackCardCount;
	private int defuseCardCount;
	private int explodingKittenCardCount;
	private int favorCardCount;
	private int nopeCardCount;
	private int normalCardCount;
	private int scryCardCount;
	private int shuffleCardCount;
	private int skipCardCount;

	private final int attackCardMax = 4;
	private final int defuseCardMax = 5;
	private final int explodingKittenCardMax = 3;
	private final int favorCardMax = 4;
	private final int nopeCardMax = 4;
	private final int normalCardMax = 4;
	private final int scryCardMax = 3;
	private final int shuffleCardMax = 3;
	private final int skipCardMax = 3;

	public CardFactory() {
		initCardCounts();
	}

	private void initCardCounts() {
		attackCardCount = 0;
		defuseCardCount = 0;
		explodingKittenCardCount = 0;
		favorCardCount = 0;
		nopeCardCount = 0;
		normalCardCount = 0;
		scryCardCount = 0;
		shuffleCardCount = 0;
		skipCardCount = 0;
	}

	public Card createCard(int cardID) {
		switch (cardID) {
			case NORMAL_CARD:
				normalCardCount = (normalCardCount) % normalCardMax + 1;
				return new NormalCard("NormalCard" + normalCardCount + ".png");
			case NOPE_CARD:
				nopeCardCount = (nopeCardCount) % nopeCardMax + 1;
				return new NopeCard("NopeCard" + nopeCardCount + ".png");
			case DEFUSE_CARD:
				defuseCardCount = (defuseCardCount) % defuseCardMax + 1;
				return new DefuseCard("DefuseCard" + defuseCardCount + ".png");
			case ATTACK_CARD:
				attackCardCount = (attackCardCount) % attackCardMax + 1;
				return new AttackCard("AttackCard" + attackCardCount + ".png");
			case SKIP_CARD:
				skipCardCount = (skipCardCount) % skipCardMax + 1;
				return new SkipCard("SkipCard" + skipCardCount + ".png");
			case EXPLODING_KITTEN_CARD:
				explodingKittenCardCount = (explodingKittenCardCount) % explodingKittenCardMax + 1;
				return new ExplodingKittenCard("ExplodingKittenCard" + explodingKittenCardCount + ".png");
			case SHUFFLE_CARD:
				shuffleCardCount = (shuffleCardCount) % shuffleCardMax + 1;
				return new ShuffleCard("ShuffleCard" + shuffleCardCount + ".png");
			case SCRY_CARD:
				scryCardCount = (scryCardCount) % scryCardMax + 1;
				return new ScryCard("ScryCard" + scryCardCount + ".png");
			case FAVOR_CARD:
				favorCardCount = (favorCardCount) % favorCardMax + 1;
				return new FavorCard("FavorCard" + favorCardCount + ".png");
			default:
				throw new CardNotFoundException("CardID incorrect for create card in Card Factory");
		}
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
