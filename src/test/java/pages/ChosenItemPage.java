package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ChosenItemPage {
    public ChosenItemPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#a-autoid-0>span>span[data-action='a-dropdown-button']")
    public WebElement quantityButton;

    @FindBy(css = "li[class='a-dropdown-item']")
    public List<WebElement> quantityDropdown;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

}
