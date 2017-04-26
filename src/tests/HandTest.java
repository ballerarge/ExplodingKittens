
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.CardStack;
import code.Hand;
import code.MainDeck;
import exceptions.IncorrectNumberOfCardsException;
import exceptions.NoCardsToMoveException;

public class HandTest {

	private MainDeck mainDeck;

	@Test
	public void testHandManagerCreation() {
		Hand handMng = new Hand();
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
	public void testMoveSelectedToStack() throws IncorrectNumberOfCardsException, NoCardsToMoveException {
		Hand handMng = new Hand();

		handMng.draw();
		handMng.selectCard(0);

		handMng.moveSelectedToStack();

		assertEquals(0, handMng.getSelectedCards().size());
	}

	@Test(expected = NoCardsToMoveException.class)
	public void testMoveSelectedToStackException() throws NoCardsToMoveException {
		Hand handMng = new Hand();

		handMng.moveSelectedToStack();
	}

}
