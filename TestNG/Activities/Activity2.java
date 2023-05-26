/*
Create a TestNG Class with the annotations
@Test
@BeforeClass
@AfterClass
In the @BeforeClass method, create the driver instance for FirefoxDriver
Also use the get() method to open the browser with https://www.training-support.net/selenium/target-practice
In the @AfterClass method, use close() to close the browser once the test is done.

Add 4 @Test methods.
In the first @Test method, use getTitle() to get and assert the title of the page.
In the second @Test method, use findElement() to look for the black button. Make an incorrect assertion. (This test case is meant to throw an error)
For the third @Test method, skip it by setting it's enabled parameter to false.
The third method will be skipped, but will not be shown as skipped.
For the fourth @Test method, skip it by throwing a SkipException inside the method.
The fourth method will be skipped, and it will be shown as skipped.
Observe the result in the console.
 */
package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity2 {
WebDriver driver;
@Test
public void testMethod1()
{
String actualTitle = driver.getTitle();
Assert.assertEquals(actualTitle, "Target Practice");
}
@Test
public void testMethod2()
{
WebElement blackButton = driver.findElement(By.className("ui black button"));
Assert.assertFalse(blackButton.isDisplayed());
}
@Test(enabled = false)
public void testMethod3()
{
    String className = driver.findElement(By.className("abc")).getText();
    Assert.assertTrue(className.contains("Practice"));
}
@Test
public void testMethod4()
{
    throw new SkipException("Skipping test case");
}

   @BeforeClass
   public void beforeClassMethod()
   {
       System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
       WebDriverManager.firefoxdriver().setup();
       // Create a new instance of the Firefox driver
       driver = new FirefoxDriver();
       //Open browser
       driver.get("https://www.training-support.net/selenium/target-practice");

   }

   @AfterClass
   public void afterClassMethod()
   {
  // Close browser after test execution
       driver.close();

   }


}
