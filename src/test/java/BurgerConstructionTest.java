import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import project.BrowsersDrivers;
import project.MainPage;
import static project.MainPage.MAIN_PAGE;

public class BurgerConstructionTest {
    private WebDriver driver;

    private MainPage mainPage;

    @Before
    public void setUp() {

        String browserName = System.getProperty("browser");
        driver = BrowsersDrivers.createDriver(browserName);
        mainPage = new MainPage(driver);

    }

    @Test
    @DisplayName("Open fillings section name")
    public void openIngredientsSectionFromSectionNameLink() {
        driver.get(MAIN_PAGE);
        mainPage.openFillingSection();
        mainPage.isFillingSectionOpen();
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
        mainPage.openFillingSection();
        mainPage.openBunsSection();
        mainPage.isBunsSectionOpen();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}