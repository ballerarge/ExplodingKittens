
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.CardFactory;
import code.CardStack;
import code.DiscardDeck;
import code.MainDeck;
import code.NormalCard;
import code.PriorityManager;
import code.TurnManager;

public class NormalCardTest {
	CardFactory cardFactory;

	@Before
	public void initialize() {
		cardFactory = new CardFactory();
		MainDeck.tearDown();
		PriorityManager.tearDown();
		TurnManager.tearDown();
		DiscardDeck.tearDown();
		CardStack.tearDown();
	}

	@After
	public void tearDown() {
		MainDeck.tearDown();
		PriorityManager.tearDown();
		TurnManager.tearDown();
		DiscardDeck.tearDown();
		CardStack.tearDown();
	}

	@Test
	public void testNormalCardHasIcon() {
		NormalCard normalCard = (NormalCard) cardFactory.createCard(CardFactory.NORMAL_CARD);

		normalCard.setIcon(0);

		assertEquals(normalCard.getIcon(), 0);
	}

	@Test
	public void testCreateNormalCardsMultipleIcons() {
		NormalCard card1 = (NormalCard) cardFactory.createCard(CardFactory.NORMAL_CARD);
		NormalCard card2 = (NormalCard) cardFactory.createCard(CardFactory.NORMAL_CARD);
		NormalCard card3 = (NormalCard) cardFactory.createCard(CardFactory.NORMAL_CARD);
		NormalCard card4 = (NormalCard) cardFactory.createCard(CardFactory.NORMAL_CARD);

		card1.setIcon(0);
		card2.setIcon(1);
		card3.setIcon(2);
		card4.setIcon(3);

		assertEquals(card1.getIcon(), 0);
		assertEquals(card2.getIcon(), 1);
		assertEquals(card3.getIcon(), 2);
		assertEquals(card4.getIcon(), 3);
	}
}