package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import code.Entry;
import code.Log;

public class LogTest {

	@Before
	public void initialize(){
		Log.tearDown();
	}
	
	
	
	@Test
	public void testLogWithEntry() {
		Entry entry0 = new Entry("message 1");
		Entry entry1 = new Entry("message 2");
		Entry entry2 = new Entry("message 3");
		Log log = Log.getInstance();
		log.addEntry(entry0);
		log.addEntry(entry1);
		log.addEntry(entry2);
		ArrayList<Entry> entries = log.getEntries();
		assertEquals(entries.get(0),entry0);
		assertEquals(entries.get(1),entry1);
		assertEquals(entries.get(2),entry2);
	}

}
