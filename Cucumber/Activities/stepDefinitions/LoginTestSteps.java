package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps {
    WebDriver driver;
    WebDriverWait wait;
    @Given("^User is on Login page$")
    public void userIsOnLoginPage() throws Throwable {

        //Create a new instance of the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Open the browser
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @When("^User enters username and password$")
    public void userEntersCreds() throws Throwable {
        //Find username and password
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        // Enter username and password
        username.sendKeys("admin");
        password.sendKeys("password");
        //Click on Login button
        driver.findElement(By.cssSelector("button.ui:nth-child(4)")).click();
    }

   /* @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void parameters() throws Throwable {
        //Find username and password
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        // Enter username and password
        username.sendKeys("username");
        password.sendKeys("password");
        //Click on Login button
        driver.findElement(By.cssSelector("button.ui:nth-child(4)")).click();
    } */

    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void parametersExample(String username, String password) throws Throwable {
        //Find username and password
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);

        //Click on Login button
        driver.findElement(By.cssSelector("button.ui:nth-child(4)")).click();
        Thread.sleep(1000);
    }


    @Then("^Read the page title and confirmation message$")
    public void getMessage() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));

        //Read the page title and heading
        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();

        //Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);

    }

    @And("^Close the Browser$")
    public void closeBrowser() throws Throwable {

     driver.close();
    }


}
