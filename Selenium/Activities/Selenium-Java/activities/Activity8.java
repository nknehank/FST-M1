/*   Waits #1
Using Selenium:

Open a new browser to https://training-support.net/selenium/dynamic-controls
Get the title of the page and print it to the console.
On the page, perform:
Find the checkbox toggle button and click it.
Wait till the checkbox disappears.
Click the button again. Wait till it appears and check the checkbox.
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

public class Activity8 {

    public static void main(String[] args) {

// Set up the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver;
        driver = new FirefoxDriver();
        // Create wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

        // Create the Actions object
        Actions builder = new Actions(driver);

        // Open the browser
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //get the title of webpage
        System.out.println("Title of webpage is" + driver.getTitle());

        // Find the toggle button and click it
        WebElement buttonAddCheckbox = driver.findElement(By.id("toggleCheckbox"));
        buttonAddCheckbox.click();
        // Wait for the checkbox to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println(((WebElement) buttonAddCheckbox).isDisplayed());
        // Click the button again
        buttonAddCheckbox.click();
        // Wait for the element to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println(buttonAddCheckbox.isDisplayed());

        //Close active session
        driver.close();


    }

}
