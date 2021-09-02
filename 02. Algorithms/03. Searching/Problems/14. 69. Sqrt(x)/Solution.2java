class Solution{
    
    public static void main(String[] args) {
        int arr[] = {1,4,9,16,25,36,49,64,81,100};
        int N = 17;
        System.out.println(findFloor(arr, arr.length, N) + 1);
    }
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    // https://github.com/thepranaygupta/Data-Structures-and-Algorithms/tree/main/02.%20Algorithms/03.%20Searching/Problems/03.%20Floor%20in%20a%20Sorted%20Array
    static int findFloor(int arr[], int n, int target){
    
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
