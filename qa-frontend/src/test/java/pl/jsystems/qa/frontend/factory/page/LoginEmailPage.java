package pl.jsystems.qa.frontend.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.Pageable;

public class LoginEmailPage extends Basepage{

//    WebDriver driver;

    public LoginEmailPage(WebDriver driver) {
        super(driver);
//        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "usernameOrEmail")
    public WebElement loginEmail;

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement emailContinueButton;

}
