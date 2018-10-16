package pl.jsystems.qa.frontend.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPasswordPage extends Basepage {

//    WebDriver driver;

    public LoginPasswordPage(WebDriver driver) {
        super(driver);
//        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "password")
    public WebElement passordInput;

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement logInButton;


}
