package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class IMDBPageObjects extends AbstractComponents {

	WebDriver driver;

	public IMDBPageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Release date December 17, 2021 (United States) Country of origin India
	 * 
	 */

	// input[@id='suggestion-search']

	@FindBy(xpath = "//input[@id='suggestion-search']")
	private WebElement searchText;

	@FindBy(xpath = "//li[@id='react-autowhatever-1--item-0']//a[@class='sc-d2740ffb-0 kqjPkC searchResult searchResult--const']")
	private WebElement selectMovie;

	@FindBy(xpath = "//li[@data-testid='title-details-releasedate']")
	private WebElement releaseDate;

	@FindBy(xpath = "//li[@data-testid='title-details-origin']")
	private WebElement releaseCountry;

	By imdbSearchBy = By.xpath("//input[@id='suggestion-search']");
	By imdbMovieNameBy = By.xpath(
			"//li[@id='react-autowhatever-1--item-0']//a[@class='sc-d2740ffb-0 kqjPkC searchResult searchResult--const']");

	public String ReleaseDate() {
		waitForElementToAppear(imdbSearchBy);
		scrollToElement(releaseDate);
		String onlyDate = releaseDate.getText().split("date")[1].trim();

		String[] strSplit = onlyDate.split(",");
		String year = strSplit[1].split("\\(")[0].trim();// year contains the year in which movie was released
		System.out.println(year);

		String[] dateAndMonth = strSplit[0].split(" ");

		String date = dateAndMonth[1].toString();
		String month = dateAndMonth[0].toString();

		String releaseDayIMDBSorted = date + " " + month + " " + year;
		return releaseDayIMDBSorted;
	}

	public String ReleaseCountry() {
		scrollToElement(releaseCountry);
		return releaseCountry.getText().split("origin")[1].trim();
	}

	public void searchMovie(String movieName) {
		waitForElementToAppear(imdbSearchBy);
		searchText.sendKeys(movieName);
		waitForElementToAppear(imdbMovieNameBy);
		selectMovie.click();
	}

	public void goTo() {
		driver.get("https://www.imdb.com/");
	}
}
