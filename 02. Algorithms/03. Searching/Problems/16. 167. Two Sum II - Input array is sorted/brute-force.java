// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
class Solution {
    public int[] twoSum(int[] arr, int target) {
        int answer[] = {0 , 0};
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
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
