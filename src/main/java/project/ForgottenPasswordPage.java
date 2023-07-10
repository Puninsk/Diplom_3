package project;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ForgottenPasswordPage {
    private final WebDriver driver;
    public ForgottenPasswordPage(WebDriver driver){
        this.driver = driver;
    }
    public static final String FORGOTTEN_PASSWORD_PAGE = "https://stellarburgers.nomoreparties.site/forgot-password";
    private By loginLink = By.xpath("//*[@href='/login']");
    @Step("Click Enter link")
    public void clickLoginLink(){
        driver.findElement(loginLink).click();
    }

}