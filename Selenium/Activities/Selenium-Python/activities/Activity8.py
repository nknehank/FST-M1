"""  Waits #1
Using Selenium:

Open a new browser to https://training-support.net/selenium/dynamic-controls
Get the title of the page and print it to the console.
On the page, perform:
Find the checkbox toggle button and click it.
Wait till the checkbox disappears.
Click the button again. Wait till it appears and check the checkbox.
Close the browser.
"""
# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions as EC
from webdriver_manager.core import driver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.wait import WebDriverWait

# Set up the Firefox Driver with WebDriverManger
service1 = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service= service1) as driver:
    # Initialize wait object
    wait = WebDriverWait(driver, 10)
    # Open the browser to the URL
    driver.get("https://www.training-support.net/selenium/dynamic-controls")
    print("Webpage Title is ", driver.title)

    # Find the checkbox div
    checkbox = driver.find_element(By.ID, "dynamicCheckbox")
    # Find the checkbox toggle button
    checkbox_toggle = driver.find_element(By.ID, "toggleCheckbox")

    # Click the checkbox_toggle button to hide checkbox
    checkbox_toggle.click()
    print("Checkbox hidden")
    # Wait till the checkbox disappears
    wait.until(EC.invisibility_of_element(checkbox))
    # Click the toggle button again
    checkbox_toggle.click()
    print("Checkbox visible")
    # Click the checkbox
    checkbox.click()
    print("Checkbox selected")

    # Close active session
    driver.quit()
