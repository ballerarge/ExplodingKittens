package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Game;

public class GameTest {

	@Test
	public void testGameCreation() {
		Game game=new Game();
	}
	
	public void testStartRuns() {
		Game game=new Game();
		game.start(3);
		
		
	}
	
	
	
}
