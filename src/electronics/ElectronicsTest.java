package electronics;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.UUID;

/**
 * ● Create package Electronics
 * 1. Create the class ElectronicsTest
 * Write the following test
 * 1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
 * 1.1 Mouse Hover on “Electronics” Tab
 * 1.2 Mouse Hover on “Cell phones” and click
 * 1.3 Verify the text “Cell phones”
 * 2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
 * 2.1 Mouse Hover on “Electronics” Tab
 * 2.2 Mouse Hover on “Cell phones” and click
 * 2.3 Verify the text “Cell phones”
 * 2.4 Click on List View Tab
 * 2.5 Click on product name “Nokia Lumia 1020” link
 * 2.6 Verify the text “Nokia Lumia 1020”
 * 2.7 Verify the price “$349.00”
 * 2.8 Change quantity to 2
 * 2.9 Click on “ADD TO CART” tab
 * 2.10 Verify the Message "The product has been added to your shopping cart" on Top
 * green Bar
 * After that close the bar clicking on the cross button.
 * 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.12 Verify the message "Shopping cart"
 * 2.13 Verify the quantity is 2
 * 2.14 Verify the Total $698.00
 * 2.15 click on checkbox “I agree with the terms of service”
 * 2.16 Click on “CHECKOUT”
 * 2.17 Verify the Text “Welcome, Please Sign In!”
 * 2.18 Click on “REGISTER” tab
 * 2.19 Verify the text “Register”
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “REGISTER” Button
 * 2.22 Verify the message “Your registration completed”
 * 2.23 Click on “CONTINUE” tab
 * 2.24 Verify the text “Shopping card”
 * 2.25 click on checkbox “I agree with the terms of service”
 * 2.26 Click on “CHECKOUT”
 * 2.27 Fill the Mandatory fields
 * 2.28 Click on “CONTINUE”
 * 2.29 Click on Radio Button “2nd Day Air ($0.00)”
 * 2.30 Click on “CONTINUE”
 * 2.31 Select Radio Button “Credit Card”
 * 2.32 Select “Visa” From Select credit card dropdown
 * 2.33 Fill all the details
 * 2.34 Click on “CONTINUE”
 * 2.35 Verify “Payment Method” is “Credit Card”
 * 2.36 Verify “Shipping Method” is “2nd Day Air”
 * 2.37 Verify Total is “$698.00”
 * 2.38 Click on “CONFIRM”
 * 2.39 Verify the Text “Thank You”
 * 2.40 Verify the message “Your order has been successfully processed!”
 * 2.41 Click on “CONTINUE”
 * 2.42 Verify the text “Welcome to our store”
 * 2.43 Click on “Logout” link
 * 2.44 Verify the URL is “https://demo.nopcommerce.com/”
 */
