package pl.jsystems.qa.frontend.factory.page;

import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends Basepage {

//    WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
//        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li.x-nav-item.x-nav-item--wide.x-nav-item--logged-in a")
    public WebElement logIn;
//    public WebElement logIn = driver.findElement(By.cssSelector("li.x-nav-item.x-nav-item--wide.x-nav-item--logged-in a"));
//    List<WebElement> lis = driver.findElements(By.cssSelector(""));
}
