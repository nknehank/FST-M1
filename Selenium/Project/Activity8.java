//8. Applying for a leave
//Goal: Login and apply for a leave on the HRM site
package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void applyLeave() throws InterruptedException {
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
            if (li.getText().equals("Dashboard"))
            {
                li.click(); // click the desired option
                System.out.println("Directory is clickable");
                break;
            }
        }

    }
}