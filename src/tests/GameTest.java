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
		Game game=new Game();
	}
	
	public void testStartRuns() {
		Game game=new Game();
		game.start(3);
	}
	
	public void testStartNumberofPlayers(){
		Game game=new Game();
		game.start(3);
		Map<Player,List> hands=game.getPlayerHands();
		assertEquals(hands.size(),3);
	}
	
	public void testIsMainDeckEmptyStartofGame(){
		Game game=new Game();
		game.start(3);
		assertFalse(game.isMainDeckEmpty());
	}
	
	public void testIsDiscardDeckEmptyStartofGame(){
		Game game=new Game();
		game.start(3);
		assertTrue(game.isDiscardDeckEmpty());
		
	}
}
