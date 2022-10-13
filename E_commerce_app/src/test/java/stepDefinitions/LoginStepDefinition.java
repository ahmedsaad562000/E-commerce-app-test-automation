package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import WebPages.loginpage;



public class LoginStepDefinition {
    WebDriver driver = null;
    loginpage login = null;
    @Given("open browser")
    public void open_browser()
    {
        String chromepath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromepath);

        //2-new object
        driver = new ChromeDriver(); //acts as mouse and keyboard
        login = new loginpage(driver);


    }
    @And("user navigates to login page")
    public void navigate_to_login_page() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();


        Thread.sleep(500);

    }
    @When("^user enter \"(.*)\" and \"(.*)\"$")
    public void Enter_Valid_Data(String s1 , String s2 ) throws InterruptedException {
        login.login_input(s1 ,s2 );
    }
    @And("User click on login button")
    public void login_btn_click() throws InterruptedException {
        login.pass_field().sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }
    @Then("user could login succesfully")
    public void user_login_success()
    {
        String asd = login.flash_msg().getText();
        Assert.assertTrue( "Error Message: saaad", asd.contains("secure"));
        Assert.assertTrue( "Error Message: logout btn is not displayed",login.logout_btn().isDisplayed());



    }

    @Then("user couldn't login succesfully")
    public void user_login_fails()
    {
        String asd = login.flash_msg().getText();
        Assert.assertTrue( "Error Message: saaad", asd.contains("invasslid"));


    }
    @After
    public void go_to_homepage()  {

        driver.quit();

    }
}
