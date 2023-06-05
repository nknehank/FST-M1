/*
Using Selenium:

Open a new browser to https://training-support.net/selenium/login-form
Get the title of the page and print it to the console.
Find the username field using any locator and enter "admin" into it.
Find the password field using any locator and enter "password" into it.
Find the "Log in" button using any locator and click it.
Close the browser.

*/


package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2Xpath {

    public static void main(String[] args) throws InterruptedException{
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net");
        //get the title
        System.out.println("Title of webpage is" + driver.getTitle());

        // click on Login button on top right side
        // Open the page
        driver.get("https://www.training-support.net/selenium/login-form");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());
        //driver.findElement(By.className("ui button")).click();
        Thread.sleep(2000);


        // Find the username field and enter the username
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/form/div[1]/input")).sendKeys("admin");
        // Find the password field and enter the password
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/form/div[2]/input")).sendKeys("password");
        // Find the login button and click it
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/form/button")).click();

        // Print the confirmation message
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + message);

        // Close the browser
        driver.close();


    }
}
