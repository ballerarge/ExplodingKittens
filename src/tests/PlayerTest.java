package tests;

import static org.junit.Assert.*;

import org.junit.Test;

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
		
		assertEqual(expected, player.getName());
	}
	
}
