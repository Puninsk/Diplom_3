import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import project.*;
import static project.ForgottenPasswordPage.FORGOTTEN_PASSWORD_PAGE;
import static project.LoginPage.LOGIN_PAGE;
import static project.MainPage.MAIN_PAGE;
import static project.RegistrationPage.REGISTRATION_PAGE;
import static project.UserPage.ACCOUNT_PAGE;


public class LoginTest {
    private WebDriver driver;
    private String userName;
    private String userEmail;
    private String userPassword;
    private User user;
    private UserPage userPage;
    private MainPage mainPage;
    private ForgottenPasswordPage forgottenPasswordPage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    @Before
    public void setUp()  {
        String browserName = System.getProperty("browser");
        driver = BrowsersDrivers.createDriver(browserName);
        userName = RandomStringUtils.randomAlphabetic(10);
        userEmail = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        userPassword = RandomStringUtils.randomAlphabetic(10);
        user = new User(userEmail, userPassword, userName, "");
        user.createUser(user);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        forgottenPasswordPage = new ForgottenPasswordPage(driver);
        userPage = new UserPage(driver);
    }
    @Test
    @DisplayName("Enter through button account enter mainpage")
    public void userLogInFromMainPageLogInButton() {
        driver.get(MAIN_PAGE);
        mainPage.clickToLoginButton();
        loginPage.moveToLoginTest();
    }

    @Test
    @DisplayName("Enter through button account")
    public void userLogInFromLoginPageLogInButton() {
        driver.get(LOGIN_PAGE);
        loginPage.setUserLogin(userEmail, userPassword);
        loginPage.clickToLoginButton();
        mainPage.isMakeOrderButtonDisplayed();
    }
    @Test
    @DisplayName("Enter through button resistration")
    public void userLogInFromRegisterPage() {
        driver.get(REGISTRATION_PAGE);
        registrationPage.clickToLoginLink();
        loginPage.moveToLoginTest();
    }
    @Test
    @DisplayName("Enter through button forgotten password")
    public void userLogInFromPasswordRecoveryPage() {
        driver.get(FORGOTTEN_PASSWORD_PAGE);
        forgottenPasswordPage.clickLoginLink();
        loginPage.moveToLoginTest();
    }
    @Test
    @DisplayName("Move to mainpage through logo userpage")
    public void moveToMainPageByLogoFromPersonalPage() {
        driver.get(LOGIN_PAGE);
        loginPage.setUserLogin(userEmail, userPassword);
        loginPage.clickToLoginButton();
        driver.get(ACCOUNT_PAGE);
        userPage.clickToLogo();
        mainPage.assertCurrentUrl();
    }
    @Test
    @DisplayName("move to userpage though userpage button")
    public void moveToUserpagehtrowUserpageButton() {
        driver.get(LOGIN_PAGE);
        loginPage.setUserLogin(userEmail, userPassword);
        loginPage.clickToLoginButton();
        userPage.clickUserPageButton();
        userPage.userPageEnterTest();
    }
    @After
    public void tearDown() {
        driver.quit();
        user.deleteUser(user);
    }
}