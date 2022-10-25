package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class WikiPageObjects extends AbstractComponents {

	WebDriver driver;

	public WikiPageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Search Wikipedia']")
	private WebElement wikiSearch;

	@FindBy(id = "searchButton")
	private WebElement wikiSearchButton;

	@FindBy(xpath = "// table[@class='infobox vevent']/tbody/tr")
	private List<WebElement> wikiRows;
	
	@FindBy(xpath = "// table[@class='infobox vevent']/tbody/tr[12]")
	private WebElement movieReleaseDate;

	By wikiSearchBy = By.xpath("//input[@placeholder='Search Wikipedia']");
	By moviePageBy = By.cssSelector(".mw-wiki-logo");

	public void wikiSendKey(String movieName) {
		waitForElementToAppear(wikiSearchBy);
		wikiSearch.sendKeys(movieName);
	}

	public void wikiSearchButton() {
		wikiSearchButton.click();
	}

	public String releaseDayCheck(String releaseDay) {
		scrollToElement(movieReleaseDate);
		waitForElementToAppear(moviePageBy);
		String originalReleaseDay = wikiRows.stream().filter(i -> i.getText().contains(releaseDay))
				.map(i -> i.getText().split("date")[1].trim()).findFirst().orElse(null);
		return originalReleaseDay;
	}

	public String releaseCountryCheck(String country) {
		String originalcountry = wikiRows.stream().filter(i -> i.getText().contains(country))
				.map(i -> i.getText().split(" ")[1].trim()).findFirst().orElse(null);

		return originalcountry;
	}

	public void goTo() {
		driver.get("https://en.wikipedia.org/wiki/Main_Page");

	}

}
