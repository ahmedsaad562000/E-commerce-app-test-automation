package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpage
{

    WebDriver driver ;
    public loginpage(WebDriver dr)
    {
        driver = dr;

    }
        public WebElement username_field()
        {
            By username = By.id("username");
            return driver.findElement(username);
        }

        public WebElement pass_field()
        {
            By pass = By.id("password");
            return driver.findElement(pass);
        }
    public WebElement flash_msg()
    {
        By flash = By.id("flash");
        return driver.findElement(flash);
    }
    public WebElement logout_btn()
    {
        By logout = By.xpath("//*[@id=\"content\"]/div/a/i");
        return driver.findElement(logout);
    }
        public void login_input(String username , String pass) throws InterruptedException
        {
            username_field().click();
            username_field().clear();
            username_field().sendKeys(username);

            username_field().sendKeys(Keys.TAB);
            Thread.sleep(500);
            pass_field().clear();
            pass_field().sendKeys(pass);


        }



}
