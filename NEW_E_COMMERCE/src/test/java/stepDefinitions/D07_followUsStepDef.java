package stepDefinitions;

import WebPages.P03_homePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class D07_followUsStepDef {
    WebDriver driver = null;
    P03_homePage homepage = null;
    public D07_followUsStepDef()
    {
        driver = Hooks.driver;
        homepage = new P03_homePage(driver);
    }

@When("^user clicks on \"(.*)\" link$")
    public void user_clicks_follow_us_link(String link) throws InterruptedException {

        List<WebElement> links = homepage.get_follow_us_links();
        WebElement specified_link = null;
        switch (link)
        {
            case "facebook":
                specified_link = links.get(0);

                break;
            case "twitter":
                specified_link = links.get(1);
                break;
            case "rss":
                specified_link = links.get(2);
                break;
            case "youtube":
                specified_link = links.get(3);
                break;
            default:
                return;

        }

        specified_link.click();

    }

    @Then("^\"(.*)\" is opened in new tab$")
    public void follow_us_link_opens(String follow_us_url) throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(driver.getCurrentUrl().equals(follow_us_url));
        soft.assertAll();

        driver.close();
        Thread.sleep(1000);


    }
}
