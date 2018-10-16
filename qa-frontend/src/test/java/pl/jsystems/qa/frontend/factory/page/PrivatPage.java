package pl.jsystems.qa.frontend.factory.page;

import okhttp3.WebSocketListener;
import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrivatPage extends Basepage {

    public PrivatPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".form-toggle__switch")
    public WebElement checkbox;

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement saveButton;
}
