package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;
import java.util.concurrent.TimeUnit;


public class DriverManager {

    private static WebDriver instance;
    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static final int IMPLICITLY_WAIT_TIMEOUT = 10;
    private static final int EXPLICITLY_WAIT_TIMEOUT = 10;
    private static final int PAGE_LOAD_TIMEOUT = 20;

    private DriverManager() {
    }

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
    }

    public static WebDriver getDriver() {
        String browser = System.getProperty("browser");
        switch (browser) {
            case "chrome":
                instance = new ChromeDriver();
                instance.manage().window().maximize();
                instance.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
                instance.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
                return instance;
            case "firefox":
                instance = new FirefoxDriver();
                instance.manage().window().maximize();
                instance.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
                instance.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
                return instance;
            default:
                throw new IllegalStateException("This driver is not supported");
        }
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(webDriver -> {
            webDriver.quit();
            webDriverThreadLocal.remove();
        });
    }


    WebDriverWait wait = new WebDriverWait(getDriver(), EXPLICITLY_WAIT_TIMEOUT);

}
