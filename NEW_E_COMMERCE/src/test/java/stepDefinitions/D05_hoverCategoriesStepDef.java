package stepDefinitions;

import WebPages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class D05_hoverCategoriesStepDef {
    WebDriver driver = null;
    P03_homePage homePage = null;
    WebElement Selected_Category = null;
    WebElement Selected_Sub_Category = null;
   String Selected_Category_name = "";
    String Selected_Sub_Category_name = "";
    int selected_category_index= 0;
    int selected_Sub_category_index= 0;
    String Selected_Sub_Category_href = "";
    public D05_hoverCategoriesStepDef()
    {
        driver = Hooks.driver;
        homePage = new P03_homePage(driver);
    }

    @When("User Selects a random Category")
    public void select_category()
    {
        List<WebElement> categories = homePage.get_All_Categories();
        selected_category_index = ThreadLocalRandom.current().nextInt(0, categories.size());
        Selected_Category = categories.get(selected_category_index);
        Selected_Category_name = Selected_Category.getText();


    }

    @And("Check if it has SubCategories")
    public void check_sub_category() throws InterruptedException {
        List<WebElement> sub_categories = homePage.get_sub_categories(selected_category_index);
        if (sub_categories.size() == 0)
        {
            Selected_Sub_Category = null;
        }
        else
        {
            selected_Sub_category_index = ThreadLocalRandom.current().nextInt(0, sub_categories.size());
            Selected_Sub_Category = sub_categories.get(selected_Sub_category_index);
            Selected_Sub_Category_name = Selected_Sub_Category.getAttribute("innerHTML");
            Selected_Sub_Category_href = Selected_Sub_Category.getAttribute("href");
        }

    }

    @And("User click on the selected Category or random SubCategory")
    public void click_on_category() throws InterruptedException {
            if(Selected_Sub_Category == null)
            {
                Selected_Category.click();
            }
            else
            {
                driver.get(Selected_Sub_Category_href);
            }
            Thread.sleep(1000);
        }

    @Then("new page title contains the name of the selected Category or SubCategory")
    public void check_title() throws InterruptedException {
        Thread.sleep(2000);
        String title = homePage.get_page_title().getText().toLowerCase().trim();

        String category = "";
        if(Selected_Sub_Category == null) {


             category= Selected_Category_name.toLowerCase().trim();
        }
        else
        {
            category = Selected_Sub_Category_name.toLowerCase().trim();
        }
        SoftAssert soft = new SoftAssert();

        soft.assertTrue(title.contains(category));
        soft.assertAll();
    }



}
