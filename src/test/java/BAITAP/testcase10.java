package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import POM.loginToBackend;

public class testcase10 {
    @Test
    public static void testcase10() {
        // Set up the WebDriver
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/index.php/backendlogin");
        String id = "user01";
        String pass = "guru99com";
        String orderId = "1000";
        String fromDate = "11/01/2023"; //MM/DD/YYYY
        String toDate = "11/08/2023"; //MM/DD/YYYY

        loginToBackend loginBE = new loginToBackend(driver);

        //Step 2: Login the credentials provided
        loginBE.login(id, pass);

        //Step 3: Go to Sales-> Orders menu
        loginBE.goToSales();

        //Step 4: Input OrderId and FromDate -> ToDate and click Search button
        loginBE.inputOrderInfo(orderId, fromDate, toDate);

        //Step 5: Screenshot capture
        loginBE.captureScreen();
    }
}