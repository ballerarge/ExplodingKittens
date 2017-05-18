package code;

import java.util.Locale;
import java.util.ResourceBundle;

public class CardLogger extends Card{
	
	private Card card;
	
	public CardLogger(Card card){
		this.card = card;
	}

	@Override
	public void cardAction(Player p1, Player p2) {
		logAction();
		card.cardAction(p1, p2);
	}

	@Override
	public Card clone() {
		return card.clone();
	}
	
	@Override
	public String toString() {
		return card.toString();
	}
	
	@Override
	public int getID() {
		return card.getID();
	}
	
	private void logAction() {
		Log log = Log.getInstance();
		Locale locale = log.locale;
		ResourceBundle resource = ResourceBundle.getBundle("resources/resources",locale);
		Player player = TurnManager.getInstance().getCurrentPlayer();
		String message ="";
		if (player!=null)
			message = player.getName();
		message += " "+resource.getString("PLAYED");
		message += " "+resource.getString("THE");
		String cardName = card.toString();
		cardName = cardName.substring(5);
		message += " "+resource.getString(cardName.toUpperCase());
		Entry entry = new Entry(message);
		log.addEntry(entry);
	}
	
	public Card getCard(){
		return card;
	}
}
