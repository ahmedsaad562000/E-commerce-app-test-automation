package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P02_login {
    WebDriver driver = null;
    public P02_login(WebDriver dri)
    {
        driver = dri;
    }

    public WebElement login_btn()
    {
        By login = By.cssSelector("button[class=\"button-1 login-button\"]");
        return driver.findElement(login);
    }
    public WebElement email_tf()
    {
        By Email = By.id("Email");
        return driver.findElement(Email);
    }
    public WebElement Password_tf()
    {
        By Password = By.id("Password");
        return driver.findElement(Password);
    }
    public void enter_Email_And_Password(String email , String password)
    {
        email_tf().sendKeys(email);
        Password_tf().sendKeys(password);
    }
    public WebElement get_error_msgs()
    {
        WebElement msg = null;
        WebElement wrong_credentials_msg = null;
        WebElement wrong_email_msg = null;
        try {
            wrong_credentials_msg = driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));

        } catch (NoSuchElementException e) {
            wrong_credentials_msg = null;
        }

        try {
            wrong_email_msg = driver.findElement(By.cssSelector("span[class=\"field-validation-error\"]"));

        } catch (NoSuchElementException e) {
            wrong_email_msg = null;
        }

        if(wrong_email_msg == null){msg = wrong_credentials_msg; }
        else if (wrong_credentials_msg == null) {msg = wrong_email_msg;}
        else {msg = null;}

        return msg;
    }
}
