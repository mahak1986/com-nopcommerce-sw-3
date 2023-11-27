package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Create the package name computer
 * 1. Create class “TestSuite”
 */
public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    /**
     * Write the following Test:
     * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
     * 1.1 Click on Computer Menu.
     * 1.2 Click on Desktop
     * 1.3 Select Sort By position "Name: Z to A"
     * 1.4 Verify the Product will arrange in Descending order.
     */
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        String menu = "Computers";
        clickOnElement(By.xpath("//a[text()='Computers ']"));
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        selectByVisibleText(By.id("products-orderby"), "Name: Z to A");
        String expected = "Name: Z to A";
        String actual = getTextFromElement(By.xpath("//option[normalize-space()='Name: Z to A']"));
        assertEqualsMethod("Not in descending order", expected, actual);
    }

    /**
     * Test name verifyProductAddedToShoppingCartSuccessFully()
     * 2.1 Click on Computer Menu.
     * 2.2 Click on Desktop
     * 2.3 Select Sort By position "Name: A to Z"
     * //2.4 Click on "Add To Cart"
     * 2.5 Verify the Text "Build your own computer"
     */
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        String menu = "Computers";
        clickOnElement(By.xpath("//a[text()='Computers ']"));
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        selectByVisibleText(By.id("products-orderby"), "Name: A to Z");
        Thread.sleep(2000);
        //clickOnElement(By.xpath("//a[@class='viewmode-icon list']"));
        clickOnElement(By.xpath("//a[text() = 'Build your own computer']"));
        //clickOnElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']"));
        String expected = "Build your own computer";
        String actual = getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']"));
        assertEqualsMethod("Element not correct", expected, actual);
        /**
         * 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
         * 2.7.Select "8GB [+$60.00]" using Select class.
         * 2.8 Select HDD radio "400 GB [+$100.00]"
         * 2.9 Select OS radio "Vista Premium [+$60.00]"
         * 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
         * [+$5.00]"
         * 2.11 Verify the price "$1,475.00"
         * Verify the Message "The product has been added to your shopping cart" on Top
         * green Bar
         */
        // //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        clickOnElement(By.id("product_attribute_1"));
        selectByVisibleText(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //Select "8GB [+$60.00]" using Select class
        clickOnElement(By.id("product_attribute_2"));
        selectByVisibleText(By.id("product_attribute_2"), "8GB [+$60.00]");
        //Select HDD radio "400 GB [+$100.00]
        clickOnElement(By.id("product_attribute_3_7"));
        //Select OS radio "Vista Premium [+$60.00]
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(2000);
        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(2000);
        // Verify the price "$1,475.00"
        String expected1 = "$1,475.00";
        String actual1 = getTextFromElement(By.id("price-value-1"));
        assertEqualsMethod("Error", expected1, actual1);
        Thread.sleep(2000);
        clickOnElement(By.id("add-to-cart-button-1"));
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage2 = "The product has been added to your shopping cart";
        String actualMessage2 = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        assertEqualsMethod("The product has been added to your shopping cart", expectedMessage2, actualMessage2);
        //After that close the bar clicking on the cross button
        clickOnElement(By.xpath("//span[@class = 'close']"));
        //2.14 Then MouseHover on "Shopping cart"
        mouseHoverToElement(By.xpath("//a[@class='ico-cart']"));
        //Click on "GO TO CART" button.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[@class='cart-label']"));
        //2.15 Verify the message "Shopping cart"
        String expectedText = "Shopping cart";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        assertEqualsMethod("Incorrect message displayed!", expectedText, actualText);
        Thread.sleep(2000);
        //Clear quantity field
        clearTextField(By.xpath("//input[@class='qty-input']"));
        //Change the Qty to "2"
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        Thread.sleep(2000);
        //Click on "Update shopping cart"
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        Thread.sleep(2000);
        //2.17 Verify the Total"$2,950.00"
        String expectedTotalPrice = "$2,950.00";
        String actualTotalPrice = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        assertEqualsMethod("Incorrect total price", expectedTotalPrice, actualTotalPrice);
        Thread.sleep(2000);
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(2000);
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        Thread.sleep(2000);
        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        assertEqualsMethod("Incorrect message displayed!", expectedMessage, actualMessage);
        Thread.sleep(2000);
        //2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        Thread.sleep(2000);
        /**
         * 2.22 Fill the all mandatory field
         * 2.23 Click on “CONTINUE”
         * 2.24 Click on Radio Button “Next Day Air($0.00)”
         * 2.25 Click on “CONTINUE”
         * 2.26 Select Radio Button “Credit Card”
         * 2.27 Select “Master card” From Select credit card dropdown
         * 2.28 Fill all the details
         * 2.29 Click on “CONTINUE”
         */
        // * 2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Mahak");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Agarwal");
        sendTextToElement(By.id("BillingNewAddress_Email"), "mahak123@gmail.com");
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "233");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "123 Wayfair Land");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "DL1 2PQ");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07945005682");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[text()='Continue']"));
        Thread.sleep(2000);
        clickOnElement(By.id("shippingoption_1"));
        // 2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        // 2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleText(By.id("CreditCardType"), "Master card");
        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Mahak Agarwal");
        sendTextToElement(By.id("CardNumber"), "0000 0000 0000 0000");
        Thread.sleep(2000);
        clickOnElement(By.id("ExpireMonth"));
        selectByValueFromDropDown(By.id("ExpireMonth"), "10");
        selectByValueFromDropDown(By.id("ExpireYear"), "2026");
        sendTextToElement(By.id("CardCode"), "526");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        /**
         * 2.30 Verify “Payment Method” is “Credit Card”
         * 2.32 Verify “Shipping Method” is “Next Day Air”
         * 2.33 Verify Total is “$2,950.00”
         * 2.34 Click on “CONFIRM”
         * 2.35 Verify the Text “Thank You”
         * 2.36 Verify the message “Your order has been successfully processed!”
         * 2.37 Click on “CONTINUE”
         * 2.37 Verify the text “Welcome to our store”
         */
        //Verify “Payment Method” is “Credit Card”
        String expectedPayment= "Payment Method: Credit Card";
        String actualPayment = getTextFromElement(By.xpath("//li[@class='payment-method']"));
        assertEqualsMethod("Incorrect payment method",expectedPayment,actualPayment);
        //Verify “Shipping Method” is “Next Day Air”
        String expectedShipping = "Shipping Method: Next Day Air";
        String actualShipping = getTextFromElement(By.xpath("//li[@class='shipping-method']"));
        assertEqualsMethod("Incorrect Shipping method",expectedShipping,actualShipping);
        //2.33 Verify Total is “$2,950.00”
        String eTotal1 = "$2,950.00";
        String aTotal1 = driver.findElement(By.xpath("//span[text()='$2,950.00'][@class = 'product-subtotal']")).getText();
        assertEqualsMethod("Incorrect total value",eTotal1,aTotal1);
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //2.35 Verify the Text “Thank You”
        String etext = "Thank you";
        String atext = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        assertEqualsMethod("Incorrect message",etext,atext);
        //Verify the message “Your order has been successfully processed!”
        String eexpectedOrder = "Your order has been successfully processed!";
        String actualOrder = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        assertEqualsMethod("Error in ordering",eexpectedOrder,actualOrder);
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //Verify the text “Welcome to our store”
        String expectedWelcome = "Welcome to our store";
        String actualWelcome = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        assertEqualsMethod("Error message",expectedWelcome,actualWelcome);

    }
    //closing the browser
    @After
    public void setDown() {
        closeBrowser();
    }
}

