// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
class Solution {
    public int[] twoSum(int[] arr, int target) {
        int answer[] = {0 , 0};
        int start = 0, end = arr.length - 1;
        int index = 0;
        while(true) {
            int mid = start + (end - start)/2;
            if(start == end) {
                index = start;
                break;
            }
            if(arr[mid] <= target)
                start = mid + 1;
            if(arr[mid] > target)
                end = mid;
        }
        for(int i = 0; i <= index; i++) {
            for(int j = i + 1; j <= index; j++) {
                if((arr[i] + arr[j]) == target) {
                    answer[0] = i + 1;
                    answer[1] = j + 1;
                    break;
                }
            }
        }
        return answer;
    }
}
