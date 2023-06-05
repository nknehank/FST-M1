/*   Input Events
Using Selenium:

Open a new browser to https://training-support.net/selenium/dynamic-controls
Get the title of the page and print it to the console.
On the page, perform:
Find the text field.
Check if the text field is enabled and print it.
Click the "Enable Input" button to enable the input field.
Check if the text field is enabled again and print it.
Close the browser.

 */

package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12 {

    public static void main(String[] args) {

// Set up the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver;
        driver = new FirefoxDriver();

        // Create the Actions object
        Actions builder = new Actions(driver);

        // Open the browser
        driver.get("https://training-support.net/selenium/input-events");
        //1. get the title of webpage
        System.out.println("Title of webpage is" + driver.getTitle());

        //Close active session
        driver.close();


    }

}
