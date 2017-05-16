
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.GameController;

public class GameControllerTest {
	@Test
	public void testGameControllerCreation() {
		GameController gameController = new GameController();
		
		assertTrue(gameController != null);
	}
}
