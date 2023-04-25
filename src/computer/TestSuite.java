package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestSuite extends Utility {

    String baseUrl ="https://demo.nopcommerce.com";
    String browser ="Chrome";
    @Before
    //launch Browser
    public void setUp(){
        openBrowser(baseUrl,browser);
    }
    @Test
    //1.Test name verifyProductArrangeInAlphaBaticalOrder()
    public void verifyProductArrangeInAlphaBeticalOrder()throws InterruptedException {
        //1.1 Click on Computer Menu.
        mouserHoverOn(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //1.2 Click on Desktop
        clickElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        //store the list of item displayed in default option to compare with after sorting value
        List<WebElement> productTitles = new ArrayList<>();
        productTitles = driver.findElements(By.xpath("//h2[@class='product-title']"));
        List<String> expectedlistOfTitle = new LinkedList<>();
        for(int i =0; i<productTitles.size();i++){

            String s = productTitles.get(i).getText();
            expectedlistOfTitle.add(s);
        }
        // sort the default display title in ZtoA order to compare with after sorting
        Collections.reverse(expectedlistOfTitle);
        //1.3 Select Sort By position "Name: Z to A"
        selectFromDropDown(By.name("products-orderby"),"Name: Z to A");
        Thread.sleep(2000);
        productTitles = driver.findElements(By.xpath("//h2[@class='product-title']"));
        List<String> acctuallistOfTitle = new LinkedList<>();
        for(int i =0; i<productTitles.size();i++){
            String s = productTitles.get(i).getText();
            acctuallistOfTitle.add(s);
        }
        boolean message = expectedlistOfTitle.equals(acctuallistOfTitle);
        Assert.assertTrue(message);
 }
 @Test
 //2.Test name verifyProductAddedToShoppingCartSuccessFully()
 public void verifyProductAddedToShoppingCartSuccessFully()throws InterruptedException{
     //2.1 Click on Computer Menu.
     mouserHoverOn(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
     // 2.2 Click on Desktop
     clickElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
     // 2.3 Select Sort By position "Name: A to Z"
     selectFromDropDown(By.name("products-orderby"),"Name: A to Z");
     // 2.4 Click on "Add To Cart"
     Thread.sleep(2000);
     clickElement(By.xpath("//button[@class='button-2 product-box-add-to-cart-button']"));
     // 2.5 Verify the Text "Build your own computer"
     verifyElements(By.xpath("//h1[normalize-space()='Build your own computer']"),"Build your own computer");
     // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
     selectFromDropDown(By.xpath("//select[@id='product_attribute_1']"),"2.2 GHz Intel Pentium Dual-Core E2200");
     // 2.7.Select "8GB [+$60.00]" using Select class.
     selectFromDropDown(By.xpath("//select[@id='product_attribute_2']"),"8GB [+$60.00]");
     // 2.8 Select HDD radio "400 GB [+$100.00]"
     Thread.sleep(1000);
     clickElement(By.xpath("//input[@id='product_attribute_3_7']"));
     // 2.9 Select OS radio "Vista Premium [+$60.00]
     clickElement(By.xpath("//input[@id='product_attribute_4_9']"));
     // 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander[+$5.00]"
     Thread.sleep(1000);
     mouseHoverOnAndClcik(By.xpath("//input[@id='product_attribute_5_10']"));
     clickElement(By.xpath("//input[@id='product_attribute_5_10']"));
     Thread.sleep(1000);
     clickElement(By.xpath("//input[@id='product_attribute_5_12']"));
     // 2.11 Verify the price "$1,475.00"
     verifyElements(By.xpath("//span[@class='price-value-1']"),"$1,470.00");
     // 2.12 Click on "ADD TO CARD" Button.
     clickElement(By.xpath("//button[@id='add-to-cart-button-1']"));
     // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
     verifyElements(By.xpath("//p[@class='content']"),"The product has been added to your shopping cart");
     // After that close the bar clicking on the cross button.
     clickElement(By.xpath("//span[@title='Close']"));
     // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
     mouserHoverOn(By.xpath("//span[@class='cart-label']"));
     clickElement(By.xpath("//button[normalize-space()='Go to cart']"));
     // 2.15 Verify the message "Shopping cart"
     verifyElements(By.xpath("//h1[normalize-space()='Shopping cart']"),"Shopping cart");
     // 2.16 Change the Qty to "2" and Click on "Update shopping cart"
     Thread.sleep(1000);
     driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
     sendValue(By.xpath("//input[@class='qty-input']"),"2");
     clickElement(By.xpath("//button[@id='updatecart']"));
     // 2.17 Verify the Total"$2,950.00"
     verifyElements(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"),"$2,950.00");
     // 2.18 click on checkbox “I agree with the terms of service”
     clickElement(By.xpath("//input[@id='termsofservice']"));
     // 2.19 Click on “CHECKOUT”
     clickElement(By.xpath("//button[@id='checkout']"));
     // 2.20 Verify the Text “Welcome, Please Sign In!”
     verifyElements(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"),"Welcome, Please Sign In!");
     // 2.21Click on “CHECKOUT AS GUEST”Tab
     clickElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
     // 2.22 Fill the all mandatory field
     sendValue(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Meena");
     sendValue(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Shah");
     sendValue(By.xpath("//input[@id='BillingNewAddress_Email']"),"meena@gmail.com");
     selectFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");
     selectFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"Florida");
     sendValue(By.xpath("//input[@id='BillingNewAddress_City']"),"NewYork");
     sendValue(By.xpath("//input[@id='BillingNewAddress_Address1']"),"8,lastRoad");
     sendValue(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"Ha3 4kj");
     sendValue(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"212224522");
     // 2.23 Click on “CONTINUE”
     clickElement(By.xpath("//button[@onclick='Billing.save()']"));
     Thread.sleep(1000);
     // 2.24 Click on Radio Button “Next Day Air($0.00)”
    // clickElement(//input[@id='shippingoption_1']");
     clickElement(By.xpath("//input[@name='shippingoption']"));
     // 2.25 Click on “CONTINUE”
     clickElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
     // 2.26 Select Radio Button “Credit Card”
     clickElement(By.xpath("//input[@id='paymentmethod_1']"));
     // 2.27 Select “Master card” From Select credit card dropdown
     clickElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
      selectFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Master card");
     // 2.28 Fill all the details
        sendValue(By.xpath("//input[@id='CardholderName']"),"Mrs L shah");
        sendValue(By.xpath("//input[@id='CardNumber']"),"5425233430109903");
        selectFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"02");
        selectFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2025");
        sendValue(By.xpath("//input[@id='CardCode']"),"123");
     // 2.29 Click on “CONTINUE”
     clickElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
     // 2.30 Verify “Payment Method” is “Credit Card”
     verifyElements(By.xpath("//li[@class='payment-method']"),"Payment Method: Credit Card");
     // 2.32 Verify “Shipping Method” is “Next Day Air”
     verifyElements(By.xpath("//li[@class='shipping-method']"),"Shipping Method: Ground");
     // 2.33 Verify Total is “$2,950.00”
     verifyElements(By.xpath("//span[@class='value-summary']"),"$2,950.00");
     // 2.34 Click on “CONFIRM”
     clickElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
     // 2.35 Verify the Text “Thank You”
     verifyElements(By.xpath("//h1[normalize-space()='Thank you']"),"Thank you");
      // 2.36 Verify the message “Your order has been successfully processed!”
     verifyElements(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"),"Your order has been successfully processed!");
     // 2.37 Click on “CONTINUE”
     clickElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
     // 2.37 Verify the text “Welcome to our store”
     verifyElements(By.xpath("//div[@class='topic-block-title']"),"Welcome to our store");
 }
 @After
    //closing browser
    public void tearDown(){ closeBrowser();}
}
