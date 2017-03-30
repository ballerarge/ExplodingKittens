
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.CardDoesNotExistException;
import code.HandManager;
import code.MainDeck;
import code.NoCardsToMoveException;

public class HandManagerTest {

	private MainDeck mainDeck;

	@Test
	public void testHandManagerCreation() {
		HandManager handMng = new HandManager();
	}

	@Test
	public void testDrawFromMainDeck() {
		HandManager handMng = new HandManager();

		handMng.draw();

		assertFalse(handMng.getHand().isEmpty());
		assertEquals(1, handMng.getHand().size());
	}

	@Test
	public void testSelectCard() throws CardDoesNotExistException {
		HandManager handMng = new HandManager();

		handMng.draw();

		assertEquals(1, handMng.getHand().size());

		handMng.selectCard(0);

		// Card should be 'moved' form hand to selectedCards.
		assertEquals(0, handMng.getHand().size());
		assertEquals(1, handMng.getSelectedCards().size());
	}

	@Test(expected = CardDoesNotExistException.class)
	public void testSelectCardException() throws CardDoesNotExistException {
		HandManager handMng = new HandManager();

		handMng.selectCard(0);
	}

	@Test
	public void testMoveSelectedToStack() throws CardDoesNotExistException, NoCardsToMoveException {
		HandManager handMng = new HandManager();

		handMng.draw();
		handMng.selectCard(0);

		handMng.moveSelectedToStack();

		assertEquals(0, handMng.getSelectedCards().size());
	}

	@Test(expected = NoCardsToMoveException.class)
	public void testMoveSelectedToStackException() throws NoCardsToMoveException {
		HandManager handMng = new HandManager();;

		handMng.moveSelectedToStack();
	}

}
