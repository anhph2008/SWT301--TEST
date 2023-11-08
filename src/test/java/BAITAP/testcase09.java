package BAITAP;

import POM.CartPage;
import POM.MobilePage;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class testcase09 {
    @Test
    public static void testcase09() {
        // Set up the WebDriver
        WebDriver driver = driverFactory.getChromeDriver();
        MobilePage mobilePage = new MobilePage(driver);
        driver.get("http://live.techpanda.org/");
        String discount = "GURU50";


        // Step 2: Go to Mobile and add IPHONE to cart
        mobilePage.enterMobile();
        mobilePage.addIPhone();

        // Step 3: Enter Coupon Code
        CartPage cartPage = new CartPage(driver);
        //get Total before discount
        String grandTotalBeforeUpdate = cartPage.getTotalAmount();
        //ADD DISCOUNT CODE
        cartPage.addDiscount(discount);

        //Step 5: Verify the discount generated
        String grandTotalAfterUpdate = cartPage.getTotalAmount();
        assert !grandTotalBeforeUpdate.equals(grandTotalAfterUpdate) : "DISCOUNT CODE was not added.";


    }
}