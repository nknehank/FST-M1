package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

            public static void main(String[] args) throws InterruptedException  {
                // Set up the Firefox driver(GeckoDriver)
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
                WebDriverManager.firefoxdriver().setup();

                // Create a new instance of the Firefox driver
                WebDriver driver = new FirefoxDriver();

                // Open the browser
                driver.get("https://training-support.net");
                //get the title
                System.out.println("Title of webpage is" + driver.getTitle());

                // Find About Us link using id and click it
                driver.findElement(By.id("about-link")).click();
                // Print the title of the new page
                System.out.println("About page title: " + driver.getTitle());

            }
}
