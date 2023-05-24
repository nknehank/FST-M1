//Verify that the “Directory” menu item is visible and clickable
//Goal: Verify that the “Directory” menu item is visible and clickable
package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void directoryVisible() throws InterruptedException {

        Activity3 obj = new Activity3();
        driver  = obj.login();
        driver.getCurrentUrl();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]")));

        //Find UL first
        WebElement UL= driver.findElement(By.cssSelector(".menu > ul:nth-child(1)"));
        // Find list items present in UL
        List<WebElement> List=UL.findElements(By.tagName("li"));

        List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]"));
        // Traverse through list items and find PIM
        for (WebElement li : List)
        {
            if (li.getText().equals("Directory"))
            {
                li.click(); // click the desired option
                System.out.println("Directory is clickable");
                break;
            }
        }

        // Find Heading and get the heading text
        WebElement headingText = driver.findElement(By.className("head"));
        String headText = headingText.getText();
        try {
            Assert.assertEquals("Search Directory", headText);
        } catch(AssertionError e)
        {
            System.out.println("Not matches");
            throw e;
        }
        System.out.println("String matches, passed");

    }

}


