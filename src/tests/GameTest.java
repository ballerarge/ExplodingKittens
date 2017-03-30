
package tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import code.Game;
import code.Player;

public class GameTest {

	@Test
	public void testGameCreation() {
		Game game = new Game();
	}

	public void testStartRuns() {
		Game game = new Game();
		game.start(3);
	}

	public void testInvalidNumberofPlayers() {
		Game game1 = new Game();
		Game game2 = new Game();
		Game game3 = new Game();
		Game game4 = new Game();
		try {
			game1.start(0);
			fail("Starting with 0 players didn't return an error");
		}
		catch (InvalidNumberofPlayersException){}
		
	}

	public void testStartNumberofPlayers() {
		Game game = new Game();
		game.start(3);
		Map<Player, List> hands = game.getPlayerHands();
		assertEquals(hands.size(), 3);
	}

	public void testGetPlayerStatus() {
		Game game = new Game();
		game.start(3);
		Map<Player, Boolean> status = game.getPlayerStatus();
		assertEquals(status.size(), 3);
	}

	public void testIsMainDeckEmptyStartofGame() {
		Game game = new Game();
		game.start(3);
		assertFalse(game.isMainDeckEmpty());
	}
}
