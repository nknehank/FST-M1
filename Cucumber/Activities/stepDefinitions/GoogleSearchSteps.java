/*
Now that the Feature file is done, we move on the Step Definitions

In stepDefinition Package, add a new Java Class named "GoogleSearchSteps"
Import all the packages that will be used
Every Step Definition must be written in the following way:
In the @Given step,

Initialize the driver and wait instance.
Use get() to open the Google home page.
In the @When step,

Use findElement() to find the search bar and enter "Cheese" in it and emulate hitting ENTER.
In the @Then step,

Wait till the results stats are shown.
Use getText() to get the text and print it.
In the @And Step,

close() the browser

 */

package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Google Home Page$")
    public void userIsOnGooglePage() throws Throwable {

        //Create a new instance of the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Open the browser
        driver.get("https://www.google.com");
    }

    @When("^User types in Cheese and hits ENTER$")
    public void userTypesInCheeseAndHitsENTER() throws Throwable {
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
    }

    @Then("^Show how many search results were shown$")
    public void showHowManySearchResultsWereShown() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
    }

    @And("^Close the browser$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }
}