/*   Drag and Drop
Using Selenium:

Open a new browser to https://training-support.net/selenium/drag-drop
Get the title of the page and print it to the console.
On the page, perform:
Find the ball and simulate a click and drag to move it into "Dropzone 1".
Verify that the ball has entered Dropzone 1.
Once verified, move the ball into "Dropzone 2".
Verify that the ball has entered Dropzone 2.
Close the browser.

 */

package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {

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
        driver.get("https://training-support.net/selenium/drag-drop");
        //1. get the title of webpage
        System.out.println("Title of webpage is" + driver.getTitle());
        //Find web elements

        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropZone1 = driver.findElement(By.id("droppable"));
        WebElement dropZone2 = driver.findElement(By.id("dropzone2"));

        //  Pick ball and drop in dropzone1
        builder.clickAndHold(ball).moveToElement(dropZone1).pause(2000).release().build().perform();


        // move the ball into "Dropzone 2"
         builder.dragAndDrop(ball, dropZone2).build().perform();


        //Close active session
        driver.close();


    }

}
