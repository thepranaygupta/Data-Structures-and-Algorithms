// https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1#

class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long target){
    
        int start = 0;
        int end = n - 1;
	    while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target)
                return mid;
            else if (target > arr[mid]) {
	    		start = mid + 1;
	    	} else if (target < arr[mid]) {
	    		end = mid - 1;
	    	}
	    }
        return end;
	}
}
