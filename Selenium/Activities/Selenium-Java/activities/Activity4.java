/*

Using Selenium:

Open a new browser to https://training-support.net/selenium/target-practice
Get the title of the page and print it to the console.
Using xpath:
Find the 3rd header on the page and print it's text to the console.
Find the 5th header on the page and print it's color.
Using any other locator:
Find the violet button and print all it's classes.
Find the grey button and print it's text.
Close the browser.

*/
package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) throws InterruptedException {

// Set up the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://training-support.net/selenium/target-practice");
        //1. get the title of webpage
        System.out.println("Title of webpage  target-practice is" + driver.getTitle());
        //2. Using xpath Find the 3rd header on the page and print its text to the console
        String getText3rdHeader = driver.findElement(By.xpath("//*[@id=\"third-header\"]")).getText();
        System.out.println("3rd Header Text" + getText3rdHeader);

        //3. Using xpath Find the 5th header on the page and print it's color.
       String  getColor5thHeader = driver.findElement
               (By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5")).getCssValue("color");
        System.out.println("5th Header color" + getColor5thHeader);

        //4. Using any other locator say ID find the violet button and print all it's classes.
        String violetButtonClasses = driver.findElement(By.className("ui violet button")).getAttribute("class");
        System.out.println("Violet button class name " + violetButtonClasses);

        //5. Using any locator say ID find the grey button and print its text.
        String greyButtonText= driver.findElement(By.className("ui grey button")).getText();
        System.out.println("Grey button text " + greyButtonText);

        //close active session after test execution
        driver.close();


    }
}
