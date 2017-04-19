
package code;

import java.util.List;

public class Player {

	private String name;
	private Hand handManager = new Hand();

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

	public Hand getHandManager() {
		return handManager;
	}

	public List<Card> getHand() {
		return handManager.getHand();
	}

	public void drawCard() {
		handManager.draw();
	}

}
