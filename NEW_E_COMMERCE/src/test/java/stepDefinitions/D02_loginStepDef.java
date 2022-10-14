package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import WebPages.P02_login;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;



public class D02_loginStepDef {
    WebDriver driver = null;
    P02_login login = null;
    public D02_loginStepDef()
    {
        driver = Hooks.driver;
        login  = new P02_login(driver);

    }


    @Given("user go to login page")
    public void user_login_page() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        driver.manage().window().maximize();

        Thread.sleep(500);

    }

    @And("^user login with \"(.*)\" \"(.*)\" and \"(.*)\"$")
    public void data_login(String validation , String email , String password)
    {
        if(validation.equals("valid"))
        {
            login.enter_Email_And_Password(email, password);
        }
        else
        {
            login.enter_Email_And_Password(email, "psd");
        }
    }


    @And("user press on login button")
    public void login_press()
    {
        login.login_btn().click();
    }

    @Then("user login to the system successfully")
        public void user_login_success() throws InterruptedException
    {
         Thread.sleep(1000);
            SoftAssert soft = new SoftAssert();

        soft.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/"));
        soft.assertAll();
        }


    @Then("user could not login to the system")
    public void user_login_fail() throws InterruptedException
    {
        Thread.sleep(500);
       WebElement asd = login.get_error_msgs();
        Thread.sleep(500);
        SoftAssert soft = new SoftAssert();

        //String s = driver.getCurrentUrl();
       // System.out.println(s);
        //soft.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/login?returnUrl=%2F"));
        soft.assertTrue((asd.isDisplayed()));


        String color_Hex_value = Color.fromString(asd.getCssValue("color")).asHex();

        soft.assertTrue(color_Hex_value.equals("#e4434b"));
        soft.assertAll();
    }



}
