/*   Input Events
Using Selenium:

Open a new browser to https://training-support.net/selenium/input-events
Get the title of the page and print it to the console.
On the page, perform:
Press the key of first letter of your name in caps
Press CTRL+a and the CTRL+c to copy all the text on the page.
(Paste the text in a text editor to verify results.)
Close the browser.

 */

package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity6 {

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
        //Press the key of first letter of your name in caps
        builder.sendKeys("N").build().perform();

        //Press CTRL+a and the CTRL+c to copy all the text on the page.
        builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        /*  On pasting in editor :
        Input Events
Mouse and Keyboard events.
1
2
3
4
You pressed
N
        */

        //Close active session
        driver.close();


    }

}
