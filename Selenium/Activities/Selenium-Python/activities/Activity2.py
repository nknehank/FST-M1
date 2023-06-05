""" Using Selenium:

Open a new browser to https://training-support.net/selenium/login-form
Get the title of the page and print it to the console.
Find the username field using any locator and enter "admin" into it.
Find the password field using any locator and enter "password" into it.
Find the "Log in" button using any locator and click it.
Close the browser."""

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
    driver.get("https://www.training-support.net/selenium/login-form")
    print("Home page Title is ", driver.title)

    # Find the username field
    username = driver.find_element(By.ID, "username")
    # Find the password field
    password = driver.find_element(By.ID, "password")

    # Enter the given credentials
    # Enter username
    username.send_keys("admin")
    # Enter password
    password.send_keys("password")

    # Find the login button
    login = driver.find_element(By.XPATH, "/html/body/div[2]/div/div[2]/div[2]/div/div/button")
    login.click()

    # Print the login error message

    print("Login button clicked")

    # Perform testing and assertions

    # Close the browser
    driver.close()
