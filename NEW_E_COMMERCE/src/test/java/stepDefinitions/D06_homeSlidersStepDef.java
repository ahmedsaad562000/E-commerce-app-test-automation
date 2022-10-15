package stepDefinitions;

import WebPages.P03_homePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import org.testng.asserts.SoftAssert;

public class D06_homeSlidersStepDef {
    WebDriver driver = null;
    P03_homePage homepage = null;
    public D06_homeSlidersStepDef()
    {
        driver = Hooks.driver;
        homepage = new P03_homePage(driver);
    }
    @When("^user Clicks on Slider number (.*)$")
    public void click_on_image(int x) throws InterruptedException {
        String a_href = homepage.getImagesElements().get(x-1).getAttribute("href");
        driver.get(a_href);
        Thread.sleep(2000);
    }
    @Then("^new page is opened with expected url \"(.*)\"$")
    public void click_on_image(String url) throws InterruptedException {
        String curr_url = driver.getCurrentUrl();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(curr_url.equals(url) , "Page Is Wrong");
        soft.assertAll();
    }
}
