package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.PlayerManager;
import code.TurnPriorityManager;

public class TurnPriorityManagerTest {

	@Test
	public void testConstruction() {
		TurnPriorityManager manager=new TurnPriorityManager();
	}

	@Test
	public void testHandlesPlayerManager(){
		
		PlayerManager pmgr=new PlayerManager();
		TurnPriorityManager manager=new TurnPriorityManager();
		manager.setPlayerManager(pmgr);
		assertEquals(pmgr,manager.getPlayerManager());
		
	}
	
}
