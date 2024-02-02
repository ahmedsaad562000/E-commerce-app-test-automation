package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
public class Hooks {
    public static WebDriver driver;
    @Before
    public static void OpenBrowser()
    {
        // 1- Bridge
        String chromepath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromepath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-blink-features=AutomationControlled");
        options.addArguments("--remote-allow-origins=*");
        //2-new object
        driver = new ChromeDriver(options); //acts as mouse and keyboard
        //3- Configurations
        driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// 4- navigate to url
        driver.get("https://demo.nopcommerce.com/");
    }
    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}