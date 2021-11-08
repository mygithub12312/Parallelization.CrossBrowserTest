package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriverInstance() {
        if (driver == null) {
            createDriver();
            setupDriver();
        }
        return driver;
    }

    private void WebDriver() {
    }

    private static void createDriver() {
        String browser = System.getProperty("browser");
        switch (browser.toUpperCase()) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver",
                      "src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver",
                      "src/test/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("This driver is not supported");
        }
    }

    private static void setupDriver() {
        driver.manage().window().maximize();
    }
}
