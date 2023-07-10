package project;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
public class RegistrationPage {
    private final WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }
    public static final String REGISTRATION_PAGE = "https://stellarburgers.nomoreparties.site/register";
    private By userPasswordField = By.xpath("//input[@name='Пароль']");
    private By userNameField = By.xpath("//label[text()='Имя']/following::input");
    private By userEmailField = By.xpath("//label[text()='Email']/following::input");
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By invalidPasswordError = By.xpath(".//p[text()='Некорректный пароль']");
    private By enterButton = By.xpath("//a[text()='Войти']");
    @Step("Click registration button")
    public void clickToRegisterButton() {
        driver.findElement(registerButton).click();
    }
    @Step("Click link to enter")
    public void clickToLoginLink() {
        driver.findElement(enterButton).click();
    }
    @Step("Write user name")
    public void setUserNameField(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
    }
    @Step("Write email")
    public void setUserEmailField(String userEmail) {
        driver.findElement(userEmailField).sendKeys(userEmail);
    }
    @Step("Write password")
    public void setUserPasswordField(String userPassword) {
        driver.findElement(userPasswordField).sendKeys(userPassword);
    }
    @Step("Fill registration form")
    public void fillRegistrationForm(String userName, String userEmail, String userPassword) {
        setUserNameField(userName);
        setUserEmailField(userEmail);
        setUserPasswordField(userPassword);
    }
    @Step("Check the massage about error of registration")
    public void isPasswordErrorDisplayed() {
        assertThat("При попытке зарегистрироваться с паролем короче 6 символов отображается варнинг", true, equalTo(driver.findElement(invalidPasswordError).isDisplayed()));
    }
    @Step("Move to registration")
    public void assertCurrentUrl() {
        assertThat("Происходит переход на страницу Регистрации", REGISTRATION_PAGE, equalTo(driver.getCurrentUrl()));
    }
}
