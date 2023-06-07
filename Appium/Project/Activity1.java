package project_appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.nexuslauncher");
        options.setAppActivity(".NexusLauncherActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    }
    public String task(String title)
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.className("android.widget.EditText")));
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(title);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        return(title);
    }

    @Test
    public void addTask() {

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Tasks")));
        // Find and click on task app
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Tasks\"]")).click();

        // Wait for elements to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.TextView")));

        // Enter the task 1
        String task1 = task("Complete Activity with Google Tasks");

        // Enter the task 2
        String task2 = task("Complete Activity with Google Keep");

        // Enter the task 3
        String task3 = task("Complete the second Activity  Google Keep");

        Assert.assertEquals(task1,"Complete Activity with Google Tasks");
        Assert.assertEquals(task2,"Complete Activity with Google Keep");
        Assert.assertEquals(task3,"Complete the second Activity  Google Keep");

    }

}
