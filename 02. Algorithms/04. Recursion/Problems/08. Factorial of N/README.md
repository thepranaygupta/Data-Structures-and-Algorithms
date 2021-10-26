### Intuition:
- Base Case: If array size is less than 0, return.
- Base Case: If array size is 1 or smaller, return 1.
- Recursion to N elements. Retrun last values after Multiplication.

### Time Complexity: O(n)

### Space Complexity: O(N)
```Python
def recur_factorial(n):
   if n == 1:
       return n
   else:
       return n*recur_factorial(n-1)

num = 7


if num < 0:
   print("Sorry, factorial does not exist for negative numbers")
elif num == 0:
   print("The factorial of 0 is 1")
else:
   print("The factorial of", num, "is", recur_factorial(num))
```

