package project_appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity3{

    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(1500));

        // Open the page in Chrome
        driver.get("https://www.training-support.net/selenium");
    }

    public String addTask(String title)
    {

        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(title);
        //wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.className("android.widget.Button")));
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
        return(title);
    }

    @Test
    public void scrollClick() throws InterruptedException{
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        // Wait for page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.view.View")));
        //driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='about-link']"));
        // Just scroll
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));

        // Find To do list and click element
        driver.findElement(AppiumBy.xpath("//android.view.View[15]/android.view.View")).click();

        //wait for page get loaded
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.className("android.webkit.WebView")));

        // Call addTask function
        // Enter the task 1
        String task1 = addTask("Add tasks to list");
        System.out.println(task1);

        // Enter the task 2
        String task2 = addTask("Get number of tasks");
        System.out.println(task2);

       // Enter the task 3
        String task3 = addTask("Clear the list");
        System.out.println(task3);

        //wait for page get loaded
        //wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.className("android.webkit.WebView")));

        List<WebElement> webElements = driver.findElements(AppiumBy.id("taskList"));
        System.out.println(webElements.size());

        //Delete task
       driver.findElement(AppiumBy.xpath("//*android.view.View[3]/android.view.View[2]")).click();

       //Assert.assertNotEquals(task1,"task1");


    }
    //Tear down method
   @AfterClass
    public void tearDown()
    {
        //Close the app
       driver.quit();
    }


}