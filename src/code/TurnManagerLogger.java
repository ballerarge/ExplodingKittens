
package code;

import java.util.ResourceBundle;

import exceptions.NoSuchPlayerException;

public class TurnManagerLogger extends TurnManager {

	public TurnManager turnManager;

	public TurnManagerLogger(TurnManager manager) {
		super();
		turnManager = manager;
	}

	@Override
	public void makeCurrentPlayerLose() throws NoSuchPlayerException {
		Log log = Log.getInstance();
		ResourceBundle bundle = ResourceBundle.getBundle("resources/resources",log.locale);
		String message = currentPlayer.getName()+" ";
		message += bundle.getString("HAS_LOST_THE_GAME");
		log.addEntry(new Entry(message));
		turnManager.makeCurrentPlayerLose();
	}

}
