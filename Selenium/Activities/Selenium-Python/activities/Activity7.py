""" Drag and Drop
Using Selenium:

Open a new browser to https://training-support.net/selenium/drag-drop
Get the title of the page and print it to the console.
On the page, perform:
Find the ball and simulate a click and drag to move it into "Dropzone 1".
Verify that the ball has entered Dropzone 1.
Once verified, move the ball into "Dropzone 2".
Verify that the ball has entered Dropzone 2.
Close the browser.
"""
import active as active
from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait

from webdriver_manager.core import driver
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service1 = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service1) as driver:
    # Open the browser to the URL
    driver.get("https://www.training-support.net/selenium/drag-drop")

    wait = WebDriverWait(driver, 10)
    print("Home page Title is ", driver.title)

    # Create the Actions object
    actions = ActionChains(driver)


# Find web elements

ball = driver.find_element(By.ID, "draggable")
dropzone1 = driver.find_element(By.ID, "droppable")
dropzone2 = driver.find_element(By.ID, "dropzone2")

# Pick ball and drop in dropzone1 and verify
actions.drag_and_drop(ball, dropzone1).pause(2000).perform()
if dropzone1.text.find("Dropped!"):
    print("Dropzone 1 was activated!")

# move the ball into "Dropzone 2" and verify
actions.drag_and_drop(ball, dropzone2).pause(2000).perform()
if dropzone2.text.find("Dropped!"):
    print("Dropzone 2 was activated!")

# Close active session
driver.quit()
