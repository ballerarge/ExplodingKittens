
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import code.*;

public class PriorityManagerTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testPriorityManagerInstanceGet() {
		PriorityManager pm = PriorityManager.getInstance();
	}

}
