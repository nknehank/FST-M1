# Tuple Number checker if divisible by 5 then print the number
demo_tuple = tuple(input("Enter tuple numbers").split(','))
print(demo_tuple)

for item in demo_tuple:
    if item % 5 == 0:
        print(item)
