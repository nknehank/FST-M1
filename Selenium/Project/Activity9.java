//Retrieve emergency contacts
//Goal: Login and retrieve the emergency contacts for the user
package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void retrieveEmergencyContact() throws InterruptedException {
        // Create object of Activity3 class
        Activity3 obj = new Activity3();
        // call login method
        driver  = obj.login();
        // get current url
        driver.getCurrentUrl();

        // wait for 30 seconds
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
        // Find and click Emergency Contacts item on left menu
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a")).click();
        // Retrieve all information from table
        //To locate table.
        WebElement myTable = driver.findElement(By.xpath("//*[@id=\"emgcontact_list\"]"));
        //To locate rows of table.
        List < WebElement > rowsTable = myTable.findElements(By.tagName("tr"));
        //To calculate no of rows In table.
        int rowCount = rowsTable.size();
        //Loop will execute till the last row of table.
        for (int row = 0; row < rowCount; row++) {
            //To locate columns(cells) of that specific row.
            List < WebElement > columnsRow = rowsTable.get(row).findElements(By.tagName("td"));
            //To calculate no of columns (cells). In that specific row.
            int columnsCount = columnsRow.size();
            //Loop will execute till the last cell of that specific row.
            for (int column = 0; column < columnsCount; column++) {
                // To retrieve text from that specific cell.
                String celText = columnsRow.get(column).getText();
                System.out.println(celText);
            }
            System.out.println("-------------------------------------------------- ");
        }


        // Print data on console

        // Close the browser
        driver.quit();


    }

}



