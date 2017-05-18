package code;

import java.util.ResourceBundle;

public class GameLogger extends Game{
	
	Game game;
	
	public GameLogger(Game game){
		this.game = game;
	}
	
	@Override
	public void nextTurn(){
		game.nextTurn();
		logStartofTurn();
	}
	
	private void logStartofTurn(){
		Log log = Log.getInstance();
		ResourceBundle bundle = ResourceBundle.getBundle("resources/resources",log.locale);
		String message = bundle.getString("TURN_MESSAGE_1");
		Player player = TurnManager.getInstance().currentPlayer;
		message += player.getName();
		message += bundle.getString("TURN_MESSAGE_2");
		log.addEntry(new Entry(message));
	}
	
}
