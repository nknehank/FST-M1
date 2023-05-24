//Adding qualifications
//Goal: Add employee qualifications

package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void addQualification() throws InterruptedException {
        // Create object of Activity3 class
        Activity3 obj = new Activity3();
        // call login method
        driver  = obj.login();
        // get current url
        driver.getCurrentUrl();
        // wait for 30 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]")));
        //Find UL first
        WebElement UL= driver.findElement(By.cssSelector(".menu > ul:nth-child(1)"));
        // Find list items present in UL
        List<WebElement> List=UL.findElements(By.tagName("li"));

        List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]"));
        // Traverse through list items and find PIM
        for (WebElement li : List)
        {
            if (li.getText().equals("My Info"))
            {
                li.click(); // click the desired option
                break;
            }
        }
        // Find and click Qualification link on left menu
        driver.findElement(By.cssSelector("#sidenav > li:nth-child(9) > a:nth-child(1)")).click();
        // Find and click Add button
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#addWorkExperience"))).click();
        // Find and enter work Experience details
        driver.findElement(By.xpath("//*[@id=\"experience_employer\"]")).sendKeys("IBM");
        driver.findElement(By.xpath("//*[@id=\"experience_jobtitle\"]")).sendKeys("TestSpecialist");
        // Find and click on save button
        driver.findElement(By.id("btnWorkExpSave")).click();
        System.out.println("Work Experience added successfully");

        // Close browser
        driver.quit();





    }

}



