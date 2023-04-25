package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    public void mouserHoverOn(By by){  // method will perform mouse hover action on elements
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
    public void mouseHoverOnAndClcik(By by){ // method will perform mouse hover and click on elements actions
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    public void clickElement(By by){  // method will perform click action on element
        driver.findElement(by).click();
    }
    public void selectFromDropDown(By by, String text){// this method will select text from dropdown list
        WebElement sortBy = driver.findElement(by);
        Select select = new Select(sortBy);
        select.selectByVisibleText(text);
    }
    public void sendValue(By by,String text){  // this method will send values to perticaular field
        driver.findElement(by).sendKeys(text);
    }

    public void verifyElements(By by,String expected){ // this method will verify two value expected and acctual
        String acctual = driver.findElement(by).getText();
        Assert.assertEquals("not match",expected,acctual);
    }
}
