# Fruit Shop
"""Create a Python dictionary that contains a bunch of fruits and their prices.
Write a program that checks if a certain fruit is available or not."""

fruit_dict = {
    "apple": 100,
    "mango": 80,
    "banana": 50,
    "watermelon": 60,
    "kiwi": 90,
    "cherry": 120
}
check_fruit = input("which fruit you want to buy")
if check_fruit in fruit_dict:
    print("Available")
else:
    print("Not available")
