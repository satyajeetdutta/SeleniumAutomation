package testComponent;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObjects.WikiPageObjects;
//import PageObjects.WikiPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	
	public WikiPageObjects wikiPageInit;
	public Properties prop ;
	FileInputStream fis;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//resources//GlobalData.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();

		return driver;

	}

	@BeforeMethod(alwaysRun = true)
	public void launchApplication() throws IOException {

		initializeDriver();

	}

	@AfterMethod(alwaysRun = true)

	public void tearDown() {
		driver.close();
	}
}
