package BAITAP;

import driver.driverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class testcase01 {
@Test
    public static void testcase01(){
        WebDriver driver = driverFactory.getChromeDriver();
        //Step1: Go to http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");
        //Step2: Verify Title of the page
        WebElement title = driver.findElement(By.cssSelector("h2:nth-child(1)"));
        try {
            Assertions.assertEquals(String.valueOf(title), "THIS IS DEMO SITE FOR   ");
        } catch (Error e){
            e.printStackTrace();
        }
        //Step 3: Click on -> MOBILE -> menu
        WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
        mobileMenu.click();

    // Step 4: In the list of all mobile, select SORT BY -> dropdown as name
        WebElement sortByDropdown = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > select:nth-child(2)"));
        Select select = new Select(sortByDropdown);
        select.selectByVisibleText("Name");
    // Step 5:
    try {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        BufferedImage bufferedImage = ImageIO.read(srcFile);
        File destFile = new File("C:\\Users\\elcam\\IdeaProjects\\selenium-demo\\TC01.png"); // Replace with your desired file path
        ImageIO.write(bufferedImage, "png", destFile);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
