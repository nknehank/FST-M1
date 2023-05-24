//Add a new employee
//Goal: Add an employee and their details to the site
package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity4 {

    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void addEmployee() throws InterruptedException {
        Activity3 obj = new Activity3();
        driver  = obj.login();
        driver.getCurrentUrl();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       //Find UL first
        WebElement UL= driver.findElement(By.cssSelector(".menu > ul:nth-child(1)"));
        // Find list items present in UL
        List<WebElement> List=UL.findElements(By.tagName("li"));

        List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]"));
        // Traverse through list items and find PIM
        for (WebElement li : List)
        {

            if (li.getText().equals("PIM"))
            {
                li.click(); // click the desired option
                break;
            }
        }
        driver.findElement(By.cssSelector("#menu_pim_addEmployee")).click();

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();

// Print the Date

        //Add employee details
        driver.findElement(By.id("firstName")).sendKeys("ruby"+date);
        driver.findElement(By.id("lastName")).sendKeys("bansal"+date);
        //Find and Click on save button
        driver.findElement(By.id("btnSave")).click();
        //Navigate to Employee list page
        driver.findElement(By.cssSelector("#menu_pim_viewEmployeeList")).click();
        //verify employee has been added
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("ruby");
        Assert.assertEquals("ruby","ruby");
        System.out.println("Employee added successfully named Ruby");

        //Close the browser
        driver.quit();


    }

}

