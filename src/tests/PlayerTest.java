
package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import code.Card;
import code.Hand;
import code.Player;

public class PlayerTest {

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
