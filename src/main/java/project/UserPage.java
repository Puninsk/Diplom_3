package project;

import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UserPage {

        private final WebDriver driver;
        public UserPage(WebDriver driver){
            this.driver = driver;
        }
        public static final String ACCOUNT_PAGE = "https://stellarburgers.nomoreparties.site/account";
        public static final String ACCOUNT_PROFILE_PAGE = "https://stellarburgers.nomoreparties.site/account/profile";
        private final By exitButton = By.xpath(".//button[text()='Выход']");
        @Step("Press delete button")
        public void clickToExitButton() {
            driver.findElement(exitButton).click();
        }

        private final By userPageButton = By.xpath("//p[text()='Личный Кабинет']");

        private final By logo = By.xpath("//div[contains(@class, 'AppHeader_header__logo')]");

        private final By constructorButton = By.xpath("//p[text()='Конструктор']");

        public void userPageEnter() {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe((ACCOUNT_PROFILE_PAGE)));
            assertThat("Переход на страницу Личного кабинета", ACCOUNT_PROFILE_PAGE, equalTo(driver.getCurrentUrl()));
        }

    @Step("Move to userpage")
    public void clickUserPageButton() {
        driver.findElement(userPageButton).click();
    }
    @Step("Click constructor button")
    public void clickToConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    @Step("Click logo")
    public void clickToLogo() {
        driver.findElement(logo).click();
    }

    }
