//2. Get the url of the header image
//Goal: Print the url of the header image to the console

package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {

    WebDriver driver;

    @Test
    public void findHeaderImageText() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver

        WebDriver driver = new FirefoxDriver();
        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement logo = driver.findElement(By.cssSelector("#divLogo > img:nth-child(1)"));
        // Get title and print logo of header image
        System.out.println("Image URL is" + logo.getAttribute("src"));

        //Close the browser
        driver.close();

    }



}
