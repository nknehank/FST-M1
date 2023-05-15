def recursion_sum(num):
    if num:
        return num + recursion_sum(num - 1)
    else:
        return 0


answer = recursion_sum(10)

print(answer)

10+9+8+7+6+5+4+3+2+1
