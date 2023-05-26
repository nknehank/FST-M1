/*
Create a TestNG Class with the annotations
@Test
@BeforeMethod
@AfterMethod
In the @BeforeMethod method, create the driver instance for FirefoxDriver
Also use the get() method to open the browser with https://www.training-support.net
In the @AfterMethod method, use close() to close the browser once the test is done.

In the @Test method,

Use getTitle() to get and print the title of the page.
Make an assertion using assertEquals() to make sure the title of the page is "Training Support".
Use findElement() to find the "About Us" Button on the page and click it.
Get and print the title of the new page.
Assert the title of the new page.

 */
package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    // Declare the WebDriver object
    WebDriver driver;
        @BeforeMethod
        public void beforeMethod()
    {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            WebDriverManager.firefoxdriver().setup();
            // Create a new instance of the Firefox driver

            driver = new FirefoxDriver();
            //Open browser
            driver.get("https://www.training-support.net");
        }

        @Test
        public void exampleTestCase () {
            // Check the title of the page
            String title = driver.getTitle();

            //Print the title of the page
            System.out.println("Page title is: " + title);

            //Assertion for page title
            Assert.assertEquals("Training Support", title);

            //Find the clickable link on the page and click it
            driver.findElement(By.id("about-link")).click();

            //Print title of new page
            System.out.println("New page title is: " + driver.getTitle());

            Assert.assertEquals(driver.getTitle(), "About Training Support");
        }

        @AfterMethod
        public void afterMethod () {
            //Close the browser
            driver.quit();
        }

    }
