# https://en.wikipedia.org/wiki/Counting_sort

def counting_sort(ls, k):
	n = len(ls)
	out = [0] * n
	count = [0] * 10

	for i in range(0, n):
		j = ls[i] // k
		count[j % 10] += 1

	for i in range(1, 10):
		count[i] += count[i - 1]

	i = n - 1
	while i >= 0:
		j = ls[i] // k
		out[count[j % 10] - 1] = ls[i]
		count[j % 10] -= 1
		i -= 1

	for i in range(0, n):
		ls[i] = out[i]

# https://en.wikipedia.org/wiki/Radix_sort

def radix_sort(ls):
	max_in_ls = max(max(ls), -min(ls))
	k = 1

	while max_in_ls // k > 0:
		counting_sort(ls, k)
		k *= 10

	# Place negative numbers at the front
	i = 0	
	while i < len(ls):
		if ls[i] < 0:
			ls = ls[i:] + ls[:i]
			i = len(ls) + 1
		i += 1

	return ls
			
example = [-10, 67, -20, -4, 25, 85, 129, 4928, 6924, -1013, 9420, 93, 5, 32, 23, 596, 64, 3, 1, 0, 294, -295929]

print("Unsorted list: ", example)
print("Sorted list: ", radix_sort(example))
