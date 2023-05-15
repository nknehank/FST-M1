# Given lists
firstList = [10, 20, 23, 11, 17]
secondList = [13, 43, 24, 36, 12]

# Print the lists
print("First List ", firstList)
print("Second List ", secondList)

# Declare a third list that will contain the result
thirdList = []

# Iterate through first list to get odd elements
for num in firstList:
    if num % 2 != 0:
        thirdList.append(num)

# Iterate through second list to get even elements
for num in secondList:
    if num % 2 == 0:
        thirdList.append(num)

# Print result
print("result List is:")
print(thirdList)
