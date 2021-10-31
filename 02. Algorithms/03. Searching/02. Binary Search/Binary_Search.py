def binary_search(n, ls):
	l = 0
	h = len(ls) - 1

	while l <= h:
		m = l + (h - l) // 2

		if ls[m] == n:
			return m
		elif n > ls[m]:
			l = m + 1
		else:
			h= m - 1
	return -1

numbers = [0, 12, 13, 34, 42, 69, 420, 435, 634, 6755, 9999, 34567, 953285]
number = 9999

ans = binary_search(number, numbers)
if ans == -1:
	print("Element not found")
else:
	print("Index of", number, "in list:", binary_search(number, numbers))
