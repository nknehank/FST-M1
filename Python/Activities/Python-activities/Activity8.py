numbers_list = list(input("Enter a sequence of comma separated values: ").split(", "))
print(numbers_list)
firstElement = numbers_list[0]
lastElement = numbers_list[-1]

if firstElement == lastElement:
    print(True)
else:
    print(False)

