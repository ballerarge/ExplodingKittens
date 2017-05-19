
package code;

import java.util.ArrayList;
import java.util.Locale;

public class Log {

	private static Log log;
	private ArrayList<Entry> entries;// 0 is the earliest event
	public Locale locale = Locale.ENGLISH;

	public static Log getInstance() {
		if (log == null)
			log = new Log();
		return log;
	}

	public static void tearDown() {
		log = null;
	}

	public static void setLog(Log otherLog) {// for testing purposes
		log = otherLog;
	}

	private Log() {
		entries = new ArrayList<Entry>();
	}

	public void addEntry(Entry entry) {
		entries.add(0, entry);
	}

	public ArrayList<Entry> getEntries() {
		return entries;
	}

}
