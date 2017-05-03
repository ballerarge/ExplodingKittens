
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.FavorCard;
import code.Player;

public class FavorCardTest {

	@Test
	public void test() {
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

}
