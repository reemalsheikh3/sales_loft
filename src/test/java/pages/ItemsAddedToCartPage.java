package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemsAddedToCartPage {

    public ItemsAddedToCartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "attach-sidesheet-view-cart-button")
    public WebElement goToCartButton;
}
