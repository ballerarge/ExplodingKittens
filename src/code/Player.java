
package code;

import java.util.List;

public class Player {

	private String name;
	private HandManager handManager = new HandManager();

	public Player() {
		this.name = "default";
	}

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public HandManager getHandManager() {
		return handManager;
	}

	public List<Card> getHand() {
		return handManager.getHand();
	}

	public void drawCard() {
		handManager.draw();
	}

}
