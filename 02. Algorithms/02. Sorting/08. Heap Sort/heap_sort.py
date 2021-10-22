'''
Max heapify() is used to build the max heap where maximum element at the root first element of the array will be maximum in max heap
'''
def max_heapify(arr, n, idx):
  max, left, right = idx, 2*idx + 1, 2*idx + 2
  # left elem > root
  if left <= n and arr[left] > arr[max]:
    max = left

  # right elem > root
  if right <= n and arr[right] > arr[max]:
    max = right

  if max != idx:
    arr[idx], arr[max] = arr[max], arr[idx]
    # Recursive
    max_heapify(arr, n, max) 
  

'''
1. The sort function calls max heapify and then swaps the final element of the max-heap with the first element
2. rebuild the heap
'''
def heapsort(arr):
  n = len(arr)
  for idx in range(n//2, -1, -1):
    max_heapify(arr, n-1, idx)

  for idx in range(n-1, -1, -1):
    # swap final elem with the starting elem
    arr[0], arr[idx] = arr[idx], arr[0]
    
    # drop the final elem from the max-heap and rebuild
    max_heapify(arr, idx-1, 0)

# test the code  
if __name__ == '__main__':
    test_arr = [1, 0, 111, 634, 25, -400, 42, -69]
    print(f"Test List: {test_arr}")
    heapsort(test_arr)
    print(f"Sorted List: {test_arr}")