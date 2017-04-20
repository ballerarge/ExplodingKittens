
package code;

public class PriorityManager {
	private static PriorityManager priorityManager;

	public static PriorityManager getInstance() {
		if (priorityManager == null) {
			priorityManager = new PriorityManager();
		}
		return priorityManager;
	}
}
