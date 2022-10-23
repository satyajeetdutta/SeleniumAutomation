package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import pageobjects.IMDBObjects;
import pageobjects.WikiObjects;

public class PushpaValidation extends BaseTest {

	@Test
	public void ValidityTest() throws IOException {

		String movieName = prop.getProperty("movieTitle");
		WikiObjects w = new WikiObjects(driver);
		w.goTo();
		w.WikiSendKey(movieName);

		w.WikiSearchButton();

		String releaseDayWiki = w.ReleaseDayCheck("Release date");
		String releasecountryWiki = w.CountryCheck("Country");

//		System.out.println(releaseDayWiki + " " + releasecountryWiki);
		IMDBObjects i = new IMDBObjects(driver);
		i.goTo();
		i.searchMovie(movieName);
		String releaseDayIMDB = i.ReleaseDate();
		String releaseCountryIMDB = i.ReleaseCountry();

//		System.out.println(releaseDayIMDB+"  "+releaseCountryIMDB);

//		System.out.println(releaseDayIMDB);

		Assert.assertEquals(releaseDayWiki, releaseDayIMDB);
		Assert.assertEquals(releasecountryWiki, releaseCountryIMDB);

	}

}
