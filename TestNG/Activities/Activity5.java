/*
Create a TestNG Class with the annotations
@Test
@BeforeClass
@AfterClass
In the @BeforeClass method, create thea driver instance for FirefoxDriver
Also use the get() method to open the browser with https://www.training-support.net/selenium/target-practice
In the @AfterClass method, use close() to close the browser once the test is done.

Write tests for:

Checking the page title
Header Tests:
Find the third header and assert the text in the h3 tag.
Find and assert the colour of the fifth header tag element.
Button Tests:
Find the button with the class olive and assert it text.
Find and assert the colour of the first button in the third row.
Group the Header tests under a group, HeaderTests.
Group the Button tests under a group, ButtonTests.


In testng.xml:

Run all the tests from this activity.
Run only the tests that are in the HeaderTests group.
Run only the tests that are in the ButtonTests group.
Exclude the tests that are in the HeaderTests group.

 */

package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

    WebDriver driver;

    @Test(groups = {"HeaderTests", "ButtonTests"})

    public void pageTitle() throws InterruptedException {

        //Checking the page title and assert
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Target Practice");
        Thread.sleep(100);
    }
    @Test (dependsOnMethods = {"pageTitle"}, groups = {"HeaderTests"})
    public void headerTest() throws InterruptedException{


        //Header Tests: Find the third header and assert the text in the h3 tag.
        WebElement h3TagText = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(h3TagText.getText(), "Third header");

        Thread.sleep(100);

        //Find and assert the colour of the fifth header tag element.
        WebElement h5TagText = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(h5TagText.getCssValue("color"), "rgb(251, 189, 8)");
        Thread.sleep(100);

    }

    @Test (dependsOnMethods = {"pageTitle"}, groups = {"HeaderTests"})
    public void buttonTest() {
        //Button Tests:
        //Find the button with the class olive and assert it text.
        WebElement oliveText = driver.findElement(By.cssSelector("button.olive"));
        Assert.assertEquals(oliveText.getText(), "Olive");

        //Find and assert the colour of the first button in the third row.
        WebElement brownColor = driver.findElement(By.cssSelector("button.brown"));
        Assert.assertEquals(brownColor.getCssValue("color"), "rgb(255, 255, 255)");


    }

    @BeforeClass(alwaysRun = true)
    public void beforeClassMethod() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        driver.get("https://www.training-support.net/selenium/target-practice");

    }

    @AfterClass(alwaysRun = true)
    public void afterClassMethod() {
        // Close browser after test execution
        driver.close();

    }


}