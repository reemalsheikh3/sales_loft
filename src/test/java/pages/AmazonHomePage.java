package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
    public AmazonHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchInputBox;

    @FindBy(id = "nav-search-dropdown-card")
    public WebElement departmentDropdown;

    @FindBy(id = "searchDropdownBox")
    public WebElement selectOptionDropdown;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchButton;

}
