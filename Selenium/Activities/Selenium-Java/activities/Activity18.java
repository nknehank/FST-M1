/*

Using Selenium:

Open a new browser to https://training-support.net/selenium/selects
Get the title of the page and print it to the console.
On the Multi Select:
Select the "JavaScript" option using the visible text.
Select the 4th, 5th and 6th options using the index.
Select the "NodeJS" option using the value.
Deselect the 5th option using index.
Close the browser.


 */


package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity18 {

    public static void main(String[] args) throws InterruptedException {

        // Set up the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://training-support.net/selenium/selects");
        //get the title
        System.out.println("Title of webpage Selects is" + driver.getTitle());

        // Find the dropdown
        WebElement select = driver.findElement(By.id("multi-select"));
        // Pass the WebElement to the Select object
        Select multiSelect = new Select(select);

        // Select "Javascript" using visible text
        multiSelect.selectByVisibleText("Javascript");
        // Select 4th, 5th, and 6th index options
        for(int i = 4; i<=6 ; i++) {
            multiSelect.selectByIndex(i);
        }
        // Select "NodeJS" using value attribute
        multiSelect.selectByValue("node");
        // Print the selected options
        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for(WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        // Deselect the 5th index option
        multiSelect.deselectByIndex(5);
        // Print the selected options
        selectedOptions = multiSelect.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for(WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        // Close the browser
        driver.quit();


    }
}
