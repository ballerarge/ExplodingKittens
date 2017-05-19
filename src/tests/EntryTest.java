
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Entry;

public class EntryTest {

	@Test
	public void testEntry() {
		String message = "this is a test";
		Entry entry = new Entry(message);
		assertEquals(message, entry.message);
		assertEquals(message, entry.getMessage());
	}

}