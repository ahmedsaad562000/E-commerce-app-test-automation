package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P01_register {
WebDriver Driver;
public P01_register(WebDriver Dri)
{
    Driver = Dri;

}

public WebElement malecheckbox()
{
    By male = By.id("gender-male");
    return Driver.findElement(male);
}
    public WebElement femalecheckbox()
    {
        By female = By.id("gender-female");
        return Driver.findElement(female);
    }
    public WebElement first_name_tf()
    {
        By fname = By.id("FirstName");
        return Driver.findElement(fname);
    }
    public WebElement last_name_tf()
    {
        By lname = By.id("LastName");
        return Driver.findElement(lname);
    }
    public WebElement Day_DOB()
    {
        By D_DOB = By.cssSelector("select[name = \"DateOfBirthDay\"]");
        return Driver.findElement(D_DOB);
    }
    public WebElement Month_DOB()
    {
        By M_DOB = By.cssSelector("select[name = \"DateOfBirthMonth\"]");
        return Driver.findElement(M_DOB);
    }
    public WebElement Year_DOB()
    {
        By Y_DOB = By.cssSelector("select[name = \"DateOfBirthYear\"]");
        return Driver.findElement(Y_DOB);
    }
    public WebElement Email_tf()
    {
        By email = By.id("Email");
        return Driver.findElement(email);
    }
    public WebElement Company_tf()
    {
        By Company = By.id("Company");
        return Driver.findElement(Company);
    }

    public WebElement password_tf()
    {
        By Password = By.id("Password");
        return Driver.findElement(Password);
    }
    public WebElement success_msg()
    {
        By msg = By.cssSelector("div[class=\"result\"]");
        return Driver.findElement(msg);
        //Your registration completed
    }

    public WebElement password_conf_tf()
    {
        By ConfirmPassword = By.id("ConfirmPassword");
        return Driver.findElement(ConfirmPassword);
    }
    public WebElement reg_btntn()
    {
        By reg = By.id("register-button");
        return Driver.findElement(reg);
    }
public void set_fname_And_lname(String fname , String lname)
{
    first_name_tf().click();
    first_name_tf().clear();
  first_name_tf().sendKeys(fname);
    last_name_tf().click();
    last_name_tf().clear();
    last_name_tf().sendKeys(lname);

}

    public void set_email(String email)
    {
        Email_tf().click();
        Email_tf().clear();
        Email_tf().sendKeys(email);

    }

    public void set_DOB()
    {
        Select DaySelect =new Select(Day_DOB());
        DaySelect.selectByVisibleText("5");
        Select MonthSelect =new Select(Month_DOB());
        MonthSelect.selectByVisibleText("July");
        Select YearSelect =new Select(Year_DOB());
        YearSelect.selectByVisibleText("2000");

    }
    public void set_password(String password , String confirm)
    {
        password_tf().click();
        password_tf().clear();
        password_tf().sendKeys(password);
        password_conf_tf().click();
        password_conf_tf().clear();
        password_conf_tf().sendKeys(confirm);

    }

}
