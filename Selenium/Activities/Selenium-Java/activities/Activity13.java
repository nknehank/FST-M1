/*
Using Selenium:

Open a new browser to https://training-support.net/selenium/tables
Get the title of the page and print it to the console.
Using xpaths on the first table:
Find the number of rows and columns in the table and print them.
Find and print all the cell values in the third row of the table.
Find and print the cell value at the second row second column.
Close the browser.

 */


package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {

    public static void main(String[] args) throws InterruptedException  {
        // Set up the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://training-support.net/selenium/tables");
        //get the title
        System.out.println("Title of webpage is" + driver.getTitle());

        // Print the number of columns
        List<WebElement> cols = driver.findElements(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table/thead/tr/th"));

        System.out.println("Number of columns: " + cols.size());
        // Print the number of rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr"));
        System.out.println("Number of rows: " + rows.size());

        // Print the cells values of the third row
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
        System.out.println("Third row cell values: ");
        for(WebElement cell : thirdRow) {
            System.out.println(cell.getText());
        }

        // Print the cell value of the second row and second column
        WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second cell value: " + cellValue.getText());

        // Close the browser
        driver.close();
    }



    }
