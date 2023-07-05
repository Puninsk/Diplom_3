import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import project.MainPage;
import project.User;
//import project.UserSteps;
import project.LoginPage;
import static project.LoginPage.LOGIN_PAGE;
import static project.MainPage.MAIN_PAGE;

public class BurgerConstructionTest {
    private WebDriver driver;
    private String userName;
    private String userEmail;
    private String userPassword;
    private User user;
   // private UserSteps userSteps;
    private LoginPage loginPage;
    private MainPage mainPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        userName = RandomStringUtils.randomAlphabetic(10);
        userEmail = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        userPassword = RandomStringUtils.randomAlphabetic(10);
    //    userSteps = new UserSteps();
        user = new User(userEmail, userPassword, userName, "");
        user.createUser(user);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        driver.get(LOGIN_PAGE);
        loginPage.setUserLogin(userEmail, userPassword);
        loginPage.clickToLoginButton();
    }
    @Test
    @DisplayName("Open fillings section name")
    public void openIngredientsSectionFromSectionNameLink() {
        driver.get(MAIN_PAGE);
        mainPage.openIngredientSection();
                mainPage.isIngredientsSectionOpen();
    }

    @Test
    @DisplayName("Open sauces section name")
    public void openSaucesSectionFromSectionNameLink() {
        driver.get(MAIN_PAGE);
        mainPage.openSaucesSection();
                mainPage.isSaucesSectionOpen();
    }

    @Test
    @DisplayName("Open buns section name")
    public void openBunsSectionFromSectionNameLink() {
        driver.get(MAIN_PAGE);
        mainPage.openIngredientSection();
        mainPage.openBunsSection();
        mainPage.isBunsSectionOpen();
    }

    @After
    public void tearDown() {
        driver.quit();
        user.deleteUser(user);
    }
}