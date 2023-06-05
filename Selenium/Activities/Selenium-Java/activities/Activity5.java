/*   Input Events
Using Selenium:

Open a new browser to https://www.training-support.net/selenium/input-events
Get the title of the page and print it to the console.
On the page, perform:
Left click and print the value of the side in the front.
Double click to show a random side and print the number.
Right click and print the value shown on the front of the cube.
Close the browser.

 */

package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {

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

        //Left click and print the value of the side in the front.
        builder.click().pause(2000).build().perform();
        String frontText = driver.findElement(By.className("active")).getText();
        System.out.println("Value of side: "  + frontText);

        //Double click to show a random side and print the number.
        builder.doubleClick().pause(2000).build().perform();
        String number = driver.findElement(By.className("active")).getText();
        System.out.println( " Random side number is " + number);

        //Right click and print the value shown on the front of the cube.
        builder.contextClick().pause(2000).build().perform();
        String frontValue = driver.findElement(By.className("active")).getText();
        System.out.println("Front Value shown on front of cube is " + frontValue);

        //Close active session
        driver.close();


    }

}
