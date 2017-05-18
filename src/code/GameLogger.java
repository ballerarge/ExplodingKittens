package code;

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
	
	private void logStartofTurn(){}
	
}
