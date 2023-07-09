package project;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


    public class BrowsersDrivers {
        public static WebDriver createDriver(String browserName) {
            WebDriver driver;

            switch (browserName.toLowerCase()) {
                case "chrome":

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    break;

                case "yandex":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                    ChromeOptions optionsY = new ChromeOptions();
                    optionsY.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                    optionsY.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(optionsY);
                    break;

                default:
                    throw new IllegalArgumentException("Неподдерживаемый браузер: " + browserName);
            }
            return driver;
        }
    }
