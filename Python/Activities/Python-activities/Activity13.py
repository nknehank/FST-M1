# Write a function sum() such that it can accept a list of elements and print the sum of all elements
def find_sum(numbers):
    sum = 0
    for num in numbers:
        sum = sum + num
    return sum


# Define the list of numbers
numberList = [10, 20, 30, 40, 50, 60, 70]

# Call the sum() function with numList as argument
result = find_sum(numberList)

# Print result with message
print("The sum of all the elements is: " + str(result))
