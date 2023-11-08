package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobilePage {
    private final WebDriver driver;

    public MobilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterMobile(){
        driver.findElement(By.cssSelector(".level0[href='http://live.techpanda.org/index.php/mobile.html']")).click();
    }

    public void addIPhone(){
        driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[1]")).click();;
    }
}
