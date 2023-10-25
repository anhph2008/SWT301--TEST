package BAITAP;

import driver.driverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class testcase02 {
    @Test
    public static void testcase01() {
        WebDriver driver = driverFactory.getChromeDriver();
        //Step1: Go to http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");
//        //Step2: Verify Title of the page
//        WebElement title = driver.findElement(By.cssSelector("h2:nth-child(1)"));
//        try {
//            Assertions.assertEquals(String.valueOf(title), "THIS IS DEMO SITE FOR   ");
//        } catch (Error e){
//            e.printStackTrace();
//        }
        //Step 2: Click on -> MOBILE menu
        WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
        mobileMenu.click();

        // Step 3: Read the cost of Sony Xperia mobile (which is $100)
        WebElement sonyXperiaCost = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
        String sonyXperiaPrice = sonyXperiaCost.getText();

        // Step 4: Click on Sony Xperia mobile
        WebElement sonyXperiaLink = driver.findElement(By.xpath("//a[@title='Sony Xperia']"));
        sonyXperiaLink.click();

        // Step 5: Read the Sony Xperia mobile from the detail page
        WebElement sonyXperiaDetailPrice = driver.findElement(By.xpath("//span[@class='price']"));
        String sonyXperiaDetailPriceText = sonyXperiaDetailPrice.getText();

        // Step 6: Compare Product value in list and details page should be equal ($100)
        Assertions.assertEquals(sonyXperiaPrice, sonyXperiaDetailPriceText, "Product prices do not match.");
        // Add notification if the prices are equal
        if (sonyXperiaPrice == sonyXperiaDetailPriceText) {
            System.out.println("Notification: Product prices are equal.");
        }
    }
}
