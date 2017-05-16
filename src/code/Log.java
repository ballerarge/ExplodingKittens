
package code;

import java.util.ArrayList;

public class Log {

	private static Log log;
	private ArrayList<Entry> entries;//0 is the earliest event
	
	
	
	public static Log getInstance() {
		if (log == null)
			log = new Log();
		return log;
	}
	
	public static void tearDown(){
		log = null;
	}
	
	private Log() {
		entries = new ArrayList<Entry>();
	}
	
	public void addEntry(Entry entry){
		entries.add(entry);
	}
	
	public ArrayList<Entry> getEntries(){
		return entries;
	}
	
}
