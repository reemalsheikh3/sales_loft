package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MagnifyingGlassSearchPage {

    public MagnifyingGlassSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "i[aria-label='Amazon Prime']")
    public List<WebElement> amazonPrimeIcon;

    @FindBy(css = "h2[class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']>a")
    public List<WebElement> itemsList;


}
