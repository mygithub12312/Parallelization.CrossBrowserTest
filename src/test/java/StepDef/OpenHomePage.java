package StepDef;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenHomePage {
    @Given("I open {string} Home Page and verify header is {string}")
    public void openPageVerifyHeader(String pageUrl, String expectedHeader) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(pageUrl);
        assertEquals(expectedHeader,driver.getTitle(),"Page Title is incorrect");
        driver.quit();
    }
}