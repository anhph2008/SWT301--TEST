package BAITAP;

import POM.RegistrationPage;
import driver.driverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class testcase05 {
    @Test
    public static void testcase05() {
        // Set up the WebDriver
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        // Step 2: Click on Register link
        WebElement Account = driver.findElement(By.xpath("//span[normalize-space()='Account']"));
        Account.click();
        WebElement registerLink = driver.findElement(By.xpath("//a[@title='Register']"));
        registerLink.click();

        // Step 3: Click Create an Account link and fill out the registration form
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegistrationForm("Mikayy", "HoangAnh", "mikayyHA@example.com", "password");
        registrationPage.clickRegister();

        // switching to new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        registrationPage.ResSuccessful();

        // switching to new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Step 6: Go to TV menu
        driver.findElement(By.xpath("//a[normalize-space()='TV']")).click();

        // Step 7: Add product (e.g., LG LCD) to your wish list
        driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")).click();

        // Step 8: Click SHARE WISHLIST
        driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]")).click();

        // Step 9: Enter email and message and click SHARE WISHLIST
        driver.findElement(By.id("email_address")).sendKeys("friend@example.com");
        driver.findElement(By.id("message")).sendKeys("Check out my wishlist!");
        driver.findElement(By.cssSelector("button[title='Share Wishlist'] span span")).click();

        // Step 10: Check wishlist is shared
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            BufferedImage bufferedImage = ImageIO.read(srcFile);
            File destFile = new File("C:\\Users\\elcam\\IdeaProjects\\selenium-demo\\ShareWL.png"); // Replace with your desired file path
            ImageIO.write(bufferedImage, "png", destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}