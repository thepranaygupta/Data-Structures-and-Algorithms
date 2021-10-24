def binarySearch(nums, target):
 
    (left, right) = (0, len(nums) - 1)
 
    while left <= right:
 
 
        mid = (left + right) // 2
 
 
        if target == nums[mid]:
            return mid
 
        elif target < nums[mid]:
            right = mid - 1
 
        else:
            left = mid + 1
 
    return -1
 
 
if __name__ == '__main__':
 
    nums = [2, 5, 6, 8, 9, 10]
    target = 5
 
    index = binarySearch(nums, target)
 
    if index != -1:
        print('Element found at index', index)
    else:
        print('Element found not in the list')
 