
package code;

import java.util.List;
import java.util.ResourceBundle;

import exceptions.InvalidBundleException;
import exceptions.NoCardsToMoveException;

public class TurnManagerLogger extends TurnManager {

	public TurnManager turnManager;

	public TurnManagerLogger(TurnManager manager) {
		super(0);
		turnManager = manager;
	}

	@Override
	public void makeCurrentPlayerLose() {
		logLoss();
		turnManager.makeCurrentPlayerLose();
	}

	private void logLoss() {
		Log log = Log.getInstance();
		ResourceBundle bundle = ResourceBundle.getBundle("resources/resources", log.locale);
		String message = getCurrentPlayer().getName() + " ";
		message += bundle.getString("HAS_LOST_THE_GAME");
		log.addEntry(new Entry(message));
	}

	@Override
	public void setPlayerManager(PlayerManager pm) {
		turnManager.setPlayerManager(pm);
	}

	@Override
	public PlayerManager getPlayerManager() {
		return turnManager.getPlayerManager();
	}

	@Override
	public Player getCurrentPlayer() {
		return turnManager.getCurrentPlayer();
	}

	@Override
	public void endTurnAndDraw() throws NoCardsToMoveException, InvalidBundleException {
		turnManager.endTurnAndDraw();
	}

	@Override
	public void endTurnWithoutDraw() {
		turnManager.endTurnWithoutDraw();
	}

	@Override
	public void endTurnWithoutDrawForAttacks() {
		turnManager.endTurnWithoutDrawForAttacks();
	}

	@Override
	public void addTurnForCurrentPlayer() {
		turnManager.addTurnForCurrentPlayer();
	}

	@Override
	public List<Player> getTurnOrder() {
		return turnManager.getTurnOrder();
	}
}