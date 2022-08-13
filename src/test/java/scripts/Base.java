package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utilities.Driver;

public class Base {
    WebDriver driver;
    WebDriverWait explicitWait;
    AmazonHomePage amazonHomePage;
    MagnifyingGlassSearchPage magnifyingGlassSearchPage;
    ChosenItemPage chosenItemPage;
    ItemsAddedToCartPage itemsAddedToCartPage;
    ShoppingCart shoppingCart;

    @BeforeMethod()
    public void setup(){
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 30);
        amazonHomePage = new AmazonHomePage(driver);
        magnifyingGlassSearchPage = new MagnifyingGlassSearchPage(driver);
        chosenItemPage = new ChosenItemPage(driver);
        itemsAddedToCartPage = new ItemsAddedToCartPage(driver);
        shoppingCart = new ShoppingCart(driver);
    }

    @AfterMethod
    public void teardown(){
            Driver.quitDriver();
    }
}