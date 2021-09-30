class Solution {
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void downHeapify(int[] arr, int pi, int li) {
        int maxIdx = pi;
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;
        if (lci <= li && arr[lci] > arr[maxIdx]) {
            maxIdx = lci;
        }
        if (rci <= li && arr[rci] > arr[maxIdx]) {
            maxIdx = rci;
        }
        if (maxIdx != pi) {
            swap(arr, maxIdx, pi);
            downHeapify(arr, maxIdx, li);
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
        int li = nums.length - 1;
        for (int i = li; i >= 0; i--) {
            downHeapify(nums, i, li);
        }
        while(k-- > 1) {
            swap(nums, 0, li--);
            downHeapify(nums, 0, li);
        }
        return nums[0];
    }
}