package project;
import io.qameta.allure.Step;
import org.junit.Assert;
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
    private By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By makeOrderButton = By.xpath("//button[text()='Оформить заказ']");


    private By bunsSectionActive = By.xpath("//div[contains(span/text(),'Булки') and contains(@class,'current')]");
    private By bunsSectionUnactive = By.xpath("//div[contains(span/text(),'Булки') and not(contains(@class,'current'))]");
    //section 'Соусы'
    private By saucesSectionActive = By.xpath("//div[contains(span/text(),'Соусы') and contains(@class,'current')]") ;
    private By saucesSectionUnactive = By.xpath("//div[contains(span/text(),'Соусы') and not(contains(@class,'current'))]") ;
    //section Начинки
    private By fillingSectionActive = By.xpath("//div[contains(span/text(),'Начинки') and contains(@class,'current')]");
    private By fillingSectionUnactive = By.xpath("//div[contains(span/text(),'Начинки') and not(contains(@class,'current'))]");



    @Step("Open filling section")
    public void openFillingSection() {
        driver.findElement(fillingSectionUnactive).click();
    }
    @Step("Open sauces section")
    public void openSaucesSection() {
        driver.findElement(saucesSectionUnactive).click();
    }
    @Step("Open buns section")
    public void openBunsSection() {
        driver.findElement(bunsSectionUnactive).click();
    }

    @Step("Check filling section")
    public boolean isFillingSectionOpen() {
        return driver.findElement(fillingSectionActive).isDisplayed();
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