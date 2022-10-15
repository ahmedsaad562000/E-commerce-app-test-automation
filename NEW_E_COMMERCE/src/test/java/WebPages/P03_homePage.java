package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_homePage {
    WebDriver driver;
    public P03_homePage(WebDriver Dri)
    {
        driver = Dri;
    }

    public WebElement curr_dropdown_list()
    {
        WebElement curr = null;
     try {
         curr = driver.findElement(By.id("customerCurrency"));
     }
     catch(NoSuchElementException e)
     {
         return null;
     }
    return curr;
    }

    public void set_Currency(String curr)
    {
        Select DaySelect =new Select(curr_dropdown_list());
        DaySelect.selectByVisibleText(curr);
    }

    public List<WebElement> shown_products()
    {
        By products_css = By.cssSelector("span[class=\"price actual-price\"]");
        return driver.findElements(products_css);
    }


    public List<WebElement> search_results()
    {
        By products_css = By.cssSelector("h2[class=\"product-title\"]>a");
        return driver.findElements(products_css);
    }
    public WebElement search_btn()
    {
        By searchBtn = By.cssSelector("button[class= \"button-1 search-box-button\"]");
        return driver.findElement(searchBtn);
    }
    public WebElement search_tf()
    {
        By searchTF = By.id("small-searchterms");
        return driver.findElement(searchTF);
    }
    public WebElement get_product_sku()
    {
        By sku = By.cssSelector("div[class = \"sku\"]>span[class = \"value\"]");
        return driver.findElement(sku);
    }


    public List<WebElement> get_All_Categories()
    {
        By All_Categories = By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a");
        return driver.findElements(All_Categories);
    }
    public List<WebElement> get_sub_categories( int index) throws InterruptedException {
        index = index+1;
        String path = "(//ul[@class='top-menu notmobile']//ul)["+index+"]/li/a";
        By sub_cat = By.xpath(path);


//        WebElement we1 = Sub_Categories.get(1);
//        System.out.println(we1.getAttribute("innerHTML"));

        return driver.findElements(sub_cat);
    }

    public WebElement get_main_category_clickable(WebElement Category)
    {
        Category.getAccessibleName();
        By Cat_name = By.cssSelector("a");
        System.out.println(Category.findElement(Cat_name).getText());
        return Category.findElement(Cat_name);
    }

    public WebElement get_page_title()
    {
        By pg_title = By.cssSelector("div[class=\"page-title\"]>h1");
        return driver.findElement(pg_title);
    }

//    ul[class="top-menu notmobile"]>li
//   ul[class="top-menu notmobile"]>li>ul>li>a
    //div[class="page-title"]>h1





}
