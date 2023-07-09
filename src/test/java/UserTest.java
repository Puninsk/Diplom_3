import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import project.*;

import static project.LoginPage.LOGIN_PAGE;
public class UserTest {
    private WebDriver driver;
    private String userName;
    private String userEmail;
    private String userPassword;
    private User user;
    private LoginPage loginPage;
    private UserPage userPage;

    @Before
    public void setUp() {
        String browserName = System.getProperty("browser");
        driver = BrowsersDrivers.createDriver(browserName);userName = RandomStringUtils.randomAlphabetic(10);
        userEmail = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        userPassword = RandomStringUtils.randomAlphabetic(10);
        user = new User(userEmail, userPassword, userName, "");
        user.createUser(user);
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
        driver.get(LOGIN_PAGE);
        loginPage.setUserLogin(userEmail, userPassword);
        loginPage.clickToLoginButton();
        userPage.clickUserPageButton();
        userPage.userPageEnterTest();
    }
    @Test
    @DisplayName("Exit though exit button Userpage")
    public void exitFromUserAccount() {
        userPage.clickToExitButton();
        loginPage.loginPageTest();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
