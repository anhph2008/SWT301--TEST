package BAITAP;

import POM.CartPage;
import POM.LoginPage;
import POM.reOrderPage;
import driver.driverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class testcase08 {
    @Test
    public static void testcase08() {
        // Set up the WebDriver
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");
        LoginPage loginPage = new LoginPage(driver);

        // Step 2: Click on My Account link
        loginPage.goToLogin();

        // Step 3: Login using previously created credentials
        loginPage.fillLoginForm("mikayyHA@example4.com", "password");
        loginPage.clickLogin();

        // switching to new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        WebElement reOrderLink = driver.findElement(By.xpath("//tr[@class='even']//a[@class='link-reorder'][normalize-space()='Reorder']"));
        reOrderLink.click();

        // Step 4: Click on 'REORDER' link, change QTY, and click Update
        CartPage reorderPage = new CartPage(driver);
        //get Total before update
        String grandTotalBeforeUpdate = reorderPage.getTotalAmount();
        reorderPage.changeQTY();

        //Step 5: Verify Grand Total is changed
        String grandTotalAfterUpdate = reorderPage.getTotalAmount();
        assert !grandTotalBeforeUpdate.equals(grandTotalAfterUpdate) : "Grand Total is not changed.";

        //Step 6: Complete Billing & Shipping Information
        reOrderPage reorder = new reOrderPage(driver);
        reorder.completeReOrder(driver, reorderPage);
        // Step 7: Verify Order is generated and note the order number
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            BufferedImage bufferedImage = ImageIO.read(srcFile);
            File destFile = new File("C:\\Users\\elcam\\IdeaProjects\\selenium-demo\\REorder.png"); // Replace with your desired file path
            ImageIO.write(bufferedImage, "png", destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}