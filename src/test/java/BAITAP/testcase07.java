package BAITAP;

import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class testcase07 {
    @Test
    public static void testcase07() {
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
        // Step 4: Click on MY ORDER link
        WebElement myOrderLink = driver.findElement(By.xpath("//a[normalize-space()='My Orders']"));
        myOrderLink.click();

        // Step 5: Click on VIEW ORDER link
        WebElement viewOrderLink = driver.findElement(By.xpath("//tr[@class='first odd']//a[contains(text(),'View Order')]"));
        viewOrderLink.click();

        // Step 6: Click on PRINT ORDER link
        WebElement printOrderLink = driver.findElement(By.xpath("//a[@class='link-print']"));
        printOrderLink.click();

        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}