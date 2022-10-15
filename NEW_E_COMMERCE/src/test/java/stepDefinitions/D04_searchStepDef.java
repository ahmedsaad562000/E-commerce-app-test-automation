package stepDefinitions;

import WebPages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

public class D04_searchStepDef {
    WebDriver driver = null;
    P03_homePage homepage = null;
    SoftAssert soft = null;
    int search_results = 0;
    public D04_searchStepDef()
    {
        driver = Hooks.driver;
        homepage = new P03_homePage(driver);
        soft = new SoftAssert();
    }

    @When("^user write \"(.*)\" in the Search Bar$")
    public void user_write_in_searchbar(String search_word)
    {
        homepage.search_tf().sendKeys(search_word);
    }

    @And("clicks On Search Button")
    public void click_search_btn()
    {
        homepage.search_btn().click();
    }

    @Then("user is directed to search results page")
    public void check_search_url() throws InterruptedException {
        Thread.sleep(500);

        soft.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q=") , "wrong page");
    }


    @And("search page shows relevant results")
    public void count_results() throws InterruptedException {
        List<WebElement> products =  homepage.search_results();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(500);
        search_results = products.size();
        soft.assertTrue(search_results>0);

    }


    @And("^results contains \"(.*)\"$")
    public void check_results(String Product_info)
    {
        List<WebElement> products =  homepage.search_results();
        for (int i = 0 ; i<products.size() ; i++)
        {
            String real_info = products.get(i).getText().toLowerCase();
            soft.assertTrue(real_info.contains(Product_info.toLowerCase()));
        }
        soft.assertAll();
    }
    @And("search shows one relevant Product")
    public void one_result_check() throws InterruptedException {
        count_results();
        Assert.assertEquals(search_results , 1);
    }

    @When("user clicks on this Product")
    public void click_on_product()
    {
        List<WebElement> products =  homepage.search_results();
        products.get(0).click();
    }

    @Then("^The product Serial number contains \"(.*)\"$")
    public void check_product_sku(String sku)
    {
        WebElement product_sku =  homepage.get_product_sku();
        String real_sku = product_sku.getText().toLowerCase();
        Assert.assertTrue(real_sku.contains(sku.toLowerCase()));
    }



}
