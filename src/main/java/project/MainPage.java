package project;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public static final String MAIN_PAGE = "https://stellarburgers.nomoreparties.site/";
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By makeOrderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By bunsSectionActive = By.xpath("//div[span[text()='Булки']]");
    private final By saucesSectionActive = By.xpath("//div[span[text()='Соусы']]") ;
    private final By ingredientsSectionActive = By.xpath("//*[text()='Начинки']");
    @Step("Open filling section")
    public void openIngredientSection() {
        driver.findElement(ingredientsSectionActive).click();
    }
    @Step("Open sauces section")
    public void openSaucesSection() {
        driver.findElement(saucesSectionActive).click();
    }
    @Step("Open buns section")
    public void openBunsSection() {
        driver.findElement(bunsSectionActive).click();
    }
    @Step("Check filling section")
    public boolean isIngredientsSectionOpen() {
        return driver.findElement(ingredientsSectionActive).isDisplayed();
    }
    @Step("Check sauces section")
    public boolean isSaucesSectionOpen() {
        return driver.findElement(saucesSectionActive).isDisplayed();
    }
    @Step("Check buns section")
    public boolean isBunsSectionOpen() {
        return driver.findElement(bunsSectionActive).isDisplayed();
    }
    @Step("Check button make order")
    public void isMakeOrderButtonDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(makeOrderButton));
        assertThat("Отображается кнопка Оформить заказ", true, equalTo(driver.findElement(makeOrderButton).isDisplayed()));
    }
    @Step("Move to mainpage")
    public void assertCurrentUrl() {
        assertThat("Происходит переход на Главную страницу", MAIN_PAGE, equalTo(driver.getCurrentUrl()));
    }
    @Step("Click button enter to userpage")
    public void clickToLoginButton() {
        driver.findElement(loginButton).click();
    }

}