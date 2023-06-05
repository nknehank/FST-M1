"""
Using Selenium:

Open a new browser to https://training-support.net/selenium/ajax
Get the title of the page and print it to the console.
On the page, perform:
Find and click the "Change content" button on the page.
Wait for the text to say "HELLO!". Print the message that appears on the page.
Wait for the text to change to contain "I'm late!". Print the new message on the page.
Close the browser.
"""
import active as active
from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

from webdriver_manager.core import driver
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service1 = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service1) as driver:
    # Open the browser to the URL
    driver.get("https://www.training-support.net/selenium/ajax")
    print("Home page Title is ", driver.title)

# Initialize the wait object
wait = WebDriverWait(driver, 10)

# Find and click the "Change content" button on the page.
driver.find_element(By.CSS_SELECTOR, "button.violet").click()

# Wait for the text to say "HELLO!". Print the message that appears on the page.
wait.until(EC.text_to_be_present_in_element(By.TAG_NAME, "h1"))

# Find and print the new text
hello_text = driver.find_element(By.TAG_NAME, "h1")
print(hello_text.text)

# Wait for the text to change to contain "I'm late!". Print the new message on the page.
late_text = driver.find_element(By.TAG_NAME, "h3")
print(late_text.text)
# Wait for the delayed text and print it
wait.until(EC.text_to_be_present_in_element(By.TAG_NAME, "h3", "I'm late!"))
late1_text = driver.findElement(By.TAG_NAME, "h3")
print(late1_text.text)

# Close active session
driver.quit()
