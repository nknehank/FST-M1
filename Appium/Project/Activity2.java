package project_appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {

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

    @Test
    public void addNote() {

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Keep Notes")));
        // Find and click on Notes app
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Keep Notes\"]")).click();

        // Wait for layout to get loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/add_items_layout")));
        // Click on Add New Note + icon
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        // Enter title
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Activity2 Title");
        // Enter description
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Activity2 Description");


        //Click on back button
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();


        // Assert note added successfully
        WebElement note = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title"));
        Assert.assertEquals(note.getText(),"Activity2 Title");


    }

    }
