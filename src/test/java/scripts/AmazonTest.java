package scripts;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends Base {

    @Test(description = "A.1")
    public void testAmazonSearch() {
        driver.get("https://www.amazon.com/");
        new Select(amazonHomePage.selectOptionDropdown).selectByVisibleText("Industrial & Scientific");
        amazonHomePage.searchInputBox.sendKeys("Magnifying Glass");
        amazonHomePage.searchButton.click();
        Assert.assertTrue(amazonHomePage.departmentDropdown.getText().contains("Industrial & Scientific"));
        Assert.assertEquals(amazonHomePage.searchInputBox.getAttribute("value"), "Magnifying Glass");
        for (int i = 0; i < magnifyingGlassSearchPage.amazonPrimeIcon.size(); i++) {
            Assert.assertEquals(magnifyingGlassSearchPage.amazonPrimeIcon.get(i).getAttribute("aria-label"), "Amazon Prime");
        }
        magnifyingGlassSearchPage.itemsList.get(0).click();
        chosenItemPage.quantityButton.click();
        chosenItemPage.quantityDropdown.get(6).click();
        Assert.assertTrue(chosenItemPage.addToCartButton.isDisplayed());
        chosenItemPage.addToCartButton.click();
        itemsAddedToCartPage.goToCartButton.click();
        Assert.assertEquals(shoppingCart.shoppingCartQuantityOfItem.getText(), "7");
        shoppingCart.compareWithSimilarItemsButton.click();
        Assert.assertTrue(shoppingCart.compareSimilarItemsPopup.isDisplayed());
        shoppingCart.closePopUpButton.click();
    }

    @Test(description = "A.2")
    public void testAmazonSearchFail() {
        driver.get("https://www.amazon.com/");
        new Select(amazonHomePage.selectOptionDropdown).selectByVisibleText("Electronics");
        amazonHomePage.searchInputBox.sendKeys("iPhone");
        amazonHomePage.searchButton.click();
        Assert.assertTrue(amazonHomePage.departmentDropdown.getText().contains("electronics"));
        //The above asserTrue statement will fail because this method is case-sensitive, and it should be capital "Electronics"
        Assert.assertEquals(amazonHomePage.searchInputBox.getAttribute("value"), "iPhone");
    }
}
    /*
        Both these tests can now be ran with command mvn test -PA.2_Test.
        -A surefire report should be created once this command is ran because the script was added into an xml file attached
        to the surefire plugin in the pom.xml.
        -If cross browser testing is required, simply go to configuration.properties and change the browser. I have included
        chrome, safari, and firefox. Make sure not to include any additional characters (even spaces) or it will not run.
     */

    /*
    A.3 Task
        -To be able to have the ability to run tests in various environments like  (dev, QA, stg, etc.) I can configure the url in
        my configuration.properties. Then similarly to how I have set up a switch case in my Driver class for cross-browser testing I can set
        up the same for environment so the environment can be chosen easily.
     */

    /*
    Section B (Manual)
    TC1-
    1. Go to Amazon.com
    2. Enter “Magnifying Glass” into the search input field
    3. Select Search
    4. Verify that results options is greater than 0

    //First always, read and understand requirements
    //Second always, perform test case manually
        *For this test case I would go to Amazon.com and find the search input box on the homepage, so I am able to enter in my search. I would also
    locate the search button. Once I enter in my send keys for the item I am searching and click the search button I will then locate the results and
    create an Assert.assertTrue that I can parse(due to it being a String) and I would use regex to take out everything except numbers using the replace all method,
    then using substring to trim the page numbers that are left over, so I can verify that the results number left is greater than 0.

    TC2-
    1. Go to Amazon.com
    2. Enter “Magnifying Glass” into the search input field
    3. Select Search
    4. Click on Brightech featured brands checkbox to filter out other brands
    5. Verify only Brightech products are displayed

    //First always, read and understand requirements
    //Second always, perform test case manually
        *For this test case I would go to Amazon.com and find the search input box on the homepage, so I am able to enter in my search. I would also
    locate the search button. Once I enter in my send keys for the item I am searching and click the search button I will then locate the Brightech checkbox under featured brands filter
    then select it. I would then locate the title of each item and put them in a list, so I can Assert that the title contains "Brightech".

    TC3-
    1. Go to Amazon.com
    2. Enter “Magnifying Glass” into the search input field
    3. Select Search
    4. Click on "AIXPI Magnifying Glass with Light, 30X Handheld Large Magnifying Glass 12 LED Illuminated Lighted Magnifier for Macular Degeneration Seniors Reading Inspection Coins
    JewelryAIXPI Magnifying Glass with Light, 30X Handheld Large Magnifying Glass 12 LED Illuminated Lighted Magnifier for Macular Degeneration Seniors Reading Inspection Coins Jewelry"
    5. Add quantity of item to be 200 and add to cart
    6. Go to cart and verify more than 200 quantity of this item can not be purchased, as per seller only 200 per customer.
    7. Verify this message pops up "This seller has a limit of 200 per customer. To see if more are available from another seller, go to the product detail page."

    //First always, read and understand requirements
    //Second always, perform test case manually
        *For this test case I would go to Amazon.com and find the search input box on the homepage, so I am able to enter in my search. I would also
    locate the search button. Once I enter in my send keys for the item I am searching and click the search button. Then once I locate the item of choice I want provided in requirements
    I would click it. I would then locate the quantity dropdown in a list and get the item from the list that has numbers 199 (being the quantity list starts at 0). Then I would locate the
    add to cart button and click it. Locate the cart button to go to cart and click it. Then I would locate the quantity box for this item in my cart and send keys of 201. Then locate the update button and click it. Lastly,
    I would locate the "This seller has a limit of 200 per customer. To see if more are available from another seller, go to the product detail page." Then run an Assert.assertTrue to verify this message is displayed.
     */

