def fact(n):
    if n == 1:
        return n
    else:
        return n* fact (n-1)

    # accepts input from user
num = int(input("Enter a number: "))
# check whether number is positive or not

if num < 0:
    print("Sorry, factorial does not exist for negative numbers")
else:
    print("The factorial of " + str(num) +  " is " + str(fact(num)))
