
package gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import code.Card;

public class CardComponent extends JLabel {
	private Card card;
	private ImageIcon image;
	private ImageIcon selectedImage;

	public CardComponent(Card card) {
		this.card = card;
		this.image = new ImageIcon(getClass().getResource(card.getImagePath()));
		Image image = this.image.getImage();
		Image newimg = image.getScaledInstance(160, 200, java.awt.Image.SCALE_SMOOTH);
		this.image = new ImageIcon(newimg);
		this.setIcon(this.image);
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public void toggleSelected() {
		// TODO Auto-generated method stub

	}
}
