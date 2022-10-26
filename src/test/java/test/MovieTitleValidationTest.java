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
	WikiPageObjects w;
	IMDBPageObjects i;
	@Test(dataProvider="getData")
	public void movieValidityTest(String movieName) throws IOException {

		//String movieName = prop.getProperty("movieTitle");
		w = new WikiPageObjects(driver);
		w.goTo();
		w.wikiSendKey(movieName);

		w.wikiSearchButton();

		String releaseDayWiki = w.releaseDayCheck("Release date");
		String releasecountryWiki = w.releaseCountryCheck("Country");


		i = new IMDBPageObjects(driver);
		i.goTo();
		i.searchMovie(movieName);
		String releaseDayIMDB = i.ReleaseDate();
		String releaseCountryIMDB = i.ReleaseCountry();

		Assert.assertEquals(releaseDayWiki, releaseDayIMDB);
		Assert.assertEquals(releasecountryWiki, releaseCountryIMDB);

	}

}
