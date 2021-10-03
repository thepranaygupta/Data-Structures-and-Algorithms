public class largestSumContiguousSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int presentSum=nums[0];
        
        for(int i=0;i<nums.length;i++){
            presentSum=presentSum+nums[i];
            if(presentSum>maxSum){
                maxSum=presentSum;
            }
            else if(presentSum<0){
                presentSum=0;
            }
            
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, 3, 2, -6, 4, 100, -200};
        maxSubArray(nums);
        System.out.println(maxSubArray(nums));
    }
}