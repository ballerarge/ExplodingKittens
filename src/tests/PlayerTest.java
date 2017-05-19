
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardStack;
import code.DiscardDeck;
import code.Hand;
import code.MainDeck;
import code.Player;
import code.PriorityManager;
import code.TurnManager;

public class PlayerTest {

	@Before
	public void initialize() {
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
	public void testPlayerCreation() {
		Player player = new Player();

		assertTrue(player != null);
	}

	@Test
	public void testPlayerCreationWithName() {
		Player player = new Player("Khaleeeeed");

		assertTrue(player != null);
	}

	@Test
	public void testGetName() {
		String expected = "Khaleeeeed";
		Player player = new Player(expected);

		assertEquals(expected, player.getName());
	}

	@Test
	public void testSetName() {
		String expected = "Khaleeeeed";
		Player player = new Player("Not Khaleeeeed");

		player.setName(expected);

		assertEquals(expected, player.getName());
	}

	@Test
	public void testGetHandManager() {
		Player player = new Player();

		assertTrue(player.getHandManager() instanceof Hand);
	}

	@Test
	public void testGetHand() {
		Player player = new Player();
		List<Card> playerHand = player.getHand();

		assertTrue(playerHand instanceof List<?>);
		// Further inspection...
		assertEquals(0, playerHand.size());
	}

	@Test
	public void testDrawCard() {
		Player player = new Player();
		MainDeck.getInstance().initStartingDeck();

		player.drawCard();

		List<Card> playerHand = player.getHand();

		assertEquals(1, playerHand.size());
	}

	@Test
	public void testPassPriority() {

	}

	@Test
	public void testReceievePriority() {

	}

}
