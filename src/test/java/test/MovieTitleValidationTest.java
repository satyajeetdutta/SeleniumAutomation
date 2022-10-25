package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.IMDBPageObjects;
import PageObjects.WikiPageObjects;
import testComponent.BaseTest;

public class MovieTitleValidationTest extends BaseTest {

	@Test
	public void movieValidityTest() throws IOException {

		String movieName = prop.getProperty("movieTitle");
		WikiPageObjects w = new WikiPageObjects(driver);
		w.goTo();
		w.wikiSendKey(movieName);

		w.wikiSearchButton();

		String releaseDayWiki = w.releaseDayCheck("Release date");
		String releasecountryWiki = w.releaseCountryCheck("Country");


		IMDBPageObjects i = new IMDBPageObjects(driver);
		i.goTo();
		i.searchMovie(movieName);
		String releaseDayIMDB = i.ReleaseDate();
		String releaseCountryIMDB = i.ReleaseCountry();

		Assert.assertEquals(releaseDayWiki, releaseDayIMDB);
		Assert.assertEquals(releasecountryWiki, releaseCountryIMDB);

	}

}
