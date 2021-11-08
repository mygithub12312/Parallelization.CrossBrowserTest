package StepDef;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.firefox.GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;

public class CrossBrowserTest {
	final String chromeDriverRootPath = "src/main/resources/chromedriver.exe";
	final String fireFoxDriverRootPath = "src/main/resources/geckodriver.exe";

	WebDriver driver;

		@Given("I open {string} About Page and verify header is {string}")
		public void openPageAndVerifyHeader(String pageUrl, String expectedHeader) {
			String browser = System.getProperty("browser");
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromeDriverRootPath);
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty(GECKO_DRIVER_EXE_PROPERTY, fireFoxDriverRootPath);
				driver = new FirefoxDriver();
			} else {
				throw new IllegalStateException(String.format("Incorrect browser", browser));
			}
			driver.get(pageUrl);
			assertEquals(expectedHeader, driver.getTitle(), "Page Title is incorrect");
			driver.quit();
		}
	}
