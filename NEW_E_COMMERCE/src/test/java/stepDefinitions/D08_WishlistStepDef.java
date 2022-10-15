package stepDefinitions;

import WebPages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D08_WishlistStepDef {
    WebDriver driver = null;
    P03_homePage homepage = null;
    public D08_WishlistStepDef()
    {
        driver = Hooks.driver;
        homepage = new P03_homePage(driver);
    }

  @When("^user clicks on wishlist button of item number (.*)$")
    public void click_on_add_to_wl(int ffd)
  {
        homepage.get_add_to_wishlist_buttons().get(ffd-1).click();
  }

    @Then("user will see success message with green background color")
    public void check_message() throws InterruptedException {
        Thread.sleep(500);
        SoftAssert soft = new SoftAssert();
        WebElement msg =homepage.get_WL_success_msg();
        soft.assertEquals(Color.fromString(msg.getCssValue("background-color")).asHex(),"#4bb07a");
        soft.assertTrue(msg.isDisplayed());
        soft.assertAll();
//        #4bb07a

    }
    @And("user clicks on Wishlist from top right of page")
    public void clicks_on_wishlist() throws InterruptedException {
        Thread.sleep(6000);
        homepage.get_WL_link().click();
    }
    @Then("wishList Product Qty will be more than 0")
    public void check_Qty() throws InterruptedException {
        Thread.sleep(1000);
        int number_of_elements = Integer.parseInt(homepage.get_Qty_Element().getAttribute("value"));
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(number_of_elements>0);
        soft.assertAll();

    }

}
//div[class="bar-notification success"]
//div[class="bar-notification success"]>p
//        input[value="1"]
//        a[class="ico-wishlist"]
//
//        div>div>div[class="add-info"]>div>button[class="button-2 add-to-wishlist-button"]


