package StepDef;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;


public class CrossBrowserTest {

	public class OpenHomePage {
		@Given("I open {string} About Page and verify header is {string}")
		public void openPageAndVerifyHeader(String pageUrl, String expectedHeader) {
			WebDriver driver = new ChromeDriver();
			driver.get(pageUrl);
			assertEquals(expectedHeader, driver.getTitle(), "Page Title is incorrect");
			driver.quit();
		}
	}
}
