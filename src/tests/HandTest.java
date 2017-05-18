
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.CardStack;
import code.DiscardDeck;
import code.FiveCardBundle;
import code.Hand;
import code.MainDeck;
import code.PriorityManager;
import code.ThreeCardBundle;
import code.TurnManager;
import code.TwoCardBundle;
import exceptions.IncorrectNumberOfCardsException;
import exceptions.InvalidBundleException;
import exceptions.NoCardsToMoveException;

public class HandTest {
	
	@Before
	public void initialize() {
		TurnManager.tearDown();
		MainDeck.tearDown();
		DiscardDeck.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
	}
	
	@After
	public void tearDown() {
		TurnManager.tearDown();
		MainDeck.tearDown();
		DiscardDeck.tearDown();
		PriorityManager.tearDown();
		CardStack.tearDown();
	}

	@Test
	public void testHandManagerCreation() {
		Hand handMng = new Hand();
		
		assertTrue(handMng != null);
	}

	@Test
	public void testDrawFromMainDeck() {
		Hand handMng = new Hand();

		handMng.draw();

		assertFalse(handMng.getHand().isEmpty());
		assertEquals(1, handMng.getHand().size());
	}

	@Test
	public void testSelectCard() throws IncorrectNumberOfCardsException {
		Hand handMng = new Hand();

		handMng.draw();

		assertEquals(1, handMng.getHand().size());

		handMng.selectCard(0);

		// Card should be 'moved' form hand to selectedCards.
		assertEquals(0, handMng.getHand().size());
		assertEquals(1, handMng.getSelectedCards().size());
	}

	@Test(expected = IncorrectNumberOfCardsException.class)
	public void testSelectCardException() throws IncorrectNumberOfCardsException {
		Hand handMng = new Hand();

		handMng.selectCard(0);
	}

	@Test
	public void testMoveSelectedToStackTwoNormal() throws IncorrectNumberOfCardsException, NoCardsToMoveException, InvalidBundleException {
		Hand handMng = new Hand();
		CardFactory factory = new CardFactory();
		List<Card> cards = new ArrayList<Card>();
		cards.add(factory.createCard(CardFactory.NORMAL_CARD));
		cards.add(factory.createCard(CardFactory.NORMAL_CARD));
		handMng.addCards(cards);
		handMng.selectCard(1);
		handMng.selectCard(0);

		handMng.moveSelectedToStack();

		assertEquals(0, handMng.getSelectedCards().size());
		assertEquals(1, CardStack.getInstance().getStack().size());
		assertTrue(CardStack.getInstance().getStack().get(0) instanceof TwoCardBundle);
	}
	
	@Test
	public void testMoveSelectedToStackThreeNormal() throws IncorrectNumberOfCardsException, NoCardsToMoveException, InvalidBundleException {
		Hand handMng = new Hand();
		CardFactory factory = new CardFactory();
		List<Card> cards = new ArrayList<Card>();
		cards.add(factory.createCard(CardFactory.NORMAL_CARD));
		cards.add(factory.createCard(CardFactory.NORMAL_CARD));
		cards.add(factory.createCard(CardFactory.NORMAL_CARD));
		handMng.addCards(cards);
		handMng.selectCard(2);
		handMng.selectCard(1);
		handMng.selectCard(0);

		handMng.moveSelectedToStack();

		assertEquals(0, handMng.getSelectedCards().size());
		assertEquals(1, CardStack.getInstance().getStack().size());
		assertTrue(CardStack.getInstance().getStack().get(0) instanceof ThreeCardBundle);
	}
	
	@Test
	public void testMoveSelectedToStackFourNormal() throws IncorrectNumberOfCardsException, NoCardsToMoveException, InvalidBundleException {
		Hand handMng = new Hand();
		CardFactory factory = new CardFactory();
		List<Card> cards = new ArrayList<Card>();
		cards.add(factory.createCard(CardFactory.NORMAL_CARD));
		cards.add(factory.createCard(CardFactory.NORMAL_CARD));
		cards.add(factory.createCard(CardFactory.NORMAL_CARD));
		cards.add(factory.createCard(CardFactory.NORMAL_CARD));
		handMng.addCards(cards);
		handMng.selectCard(3);
		handMng.selectCard(2);
		handMng.selectCard(1);
		handMng.selectCard(0);

		handMng.moveSelectedToStack();

		assertEquals(0, handMng.getSelectedCards().size());
		assertEquals(0, CardStack.getInstance().getStack().size());
	}
	
	@Test
	public void testMoveSelectedToStackFiveNormal() throws IncorrectNumberOfCardsException, NoCardsToMoveException, InvalidBundleException {
		Hand handMng = new Hand();
		CardFactory factory = new CardFactory();
		List<Card> cards = new ArrayList<Card>();
		cards.add(factory.createCard(CardFactory.NORMAL_CARD));
		cards.add(factory.createCard(CardFactory.NORMAL_CARD));
		cards.add(factory.createCard(CardFactory.NORMAL_CARD));
		cards.add(factory.createCard(CardFactory.NORMAL_CARD));
		cards.add(factory.createCard(CardFactory.NORMAL_CARD));
		handMng.addCards(cards);
		handMng.selectCard(4);
		handMng.selectCard(3);
		handMng.selectCard(2);
		handMng.selectCard(1);
		handMng.selectCard(0);

		handMng.moveSelectedToStack();

		assertEquals(0, handMng.getSelectedCards().size());
		assertEquals(1, CardStack.getInstance().getStack().size());
		assertTrue(CardStack.getInstance().getStack().get(0) instanceof FiveCardBundle);
	}
	
	

	@Test(expected = NoCardsToMoveException.class)
	public void testMoveSelectedToStackException() throws NoCardsToMoveException, InvalidBundleException {
		Hand handMng = new Hand();

		handMng.moveSelectedToStack();
	}
	
	@Test
	public void testMoveSelectedToStackNonNormal() throws NoCardsToMoveException, InvalidBundleException {
		Hand handMng = new Hand();
		CardFactory factory = new CardFactory();
		List<Card> cards = new ArrayList<Card>();
		cards.add(factory.createCard(CardFactory.ATTACK_CARD));
		handMng.addCards(cards);
		
		handMng.selectCard(0);
		handMng.moveSelectedToStack();
		
		assertEquals(0, handMng.getSelectedCards().size());
	}

}
