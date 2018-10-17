package pl.jsystems.qa.frontend.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pl.jsystems.qa.frontend.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FrontConfig {

    public WebDriver driver;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    public void setDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() throws MalformedURLException {

//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--start-maximized");

//        WebDriver driver = new ChromeDriver(chromeOptions);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);

        if (driver == null) {
            try {

                if (System.getenv().get("BROWSER").equals("remote")) {
                    driver = new RemoteWebDriver(new URL(Configuration.REMOTE_URL), capabilities);
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                } else {
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                }
            } catch (NullPointerException n) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(Configuration.WORDPRESS_URL);
    }

    @AfterEach
    public void teareDown() {
        driver.quit();
        driver = null;
    }
}
