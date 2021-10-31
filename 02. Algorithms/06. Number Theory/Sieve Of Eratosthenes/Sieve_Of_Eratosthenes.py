from math import ceil
from math import sqrt

def sieve_of_eratosthenes(n):
	is_prime = [True for i in range(n + 1)]

	for i in range(2, ceil(sqrt(n))):
		if is_prime[i]:
			for j in range(i ** 2, n + 1, i):
				is_prime[j] = False
	is_prime[0] = False
	is_prime[1] = False

	primes = []
	for number in range (n + 1):
		if is_prime[number]:
			primes.append(number)
	return primes

num = 100
print("primes lower than ", num, ": ", sieve_of_eratosthenes(num))