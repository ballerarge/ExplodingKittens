package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.HandManager;
import code.Player;

public class PlayerTest {

	@Test
	public void testPlayerCreation() {
		Player player = new Player();
	}
	
	@Test
	public void testPlayerCreationWithName() {
		Player player = new Player("Khaleeeeed");
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
		Player player = new Player("Not Khaleeeeed");
		
		assertTrue(player.getHandManger() instanceof HandManager);
	}
	
}
