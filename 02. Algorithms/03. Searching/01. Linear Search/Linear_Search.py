# To implement Linear Search in python
# Linearly search x in arr[]
# If x is present then returning its location
# else return -1
def search(arr, x):
    for i in range(len(arr)):
        if arr[i] == x:
            return i
    return -1
