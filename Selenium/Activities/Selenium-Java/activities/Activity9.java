/*   Input Events
Using Selenium:

Open a new browser to https://training-support.net/selenium/ajax
Get the title of the page and print it to the console.
On the page, perform:
Find and click the "Change content" button on the page.
Wait for the text to say "HELLO!". Print the message that appears on the page.
Wait for the text to change to contain "I'm late!". Print the new message on the page.
Close the browser.

 */

package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {

    public static void main(String[] args) {

// Set up the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver;
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open webpage and print title
       driver.get("https://training-support.net/selenium/ajax");
       System.out.println("Title of webpage is " + driver.getTitle());

        //Find and click the "Change content" button on the page.
        driver.findElement(By.xpath("//*[@id=\"ajax-content\"]/button")).click();

        //Wait for the text to say "HELLO!". Print the message that appears on the page.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        // Find and print the new text
        String helloText = driver.findElement(By.tagName("h1")).getText();
        System.out.println(helloText);

        //Wait for the text to change to contain "I'm late!". Print the new message on the page.
        WebElement lateText = driver.findElement(By.tagName("h3"));
        System.out.println(lateText.getText());
        // Wait for the delayed text and print it
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
        String late1Text = driver.findElement(By.tagName("h3")).getText();
        System.out.println(late1Text);

        //Close active session
        driver.close();


    }

}
