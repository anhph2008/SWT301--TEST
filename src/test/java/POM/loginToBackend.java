package POM;

import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class loginToBackend {
    private WebDriver driver;

    public loginToBackend(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("login"));
        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        driver.findElement(By.xpath("//input[@title='Login']")).click();

        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//span[normalize-space()='close']")).click();
    }

    public void goToSales(){
        driver.findElement(By.xpath("//span[normalize-space()='Sales']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Orders']")).click();
    }

    public void inputOrderInfo(String id, String from, String to){

        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement inputId = driver.findElement(By.cssSelector("#sales_order_grid_filter_real_order_id"));
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement inputFrom = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)"));
        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement inputTo = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)"));

        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        inputId.clear();
        inputFrom.clear();
        inputTo.clear();

        inputId.sendKeys(id);
        inputFrom.sendKeys(from);
        inputTo.sendKeys(to);

        driver.findElement(By.xpath("//span[contains(text(),'Search')]")).click();
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void captureScreen(){
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            BufferedImage bufferedImage = ImageIO.read(srcFile);
            File destFile = new File("C:\\Users\\elcam\\IdeaProjects\\selenium-demo\\TC10.png"); // Replace with your desired file path
            ImageIO.write(bufferedImage, "png", destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
