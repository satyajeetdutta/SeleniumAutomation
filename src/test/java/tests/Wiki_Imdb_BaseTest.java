package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Wiki_Imdb_BaseTest {

	public static void main(String[] args) {

		String releaseDay = null, country = null;

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		
		

		driver.findElement(By.xpath("//input[@placeholder='Search Wikipedia']")).sendKeys("Pushpa: The Rise");
		driver.findElement(By.id("searchButton")).click();

		List<WebElement> allRows = driver.findElements(By.xpath("//table[@class='infobox vevent']/tbody/tr"));
		int count = allRows.size();

		String leftXpath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[";
		String rightXpath = "]";

		for (int i = 3; i <= count; i++) {

			String actualXpath = leftXpath + i + rightXpath;
			WebElement text = driver.findElement(By.xpath(actualXpath));
			// System.out.println(text.getText());
			if (text.getText().contains("Release date")) {
				// System.out.println(text.getText());
				String releaseRow = text.getText();
				releaseDay = releaseRow.split("date")[1].trim();
			} else if (text.getText().contains("Country")) {
				String countryRow = text.getText();
				country = countryRow.split("Country")[1].trim();
			}
		}

		System.out.println(releaseDay + " " + country);

	}

}
