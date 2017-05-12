
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
			TwoCardBundle twoBundle		= new TwoCardBundle(bundleTwo);
			ThreeCardBundle threeBundle	= new ThreeCardBundle(bundleThree);
			FiveCardBundle fiveBundle	= new FiveCardBundle(bundleFive);
		} catch (InvalidBundleException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = InvalidBundleException.class)
	public void testIncorrectBundleSize() throws InvalidBundleException {

		ArrayList<Card> bundleWrong = new ArrayList<>(Arrays.asList(new NormalCard()));


		TwoCardBundle twoBundle		= new TwoCardBundle(bundleWrong);
		ThreeCardBundle threeBundle	= new ThreeCardBundle(bundleWrong);
		FiveCardBundle fiveBundle	= new FiveCardBundle(bundleWrong);
	}
	
	@Test(expected = InvalidBundleException.class)
	public void testIncorrectBundleCards() throws InvalidBundleException {

		ArrayList<Card> bundleWrong = new ArrayList<>(Arrays.asList(new AttackCard(), new NormalCard()));


		TwoCardBundle twoBundle		= new TwoCardBundle(bundleWrong);
		ThreeCardBundle threeBundle	= new ThreeCardBundle(bundleWrong);
		FiveCardBundle fiveBundle	= new FiveCardBundle(bundleWrong);
	}

}
