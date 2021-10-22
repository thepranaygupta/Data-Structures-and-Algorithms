from functools import cache

@cache
def fibonacci(n):
	if n < 2:
		return n
	return fibonacci(n-1) + fibonacci(n-2)

for i in range(100):
	print("Fibonacci number ", i, ": ", fibonacci(i))
	