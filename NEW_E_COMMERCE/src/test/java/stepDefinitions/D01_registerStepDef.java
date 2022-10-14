package stepDefinitions;

import WebPages.P01_register;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import org.testng.asserts.SoftAssert;

import java.util.concurrent.ThreadLocalRandom;

public class D01_registerStepDef {


    WebDriver driver = null;
    P01_register register = null;
    public D01_registerStepDef()
    {
       driver = Hooks.driver;
        register = new P01_register(driver);

    }



    @Given("user go to register page")
    public void user_reg_page() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.manage().window().maximize();



        Thread.sleep(500);

    }
    @When("^user select gender type \"(.*)\"$")
    public void select_gender(String gender) throws InterruptedException {
        if(gender.equals("M")) {
            register.malecheckbox().click();
        }
        else if(gender.equals("F"))
        {
            register.femalecheckbox().click();
        }
        else
        {
            register.malecheckbox().click();
        }
        Thread.sleep(1000);
    }

    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void select_gender(String fname , String lname) throws InterruptedException {
        register.set_fname_And_lname(fname , lname);
        Thread.sleep(1000);
    }

    @And("user enter date of birth")
    public void enter_DOB() throws InterruptedException {
        register.set_DOB();
        Thread.sleep(1000);
    }
    @And("^user enter \"(.*)\" email \"(.*)\" field$")
    public void enter_email(String random , String email) throws InterruptedException {
        if(random.equals("random")) {
            int int_random = ThreadLocalRandom.current().nextInt(0, 1000);
            email = "test" + int_random + "@example.com";
        }
        register.set_email(email);
        Thread.sleep(1000);
    }
    @And("^user fills Password fields \"(.*)\" \"(.*)\"$")
    public void enter_password(String pass , String confirm) throws InterruptedException {
        register.set_password(pass , confirm);
        Thread.sleep(1000);
    }

    @And("user clicks on register button")
    public void reg_click() throws InterruptedException {
        register.reg_btntn().click();
        Thread.sleep(1000);
    }

    @Then("success message is displayed")
    public void msg_check(){
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(register.success_msg().getText().contains("Your registration completed"),"Registration failed");
        soft.assertAll();
    }





}