package stepDefinitions;

import WebPages.P03_homePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class D03_currenciesStepDef {
    WebDriver driver = null;
    P03_homePage homepage = null;
    public D03_currenciesStepDef()
    {
        driver = Hooks.driver;
        homepage = new P03_homePage(driver);
    }

    @Given("user goes to homepage")
    public void go_to_homepage() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(500);
    }

    @When("^user change currency to \"(.*)\"$")
    public void usr_change_currency(String curr ) throws InterruptedException {
        homepage.set_Currency(curr);
        Thread.sleep(500);
    }

    @Then("^all shown products should contain the \"(.*)\" sign$")
    public void check_products(String curr_sign) throws InterruptedException {
        List<WebElement> products = homepage.shown_products();
        for (int i = 0 ; i<products.size() ; i++)
        {
            Assert.assertTrue(products.get(i).getText().contains(curr_sign));
        }

    }
}
