package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl ="https://demo.nopcommerce.com";
    String browser ="Chrome";
    @Before
    //launch browser
    public void setUp(){
        openBrowser(baseUrl,browser);
    }
    @Test
    //1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully()throws InterruptedException{
        //1.1 Mouse Hover on “Electronics”Tab
        mouserHoverOn(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverOnAndClcik(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
       Thread.sleep(1000);
        //1.3 Verify the text “Cell phones”
        verifyElements(By.xpath("//h1[normalize-space()='Cell phones']"),"Cell phones");
    }
    @Test
    //2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()throws InterruptedException{
        //2.1 Mouse Hover on “Electronics”Tab
        mouserHoverOn(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        // 2.2 Mouse Hover on “Cell phones” and click
        mouseHoverOnAndClcik(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        // 2.3 Verify the text “Cell phones”
        verifyElements(By.xpath("//h1[normalize-space()='Cell phones']"),"Cell phones");
        // 2.4 Click on List View Tab
        clickElement(By.xpath("//a[normalize-space()='List']"));
        // 2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]")).click();
        clickElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        // 2.6 Verify the text “Nokia Lumia 1020”
        verifyElements(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"),"Nokia Lumia 1020");
        // 2.7 Verify the price “$349.00”
        verifyElements(By.xpath("//span[@id='price-value-20']"),"$349.00");
        // 2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendValue(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
        // 2.9 Click on “ADD TO CART” tab
        clickElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        // 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        verifyElements(By.xpath("//p[@class='content']"),"The product has been added to your shopping cart");
        clickElement(By.xpath("//span[@title='Close']"));
       // 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouserHoverOn(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(1000);
        clickElement(By.xpath("//button[normalize-space()='Go to cart']"));
        //2.12 Verify the message "Shopping cart"
        verifyElements(By.xpath("//h1[normalize-space()='Shopping cart']"),"Shopping cart");
        //2.13 Verify the quantity is 2
        Thread.sleep(2000);
        String qty =driver.findElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/input[1]")).getAttribute("value");
        System.out.println(qty);
        String expqty ="2";
        Assert.assertEquals("Not match",expqty,qty);
        //2.14 Verify the Total $698.00
        verifyElements(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]"),"$698.00");
        verifyElements(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"),"$698.00");
        // 2.15 click on checkbox “I agree with the terms of service”
        clickElement(By.xpath("//input[@id='termsofservice']"));//driver.findElement(By.xpath("//input[@name='termsofservice']"))
        //2.16 Click on “CHECKOUT”
        clickElement(By.xpath("//button[@id='checkout']"));
        // 2.17 Verify the Text “Welcome, Please Sign In!”
        verifyElements(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"),"Welcome, Please Sign In!");
        // 2.18 Click on “REGISTER” tab
        clickElement(By.xpath("//button[normalize-space()='Register']"));
        // 2.19 Verify the text “Register”
        verifyElements(By.xpath("//h1[normalize-space()='Register']"),"Register");
        // 2.20 Fill the mandatory fields
        sendValue(By.xpath("//input[@id='FirstName']"),"Roma");
        sendValue(By.xpath("//input[@id='LastName']"),"Shah");
        sendValue(By.xpath("//input[@id='Email']"),"roma@gmail.com");
        sendValue(By.xpath("//input[@id='Password']"),"Usha@123");
        sendValue(By.xpath("//input[@id='ConfirmPassword']"),"Usha@123");
        // 2.21 Click on “REGISTER” Button
        clickElement(By.xpath("//button[@name='register-button']"));
        Thread.sleep(2000);
        // 2.22 Verify the message “Your registration completed”
        String register = driver.findElement(By.xpath("//div[@class='result']")).getText();
        System.out.println(register);
        verifyElements(By.xpath("//div[@class='result']"),"Your registration completed");
        // 2.23 Click on “CONTINUE” tab
        clickElement(By.xpath("//a[normalize-space()='Continue']"));
        // clickElement(By.xpath("a[class='button-1 register-continue-button']"));
        // 2.24 Verify the text “Shopping card”
        String cart =driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
        //driver.findElement(By.xpath("//span[@class='cart-label']")).getText();
        System.out.println(cart);
        verifyElements(By.xpath("//h1[normalize-space()='Shopping cart']"),"Shopping cart");
        clickElement(By.xpath("//a[normalize-space()='Log in']"));
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("roma@gmail.com");
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Usha@123");
        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
        // 2.25 click on checkbox “I agree with the terms of service”
        clickElement(By.xpath("//input[@id='termsofservice']"));
        // 2.26 Click on “CHECKOUT”
        clickElement(By.xpath("//button[@id='checkout']"));
        // 2.27 Fill the Mandatory fields
        selectFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"India");
        sendValue(By.xpath("//input[@id='BillingNewAddress_City']"),"Ahmedabad");
        sendValue(By.xpath("//input[@id='BillingNewAddress_Address1']"),"3,malson road");
        sendValue(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"ha7 8ja");
        sendValue(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"12546325");
        // 2.28 Click on “CONTINUE”
        clickElement(By.xpath("//button[@onclick='Billing.save()']"));
        // 2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickElement(By.xpath("//input[@id='shippingoption_2']"));
        // 2.30 Click on “CONTINUE”
        clickElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        // 2.31 Select Radio Button “Credit Card”
        clickElement(By.xpath("//input[@id='paymentmethod_1']"));
        // 2.32 Select “Visa” From Select credit cad dropdown
        clickElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        // 2.33 Fill all the details
        sendValue(By.xpath("//input[@id='CardholderName']"),"Mrs A shah");
        sendValue(By.xpath("//input[@id='CardNumber']"),"5425233430109903");
        selectFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"02");
        selectFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2025");
        sendValue(By.xpath("//input[@id='CardCode']"),"123");
        // 2.34 Click on “CONTINUE”
        clickElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        // 2.35 Verify “Payment Method” is “Credit Card”
        verifyElements(By.xpath("//li[@class='payment-method']"),"Payment Method: Credit Card");
        // 2.36 Verify “Shipping Method” is “2nd Day Air”
        String ship = driver.findElement(By.xpath("//li[@class='shipping-method']")).getText();
        System.out.println(ship);
        //verifyElements(By.xpath("//li[@class='shipping-method']"),"Shipping Method: Ground");
        // 2.37 Verify Total is “$698.00”
        String total= driver.findElement(By.xpath("//span[@class='value-summary']")).getText();
        System.out.println(total);
        // 2.38 Click on “CONFIRM”button-1 confirm-order-next-step-button
        clickElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        // 2.39 Verify the Text “Thank You”
        verifyElements(By.xpath("//h1[normalize-space()='Thank you']"),"Thank you");
        // 2.40 Verify the message “Your order has been successfully processed!”
        verifyElements(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"),"Your order has been successfully processed!");
        // 2.41 Click on “CONTINUE”button-1 order-completed-continue-button
        clickElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        // 2.42 Verify the text “Welcome to our store”topic-block-title
        verifyElements(By.xpath("//div[@class='topic-block-title']"),"Welcome to our store");
        // 2.43 Click on “Logout” link
        clickElement(By.linkText("Log out"));
        // 2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String titleUrl = driver.getCurrentUrl();
        String expectedUrl="https://demo.nopcommerce.com/";
        Assert.assertEquals("Not Match",expectedUrl,titleUrl);
    }
@After
//closing browser
    public void tearDown(){ closeBrowser();}
}
