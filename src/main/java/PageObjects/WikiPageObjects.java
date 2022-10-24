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

	@FindBy(xpath = "//table[@class='infobox vevent']/tbody/tr")
	private List<WebElement> rowsCount;

	private String leftXpath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[";
	private String rightXpath = "]";

	By wikiSearchBy = By.xpath("//input[@placeholder='Search Wikipedia']");
	By moviePageBy = By.cssSelector(".mw-wiki-logo");

	public void WikiSendKey(String movieName) {
		waitForElementToAppear(wikiSearchBy);
		wikiSearch.sendKeys(movieName);
	}

	public void WikiSearchButton() {
		wikiSearchButton.click();
	}

	public int RowsCount() {
		waitForElementToAppear(moviePageBy);
		return rowsCount.size();
	}

	public String LeftRowValue() {
		return leftXpath;
	}

	public String RightRowValue() {
		return rightXpath;
	}

	public String ReleaseDayCheck(String releaseDay) {

		for (int i = 3; i <= RowsCount(); i++) {

			String actualXpath = LeftRowValue() + i + RightRowValue();
			WebElement text = driver.findElement(By.xpath(actualXpath));
			scrollToElement(text);
			// System.out.println(text.getText());
			if (text.getText().contains(releaseDay)) {
				// System.out.println(text.getText());
				String releaseRow = text.getText();
				releaseDay = releaseRow.split("date")[1].trim();

			}

		}
		return releaseDay;
	}

	public String CountryCheck(String country) {

		for (int i = 3; i <= RowsCount(); i++) {

			String actualXpath = LeftRowValue() + i + RightRowValue();
			WebElement text = driver.findElement(By.xpath(actualXpath));
			// System.out.println(text.getText());

			if (text.getText().contains(country)) {
				String countryRow = text.getText();
				country = countryRow.split("Country")[1].trim();
			}

		}
		return country;
	}

	public void goTo() {
		driver.get("https://en.wikipedia.org/wiki/Main_Page");

	}

}
