
package tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import code.Game;
import code.InvalidNumberofPlayersException;
import code.Player;

public class GameTest {

	@Test
	public void testGameCreation() {
		Game game = new Game();
	}

	public void testStartRuns() throws InvalidNumberofPlayersException {
		Game game = new Game();
		try {
			game.start(3);
		} catch (InvalidNumberofPlayersException e) {
			fail("threw an InvalidNumberofPlayersException");
		}
	}

	public void testInvalidNumberofPlayers() {
		Game game1 = new Game();
		Game game2 = new Game();
		Game game3 = new Game();
		Game game4 = new Game();
		try {
			game1.start(1);
			fail("Starting with 1 players didn't return an error");
		} catch (InvalidNumberofPlayersException e) {
		}
		try {
			game2.start(2);
		}
		catch (InvalidNumberofPlayersException e){
			fail("Starting with 2 players returns an error");
		}
		try {
			game3.start(5);
		}
		catch (InvalidNumberofPlayersException e){
			fail("Starting with 5 players returns an error");
		}
		try {
			game4.start(6);
			fail("Starting with 6 players didn't return an error");
		}
		catch (InvalidNumberofPlayersException e){
		}
	}

	public void testStartNumberofPlayers() throws InvalidNumberofPlayersException {
		Game game = new Game();
		game.start(3);
		Map<Player, List> hands = game.getPlayerHands();
		assertEquals(hands.size(), 3);
	}

	public void testGetPlayerStatus() throws InvalidNumberofPlayersException {
		Game game = new Game();
		game.start(3);
		Map<Player, Boolean> status = game.getPlayerStatus();
		assertEquals(status.size(), 3);
	}

	public void testIsMainDeckEmptyStartofGame() throws InvalidNumberofPlayersException {
		Game game = new Game();
		game.start(3);
		assertFalse(game.isMainDeckEmpty());
	}
}
