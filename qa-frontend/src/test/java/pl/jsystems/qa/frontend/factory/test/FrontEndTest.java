package pl.jsystems.qa.frontend.factory.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pl.jsystems.qa.frontend.Configuration;
import pl.jsystems.qa.frontend.factory.FrontConfig;
import pl.jsystems.qa.frontend.factory.page.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontEndTest extends FrontConfig {

//    @Tag("all")
    @Test
    public void firstFrontTest(TestInfo testInfo) {

        System.out.println(testInfo.getDisplayName());
        MainPage mainPage = new MainPage(driver);

        assertTrue(driver.getTitle().contains("WordPress.com"));
        assertEquals(mainPage.logIn.getText(), "Log In");
        assertTrue(mainPage.logIn.isDisplayed());

        mainPage.logIn.click();

        LoginEmailPage loginEmailPage = new LoginEmailPage(driver);

        loginEmailPage.waitForVisibilityOfElement(loginEmailPage.loginEmail, 30);
        loginEmailPage.waitForVisibilityOfElement(loginEmailPage.emailContinueButton, 30);

        assertTrue(loginEmailPage.loginEmail.isDisplayed());
        assertTrue(loginEmailPage.emailContinueButton.isDisplayed());

        loginEmailPage.loginEmail.clear();
        loginEmailPage.loginEmail.sendKeys(Configuration.WORDPRESS_LOGIN);
        loginEmailPage.emailContinueButton.click();

        LoginPasswordPage loginPasswordPage = new LoginPasswordPage(driver);

        loginPasswordPage.waitForVisibilityOfElement(loginPasswordPage.logInButton, 30);
        loginPasswordPage.waitForVisibilityOfElement(loginPasswordPage.passordInput, 30);

        assertTrue(loginPasswordPage.passordInput.isDisplayed());
        assertTrue(loginPasswordPage.logInButton.isDisplayed());

        loginPasswordPage.passordInput.clear();
        loginPasswordPage.passordInput.sendKeys(Configuration.WORDPRESS_PASSWORD);
        loginPasswordPage.logInButton.click();

        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.waitForVisibilityOfElement(userMainPage.userAvater, 30);

        userMainPage.userAvater.click();

        UserPersonalPage userPersonalPage = new UserPersonalPage(driver);
        userPersonalPage.waitForVisibilityOfElement(userPersonalPage.privateLink, 30);
        userPersonalPage.privateLink.click();

        PrivatPage privatPage = new PrivatPage(driver);
        assertFalse(privatPage.saveButton.isEnabled());

        privatPage.checkbox.click();
        assertTrue(privatPage.saveButton.isEnabled());

    }

    @Test
    public void frontTest() {

        MainPage mainPage = new MainPage(driver);

        assertTrue(driver.getTitle().contains("WordPress.com"));
        assertEquals(mainPage.logIn.getText(), "Log In");
        assertTrue(mainPage.logIn.isDisplayed());

        mainPage.logIn.click();

        LoginEmailPage loginEmailPage = new LoginEmailPage(driver);

        loginEmailPage.waitForVisibilityOfElement(loginEmailPage.loginEmail, 30);
        loginEmailPage.waitForVisibilityOfElement(loginEmailPage.emailContinueButton, 30);

        assertTrue(loginEmailPage.loginEmail.isDisplayed());
        assertTrue(loginEmailPage.emailContinueButton.isDisplayed());

        loginEmailPage.loginEmail.clear();
        loginEmailPage.loginEmail.sendKeys(Configuration.WORDPRESS_LOGIN);
        loginEmailPage.emailContinueButton.click();

        LoginPasswordPage loginPasswordPage = new LoginPasswordPage(driver);

        loginPasswordPage.waitForVisibilityOfElement(loginPasswordPage.logInButton, 30);
        loginPasswordPage.waitForVisibilityOfElement(loginPasswordPage.passordInput, 30);

        assertTrue(loginPasswordPage.passordInput.isDisplayed());
        assertTrue(loginPasswordPage.logInButton.isDisplayed());

        loginPasswordPage.passordInput.clear();
        loginPasswordPage.passordInput.sendKeys(Configuration.WORDPRESS_PASSWORD);
        loginPasswordPage.logInButton.click();

        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.waitForVisibilityOfElement(userMainPage.userAvater, 30);

        userMainPage.userAvater.click();

        UserPersonalPage userPersonalPage = new UserPersonalPage(driver);
        userPersonalPage.waitForVisibilityOfElement(userPersonalPage.privateLink, 30);
        userPersonalPage.notification.click();

        NotificationPage notificationPage = new NotificationPage(driver);
        assertTrue(notificationPage.secondSelector.isSelected());
        notificationPage.secondSelector.click();
        assertFalse(notificationPage.secondSelector.isSelected());
        notificationPage.secondSelector.click();
        assertTrue(notificationPage.secondSelector.isSelected());



    }
}
