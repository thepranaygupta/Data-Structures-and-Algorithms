
## Finds the Nth number in the Fibonacci Series
def fib(n: int) -> int:

    if n <= 1:  # returns 0 if fib(0), and 1 if fib(1)
        return n

    return fib(n-1) + fib(n-2)

print(fib(12))




## Generates a Fibonacci Series with two starting numbers, up until the Nth number.
def fib_sequence(n: int, x: int = 0,y: int = 1) -> list:

    if n == 0:
        return [y]

    return [y]+fib_sequence(n-1,y,x+y)

print(fib_sequence(15,1,1))