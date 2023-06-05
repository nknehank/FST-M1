"""   Input Events
Using Selenium:

Open a new browser to https://training-support.net/selenium/dynamic-controls
Get the title of the page and print it to the console.
On the page, perform:
Find the checkbox input element.
Check if it is visible on the page.
Click the "Remove Checkbox" button.
Check if it is visible again and print the result.
Close the browser.
"""

import active as active
from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions as EC, wait
from selenium.webdriver.support.wait import WebDriverWait

from webdriver_manager.core import driver
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Initialize the wait object
    wait = WebDriverWait(driver, 10)

    # Navigate to the URL
    driver.get("https://training-support.net/selenium/dynamic-controls")
    # Print the title of the page
    print("Page title is: ", driver.title)

# Find the checkbox div
checkbox = driver.find_element(By.ID, "dynamicCheckbox")
# Find the checkbox toggle button
checkbox_toggle = driver.find_element(By.ID, "toggleCheckbox")
# Verify if the checkbox is displayed or not
print("Checkbox is visible: ", checkbox.is_displayed())

# Click the checkbox_toggle button to hide checkbox
checkbox_toggle.click()
# Wait till the checkbox disappears
wait.until(EC.invisibility_of_element(checkbox))
# Verify again if the checkbox is displayed or not
print("Checkbox is visible: ", checkbox.is_displayed())
