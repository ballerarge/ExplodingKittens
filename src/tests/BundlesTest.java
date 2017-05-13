
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

		try {
			TwoCardBundle twoBundle = new TwoCardBundle(bundleTwo);
			ThreeCardBundle threeBundle = new ThreeCardBundle(bundleThree);
			FiveCardBundle fiveBundle = new FiveCardBundle(bundleFive);
		} catch (InvalidBundleException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = InvalidBundleException.class)
	public void testTwoBundleIncorrectBundleSize() throws InvalidBundleException {

		ArrayList<Card> bundleWrong = new ArrayList<>(Arrays.asList(new NormalCard()));

		TwoCardBundle twoBundle = new TwoCardBundle(bundleWrong);
	}

	@Test(expected = InvalidBundleException.class)
	public void testThreeBundleIncorrectBundleSize() throws InvalidBundleException {

		ArrayList<Card> bundleWrong = new ArrayList<>(Arrays.asList(new NormalCard()));

		ThreeCardBundle threeBundle = new ThreeCardBundle(bundleWrong);
	}

	@Test(expected = InvalidBundleException.class)
	public void testFiveBundleIncorrectBundleSize() throws InvalidBundleException {

		ArrayList<Card> bundleWrong = new ArrayList<>(Arrays.asList(new NormalCard()));

		FiveCardBundle fiveBundle = new FiveCardBundle(bundleWrong);
	}

	@Test(expected = InvalidBundleException.class)
	public void testIncorrectBundleCards() throws InvalidBundleException {

		ArrayList<Card> bundleWrong = new ArrayList<>(Arrays.asList(new AttackCard(), new NormalCard()));

		TwoCardBundle twoBundle = new TwoCardBundle(bundleWrong);
		ThreeCardBundle threeBundle = new ThreeCardBundle(bundleWrong);
		FiveCardBundle fiveBundle = new FiveCardBundle(bundleWrong);
	}

	@Test(expected = InvalidBundleException.class)
	public void testTwoCardNullBundleCards() throws InvalidBundleException {
		TwoCardBundle twoBundle = new TwoCardBundle(null);
	}

	@Test(expected = InvalidBundleException.class)
	public void testThreeCardNullBundleCards() throws InvalidBundleException {
		ThreeCardBundle threeBundle = new ThreeCardBundle(null);
	}

}
