package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class testcase04 {
    @Test
    public static void testcase03() {
        WebDriver driver = driverFactory.getChromeDriver();
        //Step1: Go to http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        //Step 2: Click on -> MOBILE menu
        WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
        mobileMenu.click();

        // Step 3: Click "Add To Compare" for Sony Xperia and iPhone
        WebElement sonyXperiaCompareCheckbox = driver.findElement(By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]"));
        sonyXperiaCompareCheckbox.click();

        WebElement iPhoneCompareCheckbox = driver.findElement(By.xpath("//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]"));
        iPhoneCompareCheckbox.click();

        // Step 4: Click "COMPARE" button to open the popup window
        WebElement compareButton = driver.findElement(By.cssSelector("button[title='Compare'] span span"));
        compareButton.click();

        // Switch to the new popup window
        for (String popupWindow : driver.getWindowHandles()) {
            driver.switchTo().window(popupWindow);
        }

        // Step 5: Verify the popup window
        WebElement popupHeading = driver.findElement(By.cssSelector("div[class='page-title title-buttons'] h1"));
        assert popupHeading.getText().equals("COMPARE PRODUCTS") : "Popup heading does not match.";

        // Verify that the selected products are reflected in the popup
        WebElement sonyXperiaProduct = driver.findElement(By.xpath("//a[normalize-space()='Sony Xperia']"));
        WebElement iPhoneProduct = driver.findElement(By.xpath("//a[normalize-space()='IPhone']"));
        assert sonyXperiaProduct.isDisplayed() : "Sony Xperia product not found in the popup.";
        assert iPhoneProduct.isDisplayed() : "iPhone product not found in the popup.";

        // Wait for 5 seconds
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 6: Close the popup window and switch back to the main window
        driver.close();

        // Switch back to the main window
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

    }
}
