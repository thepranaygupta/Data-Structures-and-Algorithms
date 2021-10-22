def countSort(arr):
    # Get the lowest and highest value from the input array
    highest_elem = int(max(arr))
    lowest_elem = int(min(arr))
    
    range_ = highest_elem - lowest_elem + 1
    
    # Init a count array initialized to 0 based on the calculated range
    count_arr = [0] * range_
    # Init a output array initialized to 0 based on the array length
    output_arr = [0] * len(arr)
 
    # Loop and maintain a count of each input of the array
    for i in range(0, len(arr)):
        count_arr[arr[i]-lowest_elem] += 1
 
    # Modify the count_arr[i] so that count_arr[i] contains the position of each element in output array
    for i in range(1, len(count_arr)):
        count_arr[i] += count_arr[i-1]
 
    # Build the output array
    for i in range(len(arr)-1, -1, -1):
        output_arr[count_arr[arr[i] - lowest_elem] - 1] = arr[i]
        count_arr[arr[i] - lowest_elem] -= 1
 
    return output_arr

if __name__ == '__main__':
    test_arr = [42, 2, 69, 8, 3, 3, 1, -20]
    print(f"Input Array: {test_arr}")
    sorted_arr = countSort(test_arr)
    print(f"Sorted Array: {sorted_arr}")