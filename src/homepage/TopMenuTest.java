package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {
    public static String menu;
    String baseUrl ="https://demo.nopcommerce.com";
    String browser ="Chrome";
    @Before
    //launch browser
    public void setUp(){
        openBrowser(baseUrl,browser);
    }
    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    //1.2 This method should click on the menu whatever name is passed as parameter.
    public void selectMenu(String menu) {
        driver.findElement(By.linkText(menu)).click();
    }
    //1.3. create the @Test
    //method name verifyPageNavigation.use selectMenu method to
    public void verifyPageNavigation(String menu){
        WebElement pageTitle = driver.findElement(By.xpath("//div[@class = 'page-title']"));
        String acctualPageTitle = pageTitle.getText();
        String expectedPageTitle = menu;
        Assert.assertEquals("Not Match",expectedPageTitle,acctualPageTitle);
    }


    @Test
    //select the Menu and click on it and verify the page navigation.
    public void selectMenuAndVerifyThePageNavigation(){
        menu ="Books";
        selectMenu(menu);
        verifyPageNavigation(menu);
    }
    @After
    //closing browser
    public void tearDown(){
        closeBrowser();
    }
}