public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void UserShouldNavigateToCellPhonesPageSuccessfully() {
        // * 1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        // * 1.2 Mouse Hover on “Cell phones” and "Click"
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        // * 1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));

        assertEqualsMethod("Incorrect Top Menu", expectedText, actualText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // * 2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
        Thread.sleep(2000);
        // * 2.2 Mouse Hover on “Cell phones” and "Click"
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        Thread.sleep(2000);
        // * 2.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        assertEqualsMethod("Incorrect Top Menu", expectedText, actualText);
        // * 2.4 Click on List View Tab
        clickOnElement(By.linkText("List"));
        Thread.sleep(2000);
        // * 2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.linkText("Nokia Lumia 1020"));
        // * 2.6 Verify the text “Nokia Lumia 1020”
        String expectedMessage = "Nokia Lumia 1020";
        String actualMessage = getTextFromElement(By.xpath("//h1[text() = 'Nokia Lumia 1020']"));
        assertEqualsMethod("Incorrect message displayed!", expectedMessage, actualMessage);
        // * 2.7 Verify the price “$349.00”
        Thread.sleep(2000);
        String expectedPrice = "$349.00";
        String actualPrice = getTextFromElement(By.id("price-value-20"));
        assertEqualsMethod("Incorrect Price", expectedPrice, actualPrice);
        // * 2.8 Change quantity to 2
        Thread.sleep(2000);
        clearTextField(By.id("product_enteredQuantity_20"));
        Thread.sleep(2000);
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");
        // * 2.9 Click on “ADD TO CART” tab
        Thread.sleep(2000);
        clickOnElement(By.id("add-to-cart-button-20"));
        // * 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(2000);
        String expectedOutput = "The product has been added to your shopping cart";
        String actualOutput = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        assertEqualsMethod("", expectedOutput, actualOutput);
        Thread.sleep(2000);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class = 'close']"));
        Thread.sleep(2000);
        // * 2.11 Then MouseHover on "Shopping cart"
        mouseHoverToElement(By.xpath("//a[@class='ico-cart']"));
        //Click on "GO TO CART" button.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[@class='cart-label']"));
        // * 2.12 Verify the message "Shopping cart"
        String expectedCartMessage = "Shopping cart";
        String actualCartMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        assertEqualsMethod("Incorrect message displayed!", expectedCartMessage, actualCartMessage);
        Thread.sleep(2000);
        // * 2.13 Verify the quantity is 2
         String expectedQuantity = "2";
        String actualQuantity = driver.findElement(By.xpath("//input[@class = 'qty-input']")).getAttribute("value");
        assertEqualsMethod("Incorrect quantity",expectedQuantity, actualQuantity);
        Thread.sleep(2000);
        // * 2.14 Verify the Total $698.00
        String expectedTotal = "$698.00";
        String actualTotal = getTextFromElement(By.xpath("//span[text() = '$698.00']"));
        assertEqualsMethod("", expectedTotal, actualTotal);
        Thread.sleep(2000);
        // * 2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        Thread.sleep(2000);
        // * 2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        Thread.sleep(2000);
        // * 2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedWelcomeMessage = "Welcome, Please Sign In!";
        String actualWelcomeMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        assertEqualsMethod("Incorrect message displayed!", expectedWelcomeMessage, actualWelcomeMessage);
        Thread.sleep(2000);
        // * 2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[@class = 'button-1 register-button']"));
        Thread.sleep(2000);
        // * 2.19 Verify the text “Register”
        String expectedRegisterText = "Register";
        String actualRegisterText = getTextFromElement(By.xpath("//h1[normalize-space()='Register']"));
        assertEqualsMethod("", expectedRegisterText, actualRegisterText);
        // * 2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"), "Mahak");
        sendTextToElement(By.id("LastName"), "Agarwal");
        sendTextToElement(By.name("DateOfBirthDay"), "18");
        sendTextToElement(By.name("DateOfBirthMonth"), "December");
        sendTextToElement(By.name("DateOfBirthYear"), "1990");
        final String randomEmail = randomEmail();
        sendTextToElement(By.id("Email"), randomEmail);
        sendTextToElement(By.name("Password"), "12345678");
        sendTextToElement(By.name("ConfirmPassword"), "12345678");
        // * 2.21 Click on “REGISTER” Button
        clickOnElement(By.name("register-button"));
        Thread.sleep(2000);
        // * 2.22 Verify the message “Your registration completed”
        String expectedRegistrationMessage = "Your registration completed";
        String actualRegistrationMessage = getTextFromElement(By.className("result"));
        assertEqualsMethod("Incorrect message displayed", expectedRegistrationMessage, actualRegistrationMessage);
        Thread.sleep(2000);
        // * 2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(2000);
        // * 2.24 Verify the text “Shopping cart”
        String expectedCartText = "Shopping cart";
        String actualCartText = getTextFromElement(By.linkText("Shopping cart"));
        assertEqualsMethod("Incorrect Shopping Cart Text!", expectedCartText, actualCartText);
        Thread.sleep(2000);
        clickOnElement(By.linkText("Log in"));
        sendTextToElement(By.id("Email"),randomEmail);
        sendTextToElement(By.name("Password"), "12345678");
        Thread.sleep(2000);
        //Click on Login button
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        Thread.sleep(2000);
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(2000);
        //Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        Thread.sleep(2000);
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "233");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "123 Wayfair Land");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "DL1 2PQ");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07945005682");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@class='button-1 new-address-next-step-button']"));
        //Click on Radio Button “2nd Day Air ($0.00)
        clickOnElement(By.id("shippingoption_2"));
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByVisibleText(By.id("CreditCardType"), "Visa");
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
        //Verify “Payment Method” is “Credit Card”
        String expectedPayment= "Payment Method: Credit Card";
        String actualPayment = getTextFromElement(By.xpath("//li[@class='payment-method']"));
        assertEqualsMethod("Incorrect payment method",expectedPayment,actualPayment);
        // Verify “Shipping Method” is “2nd Day Air”
        String expectedShippingMethod= "Shipping Method: 2nd Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//li[@class='shipping-method']"));
        assertEqualsMethod("Error message",expectedShippingMethod,actualShippingMethod);
       //Verify Total is “$698.00”
        String expectedPaymentValue = "$698.00";
        String actualPaymentValue = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
        assertEqualsMethod("Error message",expectedPaymentValue,actualPaymentValue);
        Thread.sleep(2000);
        //Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //Verify the Text “Thank You”
        String expectedMessageThank = "Thank you";
        String actualMessageThank = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        assertEqualsMethod("Error message displayed",expectedMessageThank,actualMessageThank);
        //Verify the message “Your order has been successfully processed!”
        String expectedVerifyMessage = "Your order has been successfully processed!";
        String actualVerifyMessage = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        assertEqualsMethod("Error displayed",expectedVerifyMessage,actualVerifyMessage);
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //Verify the text “Welcome to our store”
        String expectedyWelcomeText = "Welcome to our store";
        String actualWelcomeText = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        assertEqualsMethod("Error message",expectedyWelcomeText,actualWelcomeText);
        //Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = driver.getCurrentUrl();
        assertEqualsMethod("Error in URL",expectedUrl,actualUrl);
    }

    private String randomEmail() {

        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }

}

