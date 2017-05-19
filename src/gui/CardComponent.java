
package gui;

import java.awt.Image;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import code.Card;

public class CardComponent extends JLabel {
	private Card card;
	boolean selected;
	private ImageIcon selectedImage;
	private ImageIcon unselectedImage;

	public CardComponent(Card card) {
		selected = false;

		this.card = card;

		ImageIcon tempImage = new ImageIcon(getClass().getResource(card.getImagePath()));
		Image firstImage = tempImage.getImage();
		Image newimg = firstImage.getScaledInstance(160, 200, java.awt.Image.SCALE_SMOOTH);
		unselectedImage = new ImageIcon(newimg);

		tempImage = new ImageIcon(getClass().getResource(addSelectedPath(card.getImagePath())));
		firstImage = tempImage.getImage();
		newimg = firstImage.getScaledInstance(160, 200, java.awt.Image.SCALE_SMOOTH);
		selectedImage = new ImageIcon(newimg);

		setIcon(unselectedImage);
	}

	private String addSelectedPath(String imagePath) {
		String output = "";

		StringTokenizer st = new StringTokenizer(imagePath, "\\");

		output += st.nextToken() + "\\selected_images\\" + st.nextToken();

		return output;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public void toggleSelected() {
		selected = !selected;

		if (selected) {
			setIcon(selectedImage);
		} else {
			setIcon(unselectedImage);
		}
	}
}
