"""  Clicking a Link

Using Selenium:

Open a new browser to https://training-support.net.
Get the title of the page and print it to the console.
Find the "About Us" button on the page using it's XPATH.
Click on that button.
Get the title of the new page and print it to the console.

"""





# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.core import driver
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service1 = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service1) as driver:
    # Open the browser to the URL
    driver.get("https://training-support.net")
    print("Home page Title is ", driver.title)

    # Find About Us link using id and click it
    driver.find_element(By.ID, "about-link").click()
    # Print the title of the new page
    print("About page title: " + driver.title)

    # Perform testing and assertions
    # Close the browser
    driver.close()
