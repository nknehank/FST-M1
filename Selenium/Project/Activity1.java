//Verify the website title
//Goal: Read the title of the website and verify the text

package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    @Test
    public void beforeMethod()
    {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver

        driver = new FirefoxDriver();
        //Open browser
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
        // Get title
        System.out.println("Webpage title is :" + driver.getTitle());
        Assert.assertEquals( "OrangeHRM",driver.getTitle() );
        //Close the browser
        driver.close();



    }



}
