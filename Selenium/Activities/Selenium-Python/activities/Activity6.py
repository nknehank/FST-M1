"""
Using Selenium:

Open a new browser to https://training-support.net/selenium/input-events
Get the title of the page and print it to the console.
On the page, perform:
Press the key of first letter of your name in caps
Press CTRL+a and the CTRL+c to copy all the text on the page.
(Paste the text in a text editor to verify results.)
Close the browser.
"""
import active as active
from selenium import webdriver
from selenium.webdriver import ActionChains, Keys
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

    # Press the key of first letter of your name in caps
    actions.send_keys("N").perform()

    # Press CTRL+a and the CTRL+c to copy all the text on the page.
    actions.key_down(Keys.CONTROL).send_keys("a").send_keys("c").key_up(Keys.CONTROL).perform()

    """ Paste in editor and get result as mentioned    
Input Events
Mouse and Keyboard events.
1
2
3
4
You pressed
N
   
    
    """

    # Close active session
    driver.quit()
