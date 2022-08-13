package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
    public ShoppingCart (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[class='a-dropdown-prompt']")
    public WebElement shoppingCartQuantityOfItem;

    @FindBy(css = "input[value='Compare with similar items']")
    public WebElement compareWithSimilarItemsButton;

    @FindBy(css = "#a-popover-content-2>h1")
    public WebElement compareSimilarItemsPopup;

    @FindBy(css = "button[data-action='a-popover-close']")
    public WebElement closePopUpButton;
}
