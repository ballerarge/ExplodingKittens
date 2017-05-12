
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardFactory;
import code.FavorCard;
import code.Player;

public class FavorCardTest {
	
	CardFactory factory;
	
	@Before
	public void initialize() {
		factory = new CardFactory();
	}

	@Test
	public void testFavorCard() {
		Player player1 = new Player();
		Player player2 = new Player();
		FavorCard card = new FavorCard();
		player1.addDefuseCardToHand();
		player2.addDefuseCardToHand();
		player2.addDefuseCardToHand();
		assertEquals(player1.getHand().size(), 1);
		assertEquals(player2.getHand().size(), 2);
		player2.getHandManager().selectCard(0);
		card.cardAction(player1, player2);
		assertEquals(player1.getHand().size(), 2);
		assertEquals(player2.getHand().size(), 1);
		player2.getHandManager().selectCard(0);
		card.cardAction(player1, player2);
		assertEquals(player1.getHand().size(), 3);
		assertEquals(player2.getHand().size(), 0);
		card.cardAction(player1, player2);
		assertEquals(player1.getHand().size(), 3);
		assertEquals(player2.getHand().size(), 0);
	}
	
	@Test
	public void testFavorClone() {
		Card favor = factory.createCard(CardFactory.FAVOR_CARD);
		
		Card clone = favor.clone();
		
		assertFalse(clone == null);
	}

}
