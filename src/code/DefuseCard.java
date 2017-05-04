
package code;

import java.util.Stack;

public class DefuseCard extends Card {

	CardStack stack;
	TurnManager tm;
	MainDeck deck;
	CardFactory factory;

	public DefuseCard() {
		this.cardID = 2;
	}

	@Override
	public void cardAction(Player p1, Player p2) {
		stack = CardStack.getInstance();
		tm = TurnManager.getInstance();
		deck = MainDeck.getInstance();
		factory = new CardFactory();

		if (stack.getStack().isEmpty()) {
			tm.getCurrentPlayer().addDefuseCardToHand();
			return;
		}

		if (stack.getStack().elementAt(0) instanceof ExplodingKittenCard) {
			stack.setStack(new Stack<Card>());

			// Here is where the user will need to decide where to put the
			// Exploding kitten card. For now, it will be placed onto the
			// bottom of the deck.
			deck.insertCard(factory.createCard(CardFactory.EXPLODING_KITTEN_CARD), deck.getCardCount() - 1);
		} else {
			tm.getCurrentPlayer().addDefuseCardToHand();
		}
	}

	@Override
	public DefuseCard clone() {
		return new DefuseCard();
	}
}
