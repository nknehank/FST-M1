# Write a Python program that throws a NameError.
# Handle the error so it doesn't halt execution.
y = input("Enter value  y")

try:
    print(x)
except NameError:
    print("x hasn't been defined yet.")
