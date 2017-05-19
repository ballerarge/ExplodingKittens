
package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import code.Card;
import code.CardFactory;
import code.DiscardDeck;
import code.Player;

public class EKCardSelectionWindow {
	private Locale locale;
	private String messageKey;

	private JFrame mainFrame;
	private JPanel mainPanel;
	private JPanel buttonPanel;
	private JPanel cardDisplayPanel;

	public EKCardSelectionWindow(Locale locale, String messageKey) {
		this.locale = locale;
		this.messageKey = messageKey;
	}

	public void displayScryWindow(List<Card> cardsScryed) {
		mainFrame = new JFrame(getStringFromBundle(("SEE_THE_FUTURE_WINDOW_TITLE")));

		mainFrame.setSize(3 * 175, 300);
		mainFrame.setResizable(false);

		mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());

		cardDisplayPanel = new JPanel();
		cardDisplayPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		for (Card card : cardsScryed) {
			CardComponent cardComponent = new CardComponent(card);

			cardDisplayPanel.add(cardComponent, gbc);

			if (gbc.gridx == 0) {
				buttonPanel.add(new JTextArea(getStringFromBundle("TOP_CARD_LABEL")), gbc);
			} else if (gbc.gridx == 1) {
				buttonPanel.add(new JTextArea(getStringFromBundle("SECOND_CARD_LABEL")), gbc);
			} else {
				buttonPanel.add(new JTextArea(getStringFromBundle("THIRD_CARD_LABEL")), gbc);
			}

			gbc.gridx++;

			cardComponent.setVisible(true);
		}

		gbc.gridx = 0;

		mainPanel.add(cardDisplayPanel, gbc);

		gbc.gridy = 1;
		mainPanel.add(buttonPanel, gbc);

		mainFrame.add(mainPanel);

		mainFrame.setVisible(true);
	}

	public Card displayFavorWindow(Player targetedPlayer) {

		Card[] options = new Card[targetedPlayer.getHand().size()];
		int index = 0;
		for (Card card : targetedPlayer.getHand()) {
			options[index] = card;
			index++;
		}

		Card returnedCard = (Card) JOptionPane.showInputDialog(null,
		        getStringFromBundle("FAVOR_CARD_SELECTION_MESSAGE"), getStringFromBundle("FAVOR_CARD_SELECT_TITLE"),
		        JOptionPane.QUESTION_MESSAGE, null, options, null);

		return returnedCard;
	}

	public Card displayFiveCardBundleWindow() {
		Card[] options = new Card[DiscardDeck.getInstance().getCardCount()];
		int index = 0;
		for (Card card : DiscardDeck.getInstance().getCards()) {
			options[index] = card;
			index++;
		}

		Card returnedCard = (Card) JOptionPane.showInputDialog(null,
		        getStringFromBundle("FIVE_CARD_BUNDLE_SELECTION_MESSAGE"),
		        getStringFromBundle("FIVE_CARD_BUNDLE_SELECT_TITLE"), JOptionPane.QUESTION_MESSAGE, null, options,
		        null);

		return returnedCard;
	}

	private String getStringFromBundle(String key) {
		return ResourceBundle.getBundle("resources/resources", locale).getString(key);
	}

	public String displayThreeCardBundleWindow() {
		CardFactory factory = new CardFactory();

		Card[] options = new Card[7];

		options[0] = factory.createCard(CardFactory.ATTACK_CARD);
		options[1] = factory.createCard(CardFactory.DEFUSE_CARD);
		options[2] = factory.createCard(CardFactory.SKIP_CARD);
		options[3] = factory.createCard(CardFactory.FAVOR_CARD);
		options[4] = factory.createCard(CardFactory.NOPE_CARD);
		options[5] = factory.createCard(CardFactory.SCRY_CARD);
		options[6] = factory.createCard(CardFactory.SHUFFLE_CARD);

		Card returnedCard = (Card) JOptionPane.showInputDialog(null,
		        getStringFromBundle("THREE_CARD_BUNDLE_SELECTION_MESSAGE"),
		        getStringFromBundle("THREE_CARD_BUNDLE_SELECT_TITLE"), JOptionPane.QUESTION_MESSAGE, null, options,
		        null);

		return returnedCard.toString();
	}
}
