/*
Create a TestNG Class with the annotations
@Test
@BeforeClass
@AfterClass
In the @BeforeClass method, create the driver instance for FirefoxDriver
Also use the get() method to open the browser with https://www.training-support.net/selenium/login-form
In the @AfterClass method, use close() to close the browser once the test is done.

Find the login input fields - username and password
Enter the credentials - admin and password - and click the "Log in" button.
Read the confirmation message and make and assertion to check if the correct message has been printed.

 */
package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;
    @Test
    public void testMethod1()
    {
        //Find the login input fields - username and password
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        //Enter the credentials - admin and password - and click the "Log in" button.
        username.sendKeys("admin");
        password.sendKeys("password");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button")).click();

        //Read the confirmation message and make and assertion to check if the correct message has been printed.
        String text = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals("Welcome Back, admin", text);
    }

    @BeforeClass
    public void beforeClassMethod()
    {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        driver.get("https://www.training-support.net/selenium/login-form");

    }

    @AfterClass
    public void afterClassMethod()
    {
        // Close browser after test execution
        driver.close();

    }




}
