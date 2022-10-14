package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

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






}
