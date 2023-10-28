package BAITAP;

import driver.driverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class testcase03 {
    @Test
    public static void testcase03() {
        WebDriver driver = driverFactory.getChromeDriver();
        //Step1: Go to http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        //Step 2: Click on -> MOBILE menu
        WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
        mobileMenu.click();

        //Step 3: Click "ADD TO CART" for Sony Xperia mobile
        WebElement addToCartButton = driver.findElement(By.xpath("//li[2]//div[1]//div[3]//button[1]//span[1]//span[1]"));
        addToCartButton.click();

        // Step 4: Change "QTY" to 1000 and click "UPDATE"
        WebElement qtyInput = driver.findElement(By.xpath("//input[@title='Qty']"));
        qtyInput.clear();
        qtyInput.sendKeys("1000");
        WebElement updateButton = driver.findElement(By.cssSelector("button[title='Update']"));
        updateButton.click();

        // Step 5: Verify the error message
        WebElement errorMessage = driver.findElement(By.cssSelector(".item-msg.error"));
        String expectedErrorMessage = "The requested quantity for \\\"Sony Xperia\\\" is not available.";

        String actualErrorMessage = errorMessage.getText();
        try {
            assert actualErrorMessage.equals(expectedErrorMessage) : "* The maximum quantity allowed for purchase is 500.";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Step 6: Click "EMPTY CART"
        WebElement emptyCartLink = driver.findElement(By.cssSelector("button[id='empty_cart_button'] span span"));
        emptyCartLink.click();

        // Step 7: Verify cart is empty
        WebElement emptyCart = driver.findElement(By.xpath("//span[normalize-space()='Cart']"));

        try {
            Assertions.assertEquals(emptyCart, driver.findElement(By.xpath("//span[normalize-space()='Cart']")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
