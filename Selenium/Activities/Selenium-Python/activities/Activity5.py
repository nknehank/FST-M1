"""
Input Events
Using Selenium:

Open a new browser to https://www.training-support.net/selenium/input-events
Get the title of the page and print it to the console.
On the page, perform:
Left click and print the value of the side in the front.
Double click to show a random side and print the number.
Right click and print the value shown on the front of the cube.
Close the browser.
"""
import active as active
from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService

from webdriver_manager.core import driver
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service1 = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service1) as driver:
    # Open the browser to the URL
    driver.get("https://www.training-support.net/selenium/input-events")
    print("Home page Title is ", driver.title)

    # Create the Actions object
    actions = ActionChains(driver)

    # Left click and print the value of the side in the front.
    actions.click().pause(10).perform()
    frontText = driver.find_element(By.CLASS_NAME, "active")
    print("Value of side:",  frontText.text)

    # Double click to show a random side and print the number.
    actions.double_click().pause(10).perform()
    number = driver.find_element(By.CLASS_NAME, "active")
    print(" Random side number is ",  number.text)

    # Right click and print the value shown on the front of the cube.
    actions.context_click().pause(10).perform()
    frontValue = driver.find_element(By.CLASS_NAME, "active")
    print("Front Value shown on front of cube is ",  frontValue.text)

    # Close active session
    driver.quit()
