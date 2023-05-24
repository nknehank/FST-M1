//Edit user information
//Goal: Edit a user’s information
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity5 {

    WebDriver driver;
    WebDriverWait wait;
    String winHandle;


@Test
    public void editEmployee() throws InterruptedException {

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
        if (li.getText().equals("My Info"))
        {
            li.click(); // click the desired option
            break;
        }
    }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSave\"]")));
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]")));
        //Enter first name
        driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]")).sendKeys("Nehak");
        // Enter Last name
        driver.findElement(By.xpath("//*[@id=\"personal_txtEmpLastName\"]")).sendKeys("Kakkar");
        // Select gender option
        driver.findElement(By.id("personal_optGender_2")).click();
        //Select Nationality and Select option Indian
        Select se = new Select(driver.findElement(By.id("personal_cmbNation")));
        se.selectByIndex(4);
        // Enter DOB
        driver.findElement(By.id("personal_DOB")).sendKeys("1986-05-27");
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
        System.out.println("Employee edited successfully");

        //Close the browser
        driver.quit();


    }
}
