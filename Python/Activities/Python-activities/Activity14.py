# Fibonacci Numbers
# 1,1,2,3,5,8,13

def fibon(number):
    if number <= 1:
        return number
    else:
        return fibon(number - 1) + fibon(number - 2)


term = int(input("Enter a number:"))
print("Fibonacci Sequence is: ")
for i in range(term):
    print(fibon(i))
