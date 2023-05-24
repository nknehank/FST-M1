//Logging into the site
//Goal: Open the site and login with the credentials provided

package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Activity3 {
    WebDriver driver;
    WebDriverWait wait;
    @Test
    public WebDriver login() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Initialize driver object
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
        // Initialize the wait object
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Find fields username and password
        WebElement username1 = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        WebElement password1 = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));

        //Enter username and password
        username1.sendKeys("orange");
        password1.sendKeys("orangepassword123");
        //Find login button and click
        driver.findElement(By.cssSelector("#btnLogin")).click();
        //Verify Home page opened up

        System.out.println("Webpage Title is :" + driver.getTitle());
        //Assert title of webpage to verify that Home page open up successfully
        try {
            Assert.assertEquals("OrangeHRM", driver.getTitle());
        }
        catch(AssertionError e) {
            System.out.println("Login Unsuccessful");
            throw e;

        }
        System.out.println("Login Successful");

        return driver;
        //Close the browser

    }

}
