import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import project.*;
import static project.LoginPage.LOGIN_PAGE;
import static project.MainPage.MAIN_PAGE;
import static project.RegistrationPage.REGISTRATION_PAGE;

public class RegistrationTest {
    private WebDriver driver;
    private String userName;
    private String userEmail;
    private String userPassword;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private UserPage userPage;

    @Before
    public void setUp() {
        String browserName = System.getProperty("browser");
        driver = BrowsersDrivers.createDriver(browserName);
        userName = RandomStringUtils.randomAlphabetic(10);
        userEmail = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        userPassword = "Test333!";
        registrationPage = new RegistrationPage(driver);
        userPage = new UserPage(driver);
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
    }

    @Test
    @DisplayName("Move to registration through registration button")
    public void userRegistrationFromTheRegistrationButton() {
        driver.get(LOGIN_PAGE);
        loginPage.clickToRegisterPageLink();
        registrationPage.assertCurrentUrl();
    }
    @Test
    @DisplayName("Successful registration")
    public void userRegistrationWithValidCredentials() {
        driver.get(REGISTRATION_PAGE);
        registrationPage.fillRegistrationForm(userName, userEmail, userPassword);
        registrationPage.clickToRegisterButton();
        registrationPage.assertCurrentUrl();
    }
    @Test
    @DisplayName("Error with incorrect password")
    public void userRegistrationWithInvalidPassword() {
        driver.get(REGISTRATION_PAGE);
        registrationPage.fillRegistrationForm(userName, userEmail, "Test");
        registrationPage.clickToRegisterButton();
        registrationPage.isPasswordErrorDisplayed();
        driver.get(MAIN_PAGE);
        userPage.clickUserPageButton();
        loginPage.moveToLoginTest();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
