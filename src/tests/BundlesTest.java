
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import code.AttackCard;
import code.Card;
import code.FiveCardBundle;
import code.NormalCard;
import code.ThreeCardBundle;
import code.TwoCardBundle;
import exceptions.InvalidBundleException;

public class BundlesTest {

	@Test
	public void testCreateBundles() {

		ArrayList<Card> bundleTwo = new ArrayList<>(Arrays.asList(new NormalCard(), new NormalCard()));
		ArrayList<Card> bundleThree = new ArrayList<>(
		        Arrays.asList(new NormalCard(), new NormalCard(), new NormalCard()));
		ArrayList<Card> bundleFive = new ArrayList<>(Arrays.asList(new NormalCard(), new NormalCard(), new NormalCard(),
		        new NormalCard(), new NormalCard()));

		TwoCardBundle twoBundle = new TwoCardBundle(bundleTwo);
		ThreeCardBundle threeBundle = new ThreeCardBundle(bundleThree);
		FiveCardBundle fiveBundle = new FiveCardBundle(bundleFive);

		assertTrue(twoBundle instanceof TwoCardBundle);
		assertTrue(threeBundle instanceof ThreeCardBundle);
		assertTrue(fiveBundle instanceof FiveCardBundle);
	}

	@Test
	public void testTwoBundleIncorrectBundleSize() throws InvalidBundleException {

		ArrayList<Card> bundleWrong = new ArrayList<>(Arrays.asList(new NormalCard()));

		TwoCardBundle twoBundle = new TwoCardBundle(bundleWrong);

		assertTrue(!TwoCardBundle.isValidBundle(twoBundle.getCardsInBundle()));
	}

	@Test
	public void testThreeBundleIncorrectBundleSize() throws InvalidBundleException {

		ArrayList<Card> bundleWrong = new ArrayList<>(Arrays.asList(new NormalCard()));

		ThreeCardBundle threeBundle = new ThreeCardBundle(bundleWrong);

		assertTrue(!ThreeCardBundle.isValidBundle(threeBundle.getCardsInBundle()));
	}

	@Test
	public void testFiveBundleIncorrectBundleSize() throws InvalidBundleException {

		ArrayList<Card> bundleWrong = new ArrayList<>(Arrays.asList(new NormalCard()));

		FiveCardBundle fiveBundle = new FiveCardBundle(bundleWrong);

		assertTrue(!FiveCardBundle.isValidBundle(fiveBundle.getCardsInBundle()));
	}

	@Test
	public void testIncorrectBundleCards() throws InvalidBundleException {

		ArrayList<Card> bundleWrong = new ArrayList<>(Arrays.asList(new AttackCard(), new NormalCard()));

		TwoCardBundle twoBundle = new TwoCardBundle(bundleWrong);
		ThreeCardBundle threeBundle = new ThreeCardBundle(bundleWrong);
		FiveCardBundle fiveBundle = new FiveCardBundle(bundleWrong);

		assertTrue(!TwoCardBundle.isValidBundle(twoBundle.getCardsInBundle()));
		assertTrue(!ThreeCardBundle.isValidBundle(threeBundle.getCardsInBundle()));
		assertTrue(!FiveCardBundle.isValidBundle(fiveBundle.getCardsInBundle()));
	}

	@Test
	public void testTwoCardNullBundleCards() throws InvalidBundleException {
		TwoCardBundle twoBundle = new TwoCardBundle(null);

		assertTrue(!TwoCardBundle.isValidBundle(twoBundle.getCardsInBundle()));
	}

	@Test
	public void testThreeCardNullBundleCards() throws InvalidBundleException {
		ThreeCardBundle threeBundle = new ThreeCardBundle(null);

		assertTrue(!ThreeCardBundle.isValidBundle(threeBundle.getCardsInBundle()));
	}

	@Test
	public void testFiveCardNullBundleCards() throws InvalidBundleException {
		FiveCardBundle fiveBundle = new FiveCardBundle(null);

		assertTrue(!FiveCardBundle.isValidBundle(fiveBundle.getCardsInBundle()));
	}

	@Test
	public void testTwoCardClone() throws InvalidBundleException {
		ArrayList<Card> list = new ArrayList<>(Arrays.asList(new NormalCard(), new NormalCard()));

		TwoCardBundle twoBundle = new TwoCardBundle(list);

		TwoCardBundle clone = twoBundle.clone();

		assertTrue(TwoCardBundle.isValidBundle(twoBundle.getCardsInBundle()));
		assertTrue(TwoCardBundle.isValidBundle(clone.getCardsInBundle()));
		assertTrue(clone instanceof TwoCardBundle);

	}

	@Test
	public void testThreeCardClone() {
		ArrayList<Card> list = new ArrayList<>(Arrays.asList(new NormalCard(), new NormalCard(), new NormalCard()));
		ThreeCardBundle threeBundle = new ThreeCardBundle(list);

		ThreeCardBundle clone = threeBundle.clone();

		assertTrue(ThreeCardBundle.isValidBundle(threeBundle.getCardsInBundle()));
		assertTrue(ThreeCardBundle.isValidBundle(clone.getCardsInBundle()));
		assertTrue(clone instanceof ThreeCardBundle);
	}

	@Test
	public void testFiveCardClone() {
		ArrayList<Card> list = new ArrayList<>(Arrays.asList(new NormalCard(), new NormalCard(), new NormalCard(),
		        new NormalCard(), new NormalCard()));
		FiveCardBundle fiveBundle = new FiveCardBundle(list);

		FiveCardBundle clone = fiveBundle.clone();

		assertTrue(FiveCardBundle.isValidBundle(fiveBundle.getCardsInBundle()));
		assertTrue(FiveCardBundle.isValidBundle(clone.getCardsInBundle()));
		assertTrue(clone instanceof FiveCardBundle);
	}

	@Test
	public void testIsValidBundleNotNormalCards() {
		ArrayList<Card> twoList = new ArrayList<>(Arrays.asList(new NormalCard(), new AttackCard()));
		ArrayList<Card> threeList = new ArrayList<>(
		        Arrays.asList(new NormalCard(), new NormalCard(), new AttackCard()));
		ArrayList<Card> fiveList = new ArrayList<>(Arrays.asList(new NormalCard(), new NormalCard(), new NormalCard(),
		        new NormalCard(), new AttackCard()));
		
		TwoCardBundle twoBundle = new TwoCardBundle(twoList);
		ThreeCardBundle threeBundle = new ThreeCardBundle(threeList);
		FiveCardBundle fiveBundle = new FiveCardBundle(fiveList);
		
		assertFalse(TwoCardBundle.isValidBundle(twoBundle.getCardsInBundle()));
		assertFalse(ThreeCardBundle.isValidBundle(threeBundle.getCardsInBundle()));
		assertFalse(FiveCardBundle.isValidBundle(fiveBundle.getCardsInBundle()));
	}
	
	@Test
	public void testIsValidBundleBadIds() {
		Card firstCard = new NormalCard();
	}

}
