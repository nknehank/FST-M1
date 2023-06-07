package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
// Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        //Open webpage
        driver.get("https://www.training-support.net");

    }

    // Test method
    @Test
    public void browserTest() {


        // Find heading on the page
        String pageHeading = driver.findElement(AppiumBy.className(
                "android.widget.TextView")).getText();

        // Print to console
        System.out.println("Heading of page: " + pageHeading);

        // Find and click the About Us link
        driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='about-link']")).click();

        // Find heading of new page and print to console
        WebElement aboutPageHeading = driver.findElement(AppiumBy.id(
                "about-link"));
        aboutPageHeading.click();
        System.out.println(aboutPageHeading);
    }
}
