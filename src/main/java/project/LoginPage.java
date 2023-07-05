package project;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
public class LoginPage {
    public static final String LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";
    private final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    private final By registerPageLink = By.xpath("//a[text()='Зарегистрироваться']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By emailField = By.xpath("//*[@name='name']");
    private final By passwordField = By.xpath("//*[@name='Пароль']");
    public void moveToLogin() {
        assertThat("Происходит переход на страницу Логина", LOGIN_PAGE, equalTo(driver.getCurrentUrl()));
    }
    @Step("Click enter button on authorization page")
    public void clickToLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("click registration on authorization page")
    public void clickToRegisterPageLink() {
        driver.findElement(registerPageLink).click();
    }

    @Step("write email")
    public void setEmailData(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("write password")
    public void setPasswordData(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("fill the user information")
    public void setUserLogin(String email, String password) {
        setEmailData(email);
        setPasswordData(password);
    }
}